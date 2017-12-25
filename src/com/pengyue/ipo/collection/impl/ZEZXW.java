package com.pengyue.ipo.collection.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import  com.pengyue.ipo.bean.News;
import com.pengyue.ipo.collection.CollectionNews;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.util.DateUtil;
/**
 * 中俄咨询网
 */
public class ZEZXW extends CollectionNews {
	
	@Override
	public void collection() {
		String url="http://www.chinaru.info/zhongejingmao/";
		String rootUrl="http://www.chinaru.info/";
		int page=1;
		List<News> newsList=new ArrayList<News>();
		try {
			do {
				Document doc=this.getConnection(url).get();
				Elements liTags=doc.select("div.con_centernews>ul>li");
				for (Element liTag : liTags) {
					String pDate=liTag.select("h3").text();
					//匹配(02/23)
					Pattern pattern = Pattern.compile("[0-9]{2}/[0-9]{1,2}"); 
				    Matcher matcher = pattern.matcher(pDate); 
					if(matcher.find()){ 
						pDate= Calendar.getInstance().get(Calendar.YEAR)+matcher.group(0).replace("/", "");
						if (isOverdue(pDate, "yyyyMMdd")) {
							  System.out.println("---新闻过期了跳过---");
								continue;
						  }
					}else {
						System.out.println("---新闻过期了跳过---");
						continue;
					}
					Elements aTags=liTag.select("h2>a");
					if (aTags==null||aTags.size()==0) {
						continue;
					}
					Element aTag=aTags.get(0);
					String newsUrl=rootUrl+aTag.attr("href");
					String title=aTag.text();
					//判断数据库中是否存在
					if(!getNewsService().urlExists(newsUrl)){
						Document detailsDoc;
						try {
							detailsDoc=getConnection(newsUrl).get();
						} catch (Exception e) {
							System.out.println("请求详情页报错:"+e.getMessage());
							continue;
						}
						Elements pTags=detailsDoc.select("#ContentTxt>p");
						StringBuffer sb=new StringBuffer();
						for (Element pTag : pTags) {
							sb.append(pTag.text());
						}
						String context=sb.toString();
						pDate=detailsDoc.select("li.newssource").text();
						//匹配 2017-2-23 12:35:27 
						pattern = Pattern.compile("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"); 
					    matcher = pattern.matcher(pDate); 
						if(matcher.find()){ 
							pDate= matcher.group(0);
						}
						String pubDate=DateUtil.fmtDt(DateUtil.parse(pDate, "yyyy-MM-dd HH:mm:ss"),timeFormat);
						News news = getNewsBean(title, pubDate, SourceInfo.ZEZXW, "0", context, newsUrl);
						newsList.add(news);
					}
				}
				if (newsList != null && newsList.size() > 0) {
					//保存数据库
					getNewsService().batchInsert(newsList);
					newsList.clear();
				}else{
					return; //当前页没有采集到今日新闻后面也就不需要采集了直接结束
				}
				page++;
				url="http://www.chinaru.info/zhongejingmao/index-"+page+".shtml";
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.pengyue.ipo.collection.impl;

import java.util.ArrayList;
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
 * 金融时报全球经济版块
 */
public class JRSB_QQJJ extends CollectionNews {
	
	@Override
	public void collection() {
		String url="http://www.ftchinese.com/channel/globaleconomy.html";
		String rootUrl="http://www.ftchinese.com/";
		int page=1;
		List<News> newsList=new ArrayList<News>();
		try {
			do {
				Document doc=this.getConnection(url).get();
				Elements divTags=doc.select("div.items>div.item-container");
				for (Element div : divTags) {
					String pDate=div.select("div.item-time").text();
					//匹配 1天前，10小时前 
					Pattern pattern = Pattern.compile("[0-9]{1,2}[天,小]"); 
				    Matcher matcher = pattern.matcher(pDate); 
					if(matcher.find()){ 
						pDate= matcher.group(0);
						  if (pDate.indexOf("天")!=-1) {
							  if (new Integer(pDate.substring(0, 1))>1) {
								  System.out.println("---新闻过期了跳过---");
									continue;
							  }
						  }
					}else {
						System.out.println("---新闻过期了跳过---");
						continue;
					}
					Elements aTags=div.select(".item-headline>a");
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
						Elements pTags=detailsDoc.select(".story-body>p");
						StringBuffer sb=new StringBuffer();
						for (Element pTag : pTags) {
							sb.append(pTag.text());
						}
						String context=sb.toString();
						pDate=detailsDoc.select("span.story-time").text();
						//匹配 2017年2月23日 07:53  
						pattern = Pattern.compile("[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日 [0-9]{1,2}:[0-9]{1,2}"); 
					    matcher = pattern.matcher(pDate); 
						if(matcher.find()){ 
							pDate= matcher.group(0);
						}
						String pubDate=DateUtil.fmtDt(DateUtil.parse(pDate, "yyyy年MM月dd日 HH:mm"),timeFormat);
						News news = getNewsBean(title, pubDate, SourceInfo.JRSB_QQJJ, "0", context, newsUrl);
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
				url="http://www.ftchinese.com/channel/globaleconomy.html?page="+page;
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

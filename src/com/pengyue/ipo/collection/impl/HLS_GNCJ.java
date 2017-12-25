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
 * 韩联社国内财经版块
 */
public class HLS_GNCJ extends CollectionNews {
	
	@Override
	public void collection() {
		String url="http://chinese.yonhapnews.co.kr/domestic/0403000001.html";
		String rootUrl="http://chinese.yonhapnews.co.kr/domestic/";
		List<News> newsList=new ArrayList<News>();
		try {
			do {
				Document doc=this.getConnection(url).get();
				Elements ulTags=doc.getElementsByClass("con_article_list").get(0).select("ul");
				for (Element ul : ulTags) {
					Elements aTags=ul.select("li.tit>a");
					if (aTags==null||aTags.size()==0) {
						continue;
					}
					Element aTag=aTags.get(0);
					String newsUrl=aTag.attr("href");
					String title=aTag.text();
					String pDate="";
					//匹配 /2017/02/23/  
					Pattern pattern = Pattern.compile("/[0-9]{4}/[0-9]{2}/[0-9]{2}/"); 
				    Matcher matcher = pattern.matcher(newsUrl); 
					if(matcher.find()){ 
						pDate= matcher.group(0).replace("/", "");
						  if (isOverdue(pDate, "yyyyMMdd")) {
							  System.out.println("---新闻过期了跳过---");
								continue;
						  }
					}else {
						System.out.println("---新闻过期了跳过---");
						continue;
					}
					//判断数据库中是否存在
					if(!getNewsService().urlExists(newsUrl)){
						Document detailsDoc;
						try {
							detailsDoc=getConnection(newsUrl).get();
						} catch (Exception e) {
							System.out.println("请求详情页报错:"+e.getMessage());
							continue;
						}
						Element textELm=detailsDoc.getElementById("articleBody");
						String context=textELm.text();
						String pubDate=DateUtil.fmtDt(DateUtil.parse(pDate, "yyyyMMdd"),timeFormat);
						News news = getNewsBean(title, pubDate, SourceInfo.HLS_GNCJ, "0", context, newsUrl);
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
				url=rootUrl+doc.getElementsByClass("paging").get(0).select("a").get(0).lastElementSibling().attr("href");
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

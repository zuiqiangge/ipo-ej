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

/**
 * 搜狐财经全球经济版块
 */
public class SoHu extends CollectionNews {
	
	@Override
	public void collection() {
		int page=1;
		int maxPage=264;
		String url="http://business.sohu.com/quanqiu/index.shtml";
		List<News> newsList=new ArrayList<News>();
		try {
			do {
				Document doc=this.getConnection(url).get();
				Elements liTags=doc.getElementsByClass("f14list").get(0).select("ul>li");
				for (Element element : liTags) {
					Elements aTags=element.select("a[href]");
					if (aTags==null||aTags.size()==0) {
						continue;
					}
					Element aTag=aTags.get(0);
					String newsUrl=aTag.attr("href");
					String title=aTag.text();
					//匹配  20161206  
					Pattern pattern = Pattern.compile("/[0-9]{8}/"); 
				    Matcher matcher = pattern.matcher(newsUrl); 
					if(matcher.find()){ 
						  String pDate = matcher.group(0).replace("/", "");
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
						Element textELm=detailsDoc.getElementById("contentText");
						String context=textELm.text();
						String pubDate=detailsDoc.getElementById("pubtime_baidu").text();
						News news = getNewsBean(title, pubDate, SourceInfo.SoHu, "0", context, newsUrl);
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
				url="http://business.sohu.com/quanqiu/index_"+(maxPage-page)+".shtml";
				page++;
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

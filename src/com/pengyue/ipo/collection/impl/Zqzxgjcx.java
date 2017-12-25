package com.pengyue.ipo.collection.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.collection.CollectionNews;
import com.pengyue.ipo.collection.SourceInfo;
/**
 * 证券之星国际财讯板块
 * @author admin
 *
 */
public class Zqzxgjcx extends CollectionNews {

	@Override
	public void collection() {
		String url = "http://finance.stockstar.com/list/955.shtml";
		String nextUrl = null;
		try {
			do {
				List<News> newsList = new ArrayList<News>();
				Document doc = null;
				if (nextUrl != null) {
					System.out.println(nextUrl);
					doc = getConnection(nextUrl).get();
				} else {
					doc = getConnection(url).get();
				}
				Elements eles = doc.select(".list-line>li");
				for (Element ele : eles) {
					String pubDate = ele.select("span").text().trim();
					//判断新闻是否过期
					if(isOverdue(pubDate,timeFormat)){
						System.out.println("---新闻过期了跳过---");
						break;
					}
					String href = ele.select("a").attr("href");
					//判断url是否已存在
					if(!getNewsService().urlExists(href)){
						Document descDoc = null;
						try {
							descDoc = getConnection(href).get();
						} catch (Exception e) {
							System.out.println("请求详情页报错:"+e.getMessage());
							continue;
						}
						String title = ele.select("a").text();
						String context = descDoc.select("#container-article").text();
						News news = getNewsBean(title, pubDate, SourceInfo.ZQZX_GJCX, "0", context, href);
						//添加到List
						newsList.add(news);
					}
				}
				if (newsList != null && newsList.size() > 0) {
					//保存数据库
					getNewsService().batchInsert(newsList);
				}else{
					break; //当前页没有采集到今日新闻后面也就不需要采集了直接跳出
				}
				
				Element next = doc.select("#Page .edit>a:contains(下一页)").first();
				if(next != null){
					nextUrl = "http://finance.stockstar.com/list/" + next.attr("href");
				}else{
					break;
				}
			} while (true);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

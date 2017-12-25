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
 * 经济参考报环球板块
 * @author admin
 *
 */
public class Jjckbhq extends CollectionNews {
	
	@Override
	public void collection() {
		String url = "http://www.jjckb.cn/hq.htm";
		try {
			List<News> newsList = new ArrayList<News>();
			Document doc = getConnection(url).get();
			Elements eles = doc.select(".box_left>ul>li");
			for (Element ele : eles) {
				String title = ele.select("a").text();
				String pubDate = ele.select("span").text();
				if(isOverdue(pubDate, "yyyy-MM-dd HH:mm")){
					System.out.println("---新闻过期了跳过---");
					break;
				}
				String href = ele.select("a").attr("href");
				if(!getNewsService().urlExists(href)){
					Document descDoc = null;
					try {
						descDoc = getConnection(href).get();
					} catch (Exception e) {
						System.out.println("请求详情页报错：" + e.getMessage());
						continue;
					}
					String context = descDoc.select("#content").text();
					News news = getNewsBean(title, pubDate, SourceInfo.JJCKB_HQ,
							"0", context, href);
					newsList.add(news);
				}
			}
			if (newsList != null && newsList.size() > 0) {
				//保存数据库
				getNewsService().batchInsert(newsList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

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
import com.pengyue.ipo.util.DateUtil;
/**
 * 新浪财经美洲经济
 * @author admin
 *
 */
public class Xlcjmzjj extends CollectionNews {

	@Override
	public void collection() {
		String url = "http://roll.finance.sina.com.cn/finance/gjcj/mzjj/index.shtml";
		String nextUrl = null;
		int page = 2;
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
				Elements eles = doc.select(".list_009>li");
				for (Element ele : eles) {
					String pubDate = ele.select("span").text().trim();
					pubDate = pubDate.replace("(", "").replace(")", "");
					//判断新闻是否过期
					if(isOverdue(pubDate,"yyyy年MM月dd日 HH:mm")){
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
						//转换日期格式
						pubDate = DateUtil.fmtDt(
								DateUtil.parse(pubDate, "yyyy年MM月dd日 HH:mm"),
								timeFormat);
						String title = ele.select("a").text();
						String context = descDoc.select("#artibody>p").text();
						News news = getNewsBean(title, pubDate, SourceInfo.XLCJ_MZJJ, "0", context, href, "1");
						
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
				//做多取前100页
				if(page <= 100){
					nextUrl = "http://roll.finance.sina.com.cn/finance/gjcj/mzjj/index_" + page + ".shtml";
					page++;
				}else{
					break;
				}
			} while (page <= 100);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

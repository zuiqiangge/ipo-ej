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
 * 金融界环球财经板块
 * @author admin
 *
 */
public class Jrjhqcj extends CollectionNews {

	@Override
	public void collection() {
		String url = "http://gold.jrj.com.cn/list/hqcj.shtml";
		String nextUrl = null;
		int page = 2;
		try {
			do {
				List<News> newsList = new ArrayList<News>();
				Document doc = null;
				if (nextUrl != null) {
					doc = getConnection(nextUrl).get();
				} else {
					doc = getConnection(url).get();
				}
				Elements eles = doc.select(".newslist5 li");
				for (Element ele : eles) {
					String pubDate = ele.select(".date").text();
					//判断新闻是否过期
					if(isOverdue(pubDate,"yyyy-MM-dd HH:mm")){
						System.out.println("---新闻过期了跳过---");
						break;
					}
					String href = ele.select(".jrj-fl").attr("href");
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
								DateUtil.parse(pubDate, "yyyy-MM-dd HH:mm"),
								timeFormat);
						String title = ele.select(".jrj-fl").text();
						String context = descDoc.select(".texttit_m1>p").text();
						News news = getNewsBean(title, pubDate, SourceInfo.JRJ_HQCJ, "0", context, href);
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
				//此网站貌似默认只显示10页超过10页请求会报错
				if(page <= 10){
					nextUrl = "http://gold.jrj.com.cn/list/hqcj-"+page+".shtml";
					page++;
				}else{
					break;
				}
			} while (true);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

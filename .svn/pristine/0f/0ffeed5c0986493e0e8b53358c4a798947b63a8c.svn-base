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
 * 中国经济网国际经济板块
 * @author admin
 *
 */
public class Zgjjwgjjj extends CollectionNews {

	@Override
	public void collection() {
		String url = "http://intl.ce.cn/sjjj/qy/";
		String nextUrl = null;
		int page = 1;
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
				Elements eles = doc.select(".lbcon>li");
				for (Element ele : eles) {
					String title = ele.select("a").text();
					String href = ele.select("a").attr("href");
					
					String web = "http://intl.ce.cn/sjjj/qy";
					//去掉url中的../同时地址前面相应的删到上一个路径
					while(href.startsWith("../")){
						href = href.substring(3);
						web = web.substring(0,web.lastIndexOf("/"));
					}
					href = web + "/" + href.replace("./", "");
					
					if(!getNewsService().urlExists(href)){
						Document descDoc = null;
						try {
							descDoc = getConnection(href).get();
						} catch (Exception e) {
							System.out.println(title);
							System.out.println(href);
							System.out.println("请求详情页报错:"+e.getMessage());
							continue;
						}
						String pubDate = descDoc.select("#articleTime").text().trim();
						//判断是否过期
						if(isOverdue(pubDate, "yyyy年MM月dd日 HH:mm")){
							System.out.println("---新闻过期了跳过---");
							break;
						}
						pubDate = DateUtil.fmtDt(DateUtil.parse(pubDate, "yyyy年MM月dd日 HH:mm"), timeFormat);
						String context = descDoc.select(".TRS_Editor").text();
						News news = getNewsBean(title, pubDate, SourceInfo.ZGJJW_GJJJ, "0", context, href);
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
				if(page < 10){
					nextUrl = "http://intl.ce.cn/sjjj/qy/index_"+page+".shtml";
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

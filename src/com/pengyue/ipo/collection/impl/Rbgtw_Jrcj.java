package com.pengyue.ipo.collection.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.collection.CollectionNews;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.util.DateUtil;

/**
 * 日本共同网金融财经板块
 */
public class Rbgtw_Jrcj extends CollectionNews {
	
//	@Override
//	public void collection() {
//		int page=1;
//		String rootUrl="http://china.kyodonews.jp/";
//		String url="http://china.kyodonews.jp/news/article_datas/index.php?category_id=15&page="+page+"&t="+new Date().getTime();
//		List<News> newsList=new ArrayList<News>();
//		try {
//			do {
//				String jsonStr = getConnection(url).ignoreContentType(true).execute().body();
//				JSONArray array = JSONArray.fromObject("["+jsonStr+"]");
//				JSONObject objects=array.getJSONObject(0);
//				int size=new Integer(objects.getString("page_count")).intValue();
//				for (int i = 0; i < size; i++) {
//					JSONObject obj = objects.getJSONObject(i+"");
//					String newsUrl=rootUrl+obj.getString("mtul");
//					String title=obj.getString("sch_hl");
//					String pDate=obj.getString("rd")+" "+obj.getString("rt");
//					 if (isOverdue(pDate, "yyyy年MM月dd日 HH:mm:ss")) {
//						  System.out.println("---新闻过期了跳过---");
//							continue;
//					 }
//					//判断数据库中是否存在
//					if(!getNewsService().urlExists(newsUrl)){
//						String context=obj.getString("sch_bd").replace("<p>", "").replace("<\\/p>", "").replace("\n", "").replace("</p>", "");
//						String pubDate=DateUtil.fmtDt(DateUtil.parse(pDate, "yyyy年MM月dd日 HH:mm:ss"),timeFormat);
//						News news = getNewsBean(title, pubDate, SourceInfo.Rbgtw_Jrcj, "0", context, newsUrl);
//						newsList.add(news);
//					}
//				}
//				if (newsList != null && newsList.size() > 0) {
//					//保存数据库
//					getNewsService().batchInsert(newsList);
//					newsList.clear();
//				}else{
//					return; //当前页没有采集到今日新闻后面也就不需要采集了直接结束
//				}
//				page++;
//			} while (true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void collection() {
		try {
			int page=1;
			String rootUrl = "https://china.kyodonews.net";
			String format = "yyyy年 MM月 dd日  HH:mm";
			do {
				List<News> newsList=new ArrayList<News>();
				String url="https://china.kyodonews.net/news/economy_science?page=" + page + "&_=" + new Date().getTime();
				System.out.println(url);
				Document doc = getConnection(url)
								.validateTLSCertificates(false)
								.get();
				Elements eles = doc.select("#js-postListItems>li");
				for (Element ele : eles) {
					String pubDate = ele.select(".time").get(0).ownText();
					pubDate = pubDate.replace("|", "").replace("-", "");
					//判断新闻是否过期
					if(isOverdue(pubDate, format)){
						System.out.println("---新闻过期了跳过---");
						break;
					}
					String href = rootUrl + ele.select("a:eq(0)").attr("href");
					//判断url是否存在
					if(!getNewsService().urlExists(href)){
						Document descDoc = null;
						String title = ele.select("a:eq(0)>h3").text();
						//转换日期格式
						pubDate = DateUtil.fmtDt(
								DateUtil.parse(pubDate, format),
								timeFormat);
						try {
							descDoc = getConnection(href).validateTLSCertificates(false).get();
						} catch (Exception e) {
							System.out.println("请求详情页报错:"+e.getMessage());
							continue;
						}
						String context = descDoc.select(".main>p:not(.credit)").text();
						News news = getNewsBean(title, pubDate, SourceInfo.Rbgtw_Jrcj, "0", context, href);
						newsList.add(news);
					}
				}
				if (newsList != null && newsList.size() > 0) {
					//保存数据库
					getNewsService().batchInsert(newsList);
				}else{
					break; //当前页没有采集到今日新闻后面也就不需要采集了直接跳出
				}
				//最多取前100页
				if(page < 100){
					page ++;
				}else{
					break;
				}
			} while (page <= 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

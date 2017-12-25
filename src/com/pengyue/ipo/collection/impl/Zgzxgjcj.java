package com.pengyue.ipo.collection.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.collection.CollectionNews;
import com.pengyue.ipo.collection.SourceInfo;
/**
 * 中国在线国际财经板块
 * @author admin
 *
 */
public class Zgzxgjcj extends CollectionNews {

	@Override
	public void collection() {
		String url = "http://news.cnfol.com/guojicaijing/";
		String nextUrl = null;
		int page = 3;
		try {
			do {
				List<News> newsList = null;
				
				if(nextUrl != null){
					System.out.println(nextUrl);
					String jsonStr = getConnection(nextUrl)
									.data("page",String.valueOf(page))
									.execute()
									.body();
					jsonStr = jsonStr.substring(jsonStr.indexOf("(") + 1, jsonStr.lastIndexOf(")"));
					JSONArray array = JSONArray.fromObject(jsonStr);			
					newsList = getListByJSONArray(array);		
				}else{
					Document doc = getConnection(url).get();
					Elements eles = doc.select(".TList>li");
					newsList = getListByHtml(eles);
				}
				if (newsList != null && newsList.size() > 0) {
					//保存数据库
					getNewsService().batchInsert(newsList);
				}else{
					break; //当前页没有采集到今日新闻后面也就不需要采集了直接跳出
				}
				nextUrl = "http://app.cnfol.com/test/newlist_api.php?catid=1278&page="+page;
				page++;
			} while (true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从json中获得list
	 * @param eles
	 * @return
	 */
	private List<News> getListByJSONArray(JSONArray array) {
		List<News> newsList = new ArrayList<News>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject json = array.getJSONObject(i);
			String href = json.getString("Url");
			String title = json.getString("Title");
			if(!getNewsService().urlExists(href)){
				Document descDoc = null;
				try {
					descDoc = getConnection(href).get();
				} catch (IOException e) {
					System.out.println("请求详情页报错：" + e.getMessage());
					continue;
				}
				String pubDate = descDoc.select("#pubtime_baidu").text().trim();
				//判断是否过期
				if(isOverdue(pubDate, "yyyy-MM-dd HH:mm:ss")){
					System.out.println("---新闻过期了跳过---");
					break;
				}
				String context = descDoc.select("#Content").text();
				News news = getNewsBean(title, pubDate, SourceInfo.ZGZX_GJCJ,
						"0", context, href);
				newsList.add(news);
			}
		}
		return newsList;
	}
	
	/**
	 * 从html中获得list
	 * @param eles
	 * @return
	 */
	public List<News> getListByHtml(Elements eles){
		List<News> newsList = new ArrayList<News>();
		for (Element ele : eles) {
			String href = ele.select("a").attr("href");
			String title = ele.select("a").text();
			Document descDoc = null;
			if(!getNewsService().urlExists(href)){
				try {
					descDoc = getConnection(href).get();
				} catch (IOException e) {
					System.out.println("请求详情页报错：" + e.getMessage());
					continue;
				}
				String pubDate = descDoc.select("#pubtime_baidu").text().trim();
				//判断是否过期
				if(isOverdue(pubDate, "yyyy-MM-dd HH:mm:ss")){
					System.out.println("---新闻过期了跳过---");
					break;
				}
				String context = descDoc.select("#Content").text();
				News news = getNewsBean(title, pubDate, SourceInfo.ZGZX_GJCJ,
						"0", context, href);
				newsList.add(news);
			}
		}
		return newsList;
	}
}

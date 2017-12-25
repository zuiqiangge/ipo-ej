package com.pengyue.ipo.collection.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.collection.CollectionNews;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.util.DateUtil;
/**
 * 华尔街日报经济版块
 */
public class HEJRB_JJ extends CollectionNews {
	
	@Override
	public void collection() {
		String url="http://cn.wsj.com/gb/economy.php";
		String rootUrl="";
		List<News> newsList=new ArrayList<News>();
		try {
			Document doc=this.getConnection(url).get();
			List<Element> aTagsList=new ArrayList<Element>();
			aTagsList.addAll(doc.select("div.sponsored-content-wrapper").select(".hed>a"));
			for (Element aTag : aTagsList) {
				if (aTag==null) {
					continue;
				}
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
					Element textELm=detailsDoc.getElementById("A");
					String context=textELm.text();
					String pDate=detailsDoc.select("time.timestamp").text();
					//匹配 2017年 02月 23日 13:51  
					Pattern pattern = Pattern.compile("[0-9]{4}年 [0-9]{1,2}月 [0-9]{1,2}日 [0-9]{1,2}:[0-9]{1,2}"); 
				    Matcher matcher = pattern.matcher(pDate); 
					if(matcher.find()){ 
						pDate= matcher.group(0);
						  if (isOverdue(pDate, "yyyy年 MM月 dd日 HH:mm")) {
							  System.out.println("---新闻过期了跳过---");
								continue;
						  }
					}
					String pubDate=DateUtil.fmtDt(DateUtil.parse(pDate, "yyyy年 MM月 dd日 HH:mm"),timeFormat);
					News news = getNewsBean(title, pubDate, SourceInfo.HEJRB_JJ, "0", context, newsUrl);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		HEJRB_JJ jj= new HEJRB_JJ();
		jj.collection();
	}
}
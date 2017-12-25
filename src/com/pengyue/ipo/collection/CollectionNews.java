package com.pengyue.ipo.collection;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.NewsZlm;
import com.pengyue.ipo.service.news.NewsService;
import com.pengyue.ipo.service.news.ReportService;
import com.pengyue.ipo.service.system.CollectSevice;
import com.pengyue.ipo.util.AutoId;
import com.pengyue.ipo.util.HanLPUtil;
import com.pengyue.ipo.util.NewsZlmUtil;
import com.pengyue.ipo.util.RegionUtil;

public abstract class CollectionNews implements Runnable {
	
	//日期时间格式
	public final static String timeFormat = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private static NewsService newsService;
	private static CollectSevice collectSevice;
	private static ReportService reportService;
	
	public static NewsService getNewsService() {
		return newsService;
	}
	public static void setNewsService(NewsService newsService) {
		CollectionNews.newsService = newsService;
	}
	public static CollectSevice getCollectSevice() {
		return collectSevice;
	}
	public static void setCollectSevice(CollectSevice collectSevice) {
		CollectionNews.collectSevice = collectSevice;
	}
	public static ReportService getReportService() {
		return reportService;
	}
	public static void setReportService(ReportService reportService) {
		CollectionNews.reportService = reportService;
	}
	
	@Override
	public void run() {
		//调用采集方法
		this.collection();
	}
	
	/**
	 * 采集方法
	 */
	public abstract void collection();
	
	/**
	 * 通过url获得Connection
	 * @param url
	 * @return
	 */
	public Connection getConnection(String url){
		return Jsoup.connect(url)
					.timeout(50000)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
	}
	
	/**
	 * 新闻是否过期了小于昨天的毫秒数则过期
	 * @param pDate
	 * @param format
	 * @return
	 */
	public boolean isOverdue(String pDate,String format){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		Date date = cal.getTime();
		try {
			Date pubDate = new SimpleDateFormat(format).parse(pDate);
			//转换设置时分秒为0
			date = sdf.parse(sdf.format(date));
			if(pubDate.getTime() >= date.getTime()){
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 获得News对象
	 * @param title
	 * @param pubDate
	 * @param sourceId
	 * @param viewNum
	 * @param context
	 * @param href
	 * @return
	 */
	public News getNewsBean(String title,String pubDate,String sourceId,String viewNum,
					String context,String href){
		
		//简介
		String desc = HanLPUtil.extractSummary(context);
		
		System.out.println(title);
		System.out.println(pubDate);
		System.out.println(desc);
		System.out.println("内容长度："+context.length());
		System.out.println(href);
		System.out.println("------------------------------");
		
		String ssdq = RegionUtil.getRegion(context);
		
		String zlm = getZlm(context);
//		String zlm = "";
		String id = AutoId.getCode();
		
		return new News(id, title, pubDate, sourceId, viewNum, desc, context, href, zlm, ssdq);
	}
	
	/**
	 * 获得News对象重载方法(加入地区id参数)
	 * @param title
	 * @param pubDate
	 * @param sourceId
	 * @param viewNum
	 * @param context
	 * @param href
	 * @param ssdq
	 * @return
	 */
	public News getNewsBean(String title,String pubDate,String sourceId,String viewNum,
					String context,String href,String ssdq){
		
		//简介
		String desc = HanLPUtil.extractSummary(context);
		
		System.out.println(title);
		System.out.println(pubDate);
		System.out.println(desc);
		System.out.println("内容长度："+context.length());
		System.out.println(href);
		System.out.println("------------------------------");
		
		String zlm = getZlm(context);
//		String zlm = "";
		String id = AutoId.getCode();
		return new News(id, title, pubDate, sourceId, viewNum, desc, context, href, zlm, ssdq);
	}
	
	public String getZlm(String context){
		Map<String, Object> params = new HashMap<String, Object>();
		if(context.length() > 1000){
			context = context.substring(0,1000);
		}
		params.put("context",context);
		NewsZlm o=reportService.getZlmByContext(params);
		String zlm=NewsZlmUtil.getZlmBy(o);
		return zlm;
	}
	/**
	 * 设置url中的中文编码
	 * @param href
	 * @param code
	 * @return
	 */
	public String setUrlChineseCode(String href,String code){
        String url = href;
		Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(url);
        try {
			while (matcher.find()) {
			  String tmp=matcher.group();
			  url=url.replaceAll(tmp,URLEncoder.encode(tmp,"UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("设置url中文编码报错:"+e.getMessage());
			return href;
		}
        return url;
	}
}

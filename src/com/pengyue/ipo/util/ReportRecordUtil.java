package com.pengyue.ipo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.one2team.examples.SamplesFactory;
import org.one2team.highcharts.server.export.ExportType;
import org.one2team.highcharts.server.export.HighchartsExporter;
import org.one2team.highcharts.shared.ChartOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Encoder;

import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.ReportBean;
import com.pengyue.ipo.bean.ReportRecord;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.service.news.ReportRecordService;
import com.pengyue.ipo.service.news.TbXtNewsService;

@Component
public class ReportRecordUtil {
	
	private static SimpleDateFormat format = new SimpleDateFormat(DateFormat.DATE_FORMAT_yyyyMMddHHmmss);
	private static TbXtNewsService tbXtNewsService;
	private static ReportRecordService reportRecordService;
	
	public static ReportBean initReport(String startTime,String endTime,String reportId) {
		ReportBean o = new ReportBean();
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("reportId", reportId);
		
		Calendar c = Calendar.getInstance();
		try {
			//获得时间段（月份和日期）
			c.setTime(format.parse(startTime));
			String timeslot = (c.get(Calendar.MONTH) + 1) + "月"
								+ c.get(Calendar.DAY_OF_MONTH) + "日";
			c.setTime(format.parse(endTime));
			timeslot += "-" + (c.get(Calendar.MONTH) + 1) + "月"
					+ c.get(Calendar.DAY_OF_MONTH) + "日";
			o.setTitledate(timeslot);
			
			params.put("zlm", "正面");
			int zmyq = tbXtNewsService.findCountByZlmAndTime(params);
			params.put("zlm", "负面");
			int fmyq = tbXtNewsService.findCountByZlmAndTime(params);
			params.put("zlm", "中立");
			int zlyq = tbXtNewsService.findCountByZlmAndTime(params);
			
			
			o.setYqztm(String.valueOf(zmyq + fmyq + zlyq));
//			o.setZmyq(String.valueOf(zmyq));
//			o.setFmyq(String.valueOf(fmyq));
//			o.setZlyq(String.valueOf(zlyq));
			
			
			params.put("ssdq", "1");
			List<News> smzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSmzzdyqList(newsListToMapList(smzzdyqList));
			
			params.put("ssdq", "2");
			List<News> sozzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSozzdyqList(newsListToMapList(sozzdyqList));
			
			params.put("ssdq", "3");
			List<News> syzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSyzzdyqList(newsListToMapList(syzzdyqList));
			
			params.put("ssdq", "4");
			List<News> szdzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSzdzdyqList(newsListToMapList(szdzdyqList));
			
			params.put("ssdq", "5");
			List<News> sfzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSfzzdyqList(newsListToMapList(sfzzdyqList));
			
			params.put("ssdq", "6");
			List<News> qqjrjgzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setQqjrjgzdyqList(newsListToMapList(qqjrjgzdyqList));
			
			params.put("ssdq", "7");
			List<News> qtzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setQtzdyqList(newsListToMapList(qtzdyqList));
			
			
			//不同地区新闻数量
			List<Map<String,Object>> result = tbXtNewsService.groupBySsdq(params);
			List<Map<String,Object>> dqslList = new ArrayList<Map<String,Object>>();
			
			int i = 1;
			for(Map<String,Object> map : result){
				Map<String,Object> mp = new HashMap<String,Object>();
				String define = map.get("DEFINE")+"";
				String count = map.get("COUNT")+"";
				mp.put("colname1", i);
				mp.put("colname2", define);
				mp.put("colname3", count);
				dqslList.add(mp);
				i++;
			}
			o.setDqslList(dqslList);
			
			//设置走势图
			o.setYqzst(reportRecordService.findImage(params));
			//走势图下面的文字说明
			o.setZsttitle("图1 " + timeslot.replace("-", "至") + "全球财经网络舆情信息量走势");
			
			//设置报告最下面的日期
			o.setReportdate(DateUtil.getcurrDate());
			
			
//			params.put("viewNum", 100000);
//			List<News> grdhtList = tbXtNewsService.findGrdyqht(params);
//			//高热度舆情话题数
//			o.setGrdht(String.valueOf(grdhtList.size()));
//			
//			StringBuffer titles = new StringBuffer();
//			int i = 0;
//			for (News news : grdhtList) {
//				i++;
//				titles.append(news.getTitle());
//				if(i < grdhtList.size()){
//					titles.append("、");
//				}
//			}
//			//高热度话题标题
//			o.setGrdhtcontext(replace(titles.toString()));
//			//走势图下面的文字说明
//			o.setZsttitle("图1 " + timeslot.replace("-", "至") + "全球财经舆情信息量走势");
//			
//			//党和国家领导人
//			params.put("code", "1");
//			List<ReportRecord> dhgjldrList = reportRecordService.findByCodeAndTime(params);
//			//涉大陆热点
//			params.put("code", "2");
//			List<ReportRecord> sdlrdList = reportRecordService.findByCodeAndTime(params);
//			//涉上海热点
//			params.put("code", "3");
//			List<ReportRecord> sshrdList = reportRecordService.findByCodeAndTime(params);
//			
//			o.setDhgjldrList(ReportRecordListToMapList(dhgjldrList));
//			o.setSdlrdList(ReportRecordListToMapList(sdlrdList));
//			o.setSshrdList(ReportRecordListToMapList(sshrdList));
//			
//			//香港媒体焦点
//			params.put("code", "4");
//			List<ReportRecord> xgzlmtTabList = reportRecordService.findByCodeAndTime(params);
//			//设置香港媒体焦点标题
//			o.setXgmtjdTitle("本期香港主流网络媒体、本地平面媒体热点话题有："
//					+ titleListToString(xgzlmtTabList)
//					+ "。综合各大媒体报道，热点新闻统计如下：");
//			//设置香港媒体焦点表格标题
//			o.setXgzlmtTabTitle("表1 " + timeslot.replace("-", "至") + "香港焦点新闻");
//			//设置香港媒体焦点表格集合
//			o.setXgzlmtTabList(ReportRecordListToMapList2(xgzlmtTabList));
//			//设置香港媒体焦点内容集合
//			o.setXgzlmtcontextList(ReportRecordListToMapList(xgzlmtTabList));
//
//			//澳门媒体焦点
//			params.put("code", "5");
//			List<ReportRecord> amzlmtTabList = reportRecordService.findByCodeAndTime(params);
//			//设置澳门媒体焦点标题
//			o.setAmmtjdTitle("澳门主流网络媒体、本地平面媒体产生少数几个话题，包括："
//					+ titleListToString(amzlmtTabList)
//					+ "。综合各大媒体报道，热点新闻统计如下：");
//			//设置澳门媒体焦点表格标题
//			o.setAmzlmtTabTitle("表2 " + timeslot.replace("-", "至") + "澳门焦点新闻");
//			//设置澳门媒体焦点表格集合
//			o.setAmzlmtTabList(ReportRecordListToMapList2(amzlmtTabList));
//			//设置澳门媒体焦点内容集合
//			o.setAmzlmtcontextList(ReportRecordListToMapList(amzlmtTabList));
//			
//			//台湾媒体焦点
//			params.put("code", "6");
//			List<ReportRecord> twzlmtTabList = reportRecordService.findByCodeAndTime(params);
//			//设置台湾媒体焦点标题
//			o.setTwmtjdTitle("台湾主流网络媒体、本地平面媒体重点关注了："
//					+ titleListToString(twzlmtTabList)
//					+ "。综合各媒体报道，热点新闻统计如下：");
//			//设置台湾媒体焦点表格标题
//			o.setTwzlmtTabTitle("表3 " + timeslot.replace("-", "至") + "台湾焦点新闻");
//			//设置台湾媒体焦点表格集合
//			o.setTwzlmtTabList(ReportRecordListToMapList2(twzlmtTabList));
//			//设置台湾媒体焦点内容集合
//			o.setTwzlmtcontextList(ReportRecordListToMapList(twzlmtTabList));
//			
//			//设置走势图
//			o.setYqzst(reportRecordService.findImage(params));
//			
//			//社交网站舆情热点
//			params.put("sourceId", SourceInfo.discuss);
//			List<ReportRecord> xgtlsjzlmtTabList = reportRecordService.findXgsjwzyqrd(params);
//			params.put("sourceId", SourceInfo.hkgolden);
//			List<ReportRecord> gdtlsjzlmtTabList = reportRecordService.findXgsjwzyqrd(params);
//			params.put("sourceId", SourceInfo.uwants);
//			List<ReportRecord> uwantstlsjzlmtTabList = reportRecordService.findXgsjwzyqrd(params);
//			
//			DecimalFormat decimalFormat = new DecimalFormat("#.0");
//			
//			params.put("discussId", SourceInfo.discuss);
//			params.put("hkgoldenId", SourceInfo.hkgolden);
//			params.put("uwantsId", SourceInfo.uwants);
//			//设置新帖文数量
//			int xtw = reportRecordService.findXtw(params);
//			double db_xtw = (xtw + 0.0)/10000.0;
//			o.setXtw(String .format("%.1f",db_xtw));
//			o.setXtw(xtw+"");
//			
//			//设置点击量
//			int djl = reportRecordService.findDjl(params);
//			double db_djl = (djl + 0.0)/10000.0;
//			o.setDjl(String.format("%.1f",db_djl));
//			
//			//设置回帖量
//			int htl = reportRecordService.findHtl(params);
//			double db_htl = (htl + 0.0) / 10000.0;
//			o.setHtl(String.format("%.1f",db_htl));
//			
//			//判断非空
//			if(xgtlsjzlmtTabList != null && xgtlsjzlmtTabList.size() > 0){
//				//取第一个
//				ReportRecord xgtlq = xgtlsjzlmtTabList.get(0);
//				o.setXgtlq1("1");
//				o.setXgtlq2(replace(xgtlq.getTitle()));
//				o.setXgtlq3(dateToFormat(xgtlq.getNewsDate(),"yyyy-MM-dd"));
//				o.setXgtlq4(xgtlq.getZlm());
//				//删除第一个
//				xgtlsjzlmtTabList.remove(0);
//			}else{
//				o.setXgtlq1("");
//				o.setXgtlq2("");
//				o.setXgtlq3("");
//				o.setXgtlq4("");
//			}
//			o.setXgtlsjzlmtTabList(fillMapList(xgtlsjzlmtTabList));
//			
//			//判断非空
//			if(gdtlsjzlmtTabList != null && gdtlsjzlmtTabList.size() > 0){
//				//取第一个
//				ReportRecord gdtlq = gdtlsjzlmtTabList.get(0);
//				o.setGdtlq1("1");
//				o.setGdtlq2(replace(gdtlq.getTitle()));
//				o.setGdtlq3(dateToFormat(gdtlq.getNewsDate(),"yyyy-MM-dd"));
//				o.setGdtlq4(gdtlq.getZlm());
//				//删除第一个
//				gdtlsjzlmtTabList.remove(0);
//			}else{
//				o.setGdtlq1("");
//				o.setGdtlq2("");
//				o.setGdtlq3("");
//				o.setGdtlq4("");
//			}
//			o.setGdtlsjzlmtTabList(fillMapList(gdtlsjzlmtTabList));
//			
//			//判断非空
//			if(uwantstlsjzlmtTabList != null && uwantstlsjzlmtTabList.size() > 0){
//				//取第一个
//				ReportRecord uwantstlq = uwantstlsjzlmtTabList.get(0);
//				o.setUwantstlq1("1");
//				o.setUwantstlq2(replace(uwantstlq.getTitle()));
//				o.setUwantstlq3(dateToFormat(uwantstlq.getNewsDate(),"yyyy-MM-dd"));
//				o.setUwantstlq4(uwantstlq.getZlm());
//				//删除第一个
//				uwantstlsjzlmtTabList.remove(0);
//			}else{
//				o.setUwantstlq1("");
//				o.setUwantstlq2("");
//				o.setUwantstlq3("");
//				o.setUwantstlq4("");
//			}
//			o.setUwantstlsjzlmtTabList(fillMapList(uwantstlsjzlmtTabList));
//			
//			//设置香港社交网站表格下面文字说明
//			o.setSjzlmtTabTitle("表4 " + timeslot.replace("-", "至") + "讨论区热帖");
//			
//			//设置香港社交网站表格下面的内容
//			List<ReportRecord> sjzlmtcontextList = reportRecordService.findSjzlmtcontext(params);
//			o.setSjzlmtcontextList(fillMapList2(sjzlmtcontextList));
//			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static ReportBean initReport(String startTime,String endTime) {
		ReportBean o = new ReportBean();
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		
		Calendar c = Calendar.getInstance();
		try {
			//获得时间段（月份和日期）
			c.setTime(format.parse(startTime));
			String timeslot = (c.get(Calendar.MONTH) + 1) + "月"
								+ c.get(Calendar.DAY_OF_MONTH) + "日";
			c.setTime(format.parse(endTime));
			timeslot += "-" + (c.get(Calendar.MONTH) + 1) + "月"
					+ c.get(Calendar.DAY_OF_MONTH) + "日";
			o.setTitledate(timeslot);
			
			params.put("zlm", "正面");
			int zmyq = tbXtNewsService.findCountByZlmAndTime(params);
			params.put("zlm", "负面");
			int fmyq = tbXtNewsService.findCountByZlmAndTime(params);
			params.put("zlm", "中立");
			int zlyq = tbXtNewsService.findCountByZlmAndTime(params);
			
			
//			o.setYqztm(String.valueOf(zmyq + fmyq + zlyq));
//			o.setZmyq(String.valueOf(zmyq));
//			o.setFmyq(String.valueOf(fmyq));
//			o.setZlyq(String.valueOf(zlyq));
			
			params.put("rownum", 5);
			o.setQqzdyqList(newsListToMapList2(tbXtNewsService.yqrdListByRownum(params)));
			
			params.put("ssdq", "1");
			List<News> smzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSmzzdyqList(newsListToMapList(smzzdyqList));
			
			params.put("ssdq", "2");
			List<News> sozzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSozzdyqList(newsListToMapList(sozzdyqList));
			
			params.put("ssdq", "3");
			List<News> syzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSyzzdyqList(newsListToMapList(syzzdyqList));
			
			params.put("ssdq", "4");
			List<News> szdzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSzdzdyqList(newsListToMapList(szdzdyqList));
			
			params.put("ssdq", "5");
			List<News> sfzzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setSfzzdyqList(newsListToMapList(sfzzdyqList));
			
			params.put("ssdq", "6");
			List<News> qqjrjgzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setQqjrjgzdyqList(newsListToMapList(qqjrjgzdyqList));
			
			params.put("ssdq", "7");
			List<News> qtzdyqList = tbXtNewsService.findNewsBySSDQ(params);
			o.setQtzdyqList(newsListToMapList(qtzdyqList));
			
			
			//不同地区新闻数量
			List<Map<String,Object>> result = tbXtNewsService.groupBySsdq(params);
			List<Map<String,Object>> dqslList = new ArrayList<Map<String,Object>>();
			
			int i = 1;
			for(Map<String,Object> map : result){
				Map<String,Object> mp = new HashMap<String,Object>();
				String define = map.get("DEFINE")+"";
				String count = map.get("COUNT")+"";
				mp.put("colname1", i);
				mp.put("colname2", define);
				mp.put("colname3", count);
				dqslList.add(mp);
				i++;
			}
			o.setDqslList(dqslList);
			
			//设置走势图
			o.setYqzst(reportRecordService.findImage(params));
			//获得项目目录
			String rootPath=ReportRecordUtil.class.getResource("/").getFile().toString();
			rootPath = rootPath.substring(1,rootPath.lastIndexOf("/WEB-INF")) + "/main/report";
			File exportDirectory = new File (rootPath);
			final SamplesFactory highchartsSamples = SamplesFactory.getSingleton();
			ChartOptions chartOptions1 = highchartsSamples.createColumnBasic(tbXtNewsService,params);
			HighchartsExporter<ChartOptions> pngExporter = ExportType.png.createExporter();
//			long top2 = 0;
//			long top = System.currentTimeMillis ();
//			long total = 0;
//			top2 = System.currentTimeMillis ();
			chartOptions1 = highchartsSamples.createColumnBasic(tbXtNewsService,params);
//			total += (System.currentTimeMillis ()-top2);
			File imgFile = new File (exportDirectory, new Date().getTime()+".png");
			pngExporter.export(chartOptions1, null, imgFile);
			InputStream in = new FileInputStream(imgFile);
			byte[] data = new byte[in.available()];
			in.read(data);
			in.close();
			o.setYqzst(new BASE64Encoder().encode(data));
			imgFile.delete();
			
			//走势图下面的文字说明
			o.setZsttitle("图1 " + timeslot.replace("-", "至") + "全球财经网络热点舆情信息");
			
			//设置报告最下面的日期
			o.setReportdate(DateUtil.getcurrDate());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	/**
	 * 集合标题拼接String
	 * @param list
	 * @return
	 */
	public static String titleListToString(List<ReportRecord> list){
		StringBuffer titles = new StringBuffer();
		if(list == null){
			return titles.toString();
		}
		int i = 0;
		for (ReportRecord r : list) {
			i++;
			titles.append(r.getTitle());
			if(i < list.size()){
				titles.append("、");
			}
		}
		return titles.toString();
	}
	
	/**
	 * NewsList转MapList
	 * @param newsList
	 * @return
	 */
	public static List<Map<String,Object>> newsListToMapList(List<News> newsList){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (News news : newsList) {
			Map<String,Object> map = new HashMap<String,Object>();
			String date = dateToMM_dd(news.getPubnisihTime_sj());
			map.put("colname1", news.getUrl());
			map.put("colname2", replace(news.getTitle()));
			map.put("colname3", "《"+news.getSourceName()+"》"+date);
			map.put("colname4", replace(news.getDescribe()));
			result.add(map);
		}
		return result;
	}
	/**
	 * NewsList转MapList
	 * @param newsList
	 * @return
	 */
	public static List<Map<String,Object>> newsListToMapList2(List<News> newsList){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (News news : newsList) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("colname1", news.getTitle());
			map.put("colname2", news.getClickedCounts());
			result.add(map);
		}
		return result;
	}
	
	/**
	 * 转MapList
	 * @param list
	 * @return
	 */
	public static List<Map<String,Object>> ReportRecordListToMapList(List<ReportRecord> list){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		int i = 1;
		for (ReportRecord r : list) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("colname1", NumberChinese.test(i) + replace(r.getTitle()));
			map.put("colname2", replace(r.getContext()));
			result.add(map);
			i++;
		}
		return result;
	}
	/**
	 * 转MapList
	 * @param list
	 * @return
	 */
	public static List<Map<String,Object>> ReportRecordListToMapList2(List<ReportRecord> list){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		int i = 1;
		for (ReportRecord r : list) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("colname1", i);
			map.put("colname2", replace(r.getTitle()));
			map.put("colname3", r.getFname());
			map.put("colname4", dateToMM_dd(r.getNewsDate()));
			map.put("colname5", "新闻");
			map.put("colname6", r.getZlm());
			result.add(map);
			i++;
		}
		return result;
	}
	
	public static String dateToMM_dd(String date){
		Calendar c = Calendar.getInstance();
		String mmdd = "";
		try {
			c.setTime(format.parse(date));
			mmdd = (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DAY_OF_MONTH) + "日";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mmdd;
	}
	
	/**
	 * 替换字符串
	 * @param str
	 * @return
	 */
	public static String replace(String str){
		if(str==null||str.length()<1){
			return "";
		}
		//System.out.println();
		String str1=str.replace("<", "&lt;").replace(" ", "").replace("　", "");
		return str1;
	}
	
//	/**
//	 * clob转String
//	 * @param clob
//	 * @return
//	 * @throws SQLException
//	 * @throws IOException
//	 */
//	public static String ClobToString(Clob clob) throws SQLException, IOException {
//
//		 String reString = "";
//		 Reader is = clob.getCharacterStream();// 得到流
//		 BufferedReader br = new BufferedReader(is);
//		 String s = br.readLine();
//		 StringBuffer sb = new StringBuffer();
//		 while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
//		 sb.append(s);
//		 s = br.readLine();
//		 }
//		 reString = sb.toString();
//		 br.close();
//		 return reString;
//	}
	
	@Autowired
	public void setTbXtNewsService(TbXtNewsService tbXtNewsService) {
		ReportRecordUtil.tbXtNewsService = tbXtNewsService;
	}
	@Autowired
	public void setReportRecordService(
			ReportRecordService reportRecordService) {
		ReportRecordUtil.reportRecordService = reportRecordService;
	}
	
	
}

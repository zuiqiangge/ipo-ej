package com.pengyue.ipo.timer;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pengyue.ipo.action.system.SearchTools;
import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.NewsKeyWord;
import com.pengyue.ipo.bean.ReportBean;
import com.pengyue.ipo.collection.Task;
import com.pengyue.ipo.mq.producer.QueueSender;
import com.pengyue.ipo.service.news.ReportService;
import com.pengyue.ipo.service.news.TbXtNewsService;
import com.pengyue.ipo.util.Cosine;
import com.pengyue.ipo.util.DateFormat;
import com.pengyue.ipo.util.ReportRecordUtil;
import com.pengyue.ipo.util.ReportUtil;

public class NesMangerJob {
	/**
	 * @ 定时扫描帖子任务
	 */
	@Autowired
	private TbXtNewsService TbXtNewsService;
	@Autowired
	private ReportService reportService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	public void checkNeedsUpdate() {
		// System.out.println("NesMangerJob启动........");

		// 获取所有需要运行的Job
		// List<News> newsList = TbXtNewsService.selectNewsNeedUpdate();
		List<String> sourceIdList = TbXtNewsService.selectSourceList();
		List<NewsKeyWord> keyWords=TbXtNewsService.queryAllKeyWord();//查询过滤词
		if (sourceIdList != null && sourceIdList.size() > 0) {
			for (int i = 0; i < sourceIdList.size(); i++) {
				try {
					// 服务器内存小，这边处理下，防止内存溢出，500条索引一次
					int needNewscounts = TbXtNewsService
							.selectNewsNeedcountUpdateBySource(sourceIdList
									.get(i));
					int rowsPerPage = 200;
					int maxPage = (int) Math.ceil((needNewscounts + 0.0)
							/ rowsPerPage);

					if (maxPage > 0) {
						for (int k = 0; k < maxPage; k++) {
							int start = k * rowsPerPage + 1; // 起始
							int end = k * rowsPerPage + rowsPerPage; // 结束
							Map<String, Object> params = new HashMap<String, Object>();

							params.put("start", start);
							params.put("end", end);
							params.put("sourceid", sourceIdList.get(i));
							List<News> newsList = TbXtNewsService
									.selectNewsNeedUpdateBySource(params);
							List<News> filtNewsList=new ArrayList<News>();
							for (News news : newsList) {
								if(news!=null&&news.getTitle()!=null&&news.getContext()!=null)
								for (NewsKeyWord word : keyWords) {
									if (news.getTitle().contains(word.getKeyWord())||news.getContext().contains(word.getKeyWord())) {
										filtNewsList.add(news);
										break;
									}
								}
							} 
							SearchTools.createIndexNews(filtNewsList);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		// System.out.println("job启动");
		// List<News> newsList =
		// TbXtNewsService.selectNewsNeedUpdateBySource("15");
		// SearchTools.createIndexNews(newsList);

	}

	public static void main1(String[] args) {
		System.out.println((int) Math.ceil((501 + 0.0) / 500));
	System.out.println("collectNews启动........");
		Task task = new Task();
		task.startTask();
	}

	public void collectNews() {
		 System.out.println("collectNews启动........");
		 Task task = new Task();
		 task.startTask();
	}

	public void collectfourms() {
		 System.out.println("collectfourms启动........");
	}
	
	/**
	 * 每周一下午三点执行
	 * @throws ParseException 
	 */
	public void report() throws ParseException{
		//计算开始时间和结束时间
		Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 75);  
	   String startTime = sdf.format(calendar.getTime());
	    String endTime = sdf.format(new Date());
	    
	    System.out.println("report:"+startTime+"-"+endTime);
	    
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(startTime,endTime);
		//获得项目目录
		String rootPath=getClass().getResource("/").getFile().toString();
		rootPath = rootPath.substring(1,rootPath.lastIndexOf("/WEB-INF"));
		String reportPath = rootPath + "//main//report//";// word模板路径
		//生成的word路径
		String pt = "//main//report//" + DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "//";
		rootPath = rootPath + pt;
		File file = new File(rootPath);
		if(!file.isDirectory()){
			file.mkdirs();//不存在则创建目录
		}
		String filename =  DateFormat
				.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
				+ ".doc";
		//调用导出方法
		ReportUtil.daochu(rb,reportPath,rootPath,filename);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("reportname", "定时简报"+new Date().getTime());
		params.put("reportstartTime", sdf2.format(sdf.parse(startTime)));
		params.put("reportendTime", sdf2.format(sdf.parse(endTime)));
		params.put("userid", "");
		params.put("issave", "1");
		params.put("modelid", "1");
		params.put("reporturl", pt+filename);
		params.put("issave", "1");
		String updataFlag = this.reportService.saveReport(params);
		if(updataFlag != null && updataFlag.equals("1")){
			System.out.println("定时任务保存成功");
		}else{
			System.out.println("定时任务保存失败");
		}
		
	}
	
	
	
	
	/**
	 * 每周二上午8点
	 * @throws ParseException 
	 */
	public void report2() throws ParseException{
		//计算开始时间和结束时间
		Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 17);  
	    String startTime = sdf.format(calendar.getTime());
	    String endTime = sdf.format(new Date());
	    
	    System.out.println("report2:"+startTime+"-"+endTime);
	    
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(startTime,endTime,"");
		//获得项目目录
		String rootPath=getClass().getResource("/").getFile().toString();
		rootPath = rootPath.substring(1,rootPath.lastIndexOf("/WEB-INF"));
		String reportPath = rootPath + "//main//report//";// word模板路径
		//生成的word路径
		String pt = "//main//report//" + DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "//";
		rootPath = rootPath + pt;
		File file = new File(rootPath);
		if(!file.isDirectory()){
			file.mkdirs();//不存在则创建目录
		}
		String filename =  DateFormat
				.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
				+ ".doc";
		//调用导出方法
		ReportUtil.daochu(rb,reportPath,rootPath,filename);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("reportname", "定时简报"+new Date().getTime());
		params.put("reportstartTime", sdf2.format(sdf.parse(startTime)));
		params.put("reportendTime", sdf2.format(sdf.parse(endTime)));
		params.put("userid", "");
		params.put("issave", "1");
		params.put("modelid", "1");
		params.put("reporturl", pt+filename);
		params.put("issave", "1");
		String updataFlag = this.reportService.saveReport(params);
		if(updataFlag != null && updataFlag.equals("1")){
			System.out.println("定时任务保存成功");
		}else{
			System.out.println("定时任务保存失败");
		}
	}
	
	/**
	 * 每周四下午3点
	 * @throws ParseException 
	 */
	public void report3() throws ParseException{
		//计算开始时间和结束时间
		Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 55);  
	    String startTime = sdf.format(calendar.getTime());
	    String endTime = sdf.format(new Date());
	    
	    System.out.println("report3:"+startTime+"-"+endTime);
	    
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(startTime,endTime,"");
		//获得项目目录
		String rootPath=getClass().getResource("/").getFile().toString();
		rootPath = rootPath.substring(1,rootPath.lastIndexOf("/WEB-INF"));
		String reportPath = rootPath + "//main//report//";// word模板路径
		//生成的word路径
		String pt = "//main//report//" + DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "//";
		rootPath = rootPath + pt;
		File file = new File(rootPath);
		if(!file.isDirectory()){
			file.mkdirs();//不存在则创建目录
		}
		String filename =  DateFormat
				.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
				+ ".doc";
		//调用导出方法
		ReportUtil.daochu(rb,reportPath,rootPath,filename);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("reportname", "定时简报"+new Date().getTime());
		params.put("reportstartTime", sdf2.format(sdf.parse(startTime)));
		params.put("reportendTime", sdf2.format(sdf.parse(endTime)));
		params.put("userid", "");
		params.put("issave", "1");
		params.put("modelid", "1");
		params.put("reporturl", pt+filename);
		params.put("issave", "1");
		String updataFlag = this.reportService.saveReport(params);
		if(updataFlag != null && updataFlag.equals("1")){
			System.out.println("定时任务保存成功");
		}else{
			System.out.println("定时任务保存失败");
		}
	}
	/**
	 * 每周五上午8点
	 * @throws ParseException 
	 */
	public void report4() throws ParseException{
		//计算开始时间和结束时间
		Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 17);  
	    String startTime = sdf.format(calendar.getTime());
	    String endTime = sdf.format(new Date());
	    
	    System.out.println("report4:"+startTime+"-"+endTime);
	    
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(startTime,endTime,"");
		//获得项目目录
		String rootPath=getClass().getResource("/").getFile().toString();
		rootPath = rootPath.substring(1,rootPath.lastIndexOf("/WEB-INF"));
		String reportPath = rootPath + "//main//report//";// word模板路径
		
		//生成的word路径
		String pt = "//main//report//" + DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "//";
		rootPath = rootPath + pt;
		File file = new File(rootPath);
		if(!file.isDirectory()){
			file.mkdirs();//不存在则创建目录
		}
		String filename =  DateFormat
				.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
				+ ".doc";
		//调用导出方法
		ReportUtil.daochu(rb,reportPath,rootPath,filename);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("reportname", "定时简报"+new Date().getTime());
		params.put("reportstartTime", sdf2.format(sdf.parse(startTime)));
		params.put("reportendTime", sdf2.format(sdf.parse(endTime)));
		params.put("userid", "");
		params.put("issave", "1");
		params.put("modelid", "1");
		params.put("reporturl", pt+filename);
		params.put("issave", "1");
		String updataFlag = this.reportService.saveReport(params);
		if(updataFlag != null && updataFlag.equals("1")){
			System.out.println("定时任务保存成功");
		}else{
			System.out.println("定时任务保存失败");
		}
	}
	
	/**
	 * 更新新闻点击量
	 */
	public void updateClickedCounts(){
		int totalcount = TbXtNewsService.selectToDayNewsCount();
		int rowsPerPage = 1000;
		int maxPage = (int) Math.ceil((totalcount + 0.0) / rowsPerPage);
		if(maxPage > 0){
			for (int k = 0; k < maxPage; k++) {
				int start = k * rowsPerPage + 1; // 起始
				int end = k * rowsPerPage + rowsPerPage; // 结束
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("start", start);
				params.put("end", end);
				
				List<News> newsList = TbXtNewsService.selectToDayNews(params);
				for (int i = 0; i < newsList.size(); i++) {
					News news1 = newsList.get(i);
					int count = 1;
					for (int j = 0; j < newsList.size(); j++) {
						if(i == j){
							continue;
						}
						News news2 = newsList.get(j);
						//文本相似度大于0.3则加1
						if(Cosine.getSimilarity(news1.getTitle(), news2.getTitle()) >= 0.3){
							count++;
						}
					}
					news1.setClickedCounts(String.valueOf(count));
					System.out.println(news1.getId()+"count : "+news1.getClickedCounts());
					TbXtNewsService.updateNewsClickedcounts(news1);
				}
			}
		}
		
	}
	
	
	
	
	
}

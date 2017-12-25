package com.pengyue.ipo.action.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pengyue.ipo.bean.News;
import com.pengyue.ipo.bean.Report;
import com.pengyue.ipo.bean.ReportAddress;
import com.pengyue.ipo.bean.TbXtYhxx;
import com.pengyue.ipo.service.news.ReportAddressService;
import com.pengyue.ipo.service.news.ReportService;
import com.pengyue.ipo.service.news.TbXtNewsService;
import com.pengyue.ipo.tree.Bar;
import com.pengyue.ipo.tree.Pie;
import com.pengyue.ipo.util.JsonUtil;

/**
 * 检索Action类
 * 
 * @Author:zhuweiwei
 * @Date：2016
 */
@Controller
@Scope("prototype")
public class SearchAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	protected static Logger log = Logger
			.getLogger(SearchAction.class.getName());

	@Autowired
	private TbXtNewsService tbXtNewsService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportAddressService reportAddressService;

	private List<News> newsList;
	private int maxPage;// 最大页
	private int maxRowCount;// 总共条数
	private int rowsPerPage = 15;// 每页显示的条数
	private int currentPage; // 当前页
	private int goPageVal; // 跳转页
	private String clickA; // 点击链接
	private String queryWord;
	private List<Map<String,Object>> sourceList;
	private String parentSourceId;
	private List<Map<String,Object>> keywordList;
	private Boolean fenci;//是否分词
	private String startTime;//开始时间
	private String endTime;//结束时间
	private List<Report> reportList;
	private List<ReportAddress> addrList;
	private String pieJsonData;
	private String barJsonData;

	public String index() {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			
			//设置最近七天时间段
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
			Date now = new Date();
			endTime = fmt.format(now);
			Calendar c = Calendar.getInstance();
			c.setTime(now);
			c.add(Calendar.DAY_OF_MONTH, -7);
			startTime = fmt.format(c.getTime());
			params.put("startTime", startTime+"000000");
			params.put("endTime", endTime+"235959");
			
			//查询关键词列表
			keywordList = tbXtNewsService.findNewsKeyword();
			//查询所有采集网站
			sourceList = tbXtNewsService.findAllSource(params);

			// 加查询条件
//			maxRowCount = tbXtNewsService.getIndexHomeCount(params);
			maxRowCount = tbXtNewsService.searchNewsCountByMap(params);
			// 最大页数 = 最大条数 /分页数
			maxPage = (int) Math.ceil((maxRowCount + 0.0) / rowsPerPage);
			// }
			int qsPage = currentPage * rowsPerPage + 1; // 起始条数
			int endPage = currentPage * rowsPerPage + rowsPerPage; // 结束条数

			params.put("qsPage", qsPage);
			params.put("endPage", endPage);
			int solrqsPage = currentPage * rowsPerPage; // 起始位置
			int solrendPage = rowsPerPage; // 结束条数
			params.put("solrqsPage", solrqsPage);
			params.put("solrendPage", solrendPage);
//			this.newsList = this.tbXtNewsService.getIndexHomeList(params);
			this.newsList = this.tbXtNewsService.searchNewsListByMap(params);
			this.pieJsonData=JsonUtil.objectToJson(this.tbXtNewsService.pieCountByGB(params));
			this.barJsonData=JsonUtil.objectToJson(this.tbXtNewsService.barCountByDay(params));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tosearch";
	}
	
	/**
	 * 全文检索查询
	 * @return
	 */
	public String newsKeyword(){
		//为null设为空字符串
		if(parentSourceId == null){
			parentSourceId = "";
		}
		rowsPerPage = 10;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			//查询关键词
			params.put("queryWord",queryWord == null || queryWord.length() < 1 ? ""
							: queryWord.trim());
			//网站id
			params.put("parentSourceId",parentSourceId == null || parentSourceId.length() < 1 ? ""
							: parentSourceId.trim());
			
			//时间区间
			if(startTime != null && startTime.trim().length() > 0 && endTime != null && endTime.trim().length() > 0){
				params.put("startTime", startTime + "000000");
				params.put("endTime", endTime + "235959");
			}
			
			//是否分词
			params.put("fenci", fenci);
			
			//查询关键词列表
			keywordList = tbXtNewsService.findNewsKeyword();
			//查询所有采集网站
			sourceList = tbXtNewsService.findAllSource(params);
			
			//查询简报的条件Map
			Map<String,Object> map = new HashMap<String,Object>();
			TbXtYhxx loginUser = (TbXtYhxx) ActionContext.getContext().getSession().get("user");
			if(loginUser != null){
				map.put("userId", loginUser.getLoginId());
			}else{
				map.put("userId", "");
			}
			//查询简报
//			reportList = reportService.findReportByMap(map);
			//查询所有板块
//			addrList = reportAddressService.findAll();
			
			// 加查询条件
//			maxRowCount = tbXtNewsService.getIndexHomeCount(params);
			maxRowCount = tbXtNewsService.searchNewsCountByMap(params);
			// 最大页数 = 最大条数 /分页数
			maxPage = (int) Math.ceil((maxRowCount + 0.0) / rowsPerPage);
			
			int qsPage = currentPage * rowsPerPage + 1; // 起始条数
			int endPage = currentPage * rowsPerPage + rowsPerPage; // 结束条数

			params.put("qsPage", qsPage);
			params.put("endPage", endPage);
			int solrqsPage = currentPage * rowsPerPage; // 起始位置
			int solrendPage = rowsPerPage; // 结束条数
			params.put("solrqsPage", solrqsPage);
			params.put("solrendPage", solrendPage);
//			this.newsList = this.tbXtNewsService.getIndexHomeList(params);
			this.newsList = this.tbXtNewsService.searchNewsListByMap(params);
			this.pieJsonData=JsonUtil.objectToJson(this.tbXtNewsService.pieCountByGB(params));
			this.barJsonData=JsonUtil.objectToJson(this.tbXtNewsService.barCountByDay(params));
			System.out.println(newsList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tosearch";
	}
	
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		SearchAction.log = log;
	}

	public TbXtNewsService getTbXtNewsService() {
		return tbXtNewsService;
	}

	public void setTbXtNewsService(TbXtNewsService tbXtNewsService) {
		this.tbXtNewsService = tbXtNewsService;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public long getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public long getMaxRowCount() {
		return maxRowCount;
	}

	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getGoPageVal() {
		return goPageVal;
	}

	public void setGoPageVal(int goPageVal) {
		this.goPageVal = goPageVal;
	}

	public String getClickA() {
		return clickA;
	}

	public void setClickA(String clickA) {
		this.clickA = clickA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQueryWord() {
		return queryWord;
	}

	public void setQueryWord(String queryWord) {
		this.queryWord = queryWord;
	}
	
	public List<Map<String, Object>> getSourceList() {
		return sourceList;
	}
	public void setSourceList(List<Map<String, Object>> sourceList) {
		this.sourceList = sourceList;
	}
	public String getParentSourceId() {
		return parentSourceId;
	}
	public void setParentSourceId(String parentSourceId) {
		this.parentSourceId = parentSourceId;
	}
	public List<Map<String, Object>> getKeywordList() {
		return keywordList;
	}
	public void setKeywordList(List<Map<String, Object>> keywordList) {
		this.keywordList = keywordList;
	}
	public Boolean getFenci() {
		return fenci;
	}
	public void setFenci(Boolean fenci) {
		this.fenci = fenci;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<Report> getReportList() {
		return reportList;
	}
	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}
	public List<ReportAddress> getAddrList() {
		return addrList;
	}
	public void setAddrList(List<ReportAddress> addrList) {
		this.addrList = addrList;
	}

	public String getPieJsonData() {
		return pieJsonData;
	}

	public void setPieJsonData(String pieJsonData) {
		this.pieJsonData = pieJsonData;
	}

	public String getBarJsonData() {
		return barJsonData;
	}

	public void setBarJsonData(String barJsonData) {
		this.barJsonData = barJsonData;
	}

	
	
}

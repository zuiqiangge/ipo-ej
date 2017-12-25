package com.pengyue.ipo.action.news;

 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pengyue.ipo.bean.Report;
import com.pengyue.ipo.bean.ReportAddress;
import com.pengyue.ipo.bean.ReportBean;
import com.pengyue.ipo.bean.ReportChartsBean;
import com.pengyue.ipo.bean.ReportRecord;
import com.pengyue.ipo.bean.TbXtYhxx;
import com.pengyue.ipo.collection.SourceInfo;
import com.pengyue.ipo.service.news.ReportAddressService;
import com.pengyue.ipo.service.news.ReportRecordService;
import com.pengyue.ipo.service.news.ReportService;
import com.pengyue.ipo.util.DateFormat;
import com.pengyue.ipo.util.DateUtil;
import com.pengyue.ipo.util.ReportRecordUtil;
import com.pengyue.ipo.util.ReportUtil;

@Controller
@Scope("prototype")
public class ReportAction extends ActionSupport {

	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportRecordService reportRecordService;
	@Autowired
	private ReportAddressService reportAddressService;

	private int maxPage;// 最大页
	private int maxRowCount;// 总共条数
	private int rowsPerPage = 10;// 每页显示的条数
	private int currentPage; // 当前页
	private List<Report> reportList;// 结果集
	private String reportName;
	private String startTime;
	private String endTime;

	private String reportId;
	private List<ReportAddress> addrList;

	/**
	 * 创建简报
	 */
	private String reportstartTime;
	private String reportendTime;
	private String reportImgDate = "\'周一\',\'周二\',\'周三\',\'周四\','周五','周六','周日'";
	private String zmNuberString = "320, 332, 301, 334, 390, 330, 320";
	private String zlNuberString = "150, 232, 201, 154, 190, 330, 410";

	private String fmNuberString = "820, 932, 901, 934, 1290, 1330, 1320";
	private String reportname;
	private String modelid;
	private String createFlag = "success";// 错误提示

	private String reportImg;
	private String addresscode;
	private List<String> recordIdList;
	
	/**
	 * 报告首页列表查询分页
	 * 
	 * @return
	 */
	public String findReportPage() {
		if (startTime == null || startTime.trim().length() == 0) {
			startTime = null;
		}
		if (endTime == null || endTime.trim().length() == 0) {
			endTime = null;
		}
		if (reportName == null || reportName.trim().length() == 0) {
			reportName = null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startTime", startTime == null ? null : startTime
				+ " 00:00:00");
		params.put("endTime", endTime == null ? null : endTime + " 23:59:59");
		params.put("reportName", reportName);

		maxRowCount = reportService.findCount(params);// 查询总数
		// 最大页数 = 最大条数 /分页数
		maxPage = (int) Math.ceil((maxRowCount + 0.0) / rowsPerPage);
		int start = currentPage * rowsPerPage + 1; // 起始
		int end = currentPage * rowsPerPage + rowsPerPage; // 结束

		params.put("start", start);
		params.put("end", end);
		reportList = reportService.findPage(params);// 查询
		return "reportHome";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteReport() {
		try {
			//先获得报告信息
			Report report = reportService.findReportById(reportId);
			//删除报告
			reportService.deleteReportById(reportId);
			//获得项目目录
			String rootPath=ServletActionContext.getServletContext().getRealPath("/");
			File file = new File(rootPath + "/" + report.getReportUrl());
			//存在文件则删除
			if(file.exists()){
				file.delete();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "reportList";
	}
	
	/**
	 * 报告分析
	 */
	public String reportAnalysis(){
		//获得报告对象
		Report report = reportService.findReportById(reportId);
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(report.getQuerytimeks(),report.getQuerytimejs());
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		String loginId = ((TbXtYhxx) session.get("user")) == null ? "admin"
				: ((TbXtYhxx) session.get("user")).getLoginId();
		//获得项目目录
		String rootPath=ServletActionContext.getServletContext().getRealPath("/");
		String reportPath = rootPath + "//main//report//";// word模板路径
		//生成的word路径
		rootPath = rootPath + "//main//report//"+loginId+"//"
				+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd)
				+ "//";
		
		File file = new File(rootPath);
		if(!file.isDirectory()){
			file.mkdirs();//不存在则创建目录
		}
		
		String filename =  DateFormat
				.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
				+ ".doc";
		//保存到数据库的word路径
		String savePath = "main/report/" + loginId + "/"
				+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "/"
				+ filename;
		//调用导出方法
		ReportUtil.daochu(rb,reportPath,rootPath,filename);
		
		//修改报告状态和word路径
		report.setIssave("1");
		report.setReportUrl(savePath);
		
		reportService.updateReport(report);
		return "reportList";
	}
	
	public String openWord(){
		//获得报告对象
		Report report = reportService.findReportById(reportId);
		ActionContext.getContext().getSession().put("wordPath", report.getReportUrl());
		return "openWord";
	}
	
	/**
	 * 创建report，返回图表数据到页面
	 * 
	 * @return
	 */
	public String createReport() {
		try{
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			String loginId = ((TbXtYhxx) session.get("user")) == null ? "admin"
					: ((TbXtYhxx) session.get("user")).getLoginId();
	
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("reportname", reportname == null ? "" : reportname
					.trim());
			params.put("reportstartTime", reportstartTime == null ? ""
					: reportstartTime.trim());
			params.put("reportendTime", reportendTime == null ? ""
					: reportendTime.trim());
			 
			params.put("userid", loginId);
			params.put("modelid", modelid);
			ServletContext servletContext = (ServletContext) ActionContext
					.getContext().get(ServletActionContext.SERVLET_CONTEXT);
	
			String rootPath = servletContext.getRealPath("/");
			String reportPath = rootPath + "//main//report//";// word模板路径
			rootPath = rootPath + "//main//report//"+loginId+"//"
					+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd)
					+ "//";// 生成的word路径
			String filename = reportname+DateFormat
					.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
					+ ".doc";
			String savePath = "/main/report/" + loginId + "/"
					+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "/"
					+ filename;
			params.put("reporturl", savePath);
			params.put("issave", "1");
			String updataFlag = this.reportService.saveReport(params);
			
			
			if(updataFlag != null && updataFlag.equals("1")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.parse(reportstartTime);
				reportstartTime = DateUtil.fmtDt(DateUtil.parse(reportstartTime, "yyyy-MM-dd"), "yyyyMMddHHmmss");
				reportendTime = DateUtil.fmtDt(DateUtil.parse(reportendTime, "yyyy-MM-dd"), "yyyyMMddHHmmss");
				ReportBean rb = ReportRecordUtil.initReport(reportstartTime,reportendTime);
				File file = new File(rootPath);
				if(!file.isDirectory()){
					file.mkdirs();//不存在则创建目录
				}
				//调用导出方法
				ReportUtil.daochu(rb,reportPath,rootPath,filename);
				
				//报告生成成功
				ServletActionContext.getResponse().getWriter().print("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//生成失败报错了
				ServletActionContext.getResponse().getWriter().print("0");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return NONE;
	}

	/**
	 *转换格式 取出所有日期 lx==1拿日期，lx=2拿数值
	 * 
	 * @param zmChartsBeans
	 * @return
	 */

	private List<String> chartsBeansToDateList(
			List<ReportChartsBean> zmChartsBeans, String lx) {
		// TODO Auto-generated method stub
		if (zmChartsBeans == null || zmChartsBeans.size() < 1)
			return null;
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < zmChartsBeans.size(); i++) {
			if (lx.equals("1")) {
				String month = zmChartsBeans.get(i).getTitle().substring(5, 7);
				String day = zmChartsBeans.get(i).getTitle().substring(8, 10);
				if (month.startsWith("0")) {
					month = month.substring(1, 2) + "月";
				} else {
					month = month + "月";
				}

				if (day.startsWith("0")) {
					day = day.substring(1, 2) + "日";
				} else {
					day = day + "日";
				}
				res.add(month + day);
			}

			else {
				res.add(zmChartsBeans.get(i).getRescounts());
			}
		}
		return res;
	}

	/**
	 * 将数据转换为echarts能识别格式
	 * 
	 * @return
	 */
	private String listToString(List<String> stringList, String splitString) {
		String res = "";
		if (stringList == null) {
			return null;
		}
		for (int i = 0; i < stringList.size(); i++) {
			if (i == 0) {
				if (splitString != null) {
					res = splitString + stringList.get(i) + splitString;
				} else {
					res = stringList.get(i);
				}
			} else {
				if (splitString != null) {
					res = res + "," + splitString + stringList.get(i)
							+ splitString;
				} else {
					res = res + "," + stringList.get(i);
				}
			}
		}
		return res;
	}

	/**
	 * 保存提交过来的图片
	 * 
	 * @return
	 */
	public String saveImage() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out1;
		ActionContext context = ActionContext.getContext();
		String updataFlag = "";
		try {

			Map session = context.getSession();
			String loginId = ((TbXtYhxx) session.get("user")) == null ? "admin"
					: ((TbXtYhxx) session.get("user")).getLoginId();

			String[] url = reportImg.split(",");
			String u = url[1];
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("reportname", reportname == null ? "" : reportname
					.trim());
			params.put("reportstartTime", reportstartTime == null ? ""
					: reportstartTime.trim());
			params.put("reportendTime", reportendTime == null ? ""
					: reportendTime.trim());
			 
			params.put("userid", loginId);
			params.put("modelid", modelid);
			ServletContext servletContext = (ServletContext) ActionContext
					.getContext().get(ServletActionContext.SERVLET_CONTEXT);

			String rootPath = servletContext.getRealPath("/");
			String reportPath = rootPath + "//main//report//";// word模板路径
			rootPath = rootPath + "//main//report//"+loginId+"//"
					+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd)
					+ "//";// 生成的word路径
			String filename = reportname+DateFormat
					.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
					+ ".doc";
			String savePath = "/main/report/" + loginId + "/"
					+ DateFormat.nowDate(DateFormat.DATE_FORMAT_yyyyMMdd) + "/"
					+ filename;
			 
			byte[] b = new BASE64Decoder().decodeBuffer(u);

			// 生成图片
			 
			if (!(new File(rootPath).isDirectory())) {

				new File(rootPath).mkdirs();
			}
			;
			// imagename 图片名===路径+源文件民
			String filename1 = DateFormat
					.nowDate(DateFormat.DATE_FORMAT_yyyyMMddHHmmss)
					+ ".png";
			String imagename = rootPath + filename1;
			File imgFile = new File(imagename);

			OutputStream out = new FileOutputStream(imgFile);
			out.write(b);
			out.flush();
			out.close();
			params.put("reportImg", ReportUtil.getImageStr(imagename));
			updataFlag = this.reportService.saveReport(params);
			if (updataFlag.equals("1")) {
				updataFlag = "简报创建成功，请去选择素材完善简报吧！";
			} else {
				updataFlag = "简报创建失败了，请按步骤操作！";
			}
			imgFile.delete();
			System.out.println(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out1 = response.getWriter();
				out1.print(updataFlag);
				out1.flush();
				out1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}

		return NONE;

	}
	
	/**
	 * 报告预览
	 * @return
	 */
	public String reportView(){
		//获得报告对象
		Report report = reportService.findReportById(reportId);
		//获得报告Bean
		ReportBean rb = ReportRecordUtil.initReport(report.getQuerytimeks(),report.getQuerytimejs(),reportId);
		//存入值栈
		ActionContext.getContext().getValueStack().set("reportBean", rb);
		return "reportView";
	}
	/**
	 * 查询报告记录
	 * @return
	 */
	public String findRecordByCode(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("reportId", reportId);
		params.put("code", addresscode);
		List<ReportRecord> recordList = null;
		if(addresscode.equals("7")){//香港社交网站舆情热点
			List<String> sourceIds = new ArrayList<String>();
//			sourceIds.add(SourceInfo.discuss);
//			sourceIds.add(SourceInfo.hkgolden);
//			sourceIds.add(SourceInfo.uwants);
			params.put("sourceIds", sourceIds);
			recordList = reportRecordService.findXgsjwzyqrd2(params);
		}else{
			recordList = reportRecordService.findByCodeAndTime(params);
		}
		ActionContext.getContext().getValueStack().set("recordList", recordList);
		return "dhgjldr";
	}
	
	/**
	 * 删除记录
	 * @return
	 */
	public String deleteRecord(){
		if(recordIdList != null && recordIdList.size() > 0){
			reportRecordService.deleteRecord(recordIdList);
		}
		if(addresscode != null && !addresscode.trim().equals("")){
			return "yqdesc";
		}
		return "yqgs";
	}
	
	/**
	 * 查询简报返回json数组
	 * @return
	 */
	public String findReportToJson(){
		//查询简报的条件Map
		Map<String,Object> map = new HashMap<String,Object>();
		TbXtYhxx loginUser = (TbXtYhxx) ActionContext.getContext().getSession().get("user");
		if(loginUser != null){
			map.put("userId", loginUser.getLoginId());
		}else{
			map.put("userId", "");
		}
		//查询简报
		reportList = reportService.findReportByMap(map);
		responseJsonArray(reportList);
		return null;
	}
	/**
	 * 查询所有板块返回json数组
	 * @return
	 */
	public String findAllAddressToJson(){
		addrList = reportAddressService.findAll();
		responseJsonArray(addrList);
		return null;
	}
	
	/**
	 * 响应json数组
	 * @param obj
	 */
	private void responseJsonArray(Object obj){
        /* 获得response */
        HttpServletResponse response = ServletActionContext.getResponse();
        /* 设置格式为text/json    */
        response.setContentType("text/json");
        /*设置字符集为'UTF-8'*/
        response.setCharacterEncoding("UTF-8"); 
		try {
			JSONArray array = JSONArray.fromObject(obj);
			response.getWriter().print(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getMaxRowCount() {
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Report> getReportList() {
		return reportList;
	}

	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}

	public ReportService getReportService() {
		return reportService;
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
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

	public String getReportstartTime() {
		return reportstartTime;
	}

	public void setReportstartTime(String reportstartTime) {
		this.reportstartTime = reportstartTime;
	}

	public String getReportendTime() {
		return reportendTime;
	}

	public void setReportendTime(String reportendTime) {
		this.reportendTime = reportendTime;
	}

	public String getReportImgDate() {
		return reportImgDate;
	}

	public void setReportImgDate(String reportImgDate) {
		this.reportImgDate = reportImgDate;
	}

	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public String getZlNuberString() {
		return zlNuberString;
	}

	public void setZlNuberString(String zlNuberString) {
		this.zlNuberString = zlNuberString;
	}

	public String getZmNuberString() {
		return zmNuberString;
	}

	public void setZmNuberString(String zmNuberString) {
		this.zmNuberString = zmNuberString;
	}

	public String getFmNuberString() {
		return fmNuberString;
	}

	public void setFmNuberString(String fmNuberString) {
		this.fmNuberString = fmNuberString;
	}

	public String getCreateFlag() {
		return createFlag;
	}

	public void setCreateFlag(String createFlag) {
		this.createFlag = createFlag;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReportImg() {
		return reportImg;
	}

	public void setReportImg(String reportImg) {
		this.reportImg = reportImg;
	}

	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}
	public String getAddresscode() {
		return addresscode;
	}
	public void setAddresscode(String addresscode) {
		this.addresscode = addresscode;
	}
	public List<String> getRecordIdList() {
		return recordIdList;
	}
	public void setRecordIdList(List<String> recordIdList) {
		this.recordIdList = recordIdList;
	}
	public List<ReportAddress> getAddrList() {
		return addrList;
	}
	public void setAddrList(List<ReportAddress> addrList) {
		this.addrList = addrList;
	}

}

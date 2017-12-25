package com.pengyue.ipo.action.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hankcs.hanlp.HanLP;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pengyue.ipo.bean.NewsZlm;
import com.pengyue.ipo.bean.TbXtYhxx;
import com.pengyue.ipo.bean.Tbfmc;
import com.pengyue.ipo.service.news.ReportService;
import com.pengyue.ipo.service.news.TbXtNewsService;
import com.pengyue.ipo.service.system.TbXtYhxxService;
import com.pengyue.ipo.util.HanLPUtil;
import com.pengyue.ipo.util.MD5;
/**
 * 用户管理Action类
 * 
 * @Author:zhuweiwei
 * @Date：2016
 */
@Controller
@Scope("prototype")
public class TbXtYhxxAction extends ActionSupport implements ModelDriven<TbXtYhxx>{
	private static final long serialVersionUID = 1L;
	private Key key; // 密钥
	public static String generateKeyStr = "abcdefghigklmnopqrstuvwxyz123456";
	private String encryptAlgorithm = "DES";
	protected static Logger log = Logger.getLogger(TbXtYhxxAction.class
			.getName());
	private TbXtYhxx tbXtYhxx;
	@Autowired
	private TbXtYhxxService tbXtYhxxService;
	@Autowired
	private TbXtNewsService tbXtNewsService;

	private List<TbXtYhxx> tbXtYhxxList;
	private int maxPage;// 最大页
	private int maxRowCount;// 总共条数
	private int rowsPerPage = 15;// 每页显示的条数
	private int currentPage; // 当前页
	private int goPageVal; // 跳转页
	private String clickA; // 点击链接
	private String conditionName;
	private String condition;
	private String loginerror;
	
	//测试正负面 
	@Autowired
	private ReportService reportService;

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public void  index() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse rep=ServletActionContext.getResponse();
		HttpSession httpSession = req.getSession(); 
		// 查询该用户是否存在
		try {
			TbXtYhxx usertemp = this.tbXtYhxxService
					.selectTbxtYhxxByLoginId(tbXtYhxx.getLoginId().trim());
			if (usertemp == null) {
				loginerror = "0";
			} else {
				if (usertemp.getPassword() != null
						&& usertemp.getPassword().equalsIgnoreCase(
								new MD5(tbXtYhxx.getPassword().trim()
										.toLowerCase()).compute())) {
					this.tbXtYhxx = usertemp;
					httpSession.setAttribute("user", tbXtYhxx);
					loginerror="1";
				} else {
					loginerror = "0";
				}
			}
			rep.getWriter().print(loginerror);
		} catch (Exception e) {
			e.printStackTrace();
			return ;
		}finally {
			try {
				rep.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		List<Tbfmc> fmcList=reportService.getwords();
//		 
//		for(int i=0;i<fmcList.size();i++){
//			 System.out.println(fmcList.get(i).getDefine()+"         "+HanLP.convertToTraditionalChinese(fmcList.get(i).getDefine()));
//			Map<String, Object> params = new HashMap<String, Object>();
//		 
//			params.put("define", fmcList.get(i).getDefine());
//			params.put("define_ft", HanLP.convertToTraditionalChinese(fmcList.get(i).getDefine()));
//			reportService.updateFmc(params);
//		}
		 
	}

	private static String readString3()

	{

		String str = "";

		File file = new File("f://data.txt");

		try {

			FileInputStream in = new FileInputStream(file);

			// size 为字串的长度 ，这里一次性读完

			int size = in.available();

			byte[] buffer = new byte[size];

			in.read(buffer);

			in.close();

			str = new String(buffer, "GBk");

		} catch (IOException e) {

			// TODO Auto-generated catch block

			return null;

		}
		System.out.println(str);
		return str;

	}

	/*
	 * 退出系统
	 */
	public String logout() {

		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		session.remove("user");
		session.remove("logincount");
		session.clear();
		return "inputwa";
	}
	
	public String queryUser(){
		tbXtYhxxService.queryUser(tbXtYhxx);
		return "userList";
	}
	
	public void delUser(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		try {
			tbXtYhxxService.delUser(tbXtYhxx.getLoginId());
			rep.getWriter().println("1");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				rep.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveUser(){
		HttpServletResponse rep=ServletActionContext.getResponse();
		try {
			tbXtYhxx.setPassword(new MD5(tbXtYhxx.getPassword()).compute());
			tbXtYhxx.setUserName(tbXtYhxx.getLoginId());
			//没有id则表示新注册用户
			if (tbXtYhxx.getId().equals("")) {
				tbXtYhxx.setId(UUID.randomUUID().toString().replace("-", ""));
				tbXtYhxxService.saveUser(tbXtYhxx);
				//1表示首页
				rep.getWriter().println("1");
			}else {
				tbXtYhxxService.editUser(tbXtYhxx);
				//2表示用户管理页
				rep.getWriter().println("2");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				rep.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public TbXtYhxx getModel() {
		if (tbXtYhxx==null) {
			tbXtYhxx=new TbXtYhxx();
		}
		return tbXtYhxx;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public static String getGenerateKeyStr() {
		return generateKeyStr;
	}

	public static void setGenerateKeyStr(String generateKeyStr) {
		TbXtYhxxAction.generateKeyStr = generateKeyStr;
	}

	public String getEncryptAlgorithm() {
		return encryptAlgorithm;
	}

	public void setEncryptAlgorithm(String encryptAlgorithm) {
		this.encryptAlgorithm = encryptAlgorithm;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		TbXtYhxxAction.log = log;
	}

	public TbXtYhxx getTbXtYhxx() {
		return tbXtYhxx;
	}

	public void setTbXtYhxx(TbXtYhxx tbXtYhxx) {
		this.tbXtYhxx = tbXtYhxx;
	}

	public TbXtYhxxService getTbXtYhxxService() {
		return tbXtYhxxService;
	}

	public void setTbXtYhxxService(TbXtYhxxService tbXtYhxxService) {
		this.tbXtYhxxService = tbXtYhxxService;
	}

	public List<TbXtYhxx> getTbXtYhxxList() {
		return tbXtYhxxList;
	}

	public void setTbXtYhxxList(List<TbXtYhxx> tbXtYhxxList) {
		this.tbXtYhxxList = tbXtYhxxList;
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

	public int getGoPageVal() {
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

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getLoginerror() {
		return loginerror;
	}

	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

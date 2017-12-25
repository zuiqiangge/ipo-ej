package com.pengyue.ipo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengyue.ipo.bean.ReportBean;

import sun.misc.BASE64Encoder;

/**
 * 简报工具类
 * 
 * @author zhuww
 * 
 */
public class ReportUtil {

	 

	/**
	 * 图片转换
	 * 
	 * @param name
	 * @return
	 */
	public static String getImageStr(String name) {
		String imgFile = name;
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	public static void daochu(ReportBean o, String mobanPath, String wordPath, String fileName) {
		
		// TODO Auto-generated method stub
//		ReportBean o=initReport();
		DocumentHandler dh = new DocumentHandler();
		String[][] sDate = new String[33][2];
		// 普通文本
		sDate[0][0] = "titledate";
		sDate[0][1] = o.getTitledate();
		
		sDate[1][0] = "yqztm";
		sDate[1][1] = o.getYqztm();
		
		sDate[2][0] = "zmyq";
		sDate[2][1] = o.getZmyq();
		
		sDate[3][0] = "zlyq";
		sDate[3][1] = o.getZlyq();
		
		sDate[4][0] = "fmyq";
		sDate[4][1] = o.getFmyq();
		
		sDate[5][0] = "yqht";
		sDate[5][1] = o.getYqht();
		
		sDate[6][0] = "grdht";
		sDate[6][1] = o.getGrdht();
		
		sDate[7][0] = "grdhtcontext";
		sDate[7][1] = o.getGrdhtcontext();
		
		sDate[8][0] = "zsttitle";
		sDate[8][1] = o.getZsttitle();
		
		sDate[9][0] = "xgmtjdTitle";
		sDate[9][1] = o.getXgmtjdTitle();
		
		sDate[10][0] = "xgzlmtTabTitle";
		sDate[10][1] = o.getXgzlmtTabTitle();
		
		
		sDate[11][0] = "ammtjdTitle";
		sDate[11][1] = o.getAmmtjdTitle();
		
		
		sDate[12][0] = "amzlmtTabTitle";
		sDate[12][1] = o.getAmzlmtTabTitle();
		
		
		sDate[13][0] = "twmtjdTitle";
		sDate[13][1] = o.getTwmtjdTitle();
		
		
		sDate[14][0] = "twzlmtTabTitle";
		sDate[14][1] = o.getTwzlmtTabTitle();
		
		
		sDate[15][0] = "xtw";
		sDate[15][1] = o.getXtw();
		
		
		sDate[16][0] = "djl";
		sDate[16][1] = o.getDjl();
		
		
		sDate[17][0] = "htl";
		sDate[17][1] = o.getHtl();
		
		
		sDate[18][0] = "xgtlq2";
		sDate[18][1] = o.getXgtlq2();
		sDate[19][0] = "xgtlq3";
		sDate[19][1] = o.getXgtlq3();
		sDate[20][0] = "xgtlq4";
		sDate[20][1] = o.getXgtlq4();
	 
		
		sDate[21][0] = "gdtlq2";
		sDate[21][1] = o.getGdtlq2();
		sDate[22][0] = "gdtlq3";
		sDate[22][1] = o.getGdtlq3();
		sDate[23][0] = "gdtlq4";
		sDate[23][1] = o.getGdtlq4();
		
		
		sDate[24][0] = "uwantstlq2";
		sDate[24][1] = o.getUwantstlq2();
		sDate[25][0] = "uwantstlq3";
		sDate[25][1] = o.getUwantstlq3();
		sDate[26][0] = "uwantstlq4";
		sDate[26][1] = o.getUwantstlq4();
		
		sDate[27][0] = "sjzlmtTabTitle";
		sDate[27][1] = o.getSjzlmtTabTitle();
		
		
		
		sDate[28][0] = "reportdate";
		sDate[28][1] = o.getReportdate();
		sDate[29][0] = "yqzst";
		sDate[29][1] = o.getYqzst();
		
		dh.getDataMap().put("qqzdyqList", o.getQqzdyqList());
		dh.getDataMap().put("smzzdyqList", o.getSmzzdyqList());
		dh.getDataMap().put("sozzdyqList", o.getSozzdyqList());
		dh.getDataMap().put("syzzdyqList", o.getSyzzdyqList());
		dh.getDataMap().put("szdzdyqList", o.getSzdzdyqList());
		dh.getDataMap().put("sfzzdyqList", o.getSfzzdyqList());
		dh.getDataMap().put("qqjrjgzdyqList", o.getQqjrjgzdyqList());
		dh.getDataMap().put("qtzdyqList", o.getQtzdyqList());
		
		//地区新闻数量
		dh.getDataMap().put("dqslList", o.getDqslList());
		
		dh.getDataMap().put("dhgjldrList", o.getDhgjldrList());
		
		dh.getDataMap().put("sdlrdList", o.getSdlrdList());
		
		dh.getDataMap().put("sshrdList", o.getSshrdList());
		
		dh.getDataMap().put("xgzlmtTabList", o.getXgzlmtTabList());
		
		dh.getDataMap().put("xgzlmtcontextList", o.getXgzlmtcontextList());
		
		dh.getDataMap().put("amzlmtTabList", o.getAmzlmtTabList());
		
		dh.getDataMap().put("amzlmtcontextList", o.getAmzlmtcontextList());
		
		dh.getDataMap().put("twzlmtTabList", o.getTwzlmtTabList());
		 
		dh.getDataMap().put("twzlmtcontextList", o.getTwzlmtcontextList());
		
		dh.getDataMap().put("xgtlsjzlmtTabList", o.getXgtlsjzlmtTabList());
		
		dh.getDataMap().put("gdtlsjzlmtTabList", o.getGdtlsjzlmtTabList());
		
		dh.getDataMap().put("uwantstlsjzlmtTabList", o.getUwantstlsjzlmtTabList());
		
		dh.getDataMap().put("sjzlmtcontextList", o.getSjzlmtcontextList());
		 
		 
		// 赋值
		dh.createDoc(mobanPath, "bg1128.ftl", wordPath+fileName , sDate);
		
	}

	public static ReportBean initReport() {
		ReportBean o = new ReportBean();
		// 党和国家领导人
		Map<String, Object> o1 = new HashMap<String, Object>();
		o1.put("colname1", "一涉及党和国家领导人标题1");
		o1.put("colname2", "一涉及党和国家领导人内容");

		Map<String, Object> o2 = new HashMap<String, Object>();
		o2.put("colname1", "二涉及党和国家领导人标题1");
		o2.put("colname2", "二涉及党和国家领导人内容");
		List<Map<String, Object>> dhgjldrList = new ArrayList<Map<String, Object>>();
		dhgjldrList.add(o1);
		dhgjldrList.add(o2);
		// 涉大陆热点事件
		List<Map<String, Object>> sdlrdList = new ArrayList<Map<String, Object>>();
		sdlrdList.add(o1);
		sdlrdList.add(o2);
		// 涉上海热点事件
		List<Map<String, Object>> sshrdList = new ArrayList<Map<String, Object>>();
		sshrdList.add(o1);
		sshrdList.add(o2);

		// 香港媒体焦点
		List<Map<String, Object>> xgzlmtTabList = new ArrayList<Map<String, Object>>();
		Map<String, Object> o3 = new HashMap<String, Object>();
		o3.put("colname1", "1");
		o3.put("colname2", "苹论：彭定康说的或许都对　港人宜深思");
		o3.put("colname3", "苹果日报");
		o3.put("colname4", "11-26");
		o3.put("colname5", "新闻");
		o3.put("colname6", "中立");
		Map<String, Object> o4 = new HashMap<String, Object>();
		o4.put("colname1", "2");
		o4.put("colname2", "苹论：彭定康说的或许都对　港人宜深思");
		o4.put("colname3", "苹果日报");
		o4.put("colname4", "11-26");
		o4.put("colname5", "新闻");
		o4.put("colname6", "中立");
		xgzlmtTabList.add(o3);
		xgzlmtTabList.add(o4);

		List<Map<String, Object>> xgzlmtcontextList = new ArrayList<Map<String, Object>>();
		xgzlmtcontextList.add(o1);
		xgzlmtcontextList.add(o2);

		// 澳门媒体焦点
		List<Map<String, Object>> amzlmtTabList = new ArrayList<Map<String, Object>>();
		amzlmtTabList.add(o3);
		amzlmtTabList.add(o4);
		List<Map<String, Object>> amzlmtcontextList = new ArrayList<Map<String, Object>>();
		amzlmtcontextList.add(o1);
		amzlmtcontextList.add(o2);

		// 台湾媒体焦点

		List<Map<String, Object>> twzlmtTabList = new ArrayList<Map<String, Object>>();
		twzlmtTabList.add(o3);
		twzlmtTabList.add(o4);
		List<Map<String, Object>> twzlmtcontextList = new ArrayList<Map<String, Object>>();
		twzlmtcontextList.add(o1);
		twzlmtcontextList.add(o2);

		// 社交网站舆情热点
		List<Map<String, Object>> xgtlsjzlmtTabList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> gdtlsjzlmtTabList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> uwantstlsjzlmtTabList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> sjzlmtcontextList = new ArrayList<Map<String, Object>>();
		sjzlmtcontextList.add(o1);
		sjzlmtcontextList.add(o2);
		Map<String, Object> o5 = new HashMap<String, Object>();
		o5.put("colname1", "1");
		o5.put("colname2", "苹论：彭定康说的或许都对　港人宜深思");
		o5.put("colname3", "11-26");
		o5.put("colname4", "中立");
		Map<String, Object> o6 = new HashMap<String, Object>();
		o6.put("colname1", "2");
		o6.put("colname2", "苹论：彭定康说的或许都对　港人宜深思");
		o6.put("colname3", "11-26");
		o6.put("colname4", "中立");
		
		xgtlsjzlmtTabList.add(o5);
		xgtlsjzlmtTabList.add(o6);
		gdtlsjzlmtTabList.add(o5);
		gdtlsjzlmtTabList.add(o6);
		uwantstlsjzlmtTabList.add(o5);
		uwantstlsjzlmtTabList.add(o6);
		
		//赋值
		o.setDhgjldrList(dhgjldrList);
		o.setSdlrdList(sdlrdList);
		o.setSshrdList(sshrdList);
		o.setXgzlmtTabList(xgzlmtTabList);
		o.setXgzlmtcontextList(xgzlmtcontextList);
		o.setAmzlmtTabList(amzlmtTabList);
		o.setAmzlmtcontextList(amzlmtcontextList);
		o.setTwzlmtTabList(twzlmtTabList);
		o.setTwzlmtcontextList(twzlmtcontextList);
		o.setXgtlsjzlmtTabList(xgtlsjzlmtTabList);
		o.setGdtlsjzlmtTabList(gdtlsjzlmtTabList);
		o.setUwantstlsjzlmtTabList(uwantstlsjzlmtTabList);
		o.setSjzlmtcontextList(sjzlmtcontextList);
		
		return o;
	}

}

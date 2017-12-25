package com.pengyue.ipo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * word模板处理
 * 
 * @author Administrator
 * 
 */
public class DocumentHandler {
	private Configuration configuration = null;
	//private List<Map<String, Object>> tables=new ArrayList();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public void createDoc(String dir, String fileName, String savePath,
			String[][] sDate) {
		// 要填入模本的数据文件
		//Map<String, Object> dataMap = new HashMap<String, Object>();
		getData( sDate);
		
		// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
		// 这里我们的模板是放在com.havenliu.document.template包下面
		Template t = null;
		try {
			// 从什么地方加载freemarker模板文件
			configuration.setDirectoryForTemplateLoading(new File(dir));

			// 设置对象包装器
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			// 设置异常处理器
			configuration
					.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
			// 定义Template对象
			t = configuration.getTemplate(fileName);
//			System.out.println("==============="+t);
			// configuration.setDirectoryForTemplateLoading(new File("E:/"));
			// test.ftl为要装载的模板
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File(savePath);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile), "utf-8"));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			t.process(dataMap, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 替换模板中字符串 参数;sDate---二维数组，第一列存放name，与模板中匹配,第二列存放值，要替换的值
	 * 
	 * @param dataMap
	 * @param sDate
	 */
	private void getData(  String[][] sDate) {
		for (int i = 0; i < sDate.length; i++) {
		//	System.out.println(sDate[i][0]+"========"+sDate[i][1]);
			dataMap.put(sDate[i][0], sDate[i][1]);
		}
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

 

 
	
	

}

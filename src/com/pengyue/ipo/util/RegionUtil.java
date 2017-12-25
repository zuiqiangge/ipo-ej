package com.pengyue.ipo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.pengyue.ipo.bean.RegionKeyword;

/**
 * 判断新闻地域
 * @author admin
 *
 */
public class RegionUtil {
	
	private static Map<String,String> map = new HashMap<String,String>();
	
//	static{
//		//加载配置文件
//		Properties prop =  new Properties();
//		
//		InputStream in = RegionUtil.class.getResourceAsStream("/dqkeyword.properties");
//        try  {    
//            prop.load(in);
//            for (int i = 0; i < prop.size(); i++) {
//				Enumeration<?> enu = prop.propertyNames();
//				while(enu.hasMoreElements()){
//					String key = (String)enu.nextElement();
//				    map.put(key, prop.getProperty(key));
//				} 
//			}
//        }  catch  (IOException e) {    
//            e.printStackTrace();    
//        }
//	}
	
	/**
	 * 设置Map
	 * @param keywords
	 */
	public static void setMap(List<RegionKeyword> keywords){
		for (RegionKeyword keyword : keywords) {
			map.put(keyword.getSsdq(), keyword.getKeywords());
		}
	}
	
	/**
	 * 通过内容获得新闻地域
	 * @param context
	 * @return
	 */
	public static String getRegion(String context){
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String val = map.get(key);
			for (String keyword : val.split(",")) {
				if(context.contains(keyword)){
					return key;
				}
			}
		}
		return "7"; //7表示其他对应数据库表的id
	}
}

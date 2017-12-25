package com.pengyue.ipo.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 该类用来对日期进行处理
 * 
 * @author yangzhen
 * @Date 2013-6-4 下午1:58:23
 */
public class DateUtil {

	private static final Logger logger = Logger.getLogger(DateUtil.class);

	public static final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat timeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 返回当前日期
	 * 
	 * @return
	 */
	public static String getcurrDate() {
		Date dt = new Date();
		return dateFmt.format(dt);
	}

	/**
	 * 返回当前时间
	 * 
	 * @return
	 */
	public static String getcurrTime() {
		Date dt = new Date();
		return timeFmt.format(dt);
	}

	/**
	 * 把传入的字符串转换为日期
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date parseDate(String strDate) {
		Date dt = null;
		try {
			dt = dateFmt.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("无法将字符串转换为日期:" + strDate);
		}
		return dt;
	}

	/**
	 * 把传入的字符串转换为时间
	 * 
	 * @param strTime
	 * @return
	 */
	public static Date parseTime(String strTime) {
		Date dt = null;
		try {
			dt = timeFmt.parse(strTime);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("无法将字符串转换为时间:" + strTime);
		}
		return dt;
	}

	/**
	 * 根据传入的格式串格式化日期对象返回
	 * 
	 * @param dt
	 * @param fmt
	 * @return
	 */
	public static String fmtDt(Date dt, String fmt) {
		SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
		return dateFmt.format(dt);
	}

	/**
	 * 把传入的字符串根据指定的格式将其转换为日期对象返回
	 * @param strDate
	 * @param fmt
	 * @return
	 */
	public static Date parse(String strDate, String fmt) {
		SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
		Date dt = null;
		try {
			dt = dateFmt.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("无法将字符串转换为时间,字符串为:" + strDate + ",格式为:" + fmt);
		}
		return dt;
	}
	
	
	
	/**
	 * 获取星期几
	 * @param c
	 * @return
	 */
	public static int getWeekDay(Calendar c){
		   if(c == null){
		    return -1;
		   }
		  
		   if(Calendar.MONDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 1;
		   }
		   if(Calendar.TUESDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 2;
		   }
		   if(Calendar.WEDNESDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 3;
		   }
		   if(Calendar.THURSDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 4;
		   }
		   if(Calendar.FRIDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 5;
		   }
		   if(Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 6;
		   }
		   if(Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK)){
		    return 7;
		   }
		   return -1;
		}
}

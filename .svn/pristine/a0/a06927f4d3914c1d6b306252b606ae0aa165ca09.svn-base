package com.pengyue.ipo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @author zww
 */
public class DateFormat {
	public final static String DATE_FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public final static String DATE_FORMAT_yyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_FORMAT_yyyy_MM = "yyyy-MM-dd";

	public final static String DATE_FORMAT_yyyyMMdd = "yyyyMMdd";

	public final static String DATE_FORMAT_yyyy = "yyyy";

	public final static String DATE_FORMAT_MM = "MM";

	public final static String DATE_FORMAT_dd = "dd";

	public final static String DATE_FORMAT_HHmmss = "HHmmss";

	/**
	 * @param dates
	 *            长度为6位、8位和14位日期的字符串
	 * @return 6位、8位和14位日期格式转换为年月日的格式
	 */
	public static String dateToTime(String dates) {
		String time = dates;
		if (time != null && time.length() == 14) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			String date = time.substring(6, 8);
			String hour = time.substring(8, 10);
			String minute = time.substring(10, 12);
			String second = time.substring(12, 14);
			time = year + "年" + month + "月" + date + "日 " + hour + "时" + minute
					+ "分" + second + "秒";
		}
		if (time != null && time.length() == 8) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			String date = time.substring(6, 8);
			time = year + "年" + month + "月" + date + "日";
		}
		if (time != null && time.length() == 6) {
			String year = time.substring(0, 4);
			String month = time.substring(4, 6);
			time = year + "年 " + month + "月";
		}
		if (time != null && time.length() == 5) {
			String year = time.substring(0, 4);
			String month = "0" + time.substring(4, 5);
			time = year + "年 " + month + "月";
		}
		return time;
	}

	/**
	 * 
	 * @return 获取当前格式为yyyyMMddHHmmss的日期
	 */
	public static String nowDate() {
		return nowDate(DATE_FORMAT_yyyyMMddHHmmss);
	}

	public static String nowDate24() {
		return nowDate(DATE_FORMAT_yyyy_MM_ddHHmmss);
	}

	/**
	 * @param dateFormat
	 *            日期格式
	 * @return 获取当前格式为dateFormat的日期
	 */
	public static String nowDate(String dateFormat) {
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		return formatter.format(now);
	}

	/**
	 * @param dateFormat
	 *            日期格式
	 * @return 获取当前格式为dateFormat的日期
	 */
	public static String prevDate(String dateFormat, int tran) {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - tran);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date endDate = null;
		try {
			endDate = formatter.parse(formatter.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return new SimpleDateFormat(dateFormat).format(beginDate);

		}
		return new SimpleDateFormat(dateFormat).format(endDate);
	}

	/**
	 * @param dateFormat
	 *            日期格式
	 * @return 获取当前格式为dateFormat的日期
	 */
	public static String nextDate(String dateFormat, int tran) {
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) + tran);
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		Date endDate = null;
		try {
			endDate = formatter.parse(formatter.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return new SimpleDateFormat(dateFormat).format(beginDate);

		}
		return new SimpleDateFormat(dateFormat).format(endDate);
	}

	/**
	 * @param dateFormat
	 *            日期格式
	 * @return 获取日期
	 */
	public static long gettime(String dateFormat, String time) {
		long unixTimestamp = 1441641600;
	 
		try {

			Date date = new SimpleDateFormat(dateFormat).parse(time);
			// long unixTimestamp = date.getTime() /1000;
			unixTimestamp = date.getTime();
		} catch ( Exception e) {
			//e.printStackTrace();
		}

		return unixTimestamp;
	}

	public static void main(String[] args) {
		gettime(DateFormat.DATE_FORMAT_yyyy_MM_ddHHmmss,"2015-09-08");
	}

}

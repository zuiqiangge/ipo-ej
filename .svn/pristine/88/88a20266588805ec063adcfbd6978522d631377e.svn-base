package com.pengyue.ipo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionContext;

public class ExcelUtilNew {
	@SuppressWarnings("unchecked")
	public static Map<String, List> getExcelContent(File file, String fileName,
			String excelVersion, int dataLimit) {
		int line = 0;

		Map<String, List> excelInfo = new HashMap<String, List>();

		List titles = new ArrayList();

		List rows = new ArrayList();

		int length = 0;

		Workbook wb = null;
		Sheet sheet = null;
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(file);
			// fs = new POIFSFileSystem(fi);

			if ("2003".equals(excelVersion)) {
				wb = new HSSFWorkbook(fi);

			} else {
				wb = new XSSFWorkbook(fi);
			}

			sheet = wb.getSheetAt(0);

			int firstnum = sheet.getFirstRowNum();
			int lastnum = sheet.getLastRowNum();

			for (int j = firstnum; j <= lastnum; j++) {

				if (j > dataLimit) {
					break;
				}

				Row row = sheet.getRow(j);
				if (row == null) {
					continue;
				}
				Cell cell = null;
				if (j == firstnum) { // 第一行
					for (int k = 0; k < 50; k++) {
						cell = row.getCell((short) k);
						if (cell != null) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
								titles.add(cell.getStringCellValue().trim());
							} else {
								titles.add(String.valueOf(
										cell.getNumericCellValue()).trim());
							}
						} else {
							break;
						}
					}

					// ActionContext.getContext().getSession().put(
					// "titles", titles);

				} else { // 打包数据
					List cols = new ArrayList();
					for (int i = 0; i < titles.size(); i++) {
						String value = "";
						cell = row.getCell(Short.parseShort(String.valueOf(i)));
						if (cell != null) {
							if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
								/** */
								/** 在excel里,日期也是数字,在此要进行判断 */
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									double d = cell.getNumericCellValue();
									Date date = HSSFDateUtil.getJavaDate(d);
									SimpleDateFormat sf = new SimpleDateFormat(
											"yyyy-MM-dd");
									value = sf.format(date);
								} else {
									value = getRightStr(cell
											.getNumericCellValue()
											+ "");
								}
							}
							/** */
							/** 处理字符串型 */
							else if (Cell.CELL_TYPE_STRING == cell
									.getCellType()) {
								value = cell.getStringCellValue().trim();

								if (value.indexOf("_x0000_") != -1) {
									value = value.split("_")[0];
								}
							}
							/** */
							/** 处理布尔型 */
							else if (Cell.CELL_TYPE_BOOLEAN == cell
									.getCellType()) {
								value = cell.getBooleanCellValue() + "";
							}
							/** */
							/** 其它的,非以上几种数据类型 */
							else {
								value = cell.toString() + "";
							}

						}
						if (length < value.length()) {
							length = value.length();

						}

						cols.add(value);
					}
					if (getLength(cols)) {
						rows.add(cols);
						line++;
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			file.delete();
		}
		titles.add(String.valueOf(length));
		excelInfo.put("titles", titles);
		ActionContext.getContext().getSession().put("exportCs", titles);

		excelInfo.put("content", rows);

		return excelInfo;
	}

	@SuppressWarnings("unchecked")
	private static boolean getLength(List cols) {
		boolean isLength = false;
		if (cols != null && cols.size() > 0) {
			for (int i = 0; i < cols.size(); i++) {
				String col = (String) cols.get(i);
				if (col != null && col.trim().length() > 0) {
					isLength = true;
				}
			}
		}
		return isLength;
	}

	private static String getRightStr(String sNum) {
		DecimalFormat decimalFormat = new DecimalFormat("#.000000");
		String resultStr = decimalFormat.format(new Double(sNum));
		if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
			resultStr = resultStr.substring(0, resultStr.indexOf("."));
		}
		return resultStr;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, List> readFileACCESS(String filePath,
			String tableName) {

		Map<String, List> excelInfo = new HashMap<String, List>();

		List titles = new ArrayList();// 列标题

		List rows = new ArrayList();// 行信息

		Properties prop = new Properties();
		prop.put("charSet", "gb2312"); // 这里是解决中文乱码
		prop.put("user", "");
		prop.put("password", "");
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="
				+ filePath; // 文件地址
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection(url, prop);
			stmt = (Statement) conn.createStatement();

			rs = stmt.executeQuery("select * from " + tableName);
			ResultSetMetaData data = rs.getMetaData();

			for (int i = 1; i <= data.getColumnCount(); i++) {
				String columnName = data.getColumnName(i); // 列名
				titles.add(columnName);
			}
			while (rs.next()) {
				List cols = new ArrayList();
				for (int i = 1; i <= data.getColumnCount(); i++) {
					String columnValue = rs.getString(i);// 列值
					cols.add(columnValue);
				}
				rows.add(cols);
			}
			excelInfo.put("titles", titles);
			excelInfo.put("content", rows);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return excelInfo;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, List> getReadTableACCESS(String filePath) {
		Map<String, List> maplist = new HashMap<String, List>();
		String url = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="
				+ filePath; // 文件地址
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection(url);
			conn.setCatalog(filePath);
			rs = conn.getMetaData().getTables(filePath, null, null,
					new String[] { "TABLE" });
			List tabNames = new ArrayList();
			while (rs.next()) {
				String tabName = rs.getString(3);
				tabNames.add(tabName);
			}
			maplist.put("tabnames", tabNames);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return maplist;
	}

	public static Map<String, List> getTxtContent(File file, String fileName,
			String sign) {
		// 当没有传入分隔符时 默认一个不可能出现的分隔符 直接全部读取内容
		if (sign == null) {
			sign = "~~~~~~~~~";
		}
		Map<String, List> map = new HashMap<String, List>();
		BufferedReader br = null;
		InputStreamReader read = null;
		boolean isFirst = true;
		try {
			read = new InputStreamReader(new FileInputStream(file), "GBK");
			br = new BufferedReader(read);
			String temp = null;
			List title_list = new ArrayList();
			List content_list = new ArrayList();
			String value = "";
			while ((temp = br.readLine()) != null) {
				if (isFirst) {
					String[] title = temp.split(sign);
					for (int i = 0; title != null && i < title.length; i++) {
						title_list.add(title[i]);
					}
					isFirst = false;
				} else {
					String content[] = temp.split(sign);
					List list = new ArrayList();
					for (int i = 0; content != null && i < content.length; i++) {

						if (value.length() < content[i].length()) {
							value = content[i];
						}
						list.add(content[i]);
					}
					content_list.add(list);
				}
			}
			title_list.add(value.length());
			map.put("titles", title_list);
			map.put("content", content_list);
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}

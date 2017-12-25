package com.pengyue.ipo.interceptor;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ffzfInterceptor extends AbstractInterceptor {
	private static Map<String, String> xssMap = new LinkedHashMap<String, String>();

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		// 含有脚本： script
		 //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		Map session = actionInvocation.getInvocationContext().getSession();
		ActionContext actionContext = actionInvocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);

		Enumeration params = request.getParameterNames();
		//Enumeration headerparams = request.getHeaderNames();
		String sql = "";
		String headersql = "";
		while (params.hasMoreElements()) {
			// 得到参数名
			String name = params.nextElement().toString();
			// System.out.println("name===========================" + name +
			// "--");
			// 得到参数对应值
			String[] value = request.getParameterValues(name);
			for (int i = 0; i < value.length; i++) {
				sql = sql + value[i];
			}
		}
//		while (headerparams.hasMoreElements()) {
//			// 得到参数名
//			String name = headerparams.nextElement().toString();
//			// System.out.println("name===========================" + name +
//			// "--");
//			if (name.toLowerCase().contains("X-Forwarded-For".toLowerCase())) {
//				System.out.println("过滤非法请求头");
//				return "errorRequest";
//			}
//			// 得到参数对应值
//			request.getHeader(name);
//
//			headersql = headersql + request.getHeader(name);
//
//		}
//		// 验证请求头
//		if (headerValidate(headersql)) {
//			// throw new IOException("您发送请求中的参数中含有非法字符");
//			return "errorRequest";
//			// String ip = req.getRemoteAddr();
//		}
		// System.out.println("============================SQL"+sql);
		// 有sql关键字，跳转到error.html
		if (sqlValidate(sql)) {
			// throw new IOException("您发送请求中的参数中含有非法字符");
			return "errorRequest";
			// String ip = req.getRemoteAddr();
		} else {
			return actionInvocation.invoke();
		}

	}

	// 效验
	protected static boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
				+ "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|like'|and|exec|execute|insert|create|drop|"
				+ "table|from|grant|use|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
				+ "chr|script|unescape|execscript|prompt|confirm|document.cookie|javascript|eval|img|style|'|\"|:\\|>|<|function|iframe|window|onclick|location|alert||mid|master|truncate|char|declare|or|;|-|--|+|like|%|#";// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.toLowerCase().indexOf(badStrs[i].toLowerCase()) >= 0
					&& badStrs[i].length() > 0) {
				System.out.println("iiii===" + str + "==="
						+ badStrs[i].toLowerCase());
				return true;
			}
		}
		return false;
	}

	// 效验header
	protected static boolean headerValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|%|chr|mid|master|truncate|"
				+ "char|declare|sitename|xp_cmdshell|like'|and|exec|execute|insert|create|drop|"
				+ "table|from|grant|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|select|delete|update|order|count|"
				+ "chr|script|unescape|execscript|prompt|confirm|document.cookie|style|javascript|eval|img|'|\"|iframe|:\\|location|onclick|alert|>|<|function|mid|master|truncate|char|declare|%|#";

		// String badStr = "'|\"";
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.toLowerCase().indexOf(badStrs[i].toLowerCase()) >= 0
					&& badStrs[i].length() > 0) {
				System.out.println("请求头===" + str + "==="
						+ badStrs[i].toLowerCase());
				return true;
			}
		}
		return false;
	}
}

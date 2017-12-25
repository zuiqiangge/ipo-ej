package com.pengyue.ipo.util;

import java.util.ArrayList;
import java.util.List;

import com.hankcs.hanlp.HanLP;

public class HanLPUtil {
	/**
	 * 繁体转简体
	 * 
	 * @param context
	 * @return
	 */
	public static String simplifiedChinese(String str) {
		if (str != null) {
			return HanLP.convertToSimplifiedChinese(str);
		}
		return null;
	}

	
	/**
	 * 提取摘要
	 * 
	 * @param str
	 * @return
	 */
	public static String extractSummary(String str) {
		List<String> result = null;
		// int size = 0;
		if (str != null) {
			// if(str.length() <= 500){
			// size = 5;
			// }else if(str.length() <= 1000){
			// size = 10;
			// }else{
			// size = 15;
			// }
			// result = HanLP.extractSummary(str, size);

			String document = str;
			int len1 = 0;
			if (document.split(",") != null) {
				len1 = document.split(",").length;
			}
			int len2 = 0;
			if (document.split("，") != null) {
				len1 = document.split("，").length;
			}
			int len = 10;
			if (len2 > len1) {
				len = len2;
			} else if (len2 < len1) {
				len = len1;
			}

			List<String> sentenceList = HanLP.extractSummary(document, len+5);
			// System.out.println(sentenceList);
			// System.out.println(sentenceList.get(0) + "    " +
			// sentenceList.size()
			// + "       " +
			// document.split("，").length+"         document=="+document.length());
			List<Integer> sorderHanp = new ArrayList<Integer>();
			for (int i = 0; i < sentenceList.size(); i++) {
				sorderHanp.add(document.indexOf(sentenceList.get(i)));
				// if(document.indexOf(sentenceList.get(i))==-1){
				// System.out.println("xxxxxxxxxxxxxxxxxxx");
				// }
			}

			for (int i = 0; i < sorderHanp.size() - 1; i++) {
				int minsorder = sorderHanp.get(i);
				for (int j = i + 1; j < sorderHanp.size(); j++) {
					if (sorderHanp.get(j) <= minsorder) {
						int tran = sorderHanp.get(i);
						sorderHanp.set(i, sorderHanp.get(j));
						sorderHanp.set(j, tran);
						minsorder = sorderHanp.get(i);

						String transec = sentenceList.get(i);
						sentenceList.set(i, sentenceList.get(j));
						sentenceList.set(j, transec);
					}
				}
			}

			result = sentenceList;

			return result.toString().replace("[", "").replace("]", "").replace(" ", "").replace("　", "") + "。";
		}
		return null;
	}

	/**
	 * 提取关键词
	 * 
	 * @param str
	 * @return
	 */
	public static String extractKeyword(String str) {
		List<String> result = null;
		if (str != null) {
			result = HanLP.extractKeyword(str, 1);
			return result.toString().replace("[", "").replace("]", "");
		}
		return null;
	}
}

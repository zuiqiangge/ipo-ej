package com.pengyue.ipo.util;

import com.pengyue.ipo.bean.NewsZlm;

public class NewsZlmUtil {
	public static String getZlmBy(NewsZlm o) {
		String resString = "中立";
//		if (o.getZm() == 0 && o.getFm() == 0 && o.getZl() == 0) {
//			return resString;
//		} else {
//			if (o.getZm() > o.getFm() && o.getZm() > o.getZl()) {
//				return "正面";
//			}
//			if (o.getZm() < o.getFm() && o.getFm() > o.getZl()) {
//				return "负面";
//			}
//		}
		int zf = o.getZm() - o.getFm();
		if (zf >= -5 && zf <= 13) {
			return "中立";
		}else if(zf>13){
			return "正面";
		}else{
			return "负面";
		}

	}
}

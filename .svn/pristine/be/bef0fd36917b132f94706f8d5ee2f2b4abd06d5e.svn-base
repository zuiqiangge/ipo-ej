package com.pengyue.ipo.util;

import com.google.gson.Gson;

public class JsonUtil {
	private static Gson gson;
	static {
		if (gson == null) {
			gson = new Gson();

		}

	}

	public static String objectToJson(Object obj) {

		String jsonStr = null;
		if (obj != null) {
			jsonStr = gson.toJson(obj);

		}

		return jsonStr;
	}

}

package com.pengyue.ipo.action;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IMEI {
	public static void main(String[] args) {
		int t=(int) System.currentTimeMillis();
		long t1=1486699911044L;
		int t2=(int)(t1);
		System.out.println(String.valueOf(System.currentTimeMillis()));
		System.out.println(String.valueOf(t));
		System.out.println(String.valueOf(t1));
		System.out.println(~t2);
	}

	public static String encode(String content) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			return getEncode32(digest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getEncode32(MessageDigest digest) {
		StringBuilder builder = new StringBuilder();
		for (byte b : digest.digest()) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}
		return builder.toString();

	}
}

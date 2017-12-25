package com.pengyue.ipo.util;

public class StringValidata {

	/**
	 * 验证是否为中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean chinese(String str) {

		char[] chars = str.toCharArray();
		boolean isGB2312 = false;
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes();
			if (bytes.length == 2) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;

				if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40
						&& ints[1] <= 0xFE) {
					isGB2312 = true;
					break;
				}
			}
		}
		return isGB2312;
	}

	// 根据Unicode编码完美的判断中文汉字和符号
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
			return true;
		}
		return false;
	}

	// 完整的判断中文汉字和符号
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!isChinese(c)) {
				return false;
			}
		}
		return true;
	}

	//判断是否包含中文
	public static boolean isIncludeChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasnumber(String str) {
		boolean includeNum = true;// 包含数字

		boolean includeLetter = false;// 包含字母
		boolean includeOther = false;// 包含其它字符
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {

			} else {
				return false;
			}
		}
		return includeNum;
	}

	public static boolean haschar(String str) {
	 

		boolean includeLetter = true;// 包含字母
	 
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
		  if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			} else {
				return false;
			}
		}
		return includeLetter;
	}

	public static boolean hasother(String str) {
	 
		boolean includeOther = true;// 包含其它字符
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				return false;
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				return false;
			} else {
			 
			}
		}
		return includeOther;
	}

	public static void main(String[] args) {
		System.out.println(isChinese("中国2"));
	}
}

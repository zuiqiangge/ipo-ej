package com.pengyue.ipo.util;

import org.apache.commons.id.Hex;

public class AutoId {
	public static String getCode() {
		return new String(Hex.encodeHex(org.apache.commons.id.uuid.UUID
				.randomUUID().getRawBytes()));
	}
}

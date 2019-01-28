package com.yongqi.util;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getUUID() {
		String uid = UUID.randomUUID().toString().replaceAll("-", "");
		return uid;
	}
}

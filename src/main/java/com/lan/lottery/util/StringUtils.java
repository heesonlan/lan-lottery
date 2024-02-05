package com.lan.lottery.util;

import java.util.UUID;

/**
 * 
 * @author lanhezhong
 * @date 2023年12月30日
 */
public abstract class StringUtils {
	public static String F="£";

	public static boolean isEmpty(Object str) {
		return (str == null || "".equals(str));
	}

	public static String randomUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

}


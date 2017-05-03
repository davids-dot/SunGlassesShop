package com.zhao.util;

public class ELUtil {

	public static String mapToServer(String realPath) {
		realPath = realPath.replace("F:", "/pic");
		return realPath;
	}

}

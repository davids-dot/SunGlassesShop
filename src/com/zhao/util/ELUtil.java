package com.zhao.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class ELUtil {

	public static String mapToServer(String realPath) {
		realPath = realPath.replace("F:", "/pic");
		return realPath;
	}

	public static String realDate(Long dateStr) {

		String str = dateStr.toString();
		int len = str.length();
		String realStr = str.substring(len - 13, len);
		Date d = new Date(Long.parseLong(realStr));
		return DateFormat.getDateTimeInstance(1, 1, Locale.CHINA).format(d);
	}

	public static void main(String[] args) {

	}

}

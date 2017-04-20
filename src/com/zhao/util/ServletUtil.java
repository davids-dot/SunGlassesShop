package com.zhao.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zhao.exception.IllegalException;

public class ServletUtil {

	public ServletUtil() {
	}

	public static Map<String, String> request2Map(HttpServletRequest request, String... args) throws IllegalException {

		Map<String, String> map = new HashMap<String, String>();
		String value;
		for (String s : args) {
			value = request.getParameter(s);
			if (value == null || value.trim().equals("")) {
				throw new IllegalException("未输入内容" + s);
			}
			map.put(s, value);
		}
		return map;
	}

}

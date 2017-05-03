package com.zhao.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.zhao.entity.Customer;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.entity.User;
import com.zhao.exception.IllegalException;
import com.zhao.service.CustomerService;
import com.zhao.service.impl.CustomerServiceImpl;

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

	public static String generateUname(String fileName) {
		return UUID.randomUUID().toString() + "_" + fileName;
	}

	public static String generateRealPath(String PATH, String uName) {
		int hashCode = uName.hashCode();
		int dir1 = hashCode & 0xf;
		int dir2 = (hashCode >> 4) & 0xf;
		String realPath = PATH + File.separator + dir1 + File.separator + dir2;
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		return realPath;

	}

	/*
	 * request 中 "cur","pSize"
	 */

	public static QueryInfo request2QueryInfo(HttpServletRequest request) {

		QueryInfo queryInfo = new QueryInfo();
		String currentPage = request.getParameter("cur");

		/*
		 * 默认分页开始，及大小
		 */
		if (currentPage == null || currentPage.trim().equals("")) {
			return queryInfo;
		}

		/*
		 * 某分页页面，默认大小
		 */
		queryInfo.setCurrentPage(Integer.parseInt(currentPage));
		String pageSize = request.getParameter("pSize");
		if (pageSize == null || pageSize.trim().equals("")) {
			return queryInfo;
		}

		/*
		 * 指定分页大小
		 */
		queryInfo.setPageSize(Integer.parseInt(pageSize));
		return queryInfo;

	}

	public static void LoginInSession(User user, HttpServletRequest req) {

		String type = user.getType();
		if (type.equals("Customer")) {
			Customer cus = new Customer(user);
			req.getSession().setAttribute("user", cus);
			return;
		}

		if (type.equals("Seller")) {
			Seller sel = new Seller(user);
			req.getSession().setAttribute("user", sel);
			return;
		}

	}

	public static Customer checkCustomerInSession(CustomerService cs, HttpServletRequest request, HttpSession session) {

		Customer cus = (Customer) session.getAttribute("user");
		if (cus.getCustomer_id() == null) {
			Customer temp = cs.find(cus.getName());
			cus.addAttribute(temp);
		}
		return cus;
	}

}

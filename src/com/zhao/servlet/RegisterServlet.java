package com.zhao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.dao.impl.UserDaoImpl;
import com.zhao.entity.User;
import com.zhao.service.VerifyService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");

		if (type == null || type.trim().equals("")) {
			return;
		}

		if (type.equals("verify")) {
			verify(request, response);
			return;
		}

		if (type.equals("register")) {
			register(request);
			forward(request, response);
			return;
		}

	}

	/*
	 * 注册成功后进行转发
	 */

	private void forward(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.getRequestDispatcher("/jsp/successRegister.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;

	}

	private void register(HttpServletRequest request) {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mobilePhone = request.getParameter("mobilephone");
		String userType = mapUserType(request.getHeader("referer"));

		if (name == null || password == null || mobilePhone == null || "".equals(name) || "".equals(password)
				|| "".equals(mobilePhone)) {
			return;
		}

		User user = new User(name, password, mobilePhone, userType);
		UserDaoImpl cu = new UserDaoImpl();
		cu.addUser(user);
		System.out.println("addUser Finished");
		// 注册过后，该用户自动登录，将用户信息存入session

		HttpSession session = request.getSession(false);
		session.setAttribute("user", user);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String mapUserType(String pre) {

		pre = pre.substring(pre.lastIndexOf('/') + 1, pre.length());

		if (pre.equals("Customer_register.jsp")) {
			return "Customer";
		}

		if (pre.equals("Admin_register.jsp")) {
			return "Admin";
		}

		if (pre.equals("Seller_register.jsp") || pre.equals("Seller_register.html")) {

			return "Seller";
		}

		return null;
	}

	private void verify(HttpServletRequest request, HttpServletResponse response) {

		String userType = mapUserType(request.getHeader("referer"));
		String param = request.getParameter("param");
		boolean valid = false;

		VerifyService cvs = new VerifyService();

		switch (param) {
		case "Name":
			valid = !cvs.nameExist(request.getParameter("name"), userType);
			break;

		case "Phone":
			valid = !cvs.phoneExist(request.getParameter("mobilephone"), userType);
			break;
		default:
			;
		}

		try {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(valid ? "true" : "false");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

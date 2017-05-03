package com.zhao.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.entity.Customer;
import com.zhao.entity.Seller;
import com.zhao.entity.User;
import com.zhao.exception.IllegalException;
import com.zhao.service.LoginRegisterService;
import com.zhao.service.SellerService;
import com.zhao.service.impl.LoginRegisterServiceImpl;
import com.zhao.service.impl.SellerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Map<String, String> args = ServletUtil.request2Map(request, "user_name", "pass_word", "verify_Code",
					"type");
			Map<String, String> errors = new HashMap<String, String>();

			LoginRegisterService ls = new LoginRegisterServiceImpl();
			boolean isRightPair = ls.isCorrectPair(args.get("user_name"), args.get("pass_word"), args.get("type"));
			if (!isRightPair) {
				errors.put("error1", "用户名或密码错误");
				errorLogin(request, response, errors);
				return;
			}

			String serverCode = (String) request.getSession(false).getAttribute("loginCode");
			if (serverCode == null) {
				throw new IllegalException("服务器未保存验证码");
			}
			if (!serverCode.equals(args.get("verify_Code"))) {
				errors.put("error2", "验证码错误，请重新获取");
				errorLogin(request, response, errors);
				return;
			}

			// 登录成功

			successLogin(request, response, args);

		} catch (IllegalException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 
	 * 登录成功，将user 记录在 session 中，如果是卖家，记录状态
	 */
	private void successLogin(HttpServletRequest request, HttpServletResponse response, Map<String, String> map) {
		User user = new User();
		user.setType(map.get("type"));
		user.setName(map.get("user_name"));
		user.setType(map.get("type"));

		ServletUtil.LoginInSession(user, request);

		try {
			if (user.getType().equals("Customer")) {
				response.sendRedirect(request.getServletContext().getContextPath());
				return;
			}

			else {

				SellerService ss = new SellerServiceImpl();
				HttpSession session = request.getSession(false);
				Seller sel = (Seller) session.getAttribute("user");
				Integer status = ss.ensureStatus(sel);
				session.setAttribute("status", status);
				response.sendRedirect(request.getServletContext().getContextPath() + "/jsp/SellerManage.jsp");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void errorLogin(HttpServletRequest request, HttpServletResponse response, Map<String, String> err) {
		request.setAttribute("errors", err);

		try {

			if (request.getParameter("type").equals("Customer")) {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}

			request.getRequestDispatcher("/SellerLogin.jsp").forward(request, response);

		} catch (ServletException | IOException e) {
			System.exit(0);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

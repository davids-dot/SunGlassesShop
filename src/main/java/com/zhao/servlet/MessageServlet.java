package com.zhao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.message.SmsBase;
import com.zhao.message.VerifyCodeProcessor;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String registerContent = "您好，欢迎成为明宇新用户。您本次注册的验证码为";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 必须先设编码再获取输出流对象

		String type = request.getParameter("type");
		if (type == null && "".equals(type)) {
			return;
		}

		if (type.equals("register")) {
			sendMessage(request, response);
			return;
		}

		if (type.equals("verifyCode")) {

			HttpSession session = request.getSession(false);
			String serverCode = (String) session.getAttribute("verifyCode");
			if (session != null)
				session.removeAttribute("verifyCode");

			String clietCode = request.getParameter("verifyCode");
			System.out.println("clientCode" + clietCode);
			System.out.println("serverCode" + serverCode);

			response.setContentType("application/json;charset=UTF-8");
			if (serverCode == null || clietCode == null || serverCode.equals("") || clietCode.equals("")
					|| !serverCode.equals(clietCode)) {
				response.getWriter().write("false");
				return;
			}

			response.getWriter().write("true");
			return;
		}

	}

	private void sendMessage(HttpServletRequest request, HttpServletResponse response) {

		String mobile = request.getParameter("mobile");
		SmsBase sms = SmsBase.getSms();

		VerifyCodeProcessor veri = VerifyCodeProcessor.getCodeProcessor();
		String verifyCode = veri.getVerifyCode();
		System.out.println(verifyCode);

		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", verifyCode);
		System.out.println("发送了验证码" + verifyCode);

		// try {
		// sms.SendSms(mobile, registerContent + verifyCode);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

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

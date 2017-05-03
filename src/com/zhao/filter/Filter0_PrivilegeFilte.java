package com.zhao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filter0_PrivilegeException
 * 
 * urlPatterns 必须以 / 开头，否则Tomcat 启动不了
 */
@WebFilter(filterName = "/Filter0_PrivilegeFilter", urlPatterns = { "/html/Seller_manage.html", "/CartServlet",
		"/BussinessServlet" })
public class Filter0_PrivilegeFilte implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		try {
			HttpSession session = req.getSession(false);
			if (session == null) {
				throw new NoPrivilegeException("ggg");
			}
			if (session.getAttribute("user") == null) {
				throw new NoPrivilegeException("ggg");
			}

			chain.doFilter(req, res);

		} catch (NoPrivilegeException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("code", "error");
			req.setAttribute("msg", "请先登录再操作");

			// 一般是顾客未登录，如此设置为顾客登录地址
			req.setAttribute("login", req.getServletContext().getContextPath() + "/login.jsp");
			req.getRequestDispatcher("/jsp/error.jsp").forward(request, response);

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * @see Exception#Exception()
	 */

}

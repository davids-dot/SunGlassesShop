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
@WebFilter(filterName = "/Filter0_PrivilegeFilter", urlPatterns = { "/html/Seller_manage.html" })
public class Filter0_PrivilegeFilte implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

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

		} catch (Exception e) {
			res.sendError(403, "您无权访问该资源");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see Exception#Exception()
	 */

}

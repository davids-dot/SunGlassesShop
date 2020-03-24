package com.zhao.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Page;
import com.zhao.entity.UserCustom;
import com.zhao.service.UserManageService;
import com.zhao.service.impl.UserManageServiceImpl;

@WebServlet("/UserManageServlet")
public class UserManageSevlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserManageService userManageService = new UserManageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page op = new Page();

		// 是不是由具体操作进来的，如果是，执行后返回结果集第一页
		String option = request.getParameter("option");
		if (option != null) {
			String userid = (request.getParameter("userid"));
			String usertype = request.getParameter("usertype");
			if (option.equals("delete")) {
				try {
					userManageService.deleteUser(userid, usertype);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (option.equals("active")) {
				try {
					userManageService.activeUser(userid, usertype);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			op.setNextPage(0);
		} else {
			// 获取参数
			int pagenumber = Integer.parseInt(request.getParameter("page.nextPage"));
			op.setNextPage(pagenumber);
		}

		// 查询
		List<UserCustom> queryUsers = null;
		try {
			queryUsers = userManageService.queryUsers(op, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("userMangeList", queryUsers);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manager/jsp/registermanager.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

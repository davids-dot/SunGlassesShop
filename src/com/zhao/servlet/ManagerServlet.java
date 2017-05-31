package com.zhao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.dao.impl.DayTransactionDaoImpl;
import com.zhao.entity.DayTransactionAmount;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.exception.IllegalException;
import com.zhao.service.ManagerService;
import com.zhao.service.impl.ManageServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class ManagerServlet
 */

@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String type = request.getParameter("type");
			if (type == null || type.trim().equals("")) {
				throw new IllegalException("管理员管理中未定义类型");
			}

			if (type.equals("queryAmount")) {
				queryDayAmount(request, response);
				return;
			}

			if (type.equals("queryShopRank")) {
				queryOrderRank(request, response);
				return;
			}
		}

		catch (IllegalException e) {
			e.printStackTrace();
		}
		// ${pageContext.servletContext.contextPath}/ManagerServlet?type=queryOrderRank&cur=1&psize=5
	}

	private void queryOrderRank(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);
		ManagerService ms = new ManageServiceImpl();
		PageBean page = ms.queryShopRank(queryInfo);
		request.setAttribute("page", page);
		request.setAttribute("queryInfo", queryInfo);

		request.getRequestDispatcher("/manager/jsp/shopList.jsp").forward(request, response);

	}

	private void queryDayAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ManagerService ms = new ManageServiceImpl();
		List<DayTransactionAmount> list = ms.queryDayAmount();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/manager/jsp/orderChart1.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

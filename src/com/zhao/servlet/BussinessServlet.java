package com.zhao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.entity.Customer;
import com.zhao.entity.Order;
import com.zhao.exception.NoAvailableGoodsException;
import com.zhao.service.CustomerService;
import com.zhao.service.impl.CustomerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class BussinessServlet
 */
@WebServlet("/BussinessServlet")
public class BussinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BussinessServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		if (type == null || type.trim().equals("")) {
			System.out.println("不合法参数");
			return;
		}

		CustomerService cs = new CustomerServiceImpl();
		HttpSession session = request.getSession(false);
		Customer cus = ServletUtil.checkCustomerInSession(cs, request, session);

		if (type.equals("buy")) {// 买单个商品
			buyGoods(request, response, cus);
			return;
		}
		if (type.equals("showAll")) {
			List<Order> orders = cs.queryOrders(cus.getCustomer_id());
			session.setAttribute("orders", orders);
			response.sendRedirect("/SunGlassesShop/jsp/order/orderList.jsp");
		}
	}

	private void buyGoods(HttpServletRequest request, HttpServletResponse response, Customer cus)
			throws ServletException, IOException {
		CustomerService cs = new CustomerServiceImpl();
		try {
			Integer goods_id = Integer.parseInt(request.getParameter("goods_id"));
			Order order = cs.buyGoods(goods_id, cus.getCustomer_id());
			request.getSession(false).setAttribute("order", order);
			request.getRequestDispatcher("/jsp/order/orderSucc.jsp").forward(request, response);

		} catch (NoAvailableGoodsException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/noAvailableGoods.jsp").forward(request, response);
		}

	}

}

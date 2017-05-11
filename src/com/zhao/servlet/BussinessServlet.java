package com.zhao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.dao.CartDao;
import com.zhao.dao.OrderDao;
import com.zhao.dao.impl.CartDaoImpl;
import com.zhao.dao.impl.OrderDaoImpl;
import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;
import com.zhao.entity.Customer;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
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
	 * 
	 * 
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
		Customer cus = ServletUtil.checkCustomerInSession(cs, session);

		if (type.equals("buy")) {// 买单个商品
			buyGoods(request, response, cus);
			return;
		}

		/*
		 * <form id="jieSuanForm"
		 * action="${pageContext.servletContext.contextPath}/BussinessServlet"
		 * method="post">
		 * 
		 * <input type="hidden" name="type" value="buySomeGoods"/> </form>
		 * 
		 */

		if (type.equals("buySomeGoods")) {
			// type

			buySomeGoods(request, response, cus);
			return;
		}

		// ff //
		if (type.equals("showSome")) {
			QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);
			PageBean page = cs.querySomeOrders(cus.getCustomer_id(), queryInfo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/order/orderList.jsp").forward(request, response);
			return;
		}

		/*
		 * {type:'pay',order_id:id}
		 */
		if (type.equals("pay")) {

			Long order_id = Long.parseLong(request.getParameter("order_id"));

			System.out.println(order_id);

			Order order = cs.pay(order_id);

			request.getSession(false).setAttribute("payOrder", order);
			response.sendRedirect(request.getServletContext().getContextPath() + "/jsp/order/pay.jsp");
			return;
		}

		// ${pageContext.servletContext.contextPath}/BussinessServlet?type=payConfirm&order_id=${payOrder.order_id}
		if (type.equals("payConfirm")) {
			Long order_id = Long.parseLong(request.getParameter("order_id"));

			cs.payConfirm(order_id);
			Map<String, Object> queryParam = new HashMap<String, Object>();
			queryParam.put("order_id", order_id);

			PageBean page = cs.querySomeOrders(queryParam, ServletUtil.request2QueryInfo(request));
			request.setAttribute("page", page);

			request.getSession(false).removeAttribute("payOrder");

			request.getRequestDispatcher("/jsp/order/orderList.jsp").forward(request, response);
			return;
		}

		if (type.equals("confirmReceipt")) {
			changeOrder(request, response, type);
			return;
		}

		// if (type.equals("showAll")) {
		// List<Order> orders = cs.queryOrders(cus.getCustomer_id());
		// session.setAttribute("orders", orders); // 这里仍是 session
		// response.sendRedirect("/SunGlassesShop/jsp/order/orderList.jsp");
		// return;
		// }

	}

	private void changeOrder(HttpServletRequest request, HttpServletResponse response, String type) throws IOException {
		Long order_id = Long.parseLong(request.getParameter("orderId"));
		OrderDao odao = new OrderDaoImpl();

		switch (type) {

		case "confirmReceipt":
			odao.changeOrderStatus(order_id, OrderType.CONFIRMED.ordinal());
			break;
		}
		response.getWriter().println("OK");
		return;
	}

	/*
	 * 
	 * <input type="hidden" name="cartItemIds" id="cartItemIds"/> <input
	 * type="hidden" name="total" id="hiddenTotal"/> <input type="hidden"
	 * name="method" value="loadCartItems"/>
	 */
	private void buySomeGoods(HttpServletRequest request, HttpServletResponse response, Customer cus)
			throws ServletException, IOException {

		// items 是session 中数据
		List<CartItem> items = ((Cart) request.getSession(false).getAttribute("cart")).getItems();

		// 前端传过来的cartItems
		String cartItems = request.getParameter("cartItemIds");
		double totalPrice = Double.parseDouble(request.getParameter("total"));

		Pattern pattern = Pattern.compile("([0-9]+)&([0-9]+)");
		Matcher matcher = pattern.matcher(cartItems);

		// buys 是保存的 cartItems
		ArrayList<CartItem> buys = new ArrayList<CartItem>();

		while (matcher.find()) {
			Integer goods_id = Integer.parseInt(matcher.group(1));
			Integer shop_id = Integer.parseInt(matcher.group(2));
			int index = items.indexOf(new CartItem(goods_id, shop_id));
			buys.add(items.get(index));
		}

		CustomerService cs = new CustomerServiceImpl();
		Order order = cs.buyGoods(buys, cus.getCustomer_id());

		// 购买之后，从cart中删除
		Cart cart = (Cart) request.getSession(false).getAttribute("cart");

		CartDao cdao = new CartDaoImpl();
		for (CartItem item : buys) {
			cdao.removeFromCart(item.getGoods_id(), item.getShop_id(), cart);
		}
		cart.getItems().removeAll(buys);
		// 购买之后，从cart中删除

		request.getSession(false).setAttribute("order", order);
		request.getRequestDispatcher("/jsp/order/orderSucc.jsp").forward(request, response);

		System.out.println("购买物品总价值" + totalPrice);
	}

	/*
	 * 买单个商品
	 */
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

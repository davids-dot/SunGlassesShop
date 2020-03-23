package com.zhao.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Cart;
import com.zhao.entity.CartItem;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet() {
		super();
		// TODO Auto-generated constructor stub
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ajax = request.getHeader("X-Requested-With");
		if (ajax == null) {
			// 以后操作
		}

		String type = request.getParameter("type");

		if (type == null || type.trim().equals("")) {
			return;
		}

		if (type.equals("cart")) {
			doCartConcernd(request, response);
			return;
		}
		System.out.println(type);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/*
	 * {type:"cart",method:"updateQuantity",cartItemId:goods_id,shopId:shop_id,
	 * num:quantity}, },
	 */

	private void doCartConcernd(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String method = request.getParameter("method");

		if (method.equals("updateQuantity")) {
			updateQuantity(request, response);
			return;
		}

	}

	/*
	 * cartItemId:goods_id,shopId:shop_id,num:quantity},
	 */
	private void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Integer goods_id = Integer.parseInt(request.getParameter("cartItemId"));
		Integer shop_id = Integer.parseInt(request.getParameter("shopId"));
		Integer num = Integer.parseInt(request.getParameter("num"));

		Cart cart = (Cart) request.getSession(false).getAttribute("cart");

		List<CartItem> items = cart.getItems();
		int index = items.indexOf(new CartItem(goods_id, shop_id));
		CartItem cartItem = items.get(index);
		Integer stock = cartItem.getStock();
		cartItem.setNum(num > stock ? stock : num);
		num = cartItem.getNum();
		Double subTotal = new BigDecimal(cartItem.getGoods().getPrice()).multiply(new BigDecimal(num)).doubleValue();

		response.setContentType("application/json;charset=utf-8");
		String data = "{\"quantity\":" + num + ",\"subTotal\":" + subTotal + "}";
		response.getWriter().print(data);
		return;

	}

}

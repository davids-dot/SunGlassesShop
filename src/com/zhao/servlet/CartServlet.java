package com.zhao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhao.entity.Cart;
import com.zhao.entity.Customer;
import com.zhao.exception.NoAvailableGoodsException;
import com.zhao.service.CustomerService;
import com.zhao.service.impl.CustomerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		// TODO Auto-generated method stub
		// Cart Servlet 可能面临的情况
		// 添加到购物 车 type=add&goods_id=xx
		// 从购物车删除 type=delete&goods_id=xx
		// 清空购物车 type=deleteAll

		/*
		 * 检查参数,不合法，“处理”，返回
		 */
		try {
			String type = request.getParameter("type");
			if (type == null || type.trim().equals("")) {
				System.out.println("不合法参数");
				return;
			}
			Integer goods_id = null;
			if (!type.equals("deleteAll") && !type.equals("showAll")) {
				String temp = request.getParameter("goods_id");
				if (temp == null || temp.trim().equals("")) {
					System.out.println("不合法参数goods_id");
					return;
				}
				goods_id = Integer.parseInt(temp);
			}

			/*
			 * 获取用户对象
			 */
			CustomerService cs = new CustomerServiceImpl();
			HttpSession session = request.getSession(false);
			Customer cus = ServletUtil.checkCustomerInSession(cs, session);
			/*
			 * 购物车对象
			 */

			Cart cart = (Cart) session.getAttribute("cart");
			if (cart == null) {
				System.out.println("session 中无cart");

				cart = cs.getCart(cus.getCustomer_id());
				session.setAttribute("cart", cart);
			}

			/*
			 * 调用service层的add,delete,deleteAll 方法
			 */
			if (type.equals("showAll")) {

			} else if (type.equals("add")) {
				cs.addToCart(goods_id, cart);

			} else if (type.equals("delete")) {
				try {
					Integer shop_id = Integer.parseInt(request.getParameter("shop_id"));
					cs.deleteFromCart(goods_id, cart, shop_id);

				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			} else if (type.equals("deleteAll")) {

			}
			request.getRequestDispatcher("/jsp/cartList.jsp").forward(request, response);
		} catch (NoAvailableGoodsException e) {
			request.getRequestDispatcher("/jsp/noAvailableGoods.jsp").forward(request, response);

		}
	}

}

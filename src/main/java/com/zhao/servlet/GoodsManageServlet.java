package com.zhao.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.zhao.dao.OrderDao;
import com.zhao.dao.impl.OrderDaoImpl;
import com.zhao.entity.Goods;
import com.zhao.entity.Order;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.exception.IllegalException;
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class GoodsManageServlet 商家管理
 */

@WebServlet("/GoodsManageServlet")
@MultipartConfig(fileSizeThreshold = 3 * 1024 * 1024)
public class GoodsManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String GOODSPATH = "F:" + File.separator + "goods";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsManageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			SellerService ss = new SellerServiceImpl();

			/*
			 * 
			 * 未申请商铺，转到申请商铺界面
			 */
			HttpSession session = request.getSession(false);
			Seller sel = (Seller) session.getAttribute("user");
			Integer status = ss.ensureStatus(sel);
			if (status.equals(1) || status.equals(2)) {
				request.setAttribute("status", status);
				response.sendRedirect(request.getServletContext().getContextPath() + "/jsp/SellerManage.jsp");
				return;
			}

			String type = request.getParameter("type");
			if (type == null || type.trim().equals("")) {
				throw new IllegalException("商品管理中未定义类型");
			}

			if (type.equals("deliver") || type.equals("delete")) {
				changeOrder(request, response, type);
				return;
			}

			if (type.equals("openShop")) {
				request.setAttribute("status", status);
				response.sendRedirect(request.getServletContext().getContextPath() + "/jsp/SellerManage.jsp");
				return;

			}

			if (type.equals("queryAdd")) {
				request.getRequestDispatcher("/jsp/addGoods.jsp").forward(request, response);
				return;
			}
			if (type.equals("addGoods")) {
				addGoods(request, response);
				return;
			}
			if (type.equals("queryGoods")) {
				queryGoods(request, response);
				return;
			}
			if (type.equals("order")) {
				queryOrder(request, response);
			}

			if (type.equals("showDetail")) {
				Order order = ss.findOrder(Long.parseLong(request.getParameter("orderId")));
				request.setAttribute("order", order);
				request.getRequestDispatcher("/jsp/SellerManage/orderDetail.jsp").forward(request, response);
			}

		} catch (IllegalException e) {
			e.printStackTrace();
		}
	}

	private void changeOrder(HttpServletRequest request, HttpServletResponse response, String type) throws IOException {
		Long order_id = Long.parseLong(request.getParameter("orderId"));
		OrderDao odao = new OrderDaoImpl();

		switch (type) {

		case "deliver":
			odao.changeOrderStatus(order_id, OrderType.DELIVERED.ordinal());
			break;
		case "delete":
			odao.changeOrderStatus(order_id, OrderType.SELLERDELETED.ordinal());
			break;

		}
		response.getWriter().println("OK");
		return;
	}

	/*
	 * type=order&query=new" type=order&query=paid" type=order&query=delivered"
	 * type=order&query=confirmed"
	 */
	private void queryOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderType TYPE = null;
		String type = request.getParameter("query");

		switch (type) {
		case "new":
			TYPE = OrderType.NEW;
			break;
		case "paid":
			TYPE = OrderType.PAID;
			break;
		case "delivered":
			TYPE = OrderType.DELIVERED;
			break;
		case "confirmed":
			TYPE = OrderType.CONFIRMED;
			break;
		}

		SellerService ss = new SellerServiceImpl();
		HttpSession session = request.getSession(false);
		Seller sel = (Seller) session.getAttribute("user");
		sel = ServletUtil.checkSellerInSession(ss, session);
		QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);

		Shop shop = ss.findShop(sel.getSeller_id());

		PageBean page = ss.queryOrder(TYPE, shop.getShop_id(), queryInfo);
		request.setAttribute("type", TYPE);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/jsp/SellerManage/orderList.jsp").forward(request, response);

	}

	private void queryGoods(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * 准备seller 对象
		 */
		SellerService ss = new SellerServiceImpl();

		Seller sel = (Seller) request.getSession(false).getAttribute("user");
		if (sel == null) {
			System.out.println("未登录");
			return;
		}

		if (sel.getSeller_id() == null) {
			sel = ss.findSeller(sel.getName());
		}

		try {
			QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);
			PageBean page = ss.queryGoods(sel, queryInfo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/jsp/goodsManage.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addGoods(HttpServletRequest request, HttpServletResponse response)
			throws IllegalException, IOException, ServletException {

		Map<String, String> params = ServletUtil.request2Map(request, "name", "brand", "area", "barCode", "date",
				"price", "manufacturer");

		Part part = request.getPart("pic");
		String uName = ServletUtil.generateUname(part.getSubmittedFileName());
		String realPath = ServletUtil.generateRealPath(GOODSPATH, uName);
		String picURI = realPath + File.separator + uName;
		part.write(picURI);

		// public Goods(String name, String barCode, String picURI, String
		// manufacturer, String brand, String area)
		Goods goods = new Goods(params.get("name"), params.get("barCode"), picURI, params.get("manufacturer"),
				params.get("brand"), params.get("area"));

		goods.setPrice(Double.valueOf(params.get("price")));
		goods.setProductionDate(Date.valueOf(params.get("date")));

		SellerService ss = new SellerServiceImpl();
		HttpSession session = request.getSession(false);
		Seller sel = (Seller) session.getAttribute("user");//

		sel = ss.findSeller(sel.getName());
		ss.addToShop(sel, goods);
		/*
		 * 更新session ,session 中的user 具有了seller_id 属性
		 */

		session.setAttribute("user", sel);

		request.getRequestDispatcher("/html/addGoodsSuccess.html").forward(request, response);
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

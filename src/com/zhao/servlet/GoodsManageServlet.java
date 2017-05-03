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

import com.zhao.entity.Goods;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.entity.Seller;
import com.zhao.exception.IllegalException;
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class GoodsManageServlet
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

			String type = request.getParameter("type");
			if (type == null || type.trim().equals("")) {
				throw new IllegalException("商品管理中未定义类型");
			}
			if (type.equals("addGoods")) {
				addGoods(request, response);
				return;
			} else if (type.equals("queryGoods")) {
				queryGoods(request, response);
			}

		} catch (IllegalException e) {
			e.printStackTrace();
		}
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

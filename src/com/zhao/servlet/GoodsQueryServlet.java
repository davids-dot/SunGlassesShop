package com.zhao.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.service.CustomerService;
import com.zhao.service.impl.CustomerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class GoodsQueryServlet
 */
@WebServlet("/GoodsQueryServlet")
public class GoodsQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (type == null || type.trim().equals("")) {
			System.out.println("不合法参数");
			return;
		}

		if (type.equals("queryGoods")) {
			queryGoods(request, response);
			return;
		}

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

	private void queryGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomerService cs = new CustomerServiceImpl();

		String keyword = request.getParameter("keyword");
		String brand = request.getParameter("brand");
		String lowPrice = request.getParameter("lowPrice");
		String highPrice = request.getParameter("highPrice");

		Map<String, String> map = new HashMap<String, String>();
		if (keyword != null && !keyword.trim().equals(""))
			map.put("keyword", keyword);
		if (brand != null && !brand.trim().equals(""))
			map.put("brand", brand);
		if (lowPrice != null && !lowPrice.trim().equals(""))
			map.put("lowPrice", lowPrice);
		if (highPrice != null && !highPrice.trim().equals(""))
			map.put("highPrice", highPrice);

		QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);
		PageBean page = cs.queryGoods(map, queryInfo);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/jsp/goodsQuery/goodsList.jsp").forward(request, response);
		return;

	}

}

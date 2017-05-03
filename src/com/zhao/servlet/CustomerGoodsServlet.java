package com.zhao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.Goods;
import com.zhao.entity.PageBean;
import com.zhao.entity.QueryInfo;
import com.zhao.exception.IllegalException;
import com.zhao.service.CustomerService;
import com.zhao.service.impl.CustomerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class CustomerGoodsServlet
 */
@WebServlet("/CustomerGoodsServlet")
public class CustomerGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerGoodsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 存到前台大量商品数据

		String goods_id = request.getParameter("goods_id");
		if (goods_id == null) {
			showGoods(request, response);
			return;
		}

		try {
			CustomerService cs = new CustomerServiceImpl();
			Goods goods = new Goods();
			goods.setGoods_id(Integer.parseInt(goods_id));
			goods = cs.findGoodsById(goods);

			request.setAttribute("goods", goods);

			// 这里的goods 仍不是 确定的goods
			request.getRequestDispatcher("/jsp/goodsDetail.jsp").forward(request, response);
		} catch (IllegalException e) {
			e.printStackTrace();
		}

	}

	private void showGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService cs = new CustomerServiceImpl();
		List<Goods> newFour = cs.newFourGoods();
		request.setAttribute("newFour", newFour);

		QueryInfo queryInfo = ServletUtil.request2QueryInfo(request);
		PageBean page = cs.bestGoodsList(queryInfo);
		request.setAttribute("page", page);

		String auto = request.getParameter("auto");
		if (auto != null) {
			request.setAttribute("auto", true);// 只有从主页跳转，才不为空
		}

		request.getRequestDispatcher("main.jsp").forward(request, response);
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

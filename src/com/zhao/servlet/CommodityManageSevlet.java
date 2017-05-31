package com.zhao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhao.entity.GoodsCustom;
import com.zhao.entity.Page;
import com.zhao.entity.UserCustom;
import com.zhao.service.CommodityManageService;
import com.zhao.service.impl.CommodityManageServiceImpl;

@WebServlet("/CommodityManageSevlet")
public class CommodityManageSevlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommodityManageService commodityManageService = new CommodityManageServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page op = new Page();

		// 是不是由具体操作进来的，如果是，执行后返回首页
		String option = request.getParameter("option");
		if (option != null) {
			Integer goodId = Integer.parseInt(request.getParameter("goodId"));
			if (option.equals("delete")) {
				try {
					commodityManageService.deleteCommodity(goodId);
					response.sendRedirect(request.getContextPath() + "/manager/jsp/commoditymanager.jsp");
					return;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		// 获取参数
		int pagenumber = Integer.parseInt(request.getParameter("page.nextPage"));
		String userid = request.getParameter("userid");
		op.setNextPage(pagenumber);

		// 查询
		List<GoodsCustom> queryGoods = null;
		try {
			queryGoods = commodityManageService.queryCommodits(op, userid, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (queryGoods == null) {// 无商品
		// response.sendRedirect(request.getContextPath() +
		// "/manager/jsp/registermanager.jsp");
		// return;
		// }
		request.setAttribute("userid", userid);
		request.setAttribute("commodityManageList", queryGoods);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manager/jsp/commoditymanager.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

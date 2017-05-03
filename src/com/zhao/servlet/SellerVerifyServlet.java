package com.zhao.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.zhao.entity.Seller;
import com.zhao.entity.User;
import com.zhao.exception.IllegalException;
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class SellerVerify
 */
@WebServlet("/SellerVerifyServlet")
@MultipartConfig(fileSizeThreshold = 3 * 1024 * 1024)
public class SellerVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 用户图片
	private static final String PATH = "F:" + File.separator + "upload";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellerVerifyServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 准备数据
			 */

			String realName = getParameter(request, "realName");
			String id_card = getParameter(request, "id_card");
			String telephone = getParameter(request, "telephone");
			String area = getParameter(request, "area");

			/*
			 * 解析上传文件
			 */
			Part part = request.getPart("user_pic");
			String uName = ServletUtil.generateUname(part.getSubmittedFileName());
			String realPath = ServletUtil.generateRealPath(PATH, uName);
			String photoURI = realPath + File.separator + uName;
			part.write(photoURI);

			/*
			 * 保存Seller 信息到数据库
			 */
			Seller sel = new Seller(realName, id_card, telephone, area, photoURI);
			SellerService s = new SellerServiceImpl();
			String userName = ((User) request.getSession(false).getAttribute("user")).getName();
			s.changeInfo(sel, userName);

			/*
			 * 更新session 中内容
			 */
			User user = (User) request.getSession(false).getAttribute("user");
			sel.setName(user.getName());
			sel.setTelephone(user.getTelephone());
			request.getSession(false).setAttribute("user", sel);

			request.getRequestDispatcher("/jsp/ShopInfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getParameter(HttpServletRequest request, String name)
			throws IOException, ServletException, IllegalException {

		String s = request.getParameter(name);
		if (s == null || s.trim().equals("")) {
			throw new IllegalException();
		}
		return s;
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

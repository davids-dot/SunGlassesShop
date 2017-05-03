package com.zhao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.zhao.entity.Seller;
import com.zhao.entity.Shop;
import com.zhao.entity.User;
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;
import com.zhao.util.ServletUtil;

/**
 * Servlet implementation class ShopManageServlet
 */
@WebServlet("/ShopManageServlet")
@MultipartConfig(fileSizeThreshold = 3 * 1024 * 1024)
public class ShopManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// shoplogo
	private static final String SHOPLOGOPATH = "F:" + File.separator + "shoplogo";
	// shopverify 材料
	private static final String SHOPVERIFYPATH = "F:" + File.separator + "shopverify";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopManageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reType = request.getHeader("Content-Type");
		System.out.println(reType);

		if (reType.contains("multipart/form-data")) {
			doMultipart(request, response);
			return;
		}
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	private void doMultipart(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * 获取 商铺名
		 * 
		 */
		String name = null;
		try {
			Part shopName = request.getPart("name");
			int len;
			byte[] buffer = new byte[1024];
			InputStream in = shopName.getInputStream();
			if ((len = in.read(buffer)) > 0) {
				name = new String(buffer, 0, len);
			}

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

		/*
		 * 获取上传材料和logo
		 * 
		 */

		String verifyInfo = null;
		try {
			Part part = request.getPart("VerifyFile");
			String uName = ServletUtil.generateUname(part.getSubmittedFileName());
			String realPath = ServletUtil.generateRealPath(SHOPVERIFYPATH, uName);
			verifyInfo = realPath + File.separator + uName;
			part.write(verifyInfo);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

		String logoURI = null;
		try {
			Part part = request.getPart("logo_pic");
			String uName = ServletUtil.generateUname(part.getSubmittedFileName());
			String realPath = ServletUtil.generateRealPath(SHOPLOGOPATH, uName);
			logoURI = realPath + File.separator + uName;
			part.write(logoURI);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}

		/*
		 * 存入session
		 */
		SellerService ss = new SellerServiceImpl();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Seller sel = ss.findSeller(user.getName());
		session.setAttribute("user", sel);
		// request.getSession(false).get

		/*
		 * 存储到 shop 表
		 */
		Shop shop = new Shop(name, verifyInfo, logoURI, sel.getSeller_id());
		ss.addShop(shop);

		try {
			request.getRequestDispatcher("/html/openShopFinish.html").forward(request, response);

		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

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

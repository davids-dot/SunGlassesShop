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
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;

/**
 * Servlet implementation class SellerVerify
 */
@WebServlet("/SellerVerifyServlet")
@MultipartConfig(fileSizeThreshold = 3 * 1024 * 1024)
public class SellerVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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

		String realName = getParameter(request, "realName");
		String id_card = getParameter(request, "id_card");
		String telephone = getParameter(request, "telephone");
		String area = getParameter(request, "area");

		System.out.println(realName + " " + id_card + " " + telephone + " " + area + " ");

		Part part = request.getPart("user_pic");
		String uName = generateUname(part.getSubmittedFileName());
		String realPath = generateRealPath(uName);
		String photoURI = realPath + File.separator + uName;
		part.write(photoURI);

		Seller sel = new Seller(realName, id_card, telephone, area, photoURI);
		SellerService s = new SellerServiceImpl();
		String userName = ((User) request.getSession(false).getAttribute("user")).getName();
		s.changeInfo(sel, userName);

		request.getRequestDispatcher("/jsp/ShopInfo.jsp").forward(request, response);
	}

	private String getParameter(HttpServletRequest request, String name) throws IOException, ServletException {
		byte[] buffer = new byte[1024];
		int len;
		len = request.getPart(name).getInputStream().read(buffer);
		return new String(buffer, 0, len);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String generateUname(String fileName) {
		return UUID.randomUUID().toString() + "_" + fileName;
	}

	private String generateRealPath(String uName) {
		int hashCode = uName.hashCode();
		int dir1 = hashCode & 0xf;
		int dir2 = (hashCode >> 4) & 0xf;
		String realPath = PATH + File.separator + dir1 + File.separator + dir2;
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		return realPath;

	}

}

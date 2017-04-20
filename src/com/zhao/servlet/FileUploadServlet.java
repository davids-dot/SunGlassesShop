package com.zhao.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet(urlPatterns = "/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 3 * 1024 * 1024)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PATH = "F:/Upload/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int len = 0;
		byte[] buffer = new byte[1024];

		len = request.getPart("username").getInputStream().read(buffer);
		String userName = new String(buffer, 0, len);
		System.out.println("用户名" + userName);

		len = request.getPart("info").getInputStream().read(buffer);
		String info = new String(buffer, 0, len);
		System.out.println("用户信息" + info);

		Part file = request.getPart("file");
		System.out.println(file.getSubmittedFileName());
		file.write(PATH + file.getSubmittedFileName());
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

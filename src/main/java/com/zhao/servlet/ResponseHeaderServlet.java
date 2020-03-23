package com.zhao.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderServlet
 */
@WebServlet("/ResponseHeaderServlet")
public class ResponseHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	
    public ResponseHeaderServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
	}
	
	
  

	



	
	
	
	
	
	
	

//	private void autoRefresh(HttpServletResponse response) throws IOException {
//		response.setHeader("Refresh", "3");
//		response.getOutputStream().write("aaaaaaaaaaaaaaaaaa".toString().getBytes());
//	}

//	private void contentTypeHeader(HttpServletResponse response) throws IOException {
//		response.setHeader("Content-Type","image/jpeg");
//			
//			InputStream in = this.getServletContext().getResourceAsStream("/mountain.jpg");
//			
//			byte[] buffer = new byte[1024];
//			
//			OutputStream out = response.getOutputStream();
//			
//			while( (in.read(buffer))>0){
//				out.write(buffer);
//			}
//	}

	
//	response.setStatus(302);
//	response.setHeader("Location", "/SunGlassesShop/Hello.html");
	
	
	// Content-Enconding  与 Content-Length 用来告诉浏览器数据压缩格式及长度
	// ？？ Servlet 中不可以 两次 getWriter() 或getOutputStream()
//	String a="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbb"
//			+ "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
//			+ "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbvcvcccccccccccccc"
//			+ "ccccccccccccccccccccccccccccccccccccccccccccccccccccc";
//	
//	System.out.println("原数据大小："+a.length());
//	
//	ByteArrayOutputStream bout = new ByteArrayOutputStream();
//	GZIPOutputStream out = new GZIPOutputStream(bout);
//	out.write(a.getBytes());
//	out.close();
//	
//	byte[] ziped = bout.toByteArray();
//	System.out.println("压缩后大小:"+ziped.length);
//	
//	response.setHeader("Content-Encoding", "gzip");
//	response.setIntHeader("Content-Length",ziped.length);
//	response.getOutputStream().write(ziped);
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

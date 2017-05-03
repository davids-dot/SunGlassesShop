package com.zhao.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.zhao.util.DBUtil;
import com.zhao.util.MapResultHandler;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String queryType = request.getParameter("queryType");
		response.setContentType("text/xml");

		if (queryType == null || "".equals(queryType))
			throw new RuntimeException("无请求类型");

		if (queryType.equals("city")) {
			queryCity(request, response);
			return;
		}

		if (queryType.equals("area")) {
			queryArea(request, response);
			return;
		}

	}

	@SuppressWarnings("unchecked")
	private void queryArea(HttpServletRequest request, HttpServletResponse response) {

		String cityId = request.getParameter("cityId");
		if (cityId == null)
			throw new RuntimeException("无城市信息");
		String sql = "select area_id,area from areas where  city_id= ?";

		List<Object> param = new ArrayList<Object>();
		param.add(cityId);
		Map<String, String> map = null;

		try {
			// area, area_id
			map = (Map<String, String>) DBUtil.executeQuery(sql, param, new MapResultHandler<String, String>());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("areas");

		for (Entry<String, String> en : map.entrySet()) {
			root.addElement("area").addAttribute("area", en.getValue()).addAttribute("area_id", en.getKey());
		}

		OutputFormat format = OutputFormat.createCompactFormat();
		try {
			XMLWriter writer = new XMLWriter(response.getOutputStream(), format);
			writer.write(doc);
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	private void queryCity(HttpServletRequest request, HttpServletResponse response) {

		String proName = request.getParameter("proName");

		if (proName == null)
			throw new RuntimeException("无省份信息");
		String sql = "select city_id,city from cities where  province_id=(" + "select province_id from provinces "
				+ "where province =?)";

		List<Object> param = new ArrayList<Object>();
		param.add(proName);
		Map<String, String> rs = null;
		try {
			rs = (Map<String, String>) DBUtil.executeQuery(sql, param, new MapResultHandler<String, String>());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("cities");

		for (Entry<String, String> entry : rs.entrySet()) {
			root.addElement("city").addAttribute("id", entry.getKey()).addText(entry.getValue());
		}

		OutputFormat format = OutputFormat.createCompactFormat();
		try {

			XMLWriter writer = new XMLWriter(response.getOutputStream(), format);
			writer.write(doc);
			writer.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

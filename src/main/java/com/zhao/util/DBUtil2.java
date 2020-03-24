package com.zhao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBUtil2 {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sun?useUnicode=true&characterEncoding=utf8";

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object executeQuery(String sql, ResultSetHandler handler, Object ... params) throws SQLException {

		Connection conn = null;
		PreparedStatement pts = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			pts = conn.prepareStatement(sql);
			pts.clearParameters();

			if (params != null) {
				for (int i = 0; i < params.length; ++i) {
					pts.setObject(i + 1, params[i]);
				}
			}
			rs = pts.executeQuery();

			return handler.handle(rs);

		} finally {
			release(conn, pts, rs);
		}

	}

	private static Connection getConnection() {

		try {
			return DriverManager.getConnection(url, "root", "12345");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private static void release(Connection conn, Statement pts, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pts != null) {
			try {
				pts.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean executeUpdate(String sql, Object ... params) throws SQLException {

		Connection conn = null;
		PreparedStatement pts = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pts = conn.prepareStatement(sql); // SQLException
			pts.clearParameters();

			if (params != null ) {
				for (int i = 0; i < params.length; i++) {
					pts.setObject(i + 1, params[i]);
				}
			}

			int res = pts.executeUpdate();
			return res > 0 ? true : false;

		} finally {

			release(conn, pts, rs);
		}

	}

}

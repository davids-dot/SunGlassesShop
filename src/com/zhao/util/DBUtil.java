package com.zhao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	private static DataSource ds = null;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}

	public static boolean executeUpdate(String sql, List<Object> param) throws SQLException {

		Connection conn = null;
		PreparedStatement pts = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			pts = conn.prepareStatement(sql); // SQLException
			pts.clearParameters();

			if (param != null && param.size() != 0) {
				for (int i = 0; i < param.size(); i++) {
					pts.setObject(i + 1, param.get(i));
				}
			}

			int res = pts.executeUpdate();
			return res > 0 ? true : false;

		} finally {

			release(conn, pts, rs);
		}

	}

	public static Object executeQuery(String sql, List<Object> param, ResultSetHandler handler) throws SQLException {

		Connection conn = null;
		PreparedStatement pts = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();

			pts = conn.prepareStatement(sql);
			pts.clearParameters();

			if (param != null && param.size() != 0) {
				for (int i = 0; i < param.size(); i++) {
					pts.setObject(i + 1, param.get(i));
				}
			}

			rs = pts.executeQuery();

			return handler.handle(rs);

		} finally {
			release(conn, pts, rs);
		}

	}

	/*
	 * 释放数据库资源
	 */

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

}

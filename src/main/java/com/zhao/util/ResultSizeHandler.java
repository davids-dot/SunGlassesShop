package com.zhao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSizeHandler implements ResultSetHandler {

	@Override
	public Object handle(ResultSet rs) {

		try {
			if (rs.next()) {
				return rs.getInt(1);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}

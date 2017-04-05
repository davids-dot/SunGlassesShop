package com.zhao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IsNullHandler implements ResultSetHandler {

	@Override
	public Object handle(ResultSet rs) {

		try {
			if (rs.next())
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}

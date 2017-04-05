package com.zhao.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListHandler<T> implements ResultSetHandler {

	public ListHandler() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object handle(ResultSet rs) {

		try {
			List<T> ans = new ArrayList<T>();
			while (rs.next()) {
				ans.add((T) rs.getObject(1));
			}
			return ans;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}

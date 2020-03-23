package com.zhao.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapResultHandler<K, V> implements ResultSetHandler {

	public MapResultHandler() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object handle(ResultSet rs) {

		try {
			Map<K, V> ans = new HashMap<K, V>();
			while (rs.next()) {
				ans.put((K) rs.getObject(1), (V) rs.getObject(2));
			}
			return ans;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}

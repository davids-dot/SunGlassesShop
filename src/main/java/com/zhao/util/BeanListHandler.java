package com.zhao.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements ResultSetHandler {

	private Class<T> clazz;

	public BeanListHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handle(ResultSet rs) {

		try {
			List<T> answer = new ArrayList<T>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			while (rs.next()) {
				T obj = clazz.newInstance();
				for (int i = 0; i < col; i++) {
					String colName = rsmd.getColumnName(i + 1);
					Object colValue = rs.getObject(colName);
					if (colValue == null) {

					}
//					Field field = clazz.getDeclaredField(colName);
//					field.setAccessible(true);ss
//					field.set(obj, colValue);
					PropertyDescriptor pd = new PropertyDescriptor(colName, clazz);
					pd.getWriteMethod().invoke(obj, colValue);
				
				}
				answer.add(obj);
			}

			return answer;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}

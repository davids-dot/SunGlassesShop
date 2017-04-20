package com.zhao.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanHandler<T> implements ResultSetHandler {

	Class<T> clazz;

	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handle(ResultSet rs) {

		try {
			if (!rs.next())
				return null;
			Object obj = clazz.newInstance();

			ResultSetMetaData md = rs.getMetaData();
			int col = md.getColumnCount();
			for (int i = 1; i <= col; i++) {
				String attr = md.getColumnName(i);
				Object value = rs.getObject(attr);
				// Field field = clazz.getDeclaredField(attr);
				// field.setAccessible(true);
				// field.set(obj, value);
				PropertyDescriptor pd = new PropertyDescriptor(attr, clazz);
				pd.getWriteMethod().invoke(obj, value);

			}
			return obj;

		} catch (InstantiationException | IllegalAccessException | SQLException | SecurityException
				| IntrospectionException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

}

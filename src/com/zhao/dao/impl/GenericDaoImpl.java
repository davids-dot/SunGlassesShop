package com.zhao.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zhao.dao.GenericDao;
import com.zhao.entity.Goods;
import com.zhao.util.BeanHandler;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;
import com.zhao.util.OneAttributeHandler;

@SuppressWarnings("rawtypes")
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private Class clazz;
	private String tableName;

	GenericDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		setClazz((Class) pt.getActualTypeArguments()[0]);
		String className = clazz.getName();
		tableName = className.substring(className.lastIndexOf(".") + 1);
	}

	@Override
	public void add(T t) {
		Field[] fields = clazz.getDeclaredFields();//
		/*
		 * 数据库操作语句,实体类的第一个属性 id ,不用添加
		 */

		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		sb.append(tableName + "(");
		for (int i = 1; i < fields.length; i++) {
			String att = fields[i].getName();
			sb.append("," + att);
		}
		sb.append(")values(");
		for (int i = 1; i < fields.length - 1; i++) {
			sb.append("?,");
		}
		sb.append("?)");
		sb.deleteCharAt(sb.indexOf("(") + 1);

		/*
		 * 准备参数
		 */
		List<Object> params = new ArrayList<Object>();
		try {
			for (int i = 1; i < fields.length; i++) {
				fields[i].setAccessible(true);
				params.add(fields[i].get(t));
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			DBUtil2.executeUpdate(sb.toString(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zhao.dao.GenericDao#update(java.lang.Object)
	 * 
	 * 根据id 将数据库中记录改成 与对象属性一致的值
	 */

	@Override
	public void update(T t) {
		Field[] fields = clazz.getDeclaredFields();//
		/*
		 * 数据库操作语句
		 */

		try {

			StringBuilder sb = new StringBuilder();
			fields[0].setAccessible(true);

			List<Object> params = new ArrayList<Object>();
			sb.append("update " + tableName + " set " + fields[0].getName() + "=? ");
			params.add(fields[0].get(t));

			for (int i = 1; i < fields.length; i++) {

				String att = fields[i].getName();
				fields[i].setAccessible(true);
				Object value = fields[i].get(t);
				if (value != null) {
					sb.append("," + att + "=?");
					params.add(fields[i].get(t));
				}
			}
			sb.append("   where " + fields[0].getName() + "=? ");
			params.add(fields[0].get(t));

			System.out.println(sb.toString());
			System.out.println(params);
			// DBUtil2.executeUpdate(sb.toString(), new ArrayList<Object>());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(String att, Object value) {

		String sql = "select * from " + tableName + " where " + att + "= ?";
		List<Object> params = new ArrayList<Object>();
		params.add(value);

		try {
			return (T) DBUtil2.executeQuery(sql, params, new BeanHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public boolean exist(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from " + tableName + " where 1=1 ");
		List<Object> param = new ArrayList<Object>();

		for (Entry<String, Object> entry : params.entrySet()) {
			sb.append(" and " + entry.getKey() + " = ? ");
			param.add(entry.getValue());
		}

		try {
			return !(boolean) DBUtil2.executeQuery(sb.toString(), param, new IsNullHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

	// 实体的toString ,并不是dao 的toString

	// public String toString() {
	//
	// StringBuilder sb = new StringBuilder();
	// Field[] fields = clazz.getDeclaredFields();//
	// for (Field field : fields) {
	// field.setAccessible(true);
	// try {
	// sb.append(field.getName() + ":" + field.get(this) + "\n");
	// } catch (IllegalArgumentException | IllegalAccessException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// return sb.toString();
	// }

	@SuppressWarnings("unchecked")
	public List<T> queryAll() {
		String sql = "select *  from " + tableName;
		try {
			return (List<T>) DBUtil2.executeQuery(sql, null, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<T> querySome(Map<String, Object> params) {
		return null;
	}

	public List<T> querySome(Map<String, Object> params, Integer begin, Integer capacity) {
		return null;
	}

	public Object findAttribute(String attName, Map<String, Object> param) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select " + attName + " from " + tableName + " where 1= 1");

		List<Object> para = new ArrayList<Object>();

		for (Entry<String, Object> entry : param.entrySet()) {
			sb.append(" and " + entry.getKey() + " = ? ");
			para.add(entry.getValue());
		}

		try {
			return DBUtil2.executeQuery(sb.toString(), para, new OneAttributeHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}

package com.zhao.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhao.entity.Customer;
import com.zhao.util.BeanListHandler;
import com.zhao.util.DBUtil;
import com.zhao.util.DBUtil2;

public class DBUtilTest {

	@Test
	public void testUpdate() throws SQLException {
		String sql = "insert into Customer(name,password,telephone) values(?,?,?);";
		List<Object> param = new ArrayList<Object>();
		param.add("yanchao");
		param.add("1233");
		param.add("18706772553");
		DBUtil.executeUpdate(sql, param);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testQuery() throws SQLException {
		String sql = "select * from customer ";
		BeanListHandler<Customer> handler = new BeanListHandler<Customer>(Customer.class);
		List<Customer> ls = (List<Customer>) DBUtil2.executeQuery(sql, null, handler);
		for (Customer c : ls) {
			System.out.println(c);
		}

	}

}

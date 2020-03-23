package com.zhao.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhao.util.DBUtil2;
import com.zhao.util.IsNullHandler;

public class VerifyTest {

	@Test
	public void isNullTest() {
		List<Object> param = new ArrayList<Object>();
		param.add("11111113");
		param.add("Seller");

		try {
			boolean isnull = (boolean) DBUtil2.executeQuery("select * from User where 1=1 and name = ? and type = ? ",
					param, new IsNullHandler());
			System.out.println(isnull);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

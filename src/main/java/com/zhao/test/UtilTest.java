package com.zhao.test;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.zhao.util.DBUtil2;
import com.zhao.util.ResultSizeHandler;

public class UtilTest {

	public UtilTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test() {
		String s1 = "hello";
		String s2 = new String("hello");

		System.out.println(s1 == s2);
		System.out.println(s1.hashCode() + "   " + s2.hashCode());

	}

	@Test

	public void testAlogorithm() {
		int a = -1;
		int b = 4;
		System.out.println(a / b);

	}

	@Test

	public void testStringLength() {
		String s = "order_id, customer_id,status";
		System.out.println(s.length());

	}

	@Test
	public void testResultSize() {
		String sql2 = "select count(*) from goods where goods_id in(select goods_id from shop_has_goods where"
				+ " shop_id = 3 )";

		try {
			System.out.println((Integer) DBUtil2.executeQuery(sql2, null, new ResultSizeHandler()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegExp() {
		String s = "9&3,10&3,14&3";
		Pattern pattern = Pattern.compile("([0-9]+)&([0-9]+)");
		Matcher matcher = pattern.matcher(s);

		while (matcher.find()) {

			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}

	}

}

package com.zhao.test;

import org.junit.Test;

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

}

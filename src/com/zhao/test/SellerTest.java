package com.zhao.test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.zhao.dao.impl.SellerDaoImpl;
import com.zhao.entity.Seller;

public class SellerTest {

	public SellerTest() {
	}

	@Test
	public void testSellerAttribute() {
		Class clazz = Seller.class;

		try {
			Object obj = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				System.out.println(fields[i].getName());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public void testSellerDao() {
		SellerDaoImpl sdao = new SellerDaoImpl();
	}

}

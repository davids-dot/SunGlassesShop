package com.zhao.test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.zhao.dao.impl.SellerDaoImpl;
import com.zhao.entity.Seller;
import com.zhao.service.SellerService;
import com.zhao.service.impl.SellerServiceImpl;

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

	@Test
	public void testSellerService() {
		SellerService ss = new SellerServiceImpl();
		Seller sel = new Seller();
		sel.setName("00000111");
		Integer status = ss.ensureStatus(sel);
		System.out.println(status);
	}

}

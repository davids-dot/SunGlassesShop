package com.zhao.message;

import java.util.Random;

public class VerifyCodeProcessor {

	private char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private final int CODELENGTH = 6;

	private char[] arr1 = new char[CODELENGTH];
	private Random random = new Random();
	private static final VerifyCodeProcessor codePro = new VerifyCodeProcessor();

	private VerifyCodeProcessor() {
	}

	public static VerifyCodeProcessor getCodeProcessor() {
		return codePro;
	}

	public String getVerifyCode() {

		random.setSeed(System.currentTimeMillis());

		for (int i = 0; i < CODELENGTH; i++) {
			arr1[i] = arr[random.nextInt(10)];
		}
		return String.valueOf(arr1);
	}

}
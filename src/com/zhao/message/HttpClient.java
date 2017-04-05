package com.zhao.message;

import java.io.*;
import java.net.*;
import java.util.Random;

public class HttpClient {

	public static void noName() {

		// client.getHostConfiguration().setHost(LOGON_SITE, LOGON_PORT,
		// "http");
		// PostMethod authpost = new PostMethod("地址");
		// // 准备参数
		// NameValuePair id = new NameValuePair("id", "id");
		// NameValuePair pwd = new NameValuePair("pwd", "pwd");
		// NameValuePair to = new NameValuePair("to", "to");
		// NameValuePair content = new NameValuePair("content", "content");
		// NameValuePair time = new NameValuePair("time", "");
		// authpost.setRequestBody(new NameValuePair[] { id, pwd, to, content,
		// time });
		// // 执行Post请求
		// client.executeMethod(authpost);
		// // 打印状态码
		// System.out.println("Login form post: " +
		// authpost.getStatusLine().toString());
		// // 释放连接
		// authpost.releaseConnection();

	}

	public static String post(String path, String params) throws Exception {

		BufferedReader in = null;
		PrintWriter out = null;
		HttpURLConnection httpConn = null;
		try {
			URL url = new URL(path);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("POST");
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);

			out = new PrintWriter(httpConn.getOutputStream());
			out.println(params);
			out.flush();

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				StringBuffer content = new StringBuffer();
				String tempStr = "";
				in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				while ((tempStr = in.readLine()) != null) {
					content.append(tempStr);
				}
				return content.toString();
			} else {
				throw new Exception("请求出现了问题!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
			if (null != httpConn) {
				httpConn.disconnect();
			}
		}
		return null;
	}

	// 为了你的测试方便收到短信！请短信内容编辑为：你的验证码为：123456【中正云通信】

	public static void main(String[] args) throws Exception {

		String resMessage = HttpClient.post("http://service.winic.org:8009/sys_port/gateway/index.asp",

				"id=" + URLEncoder.encode("宇德高辉 ", "gb2312") + "&pwd=x141195&to=18706772553&content="
						+ URLEncoder.encode("你好，欢迎注册", "gb2312") + "&time=");
		System.out.println(resMessage);

	}

}

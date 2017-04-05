<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<head>
			<meta charset="utf-8"/>
			<title></title>
			<style>


		
			</style>
			
			<script>
					function changeVerifyImage(img){
						img.src=img.src+"?"+new Date().getTime();
						}		
			
			</script>
		</head>


		
		<body>
		    <form action="/SunGlassesShop/LoginServlet" method="post">
		      <div>
		       用户名<input type="text" id="user_name"></input>
		      </div>
		      
		       <div>
		      密码<input type="text" id="password"></input>
		      </div>
		      
		        <div>
		      验证码<img src="/SunGlassesShop/VerifyImageServlet" onclick="changeVerifyImage(this)"/>
		      </div>
		      
		      
		      <input type="submit" value="提交"/>
			</form>
		</body>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
			<meta charset="utf-8"/>
			<title></title>
			<link rel="stylesheet" type="text/css" href="css/login.css">
		</head>


		
		<body>
				<header>
						<div class="logo">
							<img src="images/logo.png"/>
						</div>
				 </header>

				<div class="content">

						<div id="login_picture">
						  <img src="images/ad_pic4.jpg" width="500" />
						</div>




						<div class="login">
								<div id="login_title">
								用户登录
								</div>


								<div id="text_input">

										<form action="#" method="post">
										<div class="input_line">
										     <input type="text" name="user_name" id="user_name" placeholder="xxxxxxxxx"></input>

										 </div>

										<div class="input_line" >
											  <input type="text" name="pass_word" id="password" placeholder="密码"></input>
										</div>



										<div class="other_choice">
												<input class="choice_left" type="checkBox" name="rember_password" id="rember_password"/>记住密码
									
												<a class="choice_right" name="forget_password" id="forget_password" href="#"> 忘记密码</a>
										</div>


										 <input type ="submit" id="login_button" name="login_button" value="登       录" ></input> 



										 <div class="other_choice" pos="bottom">
										 		<div id="return_homepage">
												<a class="choice_left" href="" >先去逛逛</a>
												</div>
												<a class="choice_right" name="register" id="register" href="#"> 快速注册</a>
										</div>



										</form>
								</div><!--text-input-->


						</div><!--login-->
				</div>

				<footer> 

						<div class="links">
								<ul style="overflow: hidden">
									<li pos="first"><a> 关于我们</a></li>
									<li><a> 联系我们</a></li>
									<li><a> 人才招聘</a></li>
									<li><a> 商家入驻</a></li>
									<li><a> 广告服务</a></li>
									<li><a> 友情链接</a></li>
									<li><a> EnglishSite</a></li>
								</ul>

								<div class="copyright">
									Copyright &nbsp;&copyright; &nbsp;2004-2017 &nbsp; 明宇MY.com &nbsp;版权所有
								</div>


						</div>

                 </footer>
</body>
</html>
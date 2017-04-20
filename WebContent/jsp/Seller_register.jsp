<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta http-equiv="Chche" content="no-chche" /> 
  <meta http-equiv="Expires" content="-1" /> 
  <meta http-equiv="Pragma" content="no-cache" /> 
  <title>明宇商户注册</title> 
  <link type="text/css" rel="stylesheet" href="../css/register.css" /> 
  <script type="text/javascript" src="../js/jquery-3.1.1.js"></script> 
  <script type="text/javascript" src="../js/jquery.validate.min.js"></script> 
  <script type="text/javascript" src="../js/messages_cn.js"></script> 
  <script>
       document.write('<script type="text/javascript" src="../js/register.js?'+new Date().getTime()+'"><\/script>'); 
  </script>
 </head> 
 <body> 
  <header> 
   <div class="logo"> 
    <img src="../images/logo.png" /> 
   </div> 
  </header> 
  
  
  <div class="container"> 
  
   <div class="login"> 
    <div id="login_title">
      商家注册 
    </div>
     
    <div id="text_input"> 
     
     <form id="userRegister" action="/SunGlassesShop/RegisterServlet?type=register" method="post">
      
      <div class="inputWrapper"> 
       <div class="input_line"> 
        <label for="user_name">用户名</label> 
        <input type="text" name="name" id="user_name" placeholder="您的账户名和登录名" required /> 
       </div> 
      </div> 
      
      <div class="inputWrapper"> 
       <div class="input_line"> 
        <label for="password">密码</label> 
        <input type="password" name="password" id="pass_word" placeholder="建议至少使用两种字符组合" required /> 
       </div> 
      </div> 
      
      <div class="inputWrapper"> 
       <div class="input_line"> 
        <label for="password2">确认密码</label> 
        <input type="password" name="password2" id="password2" placeholder="请再次输入密码" required /> 
       </div> 
      </div> 
      
      <div class="inputWrapper"> 
       <div class="input_line"> 
        <label for="mobile_phone">手机号</label> 
        <input type="text" name="mobilephone" id="mobile_phone" placeholder="建议使用常用手机" required /> 
       </div> 
      </div> 
      
      <div class="inputWrapper"> 
       <div class="input_line"> 
        <label for="verifyCode">验证码</label> 
        <input type="text" name="verifyCode" id="verifyCode" placeholder="输入手机验证码" required /> 
        <div id="reGetCode"> 
         <a href="#" id="reGet">获取验证码</a> 
        </div> 
       </div> 
      </div> 
      
      <input type="submit" id="login_button" name="login_button" value="注       册" /> 
     </form> 
    </div>
    <!--text-input--> 
   </div>
   <!--login--> 
  </div>  
 </body>
</html>

    
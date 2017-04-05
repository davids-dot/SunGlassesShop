<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<title>注册成功</title>
		<meta http-equiv="refresh" content="10;url=${pageContext.servletContext.contextPath}"/> 
		<script type="text/javascript" src="js/util.js"></script>
		<!--  路径到底是怎么搞得 -->
		<style>

			html,body,h1,h2,h3,h4,h5,h6,form{
						margin:0;
						padding:0;
			}

			body{
				background-color: #ECECEC;
				border-radius: 3px;

			}

			.notice{
				width:60%;
				margin:100px auto;
				background-color: #FFF;
			}

			.notice_header{
				height:50px;
				line-height: 50px;
				font-size: 32px;
				color:#FFF;
				background-color: #E93854;
				text-align: center;
			}

			.notice_body,.notice_footer{
				padding:20px 10%;
			}
			p{

				text-indent: 2em;
			}
			a{
				text-decoration: none;
			}

		</style>
		
	</head>


    <body>
            <div class="notice">
						<div class="notice_header">
							注册成功!&nbsp;&nbsp;(明宇眼镜商城）
						</div>
						<div class="notice_body">
						<h2>亲爱的 ${user.name}：</h2>
        <p>首先感谢您加入明宇！ 请您在商品交易过程中，注意文明礼貌，遵守当地法律法规。
        明宇眼镜，让生活更精彩。 </p>
        <p>如果您有什么疑问可以联系管理员，Email: DavidSta@qq.com。</p> 

        <p>在{<span id="countDown"></span>}秒内会前往首页，如果未能跳转，请点击以下链接<br/>  </p>
         <p>	<a href="/SunGlassesShop/index.jsp">http:localhost:9080/SunGlassesShop</a></p>
      
       
						</div>
						<div class="notice_footer">
							 <p align="right">明宇 官方团队</p> 
							 <p align="right"><script>
							 	document.write(getDate());
							 </script></p> 
						</div>


            </div>

    </body>
    	<script>
    		var count =10;
    		var place =document.getElementById("countDown");

    		window.setInterval(countDown,1000);

    		function countDown(){
    			place.innerHTML=count--;
    		}
    	
    	
    	
    	</script>

    

</html>
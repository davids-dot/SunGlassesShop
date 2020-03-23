<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
	 	<script>
		document.write('<script type="text/javascript" src="../js/address.js?'+new Date()+'"><\/script>');
		</script>
		<title></title>
		<style>
			form{
				padding:20px;
				height:550px;
				background-color: #edeff8;
			}

			.input_line{
				margin-top:40px;
				margin-left:0;
				margin-bottom:40px;
				
			}

			.input_line label{
				display:inline-block;
				vertical-align:middle;
				width:100px;
				height:34px;
				margin-left:157px;
				text-align:right;
			}

			.input_line input{
				display: inline-block;
				width:268px;
				height: 24px;
				margin-bottom: 10px;
				font-size: 14px;
				line-height: 24px;
				color: rgb(36, 36, 36);
				border-radius: 3px;
				vertical-align: middle;
				padding: 4px 6px;
				margin-left:20px;
			}

			
			.input_line select{
				display: inline-block;
				height: 32px;
				margin-bottom: 10px;
				font-size: 14px;
				line-height: 24px;
				color: rgb(36, 36, 36);
				border-radius: 3px;
				vertical-align: middle;
				padding:4px 0;

			}

			.input_line span{
				font-size: 12px;
				display: inline-block;
				height:36px;
				vertical-align: text-top;
			}

		  input[type="file" i] {
		  	position:relative;
		  	width:155px;
		  	height:24px;
           align-items: baseline;
           opacity: 0;
         	top:3px;
         	left:-180px;
         	left:-145px;
            text-align: start;
            cursor:pointer;
           }

           .upload{
           	width:466px;
           	display:inline-block;
          
           		border-radius: 3px;
           	 margin-left:20px;   
           	 color:#1e88c7;        
			}
			.virtual-file{
				display: inline-block;
				width:155px;
				height:36px;
				line-height: 36px;
				text-align: center;
				background-color: #b0eeff;
			}
			#submit{
				width:100px;
				height:36px;
				margin-left:300px;
			}

			#info{
				width:300px;
				height:36px;
				background-color: transparent;
				display:inline-block;
				margin-left:-285px;
				vertical-align:middle;
				color:red;
			}




		</style>
		
	</head>


    <body>
                       <h1 style="text-align: center;">商家信息认证</h1>
<form id="Verify" onsubmit="return validFile()"action="/SunGlassesShop/SellerVerifyServlet"  enctype="multipart/form-data" method="post">


            <div class="input_line">
  <label for="realName">真实姓名:</label>	<input name="realName" 
  pattern="[\u4e00-\u9fa5]{2,7}" placeholder="请正确填写您的真实姓名" required  value="${user.realName}"/>
            </div>
	
	           <div class="input_line">
  <label for="id_card">居民身份证:</label> 
  <input name="id_card" pattern="([0-9]{6})((19[0-9]{2,2})|(20((0[0-9]{1,1})|(1[0-7]{1,1}))))(0[1-9]|1[0-2])(0[1-9]{1,1}|[1-2]{1,1}[0-9]{1,1}|3[0-1]{1,1})([0-9]{3,3}[0-9|x]{1,1})"
   placeholder ="请填写24位的真实身份证号"  required  value="${user.id_card }"/>
				</div>

				 <div class="input_line">
	 <label for="telephone">手机:</label>  
<input name="telephone"     pattern="1[3458][0-9]{9}"   placeholder="请填写您的常用手机号" required 
    value = "${user.telephone}"/> 
	 </div>
			 	<div class="input_line" >
			      <label >地址:</label>
                                                       <span>省份</span>
                                                       <select name="province" id="pro_select" 
                                                       style="width:135px">
															
													    </select>

													     <span>城市</span><select name="city" id="city_select"
													      style="min-width:131px">
													    
														</select>

														<span>县区</span><select name="area" id="area_select"
														 style="min-width:131px">
														
														</select>																				
		       </div>

			<div class="input_line">
			 <label for="user_pic" style="vertical-align:0;">上传头像:</label>
				<div class="upload">
				     <div class="virtual-file">选择文件</div>
			 		<input type="file" id="user_pic" name="user_pic" accept="image/*" />
			 	</div>

	            <div id="info"  >
			 	</div>
			
			 <!-- 文件默认只能上传一个，加入multiple 属性可以上传多个 -->
			</div>
			
             <input type ="submit" value= "提交"  id="submit" />
            </form>
	              
 	

    </body>
         <script>
           var reg= /^(png)|(jpeg)|(jpg)|(gif)$/i;
  	   
           jQuery(function(){
        	  
           	  window.parent.postMessage(document.body.offsetHeight+"","http://localhost:9080/SunGlassesShop/html/Seller_manage.html");
			  $("#user_pic").change(function(){
			       var valid =validFile();
			       
				   if(valid) { $("#info").html("已选择   "+document.getElementById("user_pic").files[0].name);
				               $("#info").css("color","green");}
				   else{ $("#info").html("请选择 常见的图片格式文件。");  $("#info").css("color","red");  }
				   
			  })           
			  
			  document.getElementById("Verify").addEventListener('submit',validFile);
           
           });
           
           function validFile(){
        	   var file= document.getElementById("user_pic").files[0];
        	   if(file==null || file ==undefined ) return false;
        	   var fileName = file.name;
		       fileName =fileName.substring(fileName.lastIndexOf('.')+1);
		   
		       if(fileName.match(reg)!=null) return true;
		       return false;
           }
           
           
        

         </script>


</html>
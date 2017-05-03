<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8" />
		<script type="text/javascript" src="/SunGlassesShop/js/jquery-3.1.1.js"></script>
	 
		<title>商铺注册申请</title>
		<style>
			form{
				padding:20px;
				background-color: #edeff8;
				height:550px;
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

			#info,#VerifyInfo{
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
                       <h1 style="text-align: center;">商铺注册申请</h1>
<form id="Verify" onsubmit="return valid()"action="/SunGlassesShop/ShopManageServlet"  enctype="multipart/form-data" method="post">
   <input type="hidden" value="register"/>

            <div class="input_line">
  <label for="name">商铺名:</label>	<input name="name" 
  pattern="[\u4e00-\u9fa5a-z0-9]{2,10}" placeholder="请填写您想要注册的商铺名称" required/>
            </div>
            
            
               <div class="input_line">
  <label for="realName">商铺所有人:</label>	<input name="owner" 
  pattern="[\u4e00-\u9fa5]{2,7}" placeholder="请填写商铺所有者" required value="${user.realName}"/>
            </div>
            
            
            <div class="input_line">
			 <label for="shop_verify" style="vertical-align:0;">申请材料:</label>
				<div class="upload">
				     <div class="virtual-file">选择文件</div>
			 		<input type="file" id="VerifyFile" name="VerifyFile"  required accept="text/plain application/msword application/pdf"/>
			 	</div>
			 	<div id="VerifyInfo">
			 	</div>

			 <!-- 文件默认只能上传一个，加入multiple 属性可以上传多个 -->
			</div>
	
	        
	        <div class="input_line" style="padding-left:44px;">
		
			 		<input type="radio" id="accept" name="accept"/><label for="accept" id="accept"
			 		style="width:300px;margin-left:-169px;color:#1e88c7;"><i>我保证上传资料无虚假内容。</i></label>
			 <!-- 文件默认只能上传一个，加入multiple 属性可以上传多个 -->
			</div>
	
	            
	    
			<div class="input_line">
			 <label for="logo_pic" style="vertical-align:0;">上传logo:</label>
				<div class="upload">
				     <div class="virtual-file">选择文件</div>
			 		<input type="file" id="logo_pic" name="logo_pic" accept="image/*" />
			 	</div>

                 <div id="info">
                 </div>
                  
			 <!-- 文件默认只能上传一个，加入multiple 属性可以上传多个 -->
			</div>
			
			
			
             <input type ="submit" value= "提交"  id="submit" />
            </form>
	              
 	

    </body>
         <script>
           var reg= /^(png)|(jpeg)|(jpg)|(gif)$/i;
           var reg2=/^(pdf)|(docx)|(doc)|(txt)$/i;
  	   
           jQuery(function(){
        	  
           	  window.parent.postMessage(document.body.offsetHeight+"","http://localhost:9080/SunGlassesShop/html/Seller_manage.html");
			  $("#logo_pic").change(function(){
			       var valid =validFile();
			       
				   if(valid) { $("#info").html("已选择   "+document.getElementById("logo_pic").files[0].name);
				               $("#info").css("color","green");}
				   else{ $("#info").html("请选择 常见的图片格式文件。");  $("#info").css("color","red");  }
				   
			  });
			  
			  $("#VerifyFile").change(function(){
			       var valid =validFile2();
			       
				   if(valid) { $("#VerifyInfo").html("已选择   "+document.getElementById("VerifyFile").files[0].name);
				               $("#VerifyInfo").css("color","green");}
				   else{ $("#VerifyInfo").html("请选择 常见的文档格式文件。");  $("#VerifyInfo").css("color","red");  }
				   
			  }) ;
			  
			  
			  document.getElementById("Verify").addEventListener('submit',validFile);
           
           });
           
           function validFile(){
  
		       var file= document.getElementById("logo_pic").files[0];
        	   if(file==null || file ==undefined ) return false;
        	   var fileName = file.name;
		       fileName =fileName.substring(fileName.lastIndexOf('.')+1);
		   
		       if(fileName.match(reg)!=null) return true;
		       return false;
		       
           }
           
           function validFile2(){
        	   
        	   var file= document.getElementById("VerifyFile").files[0];
        	   if(file==null || file ==undefined ) return false;
        	   
        	   var fileName = file.name;
		       fileName =fileName.substring(fileName.lastIndexOf('.')+1);
		       
		       if(fileName.match(reg2)!=null) return true;
		       return false;
           }
           
           function valid(){
        	   return validFile()&&validFile2();
           }
           
           
        

         </script>


</html>
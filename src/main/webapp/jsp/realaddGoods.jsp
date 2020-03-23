<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/site.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-3.1.1.js"  type="text/javascript" ></script>
	<script>
		document.write('<script type="text/javascript" src="../js/address.js?'+new Date()+'"><\/script>');

		var brand=["RayBan雷朋",
		           "BoLon暴龙",
		           "ProSun保圣",
		           "PARIM派丽蒙",
		           "MOLSION陌森",
		           "oakLey欧克利",
		           "Prsr帕莎",
		           "其他"];
	 	
  </script>
<title>Insert title here</title>
	<style>
	h1{
	margin-left:140px;
	margin-bottom:20px;
	}
	form{
	margin-left:100px;
	}
	select{
	height:38px;
	}
	#manufac{
	margin-left: 152px;
    margin-bottom: 15px;
	}
	
	
	</style>
</head>
<body>
		<h1>添加宝贝</h1>
         <form method="post" enctype="multipart/form-data" action="${pageContext.servletContext.contextPath}/GoodsManageServlet" >
              
             <input type="hidden" name="type" value="addGoods" />
              				
				<div class="ui-form-item">
					<label class="ui-label" for="name">宝贝名字<span style="color:red;">*</span></label>
					<input class="ui-input " id="name" type="text" value="" name="name" placeholder="请输入宝贝名称">
					
					
				</div>
					<div class="ui-form-item">
					<label class="ui-label" for="brand">宝贝品牌<span style="color:red;">*</span></label>
					<select class="ui-input" id="brand"  name="brand" style="height:40px;"></select>
					 
				</div>
				
				<div class="ui-form-item">
					<label class="ui-label">宝贝生产厂家<span style="color:red;">*</span></label>
					
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
				 <div id="manufac"><span style="margin-right:5px;">厂家</span><input class="ui-input" id="manufacturer" name="manufacturer" type="text" placeholder="请输入厂家名称"></div>
				<div class="ui-form-item">
					<label class="ui-label">宝贝条形码<span style="color:red;">*</span></label>
					<input class="ui-input" id="barCode" name="barCode" type="text" placeholder="请输入宝贝的条形码">
					
				</div>
				<div class="ui-form-item">
					<label class="ui-label">宝贝生产日期<span style="color:red;">*</span></label>
					<input class="ui-input" id="date" name ="date" type="date" required>
				
				</div>
				<div class="ui-form-item">
					<label class="ui-label">宝贝价格<span style="color:red;">*</span></label>
					<input class="ui-input" id="pricePic" name="price" type="range" min="0.1" max="999" step="0.1">
					 <input class="ui-input" id="priceValue" name="priceValue" type="text" style="width:60px;float:right;margin-right:100px;
					 background:url(../images/yuan.PNG) no-repeat right center;background-color:#fefd02;"
					 />
				</div>
				<script>
				
				$("#priceValue").change(
					function(){
						 document.getElementById("pricePic").value=this.value;
					}		
				);
				
				$("#pricePic").change(
				       function(){
				    	   document.getElementById("priceValue").value=this.value;
				       }		
				);
				
				
				$(function(){
					var se=document.getElementById("brand");
					
					var fragment=document.createDocumentFragment();
					
					var len=brand.length;
					for(var i=0;i<len;i++){
						var opt = document.createElement("option");
						opt.innerHTML=brand[i];
						fragment.appendChild(opt);
					}
					se.appendChild(fragment);
					
				});
				
				
				
				</script>
				
					
					 
			
				
				<div class="ui-form-item">
					<label class="ui-label">宝贝图片<span style="color:red;">*</span></label>
					<input class="ui-input" id="pic" type="file" name="pic" placeholder="请确认验证码">
					 
				</div>
		
				<div class="pl95">
					<input id="user-submit-btn" class="btn btn-lg  btn-primary mgr10" type="submit" value="　下 一 步　">
					<a id="btn-cancle" class="btn btn-lg">重置</a>
				</div>
				
			
			</form>
</body>
</html>
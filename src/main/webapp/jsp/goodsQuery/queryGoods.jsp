<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品查询</title>
<%@ include file="../head.jsp" %>
<link href="queryGoods.css?${now.time}" rel="stylesheet" type="text/css" />
</head>
<style>
   .input-line{
    width:680px;
    height:31px;
    margin:20px auto;
   }
   #search-left,#search-right,#searchText{
     height:31px;
      border-top:1px solid red;
      border-bottom:1px solid red;
   }
   #search-left{
     width:70px;
     float:left;
      background-color:#f5f5f5;
      padding:5px ;
      border-left:1px solid red;
      text-align:center;
   }
   #searchText{
     width:450px;
     padding-left:5px;
     border-left:1px solid #e5e5e5;
     float:left;
     border-right:1px solid #fff;
   }
   #search-right{
    float:left;
    width:110px;
    background:url(../../images/goodsQuery/search-right.png) no-repeat right center;
   }
 
   
   .options{
     width:70%;
     margin:20px auto;
   }
   
   .option-title{
      font-size:16px;
   }
   
   .options label{
   		margin-left:10px;
   }
   
   .money{
     margin-left:5px;
     width:80px;
     background:url(../../images/goodsQuery/money.PNG) no-repeat -2px 0px;
     padding-left:12px;
   }
   
   #goodsPage{
    width:100%;
    min-height:1000px;
    border:0;
   }

</style>
<body>
    <header>
         <div class="input-line" >
         	<div id="search-left">宝贝</div>
            <input id="searchText" type="text" placeholder="请输入要搜索的词" required/>
            <div id="search-right"></div>
         </div>
     
     
     
         <div class="options">
              <label class="option-title">品牌</label>
              <label for="" ><input name="brand" type="radio" value="">RayBan雷朋</label>
              <label for="" ><input name="brand" type="radio" value="">BoLon暴龙</label>
              <label for="" ><input name="brand" type="radio" value="">ProSun保圣</label>
              <label for="" ><input name="brand" type="radio" value="">PARIM派丽蒙</label>
              <label for="" ><input name="brand" type="radio" value="">MOLSION陌森</label>
              <label for="" ><input name="brand" type="radio" value="">oakLey欧克利</label>
              <label for="" ><input name="brand" type="radio" value="">Prsr帕莎</label>
              <label for="" ><input name="brand" type="radio" value="">其他</label>
         </div>
         
         
           <div class="options">
              <label class="option-title">价格</label>
              <label >最低<input class="money" type="number" min="0" name="lowPrice" id="lowPrice"/></label>
              <label >最高<input class="money" type="number" min="0" name="highPrice" id="highPrice"/></label>
    	   </div>
    	   
    </header>
    <iframe name="goodsPage" id="goodsPage">
    
    </iframe>


<script type="text/javascript">


  var keyword = "";
  if(document.cookie.length>0){

	  c_start = document.cookie.indexOf('keyword=');
	  if(c_start!=-1){
		  c_end =document.cookie.indexOf(';',c_start);
		  if(c_end==-1) c_end =document.cookie.length;
		  keyword = unescape(document.cookie.substring(c_start+8,c_end));
	  }
  }

  if(keyword!=""){
	  $("#goodsPage").attr("src","/SunGlassesShop/GoodsQueryServlet?type=queryGoods&keyword="+keyword);
      $('#searchText').attr('value',keyword);
  }


$(function(){
  document.getElementById("search-right").addEventListener('click',function(event){
	  var  searchText = document.getElementById("searchText").value;
	  searchText = searchText.replace(/\s+/g,'');
	 // if(searchText==null||searchText==""||searchText.length==0) return;
	  var brands = document.getElementsByName("brand");
	  var brand ="";
	  for(var i=0;i<brands.length;i++){
		  if(brands[i].checked == true){
			  brand = brands[i].value;
		  }
	  }
	  
	  var lowPrice = document.getElementById("lowPrice").value;
	  var highPrice =document.getElementById("highPrice").value;
	  $("#goodsPage").attr("src","/SunGlassesShop/GoodsQueryServlet?type=queryGoods&keyword="+searchText+"&brand="+brand+"&lowPrice="+lowPrice+"&highPrice="+highPrice+"&cur=1&pSize=50");
	  
  });
});

</script>
</body>

</html>
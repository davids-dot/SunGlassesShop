<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询订单</title>
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet" ></link>
<link href="../css/flat-ui.min.css" type="text/css" rel="stylesheet" ></link>
<link href="../css/common.css" type="text/css" rel="stylesheet" ></link>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js" type="text/javascript"></script>
</head>




<body>

   <!--用户管理模块-->
            <div role="tabpanel" class="tab-pane" id="user">
                <div class="check-div form-inline">
                    <div class="col-xs-3">
                        <button class="btn btn-yellow btn-xs" onclick="getChart()">查看交易额统计 </button>
                    </div>
                    <div class="col-xs-4">
                       <button class="btn btn-yellow btn-xs" onclick="getShopRank()">查看商铺交易排行 </button>
                    </div>
                    <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                        <label for="paixu">排序:&nbsp;</label>
                        <select class=" form-control">
                            <option>地区</option>
                            <option>地区</option>
                            <option>班期</option>
                            <option>性别</option>
                            <option>年龄</option>
                            <option>份数</option>
                        </select>
                    </div>
                </div>
              <iframe  id="orders" name="orders" style="width:100%;height:600px;border:0;overflow:hidden;" scrolling="no"></iframe>
             </div>
               

</body>
<script>

  
  function getShopRank(){
	  $("#orders").attr("src","${pageContext.servletContext.contextPath}/ManagerServlet?type=queryShopRank&cur=1&psize=5");
  }
  
  
  function getChart(){
	  $("#orders").attr("src","${pageContext.servletContext.contextPath}/ManagerServlet?type=queryAmount");
  }
</script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <style>
    a.meun-item{
    display:block;
    padding-left:20px;
    }
    </style>
<div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="左右结构项目" src="images/logo.png"><span>明宇眼镜后台管理</span></p>
                </div>
                <div id="personInfor">
                   
                   
                    <p>
                        <a>退出登录</a>
                    </p>
                </div>
              
                <a class="meun-title">交易信息管理</a>
                <a class="meun-item" href="jsp/queryOrder.jsp" target="rightPage"><img src="images/icon_source_grey.png" />订单查看</a>
                <a class="meun-item" href="#char" ><img src="images/icon_chara_grey.png">用户信息管理</a>
                <a class="meun-item meun-item-active" href="#user" ><img src="images/icon_user.png">用户管理</a>
                <a class="meun-item" href="#chan" ><img src="images/icon_change_grey.png">修改密码</a>
                <a class="meun-title">其他管理</a>
                <a class="meun-item" href="#scho" ><img src="images/icon_house_grey.png">地区管理</a>
                <a class="meun-item" href="#regu" ><img src="images/icon_rule_grey.png">规则管理</a>
                <a class="meun-item" href="#stud" ><img src="images/icon_card_grey.png">用户信息</a>
                <a class="meun-item" href="#sitt" ><img src="images/icon_char_grey.png">座位管理</a>
</div>
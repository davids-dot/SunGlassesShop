/**
 * 
 */

/*****************************注册表单相关*********************************************/
                var interval;
                var count =60;
                var reGet;   //链接
                var recentlyClick =false;
                var xhr;
                var mobile;
                var verifyCode;

                	window.onload =function(){
                		var getCode = false; 
                		 reGet = document.getElementById("reGet");
                		 reGetCode=document.getElementById("reGetCode");
                		 mobile =document.getElementById("mobile_phone");
                		 verifyCode =document.getElementById("verifyCode");
                		 reGet.onclick = reGetClicked;
                		 
                	};

                	function reGetClicked(){

                		  if(recentlyClick) return false;
                			recentlyClick =true;                     // 禁止在点击后一分钟内再点击
                			
                			sendRequest();

                			 count=60;	
                			 reGet.setAttribute("disabled","true");
                			 reGetCode.style.backgroundColor="#D7D7D7";

							 interval = window.setInterval(countDown,1000);

                			return false;

                	}
                	
                	
                	function sendRequest(){
                		xhr= new XMLHttpRequest();
                		xhr.open('post','/SunGlassesShop/MessageServlet');
                		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
                		xhr.send("mobile="+mobile.value+"&type=register");
                		
                		xhr.onreadystatechange =function(){
                			if(xhr.readystate==4&&xhr.status==200){
                				
                			}
                		}
                		
                		
                	}

                	function countDown(){	
                		reGet.text="("+count+"秒后)重新获取";
                		count--;
                		if(count < 0) {
                			window.clearInterval(interval);
                			reGet.setAttribute("disabled","false");
                			reGet.text="重新获取";
                			recentlyClick =false;
                		}
                	}



                	$.validator.setDefaults({
                		submitHandler:function(form){
                			form.submit();
                			
                		}
                	});

                	

                	$().ready(function(){
                		
                		$("#userRegister").validate(
                		{
                			onkeyup:false,
                			onclick:false,
                			

                			rules:{
                				name:{
                					maxlength:12,
                					minlength:8,
                					remote:{
                						url:"/SunGlassesShop/RegisterServlet?type=verify&param=Name",
                						type:"post",
                						dataType:"json",
                						data:{
                							name:function(){
                								return $("#user_name").val();
                							}
                						}
                					}
              
                				},
                				
                				password:{
                					maxlength:15,
                					minlength:8
                				},
                				password2:{
                					equalTo:"#pass_word"
                				},

// isPhoneNumber 是添加的自定义验证方法，其中包含错误提示信息

                				mobilephone:{
                					isPhoneNumber:true,
                                    remote:{
                                        url:"/SunGlassesShop/RegisterServlet?type=verify&param=Phone",
                                        type:"post",
                                        dataType:"json",
                                        data:{
                                            mobilephone:function(){
                                                return $("#mobile_phone").val();
                                            }
                                        }
                                    }

                				},
                				
                				verifyCode:{
                					remote:{
                						url:"/SunGlassesShop/MessageServlet?type=verifyCode",
                						type:"post",
                						dataType:"json",
                						data:{
                							verifyCode:function(){
                								return $("#verifyCode").val();
                							}
                						}
                					}
                				}
                			},
                			
                			messages:{
                				name:"不好，该用户名已被占用",
                                mobilephone:{
                                    remote:"该手机已经注册过了"
                                },
                				verifyCode:"验证码错误请重新获取"
                			},

                		
                			errorPlacement:function(error,element){
                				error.appendTo(element.parent());
                			},
                			success:"valid"

                			
                		});
                });


                	
  





/*****************************注册表单相关结束******************************************/


			
	

				
				


             	



			
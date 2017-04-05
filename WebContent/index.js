
		$(window).ready(function(){

				// $(".list_item").css("display","none");


				
				$(".list_item").children(".child_list").css("display","none");

				$(".list_item").hover(

					function(){
					container.style.display="none";
					$(this).children(".item_blank").css("display","none");
					$(this).css("border-right","none");
					$(this).children(".child_list").css("display","block");
					},

					function(){
					 $(this).children(".item_blank").css("display","block");
					 $(this).css("border-right","block");
					 $(this).children(".child_list").css("display","none");
					 container.style.display="block";
					}
				);

	  });


	 /* 焦点图相关函数————————————————————————————————————————————————————————————————————————————————————————————*/


					var list=document.getElementsByClassName("list")[0];

					var buttons =document.getElementsByClassName("focus_button");
					var container =document.getElementsByClassName("container")[0];
					var interval;
					var focus_width=parseInt(container.offsetWidth);
					


				window.onload=function(){

						var prev=document.getElementById("prev");
						var prev=document.getElementById("prev");
						

						prev.onclick= function (){
							slide(focus_width);
							checkPicButtonIndex();
							return false;
						};



						next.onclick =moveRight;


						for(var i=0;i<buttons.length;i++){
							buttons[i].onclick =function(){
								showPic(this);
								clearOther(this);
							}; // onclick 只是注册处理器，并未执行，这里的变量尤其注意

						}

						play();

						container.onmouseover= function(){
							
						
							window.clearInterval(interval);
						
						};

						container.onmouseout =function(){
							play();
						};

				}; 






					function play(){
						interval=window.setInterval(go,2000);
					}

					function go(){
						moveRight();

					}

					function moveRight(){
							slide(-focus_width);
							checkPicButtonIndex();
							return false;
					}

					

				  function checkPicButtonIndex(){

				  		var  left=parseInt(list.style.left);

				  		var tindex= left/(-focus_width);
				  		clearExceptIndex(tindex);

				  }




					function clearOther(button){

						// alert(index);
						var index = parseInt(button.getAttribute("index"));
						clearExceptIndex(index-1)


						
					}
					
					function clearExceptIndex(index){//除了 index 之外的button ，clicking 为 false

						for(var i=0;i<buttons.length;i++){

							if(i==index) {
								buttons[i].setAttribute("clicking","true");
							}
							else{
								buttons[i].setAttribute("clicking","false");
							}
						}

					}




					function showPic( button ){

							var index = parseInt(button.getAttribute("index"));
							var left=focus_width- index*focus_width;
							list.style.left=left+"px";

					}




					function slide(offset){
						
							var  left=parseInt(list.style.left)+offset;

							if(left<-4*focus_width|left>0){

								if(left<-4*focus_width){
									list.style.left="0px";
									return ;
								}

								list.style.left=-4*focus+"px";
								return ;
							}

							list.style.left=parseInt(list.style.left)+offset+"px";
								
					}


					// container.style.display="none";
	/* 焦点图相关函数————————————————————————————————————————————————————————————————————————————————————————————*/

				


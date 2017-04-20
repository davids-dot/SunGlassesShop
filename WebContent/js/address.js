/************************城市联动相关***********************************************
 * /************************城市联动相关***********************************************/
 

			    var provinces =["北京市","天津市","河北省","山西省","内蒙古自治区","辽宁省","吉林省","黑龙江省","上海市","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省","重庆市","四川省","贵州省","云南省","西藏自治区","陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔自治区","台湾省"];
				var pro_select;
				var city_select;
				
				

				window.onload = function(){
					getProvinces();
					prepareCity();

					pro_select.onchange = prepareCity;
					city_select.onchange =prepareArea;

				};


				function prepareCity(){

					var pro =pro_select.options[pro_select.selectedIndex];
					var pro_name =pro.getAttribute("value");
					

					var xhr = new XMLHttpRequest();

					xhr.open('get','/SunGlassesShop/AddressServlet?queryType=city&proName='+pro_name);

					xhr.send();

					xhr.onreadystatechange =function(){

						if(xhr.readyState ==4 && xhr.status ==200){

								setCities(this);
						}
					};

				}
				
				function prepareArea(){
					
					var city =city_select.options[city_select.selectedIndex];
					var city_name =city.getAttribute("value");
					var city_id =city.getAttribute("cityId");
					
					var xhr = new XMLHttpRequest();

					xhr.open('get','/SunGlassesShop/AddressServlet?queryType=area&cityName='+city_name+'&cityId='+city_id);
					xhr.send();

					xhr.onreadystatechange =function(){

						if(xhr.readyState ==4 && xhr.status ==200){
								setAreas(this);
						}
					};
					
				}
				
				
				function setAreas(xhr){
					var doc =xhr.responseXML;
					var areas =doc.getElementsByTagName("area");
					
					var area_select = document.getElementById("area_select");
					    $("#area_select").empty();
					    
					    for(var i=0;i<areas.length;i++){
					    	var opt = document.createElement("option");
					    	opt.setAttribute("value",areas[i].getAttribute("area_id"));
					    	opt.innerHTML =areas[i].getAttribute("area");
					    	area_select.appendChild(opt);
					    }
				}


				function setCities(xhr){
				    var doc = xhr.responseXML;
				    var cities =doc.getElementsByTagName("city");
				   
				    $("#city_select").empty();
				    
				    for(var i=0;i<cities.length;i++){
				    	var opt = document.createElement("option");
				    	opt.setAttribute("value",cities[i].innerHTML);
				    	opt.setAttribute("cityId",cities[i].getAttribute("id"));
				    	opt.innerHTML =cities[i].innerHTML;
				    	city_select.appendChild(opt);
				    }
				  
				 	prepareArea();
				}



				function getProvinces(){
             		
             		 pro_select = document.getElementById("pro_select");
             		 city_select = document.getElementById("city_select");
             		 area_select =document.getElementById("area_select");

             		for(var i=0;i<provinces.length;i++){
             			var opt =document.createElement("option");
             			opt.setAttribute("value",provinces[i]);
             			opt.innerHTML = provinces[i];
             			pro_select.appendChild(opt);
             		}
             		
             	}
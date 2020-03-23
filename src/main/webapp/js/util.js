	       function getDate(){
    			var date = new Date();

				var dataStr = date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日"+date.getHours()+"点"
				+date.getMinutes()+"分";

				return dataStr;
    		}
   
	       
	 	  function GetQueryString(name)
		  {
		       var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		       var r = window.location.search.substr(1).match(reg);
		       if(r!=null)return  unescape(r[2]); return null;
		  }
	 	  
	 	  
	 	  
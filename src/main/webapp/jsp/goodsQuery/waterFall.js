/**
 * 
 */


window.onload =function(){
	
	imgLocation("goodsList","goods");
	
}



function imgLocation(parent,content){
	
	var container  = document.getElementById(parent);
	var goodsList  =  document.getElementsByClassName(content);
	if(goodsList.length<1) return;
	var width = goodsList[0].offsetWidth;//box 宽度
	var cols = Math.floor(document.documentElement.clientWidth/width);
	container.style.width=(cols*width+10)+"px";
	container.style.margin="0 auto";
	console.log("containerWidth"+container.offsetWidth);
	

	
	var boxHeight = [];
	for(var i=0;i<cols;i++){
		boxHeight[i] = goodsList[i].offsetHeight;
	}
	console.log("boxHeight"+boxHeight);
	
	var boxLeft = [];
	for(var i=0;i<cols;i++){
		boxLeft[i] = goodsList[i].offsetLeft;
	}
	
	
	
	for(var i=cols;i<goodsList.length;i++){
	   var added =goodsList[i];
	    added.style.position ="absolute";
		var minHeight = Math.min.apply(null,boxHeight);
		added.style.top=minHeight+"px";
		var index = getMinHeightLocation(minHeight,boxHeight);
		added.style.left= boxLeft[index]+"px";
	    boxHeight[index] =minHeight+added.offsetHeight; 
	  
	}
}

function getMinHeightLocation(minHeight,boxs){
	for(var i=0;i<boxs.length;i++){
		if(boxs[i]==minHeight){
			return i;
		}
	}
}

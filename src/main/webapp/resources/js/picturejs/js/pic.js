function getStyle(obj, attr){
	return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj, false)[attr];
}

window.onload = function(){
	var oBox = document.getElementById('box');
	var oBg = document.getElementById('bg');
	var oBot = document.getElementById('bottom');
	var aBli = oBot.getElementsByTagName('li');
	var oFrame = document.getElementById('frame');
	var aLi = oBox.getElementsByTagName('li');
	var aImg = oBox.getElementsByTagName('img');
	var i = iNow =  0;
	for(i=0;i<aLi.length;i++){
		aLi[i].index = i;
		aLi[i].onclick = function(){
			var cimg=this.getElementsByTagName('img');
			var url=cimg[0].src;
			
			with(oFrame.style){display = 'block',top = this.offsetTop +'px',left = this.offsetLeft +'px',width = this.offsetWidth +'px',height = this.offsetHeight +'px';}
			oFrame.innerHTML = '<img src="'+url+'" style="width:600px; height:400px; width:expression(this.width > 600 && this.height < this.width ? 600: true);height:expression(this.height > 400 ? 400: true); " />';

			var oImg = oFrame.getElementsByTagName('img')[0];
			var iWidth = oImg.width;
			var iHeight = oImg.height;
			var iLeft = parseInt((document.documentElement.clientWidth / 2) - (iWidth /2));
			var iTop = parseInt((document.documentElement.clientHeight / 2) - (iHeight /2) - 50);
			with(oImg.style){height = width = '100%';}
			startMove(oFrame, {opacity:100, left:iLeft, top:iTop, width:iWidth, height:iHeight});
			oBg.style.display = 'block';
			oBot.style.display = 'block';
			iNow = this.index;
		};
	}
//	document.onmousedown = function(){
//		return false;
//	};
	aBli[0].onclick = function(){
		if(iNow == 0) 
			{
			 iNow = aLi.length;
			// return;
			}
		else{
			   iNow--;
		}
		var cimg=document.getElementById('img'+iNow);
		var url=cimg.src;
		oFrame.innerHTML = '<img src="'+url+'" width="100%" height="100%" />';
	};
	aBli[1].onclick = function(){
		oFrame.style.cursor = 'move';
		oFrame.onmousedown = function(e){
			var oEvent = e || event;
			var X = oEvent.clientX - oFrame.offsetLeft;
			var Y = oEvent.clientY - oFrame.offsetTop;
			document.onmousemove = function(e){
				var oEvent = e || event;
				var L = oEvent.clientX - X;
				var T = oEvent.clientY - Y;
				if(L < 0){
					L = 0;
				}else if(L > document.documentElement.clientWidth - oFrame.offsetWidth){
					L = document.documentElement.clientWidth - oFrame.offsetWidth;
				}
				if(T < 0){
					T = 0;
				}else if(T > document.documentElement.clientHeight - oFrame.offsetHeight){
					T = document.documentElement.clientHeight - oFrame.offsetHeight;
				}
				oFrame.style.left = L + 'px';
				oFrame.style.top = T + 'px';
				oFrame.style.margin = 0;
				return false;
			}
			document.onmouseup = function(){
				document.onmouseup = null;
				document.onmousemove = null;
			};
			return false;
		};
	};
	aBli[2].onclick = function(){
		if(iNow >= aLi.length-1)
			{
			 iNow = 0;
			// return;
			}
		else{
			iNow++;
		}
		var cimg=document.getElementById('img'+iNow);
		var url=cimg.src;
		oFrame.innerHTML = '<img src="'+url+'" width="100%" height="100%" />';
	};
	aBli[3].onclick = function(){
		startMove(oFrame, {opacity:0}, function(){
			oFrame.style.display = 'none';
			oBg.style.display = 'none';
			oBot.style.display = 'none';
			oFrame.onmousedown = null;
			oFrame.style.cursor = 'auto';
		});
	};
	
};
function startMove(obj, json, onEnd){
	clearInterval(obj.timer);
	obj.timer=setInterval(function (){
		doMove(obj, json, onEnd);
	},10);
}
function doMove(obj, json, onEnd){
	var attr='';
	var bStop=true;
	for(attr in json){
		var iCur=0;
		if(attr=='opacity'){
			iCur=parseInt(parseFloat(getStyle(obj, attr))*100);
		}else{
			iCur=parseInt(getStyle(obj, attr));
		}
		var iSpeed=(json[attr]-iCur)/5;
		iSpeed=iSpeed>0?Math.ceil(iSpeed):Math.floor(iSpeed);
		
		if(json[attr]!=iCur){
			bStop=false;
		}
		if(attr=='opacity'){
			obj.style.filter='alpha(opacity:'+(iCur+iSpeed)+')';
			obj.style.opacity=(iCur+iSpeed)/100;
		}else{
			obj.style[attr]=iCur+iSpeed+'px';
		}
	}
	if(bStop){
		clearInterval(obj.timer);		
		if(onEnd){
			onEnd();
		}
	}
}
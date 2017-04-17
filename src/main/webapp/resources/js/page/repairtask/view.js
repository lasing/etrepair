//初始化信息
$(function() {
	var status = $('#status').val();//任务状态
	if(status==7){
		var evScore = $('#evScore').val();//加权分数
		var scoreDetail = eval($('#scoreDetail').val());//项目打分明细
		
		var newscore = transScoreNub(evScore);
		for(var i=1;i<=5;i++){
			//对总评分操作
			var img = document.createElement("img");
			if(newscore>=i){
				img.src='../resources/images/re.png';
			}else{
				img.src='../resources/images/de.png';
			}
			img.id='imgscore'+i;
			$('#evScoreStar').append(img);
			
		}
		if(scoreDetail!=undefined){
			//对明细评分操作
			for(var j=0;j<scoreDetail.length;j++){
				var newScoreDetail = transScoreNub(scoreDetail[j].evScore);
				for(var k=1;k<=5;k++){
//					alert('score='+newScoreDetail+'--'+'j='+j+'--'+'k='+k);
					var imgdetail = document.createElement("img");
					if(newScoreDetail>=k){
						imgdetail.src='../resources/images/re.png';
					}else{
						imgdetail.src='../resources/images/de.png';
					}
					imgdetail.id='imgdetail'+j+k;
					$('#'+scoreDetail[j].evItemId).append(imgdetail);
				}
				
			}
		}
		
	}
	
});

function transScoreNub(evScore){
	var starscore;
	if(0<evScore && evScore<=20){//1★
		return 1;
	}
	if(20<evScore && evScore<=40){//2★
		return 2;
	}
	if(40<evScore && evScore<=60){//3★
		return 3;
	}
	if(60<evScore && evScore<=80){//4★
		return 4;
	}
	if(80<evScore && evScore<=100){//5★
		return 5;
	}
}




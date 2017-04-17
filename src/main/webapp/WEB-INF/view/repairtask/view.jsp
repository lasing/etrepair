<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>送修任务详情</title>
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
<link rel="stylesheet" type="text/css" href="../resources/js/picturejs/css/reset.css">
<link rel="stylesheet" type="text/css" href="../resources/js/picturejs/css/style.css">
<script type="text/javascript" src="../resources/js/picturejs/jquery.js"></script>
<script type="text/javascript" src="../resources/js/picturejs/js/pic.js"></script>
<script type="text/javascript" src="../resources/js/picturejs/TileHeadPic.js"></script>
<style type="text/css">
body {
	font-size: 14px;
}

#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
.form-group {
    margin-bottom: 15px;
    margin: 0 auto;
}

.input-icon {
    position: relative;
}
.input-icon > .form-control {
     padding-left: 33px;
 }
.form-control {
    display: block;
    width: 200px;
    height: 28px;
    font-size: 14px;
    line-height: 28px;
    font-weight: normal;
    color:#8E8B8B;
    padding:0 10px;
    background-color: white;
    border: 1px solid #e5e5e5;
    -webkit-box-shadow: none;
    box-shadow: none;
    -webkit-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
     -webkit-border-radius: 4px;
    -moz-border-radius: 47px;
    -ms-border-radius: 4px;
    -o-border-radius: 4px;
    border-radius: 4px;
}
.input-icon > i {
    color: #ccc;
    display: block;
    position: absolute;
    left:175px;
    margin: 11px 2px 4px 10px;
    z-index: 3;
    width: 16px;
    height: 16px;
    font-size: 16px;
    text-align: center;
}

</style>
</head>
<body>
	<div style="padding: 0 15px;">
		<div class="bord-main-h" style="height: 99%; overflow: auto;">
			<div id="detail">
				<div class="panel-header panel-title">
					<label>任务详情</label>
				</div>
				<div class="bj-hs">
					<div class="pull-left padd5" style="width:340px">
						<label class="lab-tb" style="width:145px; text-align: right;">报案号：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 180px;" value="<c:out value="${repairTask.registNo}"/>">
					</div>
					<div class="pull-left padd5" style="width: 340px">
						<label class="lab-tb">车型：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 180px;" value="<c:out value="${repairTask.vehicleModel}"/>">
					</div>
					<div class="pull-left padd5" style="width: 340px">
						<label class="lab-tb">车牌号：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 145px;" value="<c:out value="${repairTask.licenseNo}"/>">
					</div>
					<div class="pull-left padd5" style="width: 340px">
						<label class="lab-tb"  style="width:145px; text-align: right;">联系人：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 180px;" value="<c:out value="${repairTask.carOwner}"/>">
					</div>
					<div class="pull-left padd5" style="width: 340px">
						<label class="lab-tb">手机号：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 180px;" value="<c:out value="${repairTask.mobile}"/>">
					</div>
					<div class="pull-left padd5" style="width: 340px">
						<label class="lab-tb">保单号：</label> <input class=" text-tb"
							type="text" readonly="readonly" style=" width: 200px;" value="<c:out value="${repairTask.policyNo}"/>">
					</div>
					<div class="clear"></div>
					<div class="padd5">
						<label class="lab-tb" style="width:145px; text-align: right;">出险概述：</label>
						<textarea readonly="readonly" rows="3" cols="80"><c:out
								value="${repairTask.remark}" /></textarea>
						
					</div>
					<div class="padd5"> 
						<label class="lab-tb" style="line-height:19px ;width:145px; ">客户地址：</label> <label><c:out
								value="${repairTask.address}" /></label>
					</div><br />
					<div class="clear"></div>
					<div>
						<c:if test="${repairTask.finishTime==null || repairTask.finishTime==''}">
						<label style="width:145px; text-align: right; display: block; float:left;">预期抵达修理厂时间：</label><label class="pull-left" style=" display: block; width:300px;">
						<fmt:formatDate value="${repairTask.expectedTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label><br />
						</c:if>
						
						<br />
						<div class="clear"></div>
						<label style="width:145px; text-align: right; display: block; float:left;">
						
						
						<c:choose>
						<c:when test="${repairTask.status==2}">
								车辆抵厂放弃时间：
						</c:when>
						<c:when test="${repairTask.status==3}">
								车辆未抵厂放弃时间：
						</c:when>
						<c:when test="${repairTask.status==4}">
								用户取消放弃时间：
						</c:when>
						<c:otherwise>
								实际抵达修理厂时间：
						</c:otherwise>
						</c:choose>

						</label><label class="pull-left" style=" display: block; width:300px;">
						<fmt:formatDate value="${repairTask.confirmTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label><br /><br />
									<div class="clear"></div>
						
						<c:if test="${repairTask.informTime!=null && repairTask.informTime!=''}">
						<label style="width:145px; text-align: right; display: block; float:left;">修理厂修理完毕时间：</label><label class="pull-left" style=" display: block; width:300px;">
						<fmt:formatDate value="${repairTask.informTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label><br /><br />
									<div class="clear"></div>
						</c:if>	
						<c:if test="${repairTask.finishTime!=null && repairTask.finishTime!=''}">
						<label style="width:145px; text-align: right; display: block; float:left;">用户确认完成时间：</label><label class="pull-left" style=" display: block; width:300px;">
						<fmt:formatDate value="${repairTask.finishTime}" pattern="yyyy-MM-dd HH:mm:ss" /></label><br /><br />
									<div class="clear"></div>
						</c:if>	
								
					</div>
				</div>

			</div>

			<!-- <div class="bj-hs" id="jingyou">
				<div>
					<label>精友订单编号：</label> <input type="button"
						style="background: #6bb1e6; color: white; border:1px solid #6bb1e6;" value="查询" onclick="">
				</div>
				<div id="jyGrid"></div>
			</div> -->
			
			<input type="hidden" id="status" value="<c:out value="${repairTask.status}"/>"/>
			<c:if test="${repairTask.status==7}">
				<div class="panel-header panel-title">
					<label>评价详情</label>
				</div>
				<div style="background:#f0f1f3;">
				<div class="pull-left" style=" width:145px; text-align:right; margin-top:15px;">评价时间:</div>
				<div class="pull-left" style=" margin-top:15px;"><fmt:formatDate value="${repairTask.evTime}" pattern="yyyy-MM-dd HH:mm:ss" />  &nbsp;&nbsp;&nbsp;
					<c:if test="${evalute.evCost!=0}">
					价格：<fmt:formatNumber value="${evalute.evCost}" pattern="0.00"/>元
					</c:if>
				</div>
				<div class="clear"></div>
				<div class="pull-left"style="line-height:22px; width:145px; text-align:right; margin-top:15px;">店铺评分:</div>
				<div class="pull-left"style="margin-top:15px;">
				<input type ="hidden" id ="evScore" value="<c:out value="${evalute.evScore}"/>"/>
				<span id ="evScoreStar" ></span>
				</div>
				<div class="clear"></div>
				<div >
					<c:forEach items="${evaluteItemlist}" var="item" varStatus="status">
					<div class="pull-left">
						<div class="pull-left" style="line-height:22px; width:145px; text-align:right; margin-top:15px;">${item.itemName}:</div>
						<div class="pull-left" style="margin-top:15px;">
						<input type="hidden" id="scoreDetail" value="<c:out value="${scoreListJson}"/>"/>
						<c:forEach items="${scoreList}" var="item2" varStatus="status2">
							<c:if test="${item.evItemId==item2.evItemId}">
								<span id ="${item2.evItemId}" ></span>
							</c:if>
						</c:forEach>
						</div>
						<div class="clear"></div>
						</div>
					</c:forEach>
					<div class="clear"></div>
				</div>
				<br/>
				<div class="clear"></div>
				<div class="pull-left" style=" width:145px; text-align:right; margin-top:15px;">文字评价:</div>
				<textarea readonly="readonly" rows="3" cols="80"><c:out value="${evalute.evMemo}" /></textarea>
				
				
				<div class="box" id="box" style="background:#f0f1f3">
					<ul>	
						<c:forEach items="${urlPhotolist}" var="item" varStatus="status">
						 	<li class="apply"><img id="img${status.index}" src="${item.photoUrl}" width="100%" height="100%"></li>

						</c:forEach>
					</ul>
				</div>
				<div id="bg"></div>
				<div id="bottom">
					<ul>
						<li class="prev"></li>
						<li class="img"></li> 
						<li class="next"></li>
						<li class="close"></li>
					</ul>
				</div>
				<div id="frame" ></div>
				</div>
			</c:if>
			

		</div>
	</div>
	
	<script type="text/javascript"
		src="${ctx }/resources/js/page/repairtask/view.js"></script>

</body>

</html>
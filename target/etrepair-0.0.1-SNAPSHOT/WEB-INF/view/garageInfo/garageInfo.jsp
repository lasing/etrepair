<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<title>修理厂信息浏览</title>
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
<link rel="stylesheet" type="text/css" href="../resources/js/picturejs/css/reset.css">
<link rel="stylesheet" type="text/css" href="../resources/js/picturejs/css/style.css">
<script type="text/javascript" src="../resources/js/picturejs/jquery.js"></script>
<script type="text/javascript" src="../resources/js/picturejs/js/pic.js"></script>
<script type="text/javascript" src="../resources/js/picturejs/TileHeadPic.js"></script>
</head>
<style>
.jianjie .bjis td{
	background:#f0f1f3;
}
</style>
<body>
	<div style="padding: 0 15px;">
		<div class="bord-main-h " style="height:545px;overflow: auto ;">
			<div class="panel-header panel-title"  style="height:36px;">
				<label style="line-height:36px; padding:0 10px; ">${garage.garageName}</label>
			</div>
			<label style="line-height: 40px;border-bottom:1px solid #e5e5e5;padding-left: 30px;background:#f0f1f3; display: block;"> 详细介绍</label>
			<table class="jianjie" style="margin-top: 30px; width:100%;">
				<tr>
					<td width="140px" style="text-align: right;">类型：</td>
					<td>${garage.typeName}</td>
				</tr>
				<tr>
					<td style="text-align: right;">电话：</td>
					<td>${garage.contactPhone}</td>
				</tr>
				<tr>
					<td style="text-align: right;">详细地址：</td>
					<td>${garage.garageAddr}</td>
				</tr>
				<tr class="bjis">
					<td style="text-align: right;">服务特色：</td>
					<td>${garage.serviceFeature}</td>
				</tr>
				<tr>
					<td style="text-align: right;">图片展示：</td>
					<td></td>
				</tr>
			</table>
				<div class="box" id="box">
					<ul>	
						<c:forEach items="${garage.photoList}" var="item" varStatus="status">
						 	<li class="apply"><img id="img${status.index}" src="${item}" width="100%" height="100%"></li>

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
	</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>送修任务管理(修理厂)</title>
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
<style type="text/css">
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
</style>
</head>
<body>
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-datagrid"
			style="width: auto; height: 100%;"
			url="${ctx }/repairtask/garagelist?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
			<thead>
				<tr>
					<th width="150" data-options="field:'taskId',align:'center',formatter:formatTaskId">任务编号</th>
					<!-- <th field="taskId" width="150" >任务编号</th> -->
					<th field="registNo" width="150">报案号</th>
					<th field="orgDesc" width="100">组织机构</th>
					<th field="carOwner" width="100">联系人</th>
					<th field="mobile" width="100">手机号</th>
					<th field="licenseNo" width="100">车牌号</th>
					<th field="surveyName" width="80">查勘员</th>
					<th data-options="field:'startTime',width:70,formatter:toLocalFullDate">任务时间</th>
					<th field="statusDes" width="12%">任务状态</th>		
					<!-- <th data-options="field:'status',align:'center',formatter:formatStatus">任务状态</th>-->
					<th width="20%"
						data-options="field:'_operate',align:'center',formatter:formatOper">操作选择</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- search  -->
			<form id="fm-search" method="post" novalidate>
				<table class="xw_search_tb">
					<tr class="tb-bj pdd-top">
						<td width="25%"><label class="lab-tb">任务编号：</label> <input
							name="text-tb" id="taskId_search" class="text-tb" /></td>
						<td width="25%"><label class="lab-tb">报案号：</label> <input
							name="registNo_search" id="registNo_search" class="text-tb">
						</td>
						<td width="25%"><label class="lab-tb">联系人：</label> <input
							name="carOwner_search" id="carOwner_search" class="text-tb">
						</td>
						<td width="25%"><label class="lab-tb">任务状态：</label> <input
							name="status_search" id="status_search" class="easyui-combobox"
							style="height: 28px; width: 150px;">
						</td>
					</tr>
					<tr class="tb-bj ">
						<td width="25%"><label class="lab-tb">车牌号：</label> <input
							name="licenseNo_search" id="licenseNo_search" class="text-tb">
						</td>
						<td colspan="2"><label class="lab-tb">任务时间：</label> <input
							name="startTime_search" id="startTime_search"
							class="easyui-datebox" style="height: 28px;">&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
							<input name="endTime_search" id="endTime_search"
							class="easyui-datebox" style="height: 28px;"></td>
						<td  style="text-align: right;"><a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="searchRepairTaskSingle()"
							style="background: #418ad1; color: white; width: 100px">查询</a> <a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="resetSingle()"
							style="background: #e37648; color: white; width: 100px;">重置</a>
						</td>
					</tr>
				</table>
			</form>
			<!-- search -->
		</div>
	</div>

	<script type="text/javascript"
		src="${ctx }/resources/js/page/repairtask/repairtasklist.js"></script>

</body>
</html>
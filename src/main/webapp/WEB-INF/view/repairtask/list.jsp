<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>送修任务管理</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
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
			style="width: auto; height: 100%;" url="${ctx }/repairtask/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
			<thead frozen="true">
				<tr>
					<th width="14%" data-options="field:'taskId',align:'center',formatter:formatTaskId">任务编号</th>
					<!-- <th field="taskId" width="14%">任务编号</th> -->
					<th field="registNo" width="14%">报案号</th>
					<!-- <th field="companyDesc" width="80">精友订单号</th> -->
					<th field="orgDesc" width="18%">组织机构</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="carOwner" width="12%">联系人</th>
					<th field="mobile" width="12%">手机号</th>
					<th field="licenseNo" width="10%">车牌号</th>
					<th field="surveyName" width="8%">查勘员</th>
					<th width="12%" data-options="field:'startTime',formatter:toLocalFullDate">任务时间</th>
					<th field="statusDes" width="12%">任务状态</th>					
					<!-- <th data-options="field:'status',align:'center',formatter:formatStatus">任务状态</th> -->
					<th width="20%" data-options="field:'_operate',align:'center',formatter:formatOper">操作选择</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- search  -->
			<form id="fm-search" method="post" novalidate>
				<table class="xw_search_tb">
					<tr class="tb-bj pdd-top">
						<td width="27%">
							<label class="lab-tb">任务编号：</label>
						  <input name="text-tb"
							id="taskId_search" class="text-tb"/>
						</td>
						<td width="27%">
							<label class="lab-tb">报案号：</label>
							<input name="registNo_search"
							id="registNo_search" class="text-tb">
						</td>
						<td width="46%">
							<label class="lab-tb">精友订单号：</label>
							<input  class="text-tb" disabled="disabled">
						</td>
						
					</tr>
					<tr class="tb-bj ">
					<td>
			  				<label class="lab-tb">组织机构：</label>
			  				<input id="orgId_search" name ="orgId_search" class="easyui-combobox" style="height:28px; width:150px;" data-options="valueField:'id',textField:'text'" />
		  				</td>
					<td>
						<label class="lab-tb">任务状态：</label>
						<input name="status_search" id="status_search" class="easyui-combobox" style="height:28px;  width:150px;">
					</td>
					<td>
						<label class="lab-tb">联系人：</label>
						<input name="carOwner_search"
						id="carOwner_search" class="text-tb">
					</td>
					
					
					
					</tr>
					<tr class="tb-bj pdd-bot">
					<td>
							<label class="lab-tb">车牌号：</label>
							<input name="licenseNo_search"
							id="licenseNo_search" class="text-tb">
						</td>
						<td>
							<label class="lab-tb">查勘员：</label>
							<input name="surveyName_search"
							id="surveyName_search" class="text-tb">
						</td>
						<td>
						<label class="lab-tb">任务时间：</label>
						<input name="startTime_search"
						id="startTime_search" class="easyui-datebox" style="height:28px; width:150px;">&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
						<input name="endTime_search"
						id="endTime_search" class="easyui-datebox" style="height:28px; width:150px;">
					</td>
						
					</tr>
					<tr>
						<td colspan="4" style="text-align: right; padding: 15px 15px 5px 0px;"><a href="javascript:void(0)"
							class="easyui-linkbutton" plain="true" onclick="searchRepairTask()"
							style="background: #418ad1; color: white; width: 100px">查询</a> 
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="reset()"
							style="background: #e37648; color: white; width: 100px;">重置</a></td>
					</tr>
				</table>
			</form>
			<!-- search -->
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx }/resources/js/page/repairtask/repairtasklist.js"></script>
	
</body>
</html>
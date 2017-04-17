<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>报表管理</title>
<link rel="stylesheet" type="text/css" href="../resources/css/main.css">
<script type="text/javascript" src="${ctx }/resources/js/page/repairtaskreport/repairtaskreportlist.js"></script>
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
<script type="text/javascript">

    	//默认获取当前日期范围（一个月）
			function myformatter1(date) {
				var y = date.getFullYear();
				var m = date.getMonth();
				var d = date.getDate();

				return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
						+ (d < 10 ? ('0' + d) : d);
			}
			function myformatter2(date) {
				var y = date.getFullYear();
				var m = date.getMonth() + 1;
				var d = date.getDate();

				return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
						+ (d < 10 ? ('0' + d) : d);
			}

			$(function() {
				var curr_time = new Date();
				$("#startTime_search").datebox({
					value : myformatter1(curr_time)
				});
				$("#endTime_search").datebox({
					value : myformatter2(curr_time)
				});
				
				var startTime = $("#startTime_search").datebox('getValue');
				var endTime = $("#endTime_search").datebox('getValue');
				
				$("#dg").datagrid({
					url:getBasePath() + "/repairtaskreport/list?startTime="+startTime+"&endTime="+endTime,
				});
        });
			
   
    </script>
</head>
<body>
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-datagrid"
<%-- 		url="${ctx }/repairtaskreport/list?t=<%=(new java.util.Date())%>" --%>
			style="width: auto; height: 100%;"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
				<thead data-options="frozen:true">
				<tr>
					<th field="orgId" width="150">机构编码</th>
					<th field="orgName" width="180">机构名称</th>
					<th field="registNo" width="150">案件号</th>
					</tr>
			</thead>
			<thead>
				<tr>
					<th field="licenseNo" width="15%">车牌号</th>
					<th data-options="field:'carType',align:'center',formatter:formatCarType" width="15%">送修类型</th>
					<th data-options="field:'taskType',align:'center',formatter:formatTaskType"  width="15%">送修来源</th>
					<th field="userAccount" width="15%">送修人</th>
					<th field="userPhone" width="15%">送修电话</th>
					<th field="surveyName" width="8%">查勘员姓名</th>
					<th field="carOwner" width="15%">车主姓名</th>
					<th data-options="field:'startTime',formatter:toLocalFullDate"  width="15%">送修时间</th>
					<th field="garageName" width="150">修理厂名称</th>
					<th data-options="field:'confirmTime',formatter:toLocalFullDate"  width="15%">接收时间</th>
					<th field="status" width="15%">状态</th>
					<th data-options="field:'finishTime',formatter:toLocalFullDate"  width="15%">完成时间</th>
					<th data-options="field:'evTime',formatter:toLocalFullDate" width="15%">评价时间</th>
					</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- search  -->
			<form id="fm-search" method="post" novalidate>
				<table class="xw_search_tb">
					<tr class="tb-bj pdd-top">
						<td width="25%"><label class="lab-tb">状态：</label> <input
							name="status_search" id="status_search" class="easyui-combobox"
							style="height: 28px; width: 150px;">
						</td>
						<td width="25%"><label class="lab-tb">组织机构：</label> <input id="orgId_search" 
						name ="orgId_search" class="easyui-combobox" style="height:28px; width:150px;" 
						data-options="valueField:'id',textField:'text'" />
						</td>
						<td width="25%"></td>
						<td width="25%"></td>	
					</tr>
					<tr class="tb-bj ">
						<td colspan="4"><label class="lab-tb">送修时间：</label> <input
							name="startTime_search" id="startTime_search"
							class="easyui-datebox" style="height: 28px;">&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;
							<input name="endTime_search" id="endTime_search"
							class="easyui-datebox" style="height: 28px;"></td>
				   </tr>
				   <tr>			
						<td  colspan="4" style="text-align: right; padding: 15px 15px 5px 0px;"><a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="searchRepairTaskSingle()"
							style="background: #418ad1; color: white; width: 100px">查询</a> <a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="resetSingle()" type="reset" 
							style="background: #e37648; color: white; width: 100px;">重置</a>
							<a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="exportCSV()"
							style="background: #e55548; color: white; width: 100px;">导出</a>
						</td>
					</tr>
				</table>
			</form>
			<!-- search -->
		</div>
	</div>


</body>
</html>
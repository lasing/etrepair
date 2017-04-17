<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>ET修理厂维护</title>
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
			style="width: 700px; height: 100%;"
			url="${ctx }/garage/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
			<thead frozen="true">
				<tr>
					<th field="garageCode" width="8%">修理厂编号</th>
					<th field="garageName" width="18%">修理厂名称</th>
					<th field="garageNameAbb" width="20%">修理厂简称</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="contactPhone" width="12%">电话</th>
					<th field="repairTel" width="12%">视频查勘电话</th>
					<th field="orgDesc" width="18%">组织机构</th>
					<th field="orgId" width="8%">结构编码</th>
					<th field="tasklimit" width="8%">任务上限数</th>
					<th field="garageAddr" width="25%">地址</th>
					<th field="longitude" width="5%">经度</th>
					<th field="latitude" width="5%">纬度</th>
					<th width="5%"
						data-options="field:'isEnable',align:'center',formatter:formatIsEnable">是否可用</th>
					<th field="pointNumber" width="8%">ET网点编号</th>
					<th width="8%"
						data-options="field:'expDate',formatter:toLocalFullDate">合作有效期</th>

				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<table class="xw_search_tb">
				<tr class="tb-bj pdd-top">
					<td width="33.33333%"><label class="lab-tb">修理厂编号：</label> <input
						id="search_garageCode" class=" text-tb" type="text" value="" /></td>
					<td width="33.33333%"><label class="lab-tb">修理厂名称：</label> <input
						id="search_garageName" class="text-tb" type="text" value="" /></td>
					<td width="33.33333%"><label class="lab-tb">修理厂简称：</label> <input
						id="search_garageNameAbb" class=" text-tb" type="text" value="" />
					</td>
				</tr>
				<tr class="tb-bj pdd-bot">
					<td><label class="lab-tb">电话：</label> <input
						id="search_contactPhone" class=" text-tb" type="text" value="" />
					</td>
					<td><label class="lab-tb">地址：</label> <input
						id="search_garageAddr" class=" text-tb" type="text" value="" /></td>
					<td><label class="lab-tb">组织机构：</label> <input
						id="search_orgId" name="search_orgId" class="easyui-combobox"
						style="height: 28px; width: 150px;"
						data-options="valueField:'id',textField:'text'" /></td>

				</tr>
				<tr>
					<td colspan=3
						" style="text-align: right; padding: 15px 15px 0px 0px;"><a
						href="javascript:void(0)" class="easyui-linkbutton" plain="true"
						onclick="doSearch()"
						style="background: #6bb1e6; color: white; width: 100px;">查询</a> <a
						href="javascript:void(0)" class="easyui-linkbutton" plain="true"
						onclick="doReset()"
						style="background: #e37648; color: white; width: 100px;">重置</a></td>
				</tr>
			</table>
			<c:if test="${ empty isReadOnly || !isReadOnly}">
				<div style="padding: 0px 0px 5px 5px;">
					<!-- <a href="#"> <input type="checkbox"
						style="dispay: block; float: left">&nbsp; <span
						style="dispay: block; float: left">全选</span> <span class="clear"></span>
					</a> -->
					<a href="javascript:void(0)" class="main-bott xz-bott-i "
						onclick="newGarage()" plain="true"> <i
						class="fa fa-plus-square-o"></i>&nbsp;新增
					</a> <a href="javascript:void(0)" class="main-bott bji-bott-i "
						onclick="doUpdateRecord()" plain="true"> <i
						class="fa fa-pencil-square-o"></i>&nbsp;编辑
					</a> <a href="javascript:void(0)" id="viewGarage"
						class="main-bott ck-bott-i " onclick="doShowRecord()" plain="true">
						<i class="fa fa-search"></i>&nbsp;查看
					</a> <a href="javascript:void(0)" class="main-bott sc-bott-i "
						onclick="deleteByid()" plain="true"> <i class="fa fa-trash-o"></i>&nbsp;删除
					</a>
					<!-- class="easyui-linkbutton" -->
				</div>
			</c:if>
		</div>

	</div>

	<!-- 新增窗口 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 850px; height: 500px;" closed="true"
		buttons="#dlg-buttons">

		<div style="height: 100%;">
			<table id="dg_core" title="新增" class="easyui-datagrid"
				style="width: 850px; height: 100%;"
				url="${ctx }/garage/core/list?t=<%=(new java.util.Date())%>"
				toolbar="#toolbar_add" pagination="true" rownumbers="true"
				fit="true" fitColumns="true" singleSelect="true" pageSize:20>
				<thead>
					<tr>
						<th width="30"
							data-options="field:'isExists',align:'center',formatter:formatIsExists">是否存在</th>
						<th field="garageCode" width="60">修理厂编号</th>
						<th field="garageName" width="90">修理厂名称</th>
						<th field="repairTel" width="50">视频定损设备号</th>
						<th field="orgDesc" width="50">组织机构</th>
					</tr>
				</thead>
			</table>

			<div id="toolbar_add">
				<table class="xw_search_tb BJ-tab">
					<tr class="tb-bj pdd-top">
						<td width="40%"><label class="lab-tb-BJ">精友修理厂名称：</label> <input
							id="search_core_garageName" class="text-tb" type="text" value="" /></td>
						<td width="40%"><label class="lab-tb-BJ">精友修理厂编号：</label> <input
							id="search_core_garageCode" class="text-tb" type="text" value="" /></td>

					</tr>
					<tr class="tb-bj pdd-bot">
						<td width="40%"><label class="lab-tb-BJ">视频定损设备号：</label> <input
							id="search_core_repairTel" class="text-tb" type="text" value="" /></td>
						<td width="40%"><label class="lab-tb-BJ">组织机构：</label> <input
							id="search_core_orgId" name="search_orgId"
							class="easyui-combobox" style="height: 28px; width: 150px;"
							data-options="valueField:'id',textField:'text'" /></td>
					</tr>
					<tr>
						<td colspan="2"
							style="text-align: right; padding: 15px 15px 15px 0px;"><a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="doAddSearch()"
							style="background: #6bb1e6; color: white; width: 100px;">查询</a> <a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="doAddReset()"
							style="background: #e37648; color: white; width: 100px;">重置</a></td>
					</tr>
				</table>

			</div>
		</div>

	</div>


	<!-- 修改窗口 -->
	<div id="dlg-update" class="easyui-dialog"
		style="width: 850px; height: 500px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-update">
		<div class="ftitle">
			<label style="font-size: 16px; font-weight: lighter;">修理厂名称:</label>
			<span id="dlg-update_garageName"
				style="font-size: 16px; font-weight: lighter;"></span>
		</div>
		<form id="fm_update" method="post" novalidate>
			<table class="tckuang">
				<tr>
					<td><label class="lab-tb-BJ">ET网点编号：</label> <input
						id="dlg-update_pointNumber" name="pointNumber"
						class="easyui-textbox" style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="pointNumberValidator"></td>

					<td><label class="lab-tb-BJ">联系人：</label> <input
						id="dlg-update_contact" name="contact" class="easyui-textbox"
						style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="contactValidator"></td>
				</tr>
				<tr>
					<td><label class="lab-tb-BJ">联系电话：</label> <input
						id="dlg-update_contactPhone" name="contactPhone"
						class="easyui-textbox" style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="contactPhoneValidator"></td>
					<td><label class="lab-tb-BJ">修理厂简称：</label> <input
						id="dlg-update_garageNameAbb" name="garageNameAbb"
						class="easyui-textbox" style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="garageNameAbbValidator"></td>
				</tr>
				<tr>
					<td><label class="lab-tb-BJ">地址简称：</label> <input
						id="dlg-update_garageAddrAbb" name="garageAddrAbb"
						class="easyui-textbox" style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="garageAddrAbbValidator"></td>
					<td><label class="lab-tb-BJ">修理厂地址：</label> <input
						id="dlg-update_garageAddr" name="garageAddr"
						class="easyui-textbox" style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="garageAddrValidator"></td>
				</tr>
				<tr>
					<td><label class="lab-tb-BJ">经度：</label> <input
						id="dlg-update_longitude" name="longitude" class="easyui-textbox"
						style="height: 28px;" disabled="disabled"></td>
					<td><label class="lab-tb-BJ">纬度：</label> <input
						id="dlg-update_latitude" name="latitude" class="easyui-textbox"
						style="height: 28px;" disabled="disabled"></td>
				</tr>
				<tr>
					<td><label class="lab-tb-BJ">合作有效期：</label> <input
						id="dlg-update_expDate" name="expDate" class="easyui-datebox"
						data-options="required:true,validateOnBlur:true"
						style="height: 28px;"
						data-options="required:true,validateOnBlur:true"></td>
					<td><label class="lab-tb-BJ">任务上限数：</label> <input
						id="dlg-update_tasklimit" name="tasklimit" class="easyui-textbox"
						style="height: 28px;"
						data-options="required:true,validateOnBlur:true"
						validType="tasklimitValidator"></td>
				</tr>

				<tr>
					<td><label class="lab-tb-BJ">修理厂类别：</label> <input
						name="categoryCode" id="categoryCode" class="easyui-combobox"
						style="height: 28px; width: 150px;" ></td>
					<!-- 					<td><label class="lab-tb-BJ">修理厂类别：</label> -->
					<!-- 					<select id="categoryCode" style="height:27;width:200"> -->
					<!-- 					<option value="000">请选择</option> -->
					<!-- 					<option value="001">合作4S店</option> -->
					<!-- 					<option value="002">非合作4S店</option> -->
					<!-- 					<option value="003">合作普通修理厂</option> -->
					<!-- 					<option value="004">非合作普通修理厂（一类厂）</option> -->
					<!-- 					<option value="005">非合作普通修理厂（二类厂）</option> -->
					<!-- 					<option value="006">非合作普通修理厂（三类厂）</option> -->
					<!-- 					<option value="007">通用修理厂</option> -->
					<!-- 					<option value="012">高端维修</option> -->
					<!-- 					<option value="013">社区门店</option> -->
					<!-- 					</select> -->
					<!-- 					</td> -->
					<td colspan="2">
<!-- 					<input id="dlg-update_categoryCode" -->
<!-- 						name="categoryCode" class="easyui-textbox" type="hidden" /> -->
						</td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: right;"><label
						class="lab-tb-BJ">服务特色：</label> <textarea rows="5" cols="70"
							id="dlg-update_serviceFeature" name="serviceFeature"
							style="resize: none;"></textarea></td>
				</tr>

			</table>
		</form>
		<div id="filedlg"
			style="width: 400px; height: 50px; padding: 10px 20px">
			<form id="filefm" method="post" enctype="multipart/form-data">
				<div class="fitem">
					<input type="file" id="file" name="file"> <input
						type="button" class="xw_ensure_btn" style="width: 90px"
						onclick="uploadFile()" value="上传图片">
				</div>
			</form>
		</div>
		<span id="picShow"></span>

	</div>

	<!-- 保存新增ET修理厂按钮 -->
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveGarage()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">取消</a>
	</div>

	<!-- 更新  按钮 -->
	<div id="dlg-buttons-update">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="updateRecord()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-update').dialog('close')"
			style="width: 90px">取消</a>
	</div>
	<script type="text/javascript"
		src="${ctx }/resources/js/page/garage/garagelist.js"></script>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>角色管理</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<style type="text/css">
	#dlg-roleFunction input[type=checkbox] {
	    vertical-align: middle;
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
	#dg tr th background:blue;}
	
</style>
</head>
<body>
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-datagrid"
			style="width: 700px; height: 100%; background:#000000;" url="${ctx }/role/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="false" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<th field="roleCode" width="50">角色代码</th>
					<th field="roleName" width="50">角色名称</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<c:if test="${ empty isReadOnly || !isReadOnly}">
			<div style="padding:10px 0;">
				<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="newRole()"
				><i class="fa fa-plus-square-o"></i>&nbsp;新增</a> 
				<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="editRole()"
				><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a> 
				<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="editRoleFunction()"
				><i class="fa fa-cog"></i>&nbsp;权限设置</a> 
				<a href="javascript:void(0)" class="main-bott sc-bott-i" plain="true" onclick="destroyRole()"
				><i class="fa fa-trash-o"></i>&nbsp;删除</a>
			</div>	
			<div style="clear: both;"></div>
			</c:if>
		</div>
	</div>
	<!-- add self -->
	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">角色</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">角色代码：</label> <input name="roleCode" class="easyui-textbox"style="height:28px;"
					required="required"  validType="roleCodeValidator['#roleCodeValidatorTip']"><span id="roleCodeValidatorTip">&nbsp;角色编码2~10位字符之间,且不为空 </span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">角色名称：</label> <input name="roleName" class="easyui-textbox"style="height:28px;"
					required="required"  validType="roleNameValidator['#roleNameValidatorTip']"><span id="roleNameValidatorTip"></span>
			</div>
		</form>


	</div>
	<!--  更新 start -->
	<div id="dlg-update" class="easyui-dialog"
		style="width: 600px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-update">
		<div class="ftitle">角色</div>
		<form id="fm-update" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">角色代码：</label> <input name="roleCode" id="roleCodeUpdate" class="easyui-textbox" style="height:28px;"
					required="required"  validType="reRoleCodeValidator['#reRoleCodeValidatorTip']">   <span id="reRoleCodeValidatorTip"></span>   
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">角色名称：</label> <input name="roleName" id="roleNameUpdate" class="easyui-textbox" style="height:28px;"
					required="required"  validType="reRoleNameValidator['#reRoleNameValidatorTip']">  <span id="reRoleNameValidatorTip"></span>
			</div>
		</form>
	</div>
	<!-- 更新 end -->
	<!-- 角色菜单 -->
	<div id="dlg-roleFunction" class="easyui-dialog"
		style="width: 500px; height: 500px; padding: 10px 20px;overflow:hidden;" closed="true"
		buttons="#dlg-buttons-roleFunction">
		<!-- treegrid start -->
		<table id="tt" style="height: 400px"></table>
		<!-- treegrid end -->
	</div>
	<div id="dlg-buttons-roleFunction">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveRoleFunction()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-roleFunction').dialog('close')"
			style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveRole()" style="width: 90px ; border-radius:4px;">保存角色</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<div id="dlg-buttons-update">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="updateRole()" style="width: 90px; border-radius:4px;">更新角色</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-update').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<script type="text/javascript"
		src="${ctx }/resources/js/page/role/rolelist.js"></script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>菜单管理</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
	<!-- <div style="margin: 20px 0;"></div> -->
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-treegrid" fitColumns="true"
			style="width: 700px; height: 100%;" fit="true"
			data-options="
                url: '${ctx }/function/list?t=<%=(new java.util.Date())%>',
                method: 'get',
                rownumbers: true,
                showFooter: true,
                idField: 'functionId',
                treeField: 'functionName'
            "
		toolbar="#toolbar">
		<thead frozen="true">
			<tr>
				<th field="functionName" width="200" align='left'>菜单名称</th>
			</tr>
		</thead>
		<thead>
			<tr>
				<th field="functionUrl" width="60" align="center">菜单地址</th>
				<!-- <th field="iconName" width="60" align="center">菜单图标</th> -->

				</tr>
			</thead>
		</table>

		<div id="toolbar">
		<c:if test="${ empty isReadOnly || !isReadOnly}">
			<div style="padding:10px 0;">
				<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="newFunction()"
				><i class="fa fa-plus-square-o"></i>&nbsp;新增</a> 
				<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="editFunction()"
				><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a> 
				<a href="javascript:void(0)" class="main-bott sc-bott-i" plain="true" onclick="removeFunctions()"
				><i class="fa fa-trash-o"></i>&nbsp;删除</a>
			</div>
			<div style="clear:both;"></div>
       </c:if>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 480px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">菜单信息</div>
		<form id="fm" method="post" novalidate>
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ">菜单层级：</label> <input class="easyui-combobox" style="height:28px;"
					id="functionlevel" name="functionLevel"
					data-options="valueField:'id',textField:'text'"   editable="false">
			</div>
			<!--  add dropdownlist end -->
			<div class="fitem">
				<label class="lab-tb-BJ">菜单名称：</label> <input name="functionName" id="functionName"
					class="easyui-textbox" style="height:28px;" data-options="required:true"   validType="menuNameValidator['#menuValidatorTip']" ><span id="menuValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">菜单地址：</label> <input name="functionUrl" class="easyui-textbox" style="height:28px;">
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">菜单顺序：</label> <input name="functionOrder"
					class="easyui-textbox" style="height:28px;" required="required" validtype="number">
			</div>
			<!-- add dropdownlist start -->
			<!-- <div class="fitem">
				<label class="lab-tb-BJ">图标名称：</label> <input class="easyui-combobox" style="height:28px;" id="iconId"
					name="iconId" data-options="valueField:'id',textField:'text'"   editable="false">
			</div> -->
			<!--  add dropdownlist end -->
		</form>
	</div>



	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveFunction()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>

	<script type="text/javascript"
		src="${ctx }/resources/js/page/function/functionlist.js"></script>
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
</body>
</html>
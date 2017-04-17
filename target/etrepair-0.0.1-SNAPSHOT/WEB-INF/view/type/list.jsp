<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>数据字典</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-treegrid"
			style="width: 700px; height: 100%;" fitColumns="true" fit="true"
			data-options="
                url: '${ctx }/type/list?t=<%=(new java.util.Date())%>',
                method: 'get',
                rownumbers: true,
                showFooter: true,
                idField: 'id',
                treeField: 'name'"
			toolbar="#toolbar">
			<thead frozen="true">
				<tr>
					<th field="name" width="500" align='left'>字典名称</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="code" width="60" align="center">字典编码</th>
				</tr>
			</thead>
		</table>

		<div id="toolbar">
			<c:if test="${ empty isReadOnly || !isReadOnly}">
				<div style="padding:10px 0;">
					<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="newTypeGroup()"
						><i class="fa fa-download"></i>&nbsp;字典项录入</a> 
					<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="addType()"
						><i class="fa fa-download"></i>&nbsp;参数值录入</a> 
					<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true" onclick="edit()"
						><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a> 
					<a href="javascript:void(0)" class="main-bott sc-bott-i" plain="true" onclick="destroyType()"
						><i class="fa fa-trash-o"></i>&nbsp;删除</a>
				</div>
				<div style="clear:both;"></div>
			</c:if>	
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog"
		style="width: 500px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">字典信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">字典编码：</label> <input name="code" class="easyui-textbox" style="height:28px;"
					data-options="required:true" validType="typeCodeValidator['#typeCodeValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="typeCodeValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">字典名称：</label> <input name="name" class="easyui-textbox" style="height:28px;"
					data-options="required:true" validType="typeNameValidator['#typeNameValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="typeNameValidatorTip"></span>
			</div>
		</form>
	</div>

	<!-- 参数值录入  -->
	<div id="dlg-type-add" class="easyui-dialog"
		style="width: 500px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-add">
		<form id="fm-add" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">参数名称： </label> <input name="typecode" class="easyui-textbox" style="height:28px;"
					data-options="required:true"  validType="paramNameValidator['#paramNameValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="paramNameValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">参数值： </label> <input name="typename" class="easyui-textbox" style="height:28px;"
					data-options="required:true"  validType="paramValueValidator['#paramValueValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="paramValueValidatorTip"></span>
			</div>
		</form>
	</div>
	<!-- end -->
	<!-- 参数值更新  -->
	<div id="dlg-type-update" class="easyui-dialog"
		style="width: 500px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-update">
		<form id="fm-update" method="post" novalidate>
			<div class="fitem">
				<label>参数名称: </label> <input name="name" class="easyui-textbox" style="height:28px;"
					data-options="required:true"  validType="paramNameValidator['#paramNameReValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="paramNameReValidatorTip"></span>
			</div>
			<div class="fitem">
				<label>参数值: </label> <input name="code" class="easyui-textbox" style="height:28px;"
					data-options="required:true"  validType="paramValueValidator['#paramValueReValidatorTip']">&nbsp;&nbsp;&nbsp;<span id="paramValueReValidatorTip"></span>
			</div>
		</form>
	</div>
	<!-- end -->
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveTypeGroup()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<div id="dlg-buttons-add">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveType()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-type-add').dialog('close')"
			style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<div id="dlg-buttons-update">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveTypeGroup()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-type-update').dialog('close')"
			style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<script type="text/javascript"
		src="${ctx }/resources/js/page/type/typelist.js"></script>
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
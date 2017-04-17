<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>组织机构管理</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>

	<div style="height: 100%;">
	
	<%-- <table id="dg" title="组织机构管理" class="easyui-datagrid"
			style="width: 700px; height: 100%;" url="${ctx }/orginfo/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar"  fit="true"
			fitColumns="true" >
			<thead>
				<tr>
					<th field="orgname" width="350" align="left">组织机构名称</th>
					<th field="orgcode" width="60" align="center">组织机构编码</th>
					<th field="description" width="60" align="center">组织机构简称</th>
				</tr>
			</thead>
		</table> --%>
	
		<table id="dg" title="" class="easyui-treegrid"
			style="width: 700px; height: 100%;" fitColumns="true" fit="true"
			data-options="
                url: '${ctx }/orginfo/list?t=<%=(new java.util.Date())%>',
                method: 'get',
                rownumbers: true,
                showFooter: true,
                idField: 'id',
                treeField: 'orgname'
            "
			toolbar="#toolbar">
			<thead frozen="true">
				<tr>
					<th field="orgname" width="350" align="left">组织机构名称</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="orgcode" width="60" align="center">组织机构编码</th>
					<th field="description" width="60" align="center">组织机构简称</th>
				</tr>
			</thead>
		</table>

		<div id="toolbar" style="padding-bottom:10px;">
		<!-- search  -->
			<form id="fm-search" method="post" novalidate>
				<table class="xw_search_tb" style="">
					<tr class="tb-bj pdd-top pdd-bot">
						<td><label class="lab-tb">公司名称: &nbsp;</label>
							<input class="easyui-combobox" id="companycode-search" style="height:28px;"
							name="companycode-search"
							data-options="valueField:'id',textField:'text'" editable="false">
						<a href="javascript:void(0)"
							class="easyui-linkbutton" plain="true" onclick="searchOrgInfo()"
							style="background: #418ad1; color: white; width: 100px">查询</a> </td>
					</tr>
				</table>
			</form>
			<!-- search -->
		
			<c:if test="${ empty isReadOnly || !isReadOnly}">
			<div>
			<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true"
				onclick="newOrginfo()"><i class="fa fa-plus-square-o"></i>&nbsp;新增</a>
			<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true"
				onclick="editOrgInfo()"><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a>
			<a href="javascript:void(0)" class="main-bott sc-bott-i" plain="true"
				onclick="destroyOrgInfo()"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
				</div>
				<div style="clear:both;"></div>
		 </c:if>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 480px; padding: 10px 20px; " closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">组织机构信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构名称：</label> <input name="orgName" class="easyui-textbox" style="height:28px;"
					data-options="required:true,validateOnBlur:true"  validType="orgNameValidator['#orgnameValidatorTip']">&nbsp;&nbsp;<span id="orgnameValidatorTip">&nbsp; 名称长度不超过30个字符  </span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构编号：</label> <input name="orgCode" id="orgcode" class="easyui-textbox" style="height:28px;"
					data-options="required:true"  validType="orgCodeValidator['#orgCodeValidatorTip']">&nbsp;&nbsp;<span id="orgCodeValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构简称：</label> <input name="orgDesc"
					class="easyui-textbox" style="height:28px;" data-options="required:true">
			</div>
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">所属公司：</label>
					<input class="easyui-combobox" style="height:28px;" id="companycode"
							name="companyCode"
							data-options="valueField:'id',textField:'text'" editable="false">
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">上级组织机构：</label> <input class="easyui-combotree" style="height:28px;" id="_parentId"
					name="parentOrgId" data-options="valueField:'id',textField:'text'"   editable="false">
			</div>
			<!--  add dropdownlist end -->
		</form>
	</div>
	
	<div id="dlg-update" class="easyui-dialog"
		style="width: 600px; height: 480px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-update">
		<div class="ftitle">组织机构信息</div>
		<form id="fm-update" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构名称：</label> <input name="orgname" class="easyui-textbox" style="height:28px;"
					data-options="required:true,validateOnBlur:true"  validType="orgNameValidator['#orgnameUpdateValidatorTip']">&nbsp;&nbsp;<!-- <span id="orgnameUpdateValidatorTip">&nbsp; 名称长度不超过20个字符  </span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构编号：</label> <input name="orgcode" id="orgcode-update" class="easyui-textbox" style="height:28px;"
					data-options="readonly:false"   validType="reorgCodeValidator['#reorgCodeValidatorTip']">&nbsp;&nbsp;<!-- <span id="reorgCodeValidatorTip">&nbsp; 编码长度为0 ~ 6位  </span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">组织机构简称：</label> <input name="description"
					class="easyui-textbox" style="height:28px;" data-options="required:true">
			</div>
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">所属公司：</label>
					<input class="easyui-combobox" style="height:28px;" id="companycode_update"
							name="companycode"
							data-options="valueField:'id',textField:'text'" editable="false">
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ" style="width:120px;">上级组织机构：</label> <input class="easyui-combobox" style="height:28px;" id="_parentId_update"
					name="_parentId" data-options="valueField:'id',textField:'text'">
			</div>
			<!--  add dropdownlist end -->
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveOrgInfo()" style="width: 90px ; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<div id="dlg-buttons-update">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="updateOrgInfo()" style="width: 90px; border-radius:4px;">更新</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-update').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	<script type="text/javascript"
		src="${ctx }/resources/js/page/orginfo/orginfolist.js"></script>
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
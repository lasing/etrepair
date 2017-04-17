<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>公司管理</title>
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
		<table id="dg" title="公司管理" class="easyui-datagrid"
			style="width: 700px; height: 100%;" url="${ctx }/company/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
			<thead>
				<tr>
					<th field="companyCode" width="40">公司编码</th>
					<th field="companyName" width="80">公司名称</th>
					<th field="companyDesc" width="80">公司简称</th>
					<th field="companyAddr" width="100">公司地址</th>
					<th field="contact" width="50">联系人</th>
					<th field="contactPhone" width="50">联系电话</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- search  -->
			<form id="fm-search" method="post" novalidate style="margin-bottom: 0px;">
				<table class="xw_search_tb">
					<tr class="tb-bj pdd-top pdd-bot">
						<td width="33.3333%">
						<label class="lab-tb">公司编码：</label>
						  <input name="companycode-search"
							id="companycode-search" class="text-tb"  style="height:28px;"/>
						</td>
						<td width="33.3333%">
						<label class="lab-tb">公司名称：</label>
							<input name="companyname-search"
							id="companyname-search" class="text-tb"  style="height:28px;">
						</td>
						<td width="33.3333%"></td>
					</tr>
					<tr>
						<td  colspan="3" style="text-align: right; padding:15px 15px 0px 0px;"><a href="javascript:void(0)"
							class="easyui-linkbutton" plain="true" onclick="searchCompany()"
							style="background: #418ad1; color: white; width: 100px">查询</a> 
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="reset()"
							style="background: #e37648; color: white; width: 100px;">重置</a></td>
					</tr>
				</table>
			</form>
			<!-- search -->
			<c:if test="${ empty isReadOnly || !isReadOnly}">
				<div  style="padding:0px 0px 5px 5px; ">
					<a href="javascript:void(0)" class="main-bott bji-bott-i" plain="true"
					onclick="newCompany()"><i class="fa fa-plus-square-o"></i>&nbsp;新增</a> <a
					href="javascript:void(0)" class="main-bott bji-bott-i" plain="true"
					onclick="editCompany()"><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a> 
					<a href="javascript:void(0)" class="main-bott sc-bott-i" plain="true"
					onclick="destroyCompany()"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
				</div>
				<div style="clear:both;"></div>
			 </c:if>
		</div>
	</div>

<!-- 新增窗口 -->
	<div id="dlg" class="easyui-dialog"
		style="width: 600px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">公司</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">公司编码：</label> <input name="companyCode" class="easyui-textbox" id="companyCode" style="height:28px;"
					required="required"  validType="companyCodeValidator['#companyCodeValidatorTip']"><span id="companyCodeValidatorTip">&nbsp;公司编码2~10位字符</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司名称：</label> <input name="companyName" id="companyName" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyNameValidator['#companyNameValidatorTip']"><span id="companyNameValidatorTip">&nbsp;公司名称2~50位字符</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司简称：</label> <input name="companyDesc" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyDescValidator['#companyDescValidatorTip']"><span id="companyDescValidatorTip">&nbsp;公司简介2~50位字符</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司地址：</label> <input name="companyAddr" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyAddrValidator['#companyAddrValidatorTip']"><span id="companyAddrValidatorTip">&nbsp;公司地址2~50位字符</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">联系人：</label> <input name="contact" class="easyui-textbox" style="height:28px;"
					required="required"  validType="contactValidator['#contactValidatorTip']"><span id="contactValidatorTip">&nbsp;联系人2~30位字符</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">手机号：</label> <input name="contactPhone" class="easyui-textbox" style="height:28px;"
				  validType="mobile['#contactPhoneValidatorTip']"><span id="contactPhoneValidatorTip"></span>
			</div>
		</form>
	</div>
	
	
<!-- 修改窗口 -->
	<div id="dlg-update" class="easyui-dialog"
		style="width: 600px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-update">
		<div class="ftitle">公司</div>
		<form id="fm-update" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">公司编码：</label> <input name="companyCode" id="companyCodeUpdate" class="easyui-textbox" style="height:28px;"
					required="required"  validType="reCompanyCodeValidator['#reCompanyCodeValidatorTip']"><span id="reCompanyCodeValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司名称：</label> <input name="companyName" id="companyNameUpdate" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyNameValidator['#reCompanyNameValidatorTip']"><span id="reCompanyNameValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司简介：</label> <input name="companyDesc" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyDescValidator['#reCompanyDescValidatorTip']"><span id="reCompanyDescValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">公司地址：</label> <input name="companyAddr" class="easyui-textbox" style="height:28px;"
					required="required"  validType="companyAddrValidator['#reCompanyAddrValidatorTip']"><span id="reCompanyAddrValidatorTip"></span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">联系人：</label> <input name="contact" class="easyui-textbox" style="height:28px;"
					required="required"  validType="contactValidator['#reContactValidatorTip']"><!-- <span id="reContactValidatorTip">&nbsp;联系人2~30位字符</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">手机号：</label> <input name="contactPhone" class="easyui-textbox" style="height:28px;"
					  validType="mobile['#contactPhoneValidatorTip']"><span id="contactPhoneValidatorTip"></span>
			</div>
		</form>
	</div>
	
	
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveCompany()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	
	<!-- 更新 -->
	<div id="dlg-buttons-update">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="updateCompany()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-update').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	
	<script type="text/javascript" src="${ctx }/resources/js/page/company/companylist.js"></script>
	
</body>
</html>
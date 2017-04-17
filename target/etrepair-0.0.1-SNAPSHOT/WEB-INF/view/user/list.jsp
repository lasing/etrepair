<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%@ include file="../common/meta.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">

</head>
<body>
	<div style="height: 100%;">
		<table id="dg" title="" class="easyui-datagrid" url="${ctx }/user/list?t=<%=(new java.util.Date())%>"
			toolbar="#toolbar" pagination="true" rownumbers="true" fit="true"
			fitColumns="true" singleSelect="true" pageSize:20>
			<thead frozen="true">
				<tr>
					<th field="userCode" width="10%">员工编号</th>
					<th field="userName" width="12%">用户名</th>
					<th field="realName" width="12%">真实姓名</th>
				</tr>
			</thead>
			<thead>
				<tr>
					<th field="companyName" width="20%">公司</th>
					<th field="orgName" width="20%">组织名称</th>
					<!-- <th field="roleName" width="50">角色名称</th> -->
					<th field="mobilePhone" width="12%">手机号码</th>
					<th field="officePhone" width="12%">办公电话</th>
					<th field="email" width="20%">常用邮箱</th>
					<th field="status" width="5%" data-options="formatter:statusFormatter">状态</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- search  -->
			<form id="fm-search" method="post" novalidate style="margin-bottom: 0px;">
				<table class="xw_search_tb">
					<tr class="tb-bj pdd-top pdd-bot">
						<td>
							<label class="lab-tb">用户名：</label>
							<input name="username-search" id="username-search" 
								class="easyui-textbox " style="height:28px;"/>
						</td>
						<td>
							<label class="lab-tb">员工编号：</label>
							<input name="usercode-search"
								id="usercode-search" class="easyui-textbox" style="height:28px;">
						</td>
						<td>
						<label class="lab-tb">真实姓名：</label>
						<input
							name="realname-search" id="realname-search" style="height:28px;"
							class="easyui-textbox" >
						</td>
						<td>
						<label class="lab-tb">公司：</label>
						<input class="easyui-combobox" id="companycode-search" style="height:28px;"
							name="companycode-search"
							data-options="valueField:'id',textField:'text'" editable="false">
						</td>
					
					</tr>
					<tr>
						<td colspan="4" style="text-align: right; padding: 15px 15px 0px 0px;"><a href="javascript:void(0)"
							class="easyui-linkbutton" plain="true" onclick="searchUser()"
							style="background: #418ad1; color: white; width: 100px">查询</a> <a
							href="javascript:void(0)" class="easyui-linkbutton" plain="true"
							onclick="reset()"
							style="background: #e37648; color: white; width: 100px;">重置</a></td>
					</tr>
				</table>
			</form>
			<!-- search -->
			<c:if test="${ empty isReadOnly || !isReadOnly}">
				<div style="padding:0px 0px 5px 5px; ">
					<a href="javascript:void(0)" class="main-bott bji-bott-i " plain="true"
					onclick="newUser()"
					><i class="fa fa-plus-square-o"></i>&nbsp;新增</a> <a
					href="javascript:void(0)" class="main-bott bji-bott-i " plain="true"
					onclick="editUser()"
					><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a> <a
					href="javascript:void(0)" class="main-bott bji-bott-i " plain="true"
					onclick="editRole()"
					><i class="fa fa-file-text-o"></i>&nbsp;角色分配</a> <a
					href="javascript:void(0)" class="main-bott sc-bott-i " plain="true"
					onclick="destroyUser()"
					><i class="fa fa-trash-o"></i>&nbsp;删除</a>
				</div>
				<div style="clear: both;"></div>
			 </c:if>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog"
		style="width: 700px; height: 480px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">用户信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label  class="lab-tb-BJ">员工编号：</label> <input name="userCode"  id="userCode"  class="easyui-textbox" style="height:28px;" data-options="required:true"  validType="userCodeValidator['#usercodeValidatorTip']"><!-- <span id="usercodeValidatorTip">&nbsp; 员工编号为5位以上字符</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">用户名：</label> <input name="userName" id="userName" class="easyui-textbox" style="height:28px;" data-options="required:true"   validType="userNameValidator['#usernameValidatorTip']"><!-- <span id="usernameValidatorTip"> &nbsp; 用户名范围在2~20位字符</span> -->
			</div>
			
			<div class="fitem">
				<label class="lab-tb-BJ">真实姓名：</label> <input name="realName" id="realName" class="easyui-textbox" style="height:28px;" data-options="required:true" validType="realNameValidator['#realnameValidatorTip']"><!-- <span id="realnameValidatorTip">&nbsp; 填写个人真实姓名</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">密码：</label> <input name="password" type="password"  id="password"  class="easyui-textbox"  style="height:28px;"data-options="required:true"  validType="passwordValidator['#passwordValidatorTip']"><!-- <span id="passwordValidatorTip">&nbsp; 密码至少6个字符,最多18个字符</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">确认密码：</label> <input name="repassword"  type="password" id="repassword" class="easyui-textbox" style="height:28px;" data-options="required:true" validType="repasswordValidator['#password','#repasswordValidatorTip']"><!-- <span id="repasswordValidatorTip">&nbsp; 重复个人密码</span> -->
			</div>
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ">公司：</label> <input class="easyui-combobox" style="height:28px;" id="companycode" required="required" validtype="selectValueRequired['#departidValidatorTip']"  type="text"
					name="companyCode" data-options="valueField:'id',textField:'text'" 
                  editable="false" ><span id="departidValidatorTip">&nbsp; 请选择部门</span>
			</div>
			<!--  add dropdownlist end -->
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ">组织机构：</label> <input class="easyui-combobox" style="height:28px;" id="orgid"  required="required" validtype="selectValueRequired['#taorgidValidatorTip']"  type="text"
					name="orgId" data-options="valueField:'id',textField:'text'" editable="false"><span id="taorgidValidatorTip">&nbsp; 请选择组织机构</span>
			</div>
			<!--  add dropdownlist end -->
			<div class="fitem">
				<label class="lab-tb-BJ">手机号码：</label> <input name="mobilePhone"  id="mobilePhone" class="easyui-textbox" style="height:28px;"  required="required" validtype="mobile['#mobilephoneValidatorTip']" ><span id="mobilephoneValidatorTip">&nbsp; 手机号码位11位数字</span>
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">办公室电话：</label> <input name="officePhone" id="officePhone" 
					class="easyui-textbox"  style="height:28px;"   > 
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">常用email：</label> <input name="email"  id="email"   class="easyui-validatebox" style="height:28px;" data-options="validType:'email'" invalidMessage="邮箱格式不正确"><span id="emailValidatorTip" >&nbsp; 邮箱格式：用户名@主机域名，如abc@123.com</span>
			</div>
			<div  class="fitem">
			<label class="lab-tb-BJ">是否可用：</label> 
			<select id="isEnable" class="easyui-combobox" style="height:28px; width: 100px;" name="isEnable" data-options="required:true" style="width:100px" editable="false">
		   						<option value="1">是</option>
								<option value="0">否</option>								    
			</select><span></span>
			</div>
			
		</form>
	</div>
	
	<!--  用户更新  start-->
	
	<div id="dlg-update" class="easyui-dialog"
		style="width: 700px; height: 480px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-userUpdate">
		<div class="ftitle">用户信息</div>
		<form id="fm-update" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb-BJ">员工编号：</label> <input name="userCode"  id="usercodeUpdate"  class="easyui-textbox" style="height:28px;" data-options="required:true"  validType="reUserCodeValidator['#reUsercodeValidatorTip']"><!-- <span id="reUsercodeValidatorTip">&nbsp; 员工编号为5位以上字符</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">用户名：</label> <input name="userName" id="usernameUpdate" class="easyui-textbox" style="height:28px;" data-options="required:true"   validType="reUserNameValidator['#usernameUpdateValidatorTip']"><!-- <span id="usernameUpdateValidatorTip"> &nbsp; 用户名范围在2~20位字符</span> -->
			</div>
			
			<div class="fitem">
				<label class="lab-tb-BJ">真实姓名：</label> <input name="realName" id="realnameUpdate" class="easyui-textbox" style="height:28px;" data-options="required:true" validType="realNameValidator['#realnameUpdateValidatorTip']"><!-- <span id="realnameUpdateValidatorTip">&nbsp; 填写个人真实姓名</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">密码：</label> <input name="passwordUpdate" type="password"  id="passwordUpdate"  class="easyui-textbox" style="height:28px;"   validType="passwordValidator['#passwordUpdateValidatorTip']"><!-- <span id="passwordUpdateValidatorTip">&nbsp; 密码至少6个字符,最多18个字符</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">确认密码：</label> <input name="repasswordUpdate"  type="password" id="repasswordUpdate" class="easyui-textbox" style="height:28px;"  validType="repasswordValidator['#passwordUpdate','#repasswordUpdateValidatorTip']"><!-- <span id="repasswordUpdateValidatorTip">&nbsp; 重复个人密码</span> -->
			</div>
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ">公司：</label> <input class="easyui-combobox" style="height:28px;" id="companycode-update" required="required" validtype="selectValueRequired['#departidUpdateValidatorTip']"  type="text"
					name="companyCode" data-options="valueField:'id',textField:'text'"   editable="false"
                  ><!-- <span id="departidUpdateValidatorTip">&nbsp; 请选择公司</span> -->
			</div>
			<!--  add dropdownlist end -->
			<!-- add dropdownlist start -->
			<div class="fitem">
				<label class="lab-tb-BJ">组织机构：</label> <input class="easyui-combobox" style="height:28px;" id="orgid-update"  required="required" validtype="selectValueRequired['#orgidUpdateValidatorTip']"  type="text"
					name="orgId" data-options="valueField:'id',textField:'text'"  editable="false"><!-- <span id="orgidUpdateValidatorTip">&nbsp; 请选择组织机构</span> -->
			</div>
			<!--  add dropdownlist end -->
			<div class="fitem">
				<label class="lab-tb-BJ">手机号码：</label> <input name="mobilePhone"  id="mobilephoneUpdate" class="easyui-textbox" style="height:28px;"  required="required" validtype="mobile['#mobilephoneUpdateValidatorTip']" ><!-- <span id="mobilephoneUpdateValidatorTip">&nbsp; 手机号码位11位数字</span> -->
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">办公室电话：</label> <input name="officePhone" id="officephoneUpdate" 
					class="easyui-textbox"  style="height:28px;"    > 
			</div>
			<div class="fitem">
				<label class="lab-tb-BJ">常用email：</label> <input name="email"  id="emailUpdate"   class="easyui-validatebox" style="height:28px;" data-options="validType:'email'" invalidMessage="邮箱格式不正确"><span id="emailUpdateValidatorTip" >&nbsp; 邮箱格式：用户名@主机域名，如abc@123.com</span>
			</div>
			<div  class="fitem">
			<label class="lab-tb-BJ">是否激活：</label> 
			<select id="isEnable" class="easyui-combobox" style="height:28px; width: 100px;" name="isEnable" data-options="required:true" style="width:100px;"  editable="false">
		   						<option value="1">是</option>
								<option value="0">否</option>								    
			</select><span></span>
			</div>
			
		</form>
	</div>
	
	<!--  用户更新  end-->
	<!--   角色分配  开始 -->
	<div id="dlg-role" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons-roles">
		<div class="ftitle">角色信息</div>
		<form id="fm-role" method="post" novalidate>
			<div class="fitem">
				<label class="lab-tb" style="width:80px;">用户名称：</label> <input id="username-role" name="userName"
					class="easyui-textbox" style="height:28px;">
			</div>
			<div id="dg-role-container">
			<table id="dg-role"></table>
			</div>
		</form>
	</div>
	<!--   角色分配  结束 -->
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveUser()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>
	
	<!-- 更新用户 -->
	<div id="dlg-buttons-userUpdate">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="updateUser()" style="width: 90px; border-radius:4px;">保存</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-update').dialog('close')" style="width: 90px; border-radius:4px;">取消</a>
	</div>

	<!-- 角色按钮组  -->
	<div id="dlg-buttons-roles">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="saveRole()" style="width: 90px; border-radius:4px;">保存权限</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg-role').dialog('close')"
			style="width: 90px; border-radius:4px;">取消</a>
	</div>

	<script type="text/javascript" src="${ctx }/resources/js/page/user/userlist.js"></script>

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
	width: 120px;
}

.fitem input {
	width: 160px;
}
</style>
</body>
</html>
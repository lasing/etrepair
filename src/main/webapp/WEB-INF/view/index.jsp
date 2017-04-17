<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<%@ include file="common/meta.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <title>天安第三方合作管理平台</title>
<link rel="stylesheet" type="text/css" href="resources/css/index.css">
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src='resources/js/page/index.js'> </script>
<script type="text/javascript" src="${ctx }/resources/js/jeasyui/jquery.form.js"></script>
</head>

<body class="easyui-layout" style="overflow-y: hidden" fit="true" scroll="no">
	
	<div data-options="region:'north'" class="header">
		<div style="float:right; font-size: 13px;color: white; padding-right:20px;">
		 <div style="float:left; margin-top:18px; "><i class="fa fa-user"></i>&nbsp;${userName}</div>
		 <div style="float:left; margin-top:18px; margin-left:20px;"><a href="javascript:void(0);"  style="color:white"><i class="fa fa-credit-card"></i>&nbsp;职务</a></div>
		 <div style="float:left; margin-top:18px; margin-left:20px;"><a href="javascript:void(0);" id="editpass" style="color:white" onclick="changePassword('${userCode}','${userName}')"><i class="fa fa-cog"></i>&nbsp;修改密码</a>  </div>
		 <div style="float:left; margin-top:8px; margin-left:20px; cursor: pointer;"><a href="javascript:void(0);" class="" id="loginOut"  onclick="logout()"><img alt="" src="././resources/images/guanbi.png" ></a></div><!-- <i class="fa fa-power-off"></i>  class="Close"-->
		 <div class="clear"></div>
		</div>
		<img alt="" src="././resources/images/logo.png" class="xw_index_logo">
		<a href="javascript:void(0)" class="xw_index_left_a">天安第三方合作管理平台</a>
		
	</div>
	<!-- <div data-options="region:'north'" style="height:50px"></div> -->
	<div region="south" style="height: 4%; background: #D2E0F2;">
		<div class="footer">© 版权所有 朗泰恒盛 版本号：2.0.0</div>
	</div>

	<div  id="west" region="west" title="导航菜单" style="width: 14%;">
		<div id="nav"> <!--  导航内容 --> </div>
	</div>
	<div id="opt_info" region="center" border="false" style="background: #ffffff; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden; color: black;text-align:center;">
				 <div>${hehe}</div> 
				<div style="width:100%;height:300px;line-height:300px;">
					<h1>欢迎使用天安第三方合作管理平台</h1> 
				</div>
			</div>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" style="width:400px;height:270px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<div class="fitem" style="display: none;">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;编码:</label>
                <input id="div_userCode" name="userCode" class="easyui-textbox">
            </div>
        	<div class="fitem">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;用户名:</label>
                <input id="div_userName" name="userName" style="padding-left:0px;padding-right:0px;" class="easyui-textbox" disabled="disabled">
            </div>
            <div class="fitem">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;原密码:</label>
                <input id="div_orgPassword" name="orgPassword" type="password" class="easyui-textbox" required="true" >
            </div>
            <div class="fitem">
                <label>&nbsp;&nbsp;&nbsp;&nbsp;新密码:</label>
                <input id="div_newPassword" name ="newPassword" type="password" class="easyui-textbox" required="true" >
            </div>
            <div class="fitem">
                <label>&nbsp;确认密码:</label>
                <input id="div_confirmPassword" name="confirmPassword" type="password" class="easyui-textbox" required="true" >
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
		<a href="javascript:void(0)" class="xw_ensure_btn"
			onclick="savePassword()" style="width: 90px; border-radius:4px;">确定</a> <a
			href="javascript:void(0)" class="xw_cancel_btn"
			onclick="javascript:$('#dlg').dialog('close')" style="width: 90px; border-radius:4px;">关闭</a>
	</div>
</body>
</html>

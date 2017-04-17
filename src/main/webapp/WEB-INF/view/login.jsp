<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>天安第三方合作管理平台</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/css/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="resources/js/jeasyui/jquery.min.js"></script>
    <script type="text/javascript" src='resources/js/page/login.js'> </script>
    <script type="text/javascript" src='resources/js/common.js'> </script>
</head>
<style>
.form-control-input{
  height: 34px;
  font-size: 14px;
  line-height: 34px;
  font-weight: normal;
  padding:0 10px;
  color: #8E8B8B;
  background-color: white;
  border: 1px solid #e5e5e5;
  -webkit-box-shadow: none;
  box-shadow: none;
  -webkit-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
  transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
  -webkit-border-radius: 4px;
  -moz-border-radius: 47px;
  -ms-border-radius: 4px;
  -o-border-radius: 4px;
  border-radius: 4px;
}
</style>
<body >
<div class="xw_container">
	<!-- 根据type类型决定是否刷新整个页面 -->
	<input id="type" type="hidden" value="${sessionScope.type}" >
	<!-- 判断用户登录是否通过 -->
	<input id="error" type="hidden" value="<%=request.getParameter("error") %>" >
    <div class="xw_login_head">
       <!--  <div class="xw_lefticon"></div>
        <div class="xw_righticon"></div> -->
       <div class="xw_login_title" style="font-size:22px;">天安第三方合作管理平台</div>
       
    </div>
    <div class="bg-login" style= "padding-bottom:34px">
	 	<!-- <div class="xw_login_line" >
	        <span class="xw_login_welcome" style="text-align: left; margin: 0px;">欢迎登录天安第三方管理平台</span>
	    </div>  -->
		<form id="fm" action="${ctx }/j_spring_security_check" method="POST">
		    <div class="">
		        <div class="">
		        	<div class="form-group">
						<div class="input-icon">
							<i class="fa fa-user"></i>
							<input class="form-control" name="j_username" id ="j_username" value="${username }"  type="text" placeholder="账号" />
						</div>
					</div>
					<div class="form-group" style="margin-top:20px">
						<div class="input-icon">
							<i class="fa fa-lock"></i>
							<input class="form-control "  name="j_password" id="j_password" type="password"  value="${password }"  placeholder="密码"/>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px">
						<div class="input-icon">
							<div style="float:left;">
								<input class="form-control-input" name="vCode" id="vCode" type="text"  style="width:150px;"
							  placeholder="验证码" />
							</div>
							<div style="float:right;">
								<img style="white-space: nowrap;" title="点击" id="refush" onclick="initCode()"/>
							</div>
							<div class="clear"></div>
							<!-- <i class="fa"></i>
							<input class="form-control-input" name="vCode" id="vCode" type="text"  style="width:150px;"
							  placeholder="验证码" />
							<img style="white-space: nowrap;" title="点击" id="refush" onclick="initCode()"/> -->
						</div>
					</div>
					
		         <%--    <div class="xw_login_user">
		                <span class="xw_span">账号:</span><input name="j_username" id ="j_username" value="${username }"  type="text" class="xw_input" >
		            </div>
		            <div class="xw_login_user">
		                <span class="xw_span">密码:</span><input name="j_password" id="j_password" type="password"  value="${password }" class="xw_input"  >
		            </div> --%>
		        </div>
		        <div id="errorMessage" style="width: 268px;margin:auto;color:red;font-size:14px;"></div>
		        <div class="xw_login_savestate">
		        	<div style="width:268px;margin-top:15px;">
		        	<label for="rememberPwd" >
			                <input id="rememberPwd"  name="rememberPwd" type="checkbox" checked="true"  style="">
			                <span style="width:100px;">记住密码</span></label>
			            <div><!-- <a href="#" style="position: absolute;right:0;top:0;">忘记密码?</a> --></div>
		        	</div>
		        </div>
		        <div class="xw_login_btn">
		            <!-- <input type="submit" value="登&nbsp;录" onClick = "submitForm()"> -->
		            <input id="Btn_login" type="button" value="登&nbsp;录" onClick = "submitForm()" style="cursor: pointer;">
		            <!-- <input type="submit" value="登&nbsp;录"> -->
		        </div>
	   		</div>
	    </form>
    </div>
    <div class="xw_login_footer">
            © 版权所有 北京朗泰恒盛信息技术有限公司
    </div>
</div>
<script type="text/javascript">


 document.onkeydown = function(e) {
    e = e ? e : window.event;
    var keyCode = e.which ? e.which : e.keyCode;
    
    if(keyCode == 13)
    	$("#Btn_login").trigger("click");
    {
	if(e.which) {
       		e.which=0;
    	} else {
		e.keyCode=0;
    	}
    }	    
}
 
 

</script>
</body>
</html>
function submitForm() {
	if ($("#j_username").val() == "") {
		alert("用户名不能为空");
		return null;
	}
	if ($("#j_password").val() == "") {
		alert("用户密码不能为空");
		return null;
	}
	$('#fm').submit();
}

function submitForm() {
	if ($("#j_username").val() == "") {
		alert("用户名不能为空");
		return null;
	}
	if ($("#j_password").val() == "") {
		alert("用户密码不能为空");
		return null;
	}
	var pass = true;
	if ($("#vCode").val() == "") {
		alert("验证码不能为空");
		return null;
	} else {
		// 验证码验证
		// ajax
		$.ajax({
			url : getBasePath() + "/validateCode",
			data : {
				vCode : $("#vCode").val()
			},
			async : false,
			success : function(result) {
				var result = $.parseJSON(result);
 				if (result.status == 'ERROR') {
					alert("您输入的验证码错误，请重新输入");
					initCode();
					pass = false;
				}
			}
		});
	}
	if (pass) {
		$('#fm').submit();
	} else {
		return;
	}

}

$(function() {
	initCode();
	// 根据失败原因展现信息
	if ($("#error").val() == "1") {
		$("#errorMessage").html("用户名或密码不正确");
	} else if ($("#error").val() == "2") {
		$("#errorMessage").html("用户角色未分配，请联系管理员");
	} else {
		$("#errorMessage").html("");
	}
	// 超市刷新页面
	if ($("#type").val() == 1) {
		window.parent.location.reload();
	}
});
function initCode() {
	var date = new Date().getTime();
//	var systemctx=$("#systemctx").val();
	// $("#refush").attr("src",'http://localhost:8080/etrepair/validateCodeServlet.images?time='+date);
	$("#refush").attr("src",getBasePath()+ '/validateCodeServlet.images?time=' + date);
}
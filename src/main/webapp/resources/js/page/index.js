var _menus = {};
var url="";
$(function() {
	$.ajax({
		url : getBasePath() + "/function/init?t=" + new Date().getTime(),
		data : {},
		async : false,
		success : function(data) {
 			_menus = data;
 	

		}
	});
	InitLeftMenu();
	/*var registNo = document.getElementById("caseNo").value;
	if(registNo!=null&&registNo!=""){
		addTab("案件"+registNo, "/dispatch/dispatch/toDispatch?registNo="+registNo, "");
	}*/
});

// 初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({
		animate : false,
		fit : true,
		border : false
	});
	var selectedPanelname = '';
	$.each(_menus.menus, function(i, n) {
		var menulist = '';
		menulist += '<ul class="navlist">';
		$.each(n.menus, function(j, o) {
			// menulist += '<li><div ><a ref="'+o.menuid+'" href="#" rel="' +
			// o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span
			// class="nav">' + o.menuname + '</span></a></div> ';
			menulist += '<li><div ><a ref="' + o.menuid + '" href="javascript:void(0)" rel="'
					+ o.url + '" ><span></span><span class="nav">' + o.menuname
					+ '</span></a></div> ';
//			if (o.child && o.child.length > 0) {
//				menulist += '<ul class="third_ul">';
//				$.each(o.child, function(k, p) {
//					// menulist += '<li><div><a ref="'+p.menuid+'" href="#"
//					// rel="' + p.url + '" ><span class="icon '+p.icon+'"
//					// >&nbsp;</span><span class="nav">' + p.menuname +
//					// '</span></a></div> </li>';
//					menulist += '<li><div><a ref="' + p.menuid
//							+ '" href="#" rel="' + p.url
//							+ '" ><span></span><span class="nav">' + p.menuname
//							+ '</span></a></div> </li>';
//				});
//				menulist += '</ul>';
//			}
			menulist += '</li>';
		});
		menulist += '</ul>';
		$('#nav').accordion('add', {
			title : n.menuname,
			content : menulist,
			border : false,
			iconCls : 'icon ' + n.icon
		});

		if (i == 0) {
			selectedPanelname = n.menuname;
		}

	});
	$('#nav').accordion('select', selectedPanelname);
	$('.navlist li a').click(function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = $(this).find('.icon').attr('class');
		var third = find(menuid);
		if (third && third.child && third.child.length > 0) {
			$('.third_ul').slideUp();
			var ul = $(this).parent().next();
			if (ul.is(":hidden")) {
				ul.slideDown();
			} else {
				ul.slideUp();
			}
		} else {
			addTab(tabTitle, url, icon);
			$('.navlist li div').removeClass("selected");
			$(this).parent().addClass("selected");
		}
	}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
}

function find(menuid) {
	var obj = null;
	$.each(_menus.menus, function(i, n) {
		$.each(n.menus, function(j, o) {
			if (o.menuid == menuid) {
				obj = o;
			}
		});
	});

	return obj;
}

function logout() {
	$.messager.confirm("操作提示", "您确定要退出吗？&nbsp;&nbsp;&nbsp;&nbsp;", function (data) {  
        if (data) {  
        	window.location.href=getBasePath()+"/j_spring_security_logout"; 
        }  
    });
	resizeDialog();
	/*var winWidth = document.body.clientWidth;
	var leftWidth = (winWidth - 200)/2;
	$(".messager-window").css("left",leftWidth+"px");
	$(".window-shadow").css("left",leftWidth+"px");*/
}

function changePassword(userCode,userName) {
	
	$('#dlg').dialog('open').dialog('center').dialog('setTitle','修改密码');
	$('#fm').form('clear');
	$("#div_userCode").textbox('setValue',userCode);
	$('#div_userName').textbox('setValue',userName);
    url=getBasePath() +'/user/updatePwd';
}
function savePassword() {
	if($("#fm").form('validate')){
		var orgPwd=$("#div_orgPassword").val();
    	var newPwd=$("#div_newPassword").val();
    	var confirmPwd=$("#div_confirmPassword").val();
    	if(newPwd!=orgPwd){
    		if(newPwd==confirmPwd){
    			if(newPwd.length>=6 && newPwd.length<=18){
    				//异步提交
        			$("#fm").ajaxSubmit({
        				url: url,
        				async: false,
        				success: function(result){
        		            if (result.status=='OK'){
        		            	$('#dlg').dialog('close');        // close the dialog
        		                $.messager.show({
        		                	title:'提示',
        		                	msg:'修改密码成功！',
        		                	timeout:3000,
        		                	showType:'slide' 
        		                });
        		            } else {
        		            	$.messager.alert('错误',result.message+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;','error');
        		            }
        				}
        			});
        		}else{
        			$.messager.alert('错误','密码必须是6-18位'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;','error');
        		}
    		}else{
    			$.messager.alert('错误','两次密码不一致'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;','error');
    		}
    	}
		else{
			$.messager.alert('错误','新密码与原密码不能相同'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;','error');
		}
	}else{
		$.messager.alert('提示','请输入正确的校验项！','info');
	}
}


function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
}

//关闭当前选项
function closeCurTab() {
	var tab = $('#tabs').tabs("getSelected");
	var tabIndex = $('#tabs').tabs("getTabIndex", tab);
	
	$('#tabs').tabs('close', tabIndex);
}

function showMessage(msg){
	$.messager.show({
		title: '提示',
		msg: msg,
		timeout: 5000,
		showType: 'slide'
	});
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:99.6%;"></iframe>';
	return s;
}

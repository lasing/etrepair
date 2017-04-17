var url;

function newFunction() {
	// 清空提示消息
	$("#menuValidatorTip").text("菜单名称范围4~15位字符,且不为空");

	$('#iconid').combobox('reload', getBasePath() + '/icon/list/json');
	$('#functionlevel').combobox('reload',
			getBasePath() + '/function/level/json');
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新增菜单');
	$("#iconid").combobox('setValue', '0');
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#fm').form('clear');
		$("#functionlevel").parent().show();
		url = getBasePath() + '/function/add?functionId=' + row.functionId;
	} else {
		$("#functionlevel").parent().hide();
		url = getBasePath() + '/function/add';
	}
}
var functionNameUpdate;
function editFunction() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#iconid').combobox('reload', getBasePath() + '/icon/list/json');
		$('#dlg').dialog('open').dialog('center').dialog('setTitle', '编辑菜单');
		$("#functionlevel").parent().hide();
		$('#fm').form('load', row);
		url = getBasePath() + '/function/update?functionId=' + row.functionId;
		functionNameUpdate =row.functionName;
	} else {
		$.messager.show({ // show error message
			title : '错误',
			msg : '请选择一个菜单'
		});
	}
}

function saveFunction() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = $.parseJSON(result);
			if (result && result.status == 'OK') {
				$.messager.show({
					title : '提示',
					msg : ' 菜单保存成功'
				});

				$('#dlg').dialog('close'); // close the dialog
				$('#dg').treegrid('load', {

				});
				location.reload();
			} else {
				$.messager.show({
					title : '提示',
					msg : ' 菜单保存失败'
				});
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data

			}
		}
	});
}

function removeFunctions() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '你确定要删除这个菜单吗?', function(r) {
			if (r) {
				$.post(getBasePath() + '/function/delete', {
					id : row.functionId
				}, function(result) {
					if (result && result.status == 'OK') {
						$('#dg').datagrid('reload'); // reload the user data
						location.reload();
					} else {
						$.messager.show({ // show error message
							title : '提示',
							msg : '删除失败'
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.show({ // show error message
			title : '提示',
			msg : '请选择要删除的项目'
		});
	}
}

$.extend($.fn.validatebox.defaults.rules, {
	menuNameValidator: {  
        validator: function (value, param) {  
    	var value=$.trim(value);
    	if (value.length > 15 || value.length < 4 && value != '') {
    	        return false;
    	  }else{
      		 var result=true;
      		var newfunctionName=$("#functionName").textbox('getValue');
 			$.ajax({
 				url: encodeURI(encodeURI(getBasePath()+'/function/name/exist?functionName='+value)),
 				async : false,
 				success : function(data) {
 					if(!data){
       					$(param[0]).text("");
 	            		 $(param[0]).css("color","green");
  	            		  result= true;
  	            		  return true;
   					 }else if(data && (newfunctionName!=functionNameUpdate)){
   						 $(param[0]).text("该菜单名称已存在!");
	            	     $(param[0]).css("color","red");
	            	     result= false;
	            	     return false;
   					 }else{
   						 $(param[0]).text("");
  						result= true;
  						return true;
  					 }
 				}
 			});
 			return  result;
	   }
      },  
        message: '菜单名称范围4~15位字符,且不为空'  
    },
	
	number : {
		validator : function(value, param) {
			return /^\d+$/.test(value);
		},
		message : '请输入数字'
	}

});
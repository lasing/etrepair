var url;
var addTypeUrl;
var typeOrTypeGroup;
function newTypeGroup() {

	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '字典项录入');
	$('#fm').form('clear');
	url = getBasePath() + '/type/typegroup/add';
}
function edit() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		// 判断是字典 还是字典组 start
		$.ajax({
			url : getBasePath() + "/type/typeOrTypeGroup?t="
					+ new Date().getTime(),
			method : "GET",
			data : {
				id : row.id
			},
			async : false,
			success : function(data) {
				if (data && data == 'type') {
					typeOrTypeGroup = 'type';
					$('#dlg-type-update').dialog('open').dialog('center')
							.dialog('setTitle', '参数值修改');
					$('#fm-update').form('load', row);
				} else if (data && data == 'typeGroup') {
					typeOrTypeGroup = 'typeGroup';
					$('#dlg').dialog('open').dialog('center').dialog(
							'setTitle', '编辑字典');
					$('#fm').form('load', row);
				} else {
				}

			}
		});
		// 判断是字典 还是字典组 end
		url = getBasePath() + '/type/update?id=' + row.id;
	} else {
		$.messager.show({ // show error message
			title : '错误',
			msg : '请选择一个项目更新'
		});
	}
}

function addType() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg-type-add').dialog('open').dialog('center').dialog('setTitle',
				'参数值录入');
		addTypeUrl = getBasePath() + '/type/add?id=' + row.id;
	} else {
		$.messager.show({ // show error message
			title : '错误',
			msg : '请选择一个字典组'
		});
	}
}
function saveType() {

	$('#fm-add').form('submit', {
		url : addTypeUrl,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = $.parseJSON(result);
			if (result && result.status == 'OK') {
				$.messager.show({
					title : '提示',
					msg : '保存成功'
				});
				$('#dlg-type-add').dialog('close');
				location.reload();
			} else {
				$.messager.show({
					title : '提示',
					msg : '保存失败'
				});
				$('#dlg-type-add').dialog('close'); // close the dialog
			}
		}
	});
}
function saveTypeGroup() {
	if (typeOrTypeGroup == 'type') {
		$('#fm-update').form('submit', {
			url : url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				var result = $.parseJSON(result);
				if (result && result.status == 'OK') {
					$.messager.show({
						title : '提示',
						msg : '保存成功'
					});
					$('#dlg').dialog('close');
					location.reload();
				} else {
					$.messager.show({
						title : '提示',
						msg : '保存失败'
					});
					$('#dlg-type-update').dialog('close'); // close the dialog
				}
			}
		});
	} else {
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
						msg : '保存成功'
					});
					$('#dlg').dialog('close');
					location.reload();
				} else {
					$.messager.show({
						title : '提示',
						msg : '保存失败'
					});
					$('#dlg').dialog('close'); // close the dialog
				}
			}
		});
	}

}

function destroyType() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '你确定要删除这个字典吗?', function(r) {
			if (r) {
				$.post(getBasePath() + '/type/delete', {
					id : row.id
				}, function(result) {
					if (result.status == 'OK') {
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
			title : '错误',
			msg : '请选择要删除的项目'
		});
	}
}

// 验证用户添加部门
$.extend($.fn.validatebox.defaults.rules, {
	typeCodeValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 30 || value.length < 2) {
				$(param[0]).text("请输入2~30 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}
		},
		message : '编码范围在2~30位字符'
	},
	typeNameValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 30 || value.length < 2) {
				$(param[0]).text("请输入2~30 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}
		},
		message : '名称范围在2~30位字符'
	},
	paramNameValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 30 || value.length < 1) {
				/*
				 * $(param[0]).text("请输入1~10 位字符!");
				 * $(param[0]).css("color","red");
				 */
				return false;
			} else {
				/*
				 * $(param[0]).text("验证通过!"); $(param[0]).css("color","green");
				 */
				return true;
			}
		},
		message : '类型范围在1~30位字符 '
	},
	paramValueValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 30 || value.length < 1) {
				$(param[0]).text("请输入1~30 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}
		},
		message : '参数值在1~30位字符'
	}
});
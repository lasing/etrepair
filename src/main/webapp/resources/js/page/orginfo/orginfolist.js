var url;

$(function(){
	// 加载公司列表
	$('#companycode-search').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal=0');
});

function newOrginfo() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		// 加载公司列表
		$('#companycode').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal=""');

		// 加载组织机构列表
		$('#_parentId').combotree({
			url : getBasePath() + '/orginfo/list/jsonCodeIdTree'
		});
		$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新增组织机构');
		$('#fm').form('clear');
		url = getBasePath()+'/orginfo/add';
		$("#_parentId").combobox('setValue', row.id);

	} else {
		// 加载公司列表
		$('#companycode').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal=-1');

		// 加载组织机构列表
		$('#_parentId').combotree({
			url : getBasePath() + '/orginfo/list/jsonCodeIdTree'
		});
		$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新增组织机构');
		$('#fm').form('clear');
		url = getBasePath()+'/orginfo/add';
		
	}
}

var oldOrgCode;
function editOrgInfo() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#companycode_update').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal='+row.companycode);	
		$('#_parentId_update').combotree({
			url : getBasePath() + '/orginfo/list/jsonCodeIdTree'
		});
		
		$('#dlg-update').dialog('open').dialog('center').dialog('setTitle',
				'编辑组织机构');
		$('#fm-update').form('load', row);
		url = getBasePath()+'/orginfo/update?id=' + row.id;
		oldOrgCode = row.orgcode;
	} else {
		$.messager.show({ // show error message
			title : '错误',
			msg : '请选择要编辑的项目'
		});
	}
}

function saveOrgInfo() {
	var _parentId = $('#_parentId').combobox('getValue');
	var orgCode = $('#orgcode').textbox('getValue')
	// 验证中支机构
	// 根据parentId 获取组织机构 ，判断是何种类型，分公司组织编码为4位
	// 若为分公司 则添加的为 中支机构
	// ------------
	$.when($.ajax({
		url : getBasePath() + "/orginfo/code",
		data : {
			id : _parentId
		}
	}), $.ajax({
		url : getBasePath() + "/orginfo/code/exist",
		data : {
			orgCode : orgCode
		}
	})).done(function(a1, a2) {
		if (a2[0]) {
			$.messager.show({ // show error message
				title : '提示',
				msg : '该机构编码已存在'
			});
			return;
		} else {
			/*if (a1[0].length == 4 && orgCode.substr(0, 4) != a1[0]) {
				$.messager.show({ // show error message
					title : '提示',
					msg : '中支机构机构编码前四位需和分公司相同'
				});
				return;
			}*/

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
	});

}
function updateOrgInfo() {
	// /// start
	var _parentId = $('#_parentId_update').combobox('getValue');
	var orgCode = $('#orgcode-update').textbox('getValue')
	// 验证中支机构
	// 根据parentId 获取组织机构 ，判断是何种类型，分公司组织编码为4位
	// 若为分公司 则添加的为 中支机构
	// ------------
	$.when($.ajax({
		url : getBasePath() + "/orginfo/code",
		data : {
			id : _parentId
		}
	}), $.ajax({
		url : getBasePath() + "/orginfo/code/exist",
		data : {
			orgCode : orgCode
		}
	})).done(function(a1, a2) {
		if (a2[0] && oldOrgCode != orgCode) {
			$.messager.show({ // show error message
				title : '提示',
				msg : '该组织机构已存在'
			});
			return;
		} else {
			/*if (a1[0].length == 4 && orgCode.substr(0, 4) != a1[0]) {
				$.messager.show({ // show error message
					title : '提示',
					msg : '中支机构机构编码前四位需和分公司相同'
				});
				return;
			} */
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
							location.reload();
						} else {
							$.messager.show({
								title : '提示',
								msg : '保存失败'
							});
							$('#dlg-update').dialog('close'); // close the
																// dialog
						}
					}
				});
		}
	});
	// /// end
}

function destroyOrgInfo() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '你确定要删除这个组织机构吗?', function(r) {
			if (r) {
				$.post(getBasePath() + '/orginfo/delete', {
					id : row.id
				}, function(result) {
					if (result.status == 'OK') {
						location.reload();
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

//搜索公司下的组织机构
function searchOrgInfo(){
	var companycode=$("#companycode-search").combobox('getValue');
	$("#dg").treegrid("load",{companyCode:companycode});
}


// 验证组织机构
$.extend($.fn.validatebox.defaults.rules, {
	orgNameValidator : {
		validator : function(value, param) {
			if (!value || value == '') {
				$(param[0]).text("请输入30个以内字符!");
			}
			if (value.length > 30 || value.length == 0) {
				$(param[0]).text("请输入30个以内字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}
		},
		message : '名称长度不超过30个字符 '
	},
	orgCodeValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 20 || value.length < 1) {
				$(param[0]).text("请输入1~20位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				var result = true;
				$.ajax({
					url : getBasePath() + "/orginfo/code/exist?t="
							+ new Date().getTime(),
					data : {
						orgCode : value
					},
					async : true,
					success : function(data) {
						var result = $.parseJSON(data);
						if (result == true) {
							$(param[0]).text("该编号已存在!");
							$(param[0]).css("color", "red");
							result = false;
						} else {
							$(param[0]).text("");
							$(param[0]).css("color", "green");
							result = true;
						}
					}
				});
				return result;
			}
		},
		message : '组织编号为1~20位字符'
	},
	reorgCodeValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 20 || value.length < 1) {
				$(param[0]).text("请输入1~20 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}

		},
		message : '组织编号为1~20位字符 '
	},
	float : {
		validator : function(value, param) {
			var result = /^\d+(\.\d+)?$/.test(value);
			if (!result) {
				$(param[0]).text("只能输入整数或浮点数!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;
			}
		},
		message : '只能输入整数或浮点数'
	}
});
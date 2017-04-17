/**
 * 新增窗口
 */
var url;
function newCompany() {
	// 清空消息提示

	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新建公司');
	$('#fm').form('clear');
	url = getBasePath() + '/company/add';
}
/**
 * 保存新增
 */
function saveCompany() {
	var companyCode = $("#companyCode").textbox("getValue");
	var companyName = $("#companyName").textbox("getValue");
	$.ajax({
		url : getBasePath() + "/company/code/exist",
		data : {
			companyCode : companyCode
		},
		async : false,
		success : function(data) {
			if (data) {
				$.messager.show({
					title : '提示',
					msg : '公司编码已存在'
				});
				return;
			} else if (!data) {
				$.ajax({
					url : getBasePath() + "/company/name/exist",
					data : {
						companyName : companyName
					},
					async : false,
					success : function(data) {
						if (!data) {// 公司名称不存在

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
											msg : '公司保存成功'
										});
										$('#dlg').dialog('close');
										$('#dg').datagrid('reload');
									} else {
										$.messager.show({
											title : '提示',
											msg : '公司保存失败'
										});
									}
								}
							});
						} else if (data) {// 公司名称存在
							$.messager.show({
								title : '提示',
								msg : '公司名称已存在'
							});
							return;
						}
					}

				});
			} else {
				$.messager.show({
					title : '提示',
					msg : '请求超时，请稍后再试...'
				});

			}
		}
	});

}

/**
 * 修改窗口
 */
var companyCodeUpdate;
function editCompany() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg-update').dialog('open').dialog('center').dialog('setTitle',
				'修改公司');
		$('#fm-update').form('load', row);
		url = getBasePath() + '/company/update?companyCode=' + row.companyCode;
		companyCodeUpdate = row.companyCode;
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择公司'
		});
	}
}

/**
 * 保存修改
 */
function updateCompany() {
	var companyCode = $("#companyCodeUpdate").textbox('getValue');
	var companyName = $("#companyNameUpdate").textbox('getValue');
	$
			.ajax({
				url : encodeURI(encodeURI(getBasePath()
						+ '/company/code/exist?companyCode=' + companyCode)),
				async : false,
				success : function(data) {
					if (!data) {
						// 公司编码不存在，判断公司名称是否已经存在
						$
								.ajax({
									url : getBasePath() + "/company/name/exist",
									data : {
										companyName : companyName
									},
									async : false,
									success : function(data) {
										if (!data) {// 公司名称不存在
											$('#fm-update')
													.form(
															'submit',
															{
																url : url,
																onSubmit : function() {
																	return $(
																			this)
																			.form(
																					'validate');
																},
																success : function(
																		result) {
																	var result = $
																			.parseJSON(result);
																	if (result
																			&& result.status == 'OK') {
																		$.messager
																				.show({
																					title : '提示',
																					msg : '公司更新成功'
																				});
																		$(
																				'#dlg-update')
																				.dialog(
																						'close');
																		$('#dg')
																				.datagrid(
																						'reload');
																	} else {
																		$.messager
																				.show({
																					title : '提示',
																					msg : '公司更新失败'
																				});
																	}
																}
															});
										} else if (data) {// 公司名称存在
											var companyNameSelect = $('#dg')
													.datagrid('getSelected').companyName;
											if (companyName == companyNameSelect) {// 如果是选中的公司
												$('#fm-update')
														.form(
																'submit',
																{
																	url : url,
																	onSubmit : function() {
																		return $(
																				this)
																				.form(
																						'validate');
																	},
																	success : function(
																			result) {
																		var result = $
																				.parseJSON(result);
																		if (result
																				&& result.status == 'OK') {
																			$.messager
																					.show({
																						title : '提示',
																						msg : '公司更新成功'
																					});
																			$(
																					'#dlg-update')
																					.dialog(
																							'close');
																			$(
																					'#dg')
																					.datagrid(
																							'reload');
																		} else {
																			$.messager
																					.show({
																						title : '提示',
																						msg : '公司更新失败'
																					});
																		}
																	}
																});
											} else {
												$.messager.show({
													title : '提示',
													msg : '该公司名称已存在'
												});
											}
										}
									}
								})
					} else if (data) {// 公司编码存在
						var companyCodeSelect = $('#dg')
								.datagrid('getSelected').companyCode;
						if (companyCode == companyCodeSelect) {// 如果是选中的信息
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
											msg : '公司更新成功'
										});
										$('#dlg-update').dialog('close');
										$('#dg').datagrid('reload');
									} else {
										$.messager.show({
											title : '提示',
											msg : '公司更新失败'
										});
									}
								}
							});
						} else {
							$.messager.show({
								title : '提示',
								msg : '该公司编码已存在'
							});
						}
					} else {
						$.messager.show({
							title : '提示',
							msg : '请求超时，请稍后再试...'
						});
					}
				}
			});
}

/**
 * 删除
 */
function destroyCompany() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '你确定要删除该公司吗?', function(r) {
			if (r) {
				$.post(getBasePath() + '/company/delete', {
					id : row.companyCode
				}, function(result) {
					if (result.status == 'OK') {
						$.messager.show({
							title : '提示',
							msg : '删除成功'
						});
						$('#dg').datagrid('reload');
						// user data
					} else {
						$.messager.show({
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
			msg : '请选择删除行'
		});

	}
	resizeDialog();
}

/**
 * 查询加载数据，附带了请求参数
 */
function searchCompany() {
	var companycode = $("#companycode-search").val();
	var companyname = $("#companyname-search").val();
	$("#dg").datagrid("load", {
		companyCode : companycode,
		companyName : companyname
	});

}

function reset() {
	$("#companycode-search").val("");
	$("#companyname-search").val("");
	$("#dg").datagrid("load", {});
}

/**
 * 校验公司信息
 */
$.extend($.fn.validatebox.defaults.rules, {
	companyNameValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 50 || value.length < 2) {
				$(param[0]).text("请输入2~50 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				var result = true;
				$.ajax({
					url : encodeURI(encodeURI(getBasePath()
							+ '/company/name/exist?companyName=' + value)),
					async : true,
					success : function(data) {
						if (!data) {
							$(param[0]).text("");
							$(param[0]).css("color", "green");
							result = true;
						} else if (data) {
							$(param[0]).text("该公司名称已存在!");
							$(param[0]).css("color", "red");
							result = false;
							return false;
						} else {
							$.messager.show({
								title : '提示',
								msg : '请求超时，请稍后再试...'
							});
							result = false;
							return false;
						}
					}
				});
				return result;
			}
		},
		message : '公司名称2~50位字符之间'
	},
	companyCodeValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 10 || value.length < 2) {
				$(param[0]).text("请输入2~10 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				var result = true;
				$.ajax({
					url : encodeURI(encodeURI(getBasePath()
							+ '/company/code/exist?companyCode=' + value)),
					async : true,
					success : function(data) {
						if (!data) {
							$(param[0]).text("");
							$(param[0]).css("color", "green");
							result = true;
						} else if (data) {
							$(param[0]).text("该公司编码已存在!");
							$(param[0]).css("color", "red");
							result = false;
							return false;
						} else {
							$.messager.show({
								title : '提示',
								msg : '请求超时，请稍后再试...'
							});
							result = false;
							return false;
						}
					}
				});
				return result;
			}
		},
		message : '公司编码2~10位字符之间'
	},
	reCompanyCodeValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 10 || value.length < 2) {
				$(param[0]).text("请输入2~10 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;

			}
		},
		message : '公司编码2~10位字符 '
	},
	
	companyDescValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 50 || value.length < 2) {
				$(param[0]).text("请输入2~50 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;

			}
		},
		message : '公司简介2~50位字符 '
	},
	companyAddrValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 50 || value.length < 2) {
				$(param[0]).text("请输入2~50 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;

			}
		},
		message : '公司地址2~50位字符 '
	},
	
	
	contactValidator : {
		validator : function(value, param) {
			var value = $.trim(value);
			if (value.length > 30 || value.length < 2) {
				$(param[0]).text("联系人2~30 位字符!");
				$(param[0]).css("color", "red");
				return false;
			} else {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
				return true;

			}
		},
		message : '联系人2~30位字符 '
	},
	
	mobile : {
		validator : function(value, param) {
			var value = $.trim(value);
			var result = /^(13|15|16|17|18)\d{9}$/i.test(value);
			if (result) {
				$(param[0]).text("");
				$(param[0]).css("color", "green");
			} else {
				$(param[0]).text("手机号码不正确!");
				$(param[0]).css("color", "red");
			}
			return result;
		},
		message : '手机号码不正确'
	}

});

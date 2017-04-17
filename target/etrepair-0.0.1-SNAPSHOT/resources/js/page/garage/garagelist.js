var url;
var orgData;
$(function() {
	// 加载组织机构列表
	$('#search_orgId').combotree({
		url : getBasePath() + '/orginfo/list/jsonCodeIdTreeByUserOrgId'
	});
	$('#dg').datagrid('doCellTip', {
		'max-width' : '100px'
	});
	$('#dg_core').datagrid('doCellTip', {
		'max-width' : '100px'
	});
});

function formatIsEnable(val, row, index) {
	var isEnable = row.isEnable;
	/** 是否可用，1：是 0：否 */
	if (isEnable == 0) {
		return '否';
	}
	if (isEnable == 1) {
		return '是';
	}
}

function formatIsExists(val, row, index) {
	var isExists = row.isExists;
	/** 是否存在，1：是 0：否 */
	if (isExists == 0) {
		return '否';
	}
	if (isExists == 1) {
		return '是';
	}
}


// 新增ET修理厂窗口
function newGarage() {
	doAddReset();// 重置新增查询
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新增ET修理厂');
	$(function() {
		// 加载组织机构列表
		$('#search_core_orgId').combotree({
			url : getBasePath() + '/orginfo/list/jsonCodeIdTreeByUserOrgId'
		});
	});
}

/**
 * 保存新增ET修理厂
 */
function saveGarage() {
	var row = $('#dg_core').datagrid('getSelected');
	if (row) {
		if (row.isExists == 1) {
			$.messager.alert('提示', '该修理厂已经存在!', 'info');
			return false;
		}
		$.ajax({
			url : getBasePath() + "/garage/add",
			data : {
				garageId : row.garageId
			},
			async : false,
			success : function(result) {
				var result = $.parseJSON(result);
				if (result && result.status == 'OK') {
					$.messager.show({
						title : '提示',
						msg : 'ET修理厂保存成功，请在编辑页面完善相关信息'
					});
					$('#dlg').dialog('close');// 是否关闭核心修理厂弹窗
					$('#dg').datagrid('reload');
				} else if (result && result.status == 'ERROR') {
					$.messager.show({
						title : '提示',
						msg : '该修理厂电话已经存在，不能新增'
					});
				} else {
					$.messager.show({
						title : '提示',
						msg : '修理厂保存失败'
					});
				}

			}
		});
		$('#dg_core').datagrid('reload');
	} else {
		$.messager.alert('提示', '请选择一个精友修理厂添加!', 'info');
		return false;
	}
}

function doAddSearch() {
	var coreGarageName = $("#search_core_garageName").val();
	var coreGarageCode = $("#search_core_garageCode").val();
	var coreRepairTel = $("#search_core_repairTel").val();
	var coreOrgId = $("#search_core_orgId").combobox('getValue');
	var param = {};
	param.push = function(o) {
		// 如果o是object
		if (typeof (o) == 'object')
			for ( var p in o)
				this[p] = o[p];
	};
	if (coreGarageName != '') {
		param.push({
			"garageName" : coreGarageName
		});
	}
	if (coreGarageCode != '') {
		param.push({
			"garageCode" : coreGarageCode
		});
	}
	if (coreRepairTel != '') {
		param.push({
			"repairTel" : coreRepairTel
		});
	}
	if (coreOrgId != '') {
		param.push({
			"orgId" : coreOrgId
		});
	}
	$("#dg_core").datagrid("load", param);
}

function doSearch() {
	var garageCode = $("#search_garageCode").val();
	var garageName = $("#search_garageName").val();
	var garageNameAbb = $("#search_garageNameAbb").val();
	var contactPhone = $("#search_contactPhone").val();
	var garageAddr = $("#search_garageAddr").val();
	var orgId = $("#search_orgId").combobox('getValue');
	var param = {};
	param.push = function(o) {
		// 如果o是object
		if (typeof (o) == 'object')
			for ( var p in o)
				this[p] = o[p];
	};
	if (garageCode != '') {
		param.push({
			"garageCode" : garageCode
		});
	}
	if (garageName != '') {
		param.push({
			"garageName" : garageName
		});
	}
	if (garageNameAbb != '') {
		param.push({
			"garageNameAbb" : garageNameAbb
		});
	}
	if (contactPhone != '') {
		param.push({
			"contactPhone" : contactPhone
		});
	}
	if (garageAddr != '') {
		param.push({
			"garageAddr" : garageAddr
		});
	}
	if (orgId != '') {
		param.push({
			"orgId" : orgId
		});
	}
	$("#dg").datagrid("load", param);
}

function doShowRecord() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		var garageId = row.garageId;
		var garageName = row.garageName;
		var title = garageName;
		var garagedetail = getBasePath() + '/garageInfo/garage?garageId='
				+ garageId;
		// $('#viewGarage').attr('href',getBasePath()
		// +'/garageInfo/garage?garageId='+garageId);
		top.parent.addTab(title, garagedetail, "");
	} else {
		$.messager.show({
			title : '提示',
			msg : '请选择一条记录'
		});
	}
}

function doReset() {
	$("#search_garageCode").val("");
	$("#search_garageName").val("");
	$("#search_garageNameAbb").val("");
	$("#search_contactPhone").val("");
	$("#search_garageAddr").val("");
	$("#search_orgId").combobox('setValue', '');
	$("#dg").datagrid("load", {});
}

function doAddReset() {
	$("#search_core_garageName").val("");
	$("#search_core_garageCode").val("");
	$("#search_core_repairTel").val("");
	$("#search_core_orgId").combobox('setValue', '');
	$("#dg_core").datagrid("load", {});
}

// 重新加载图片对象
function resetPicdig() {
	// 先置空
	$("#picShow").empty();
	var row = $('#dg').datagrid('getSelected');
	var garage_id = row.garageId;
	$.ajax({
		url : getBasePath() + '/garage/photolist?garageId=' + garage_id
				+ '&time=' + new Date().getTime(),
		async : false,
		success : function(data) {
			if (data) {
				for ( var i = 0; i < data.total; i++) {
					var garagePhotoId = data.rows[i].garagePhotoId;
					// 构造图片对象
					var img = document.createElement("img");
					binddelete(img, garagePhotoId);
					img.src = data.rows[i].photoUrl;
					img.id = garagePhotoId;
					img.height = 100;
					img.width = 200;
					// 图片追加到span中
					$('#picShow').append(img);
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

//编辑按钮
var garage_id;
function doUpdateRecord() {
	// var row = $('#dg').datagrid('getSelections');
	var row = $('#dg').datagrid('getSelected');
	
	if (row) {
		$('#dlg-update').dialog('open').dialog('center').dialog('setTitle',
				'编辑');
		$('#dlg-update_garageName').html(row.garageName);

		$('#dlg-update_pointNumber').textbox('setValue', row.pointNumber);

		$('#dlg-update_contact').textbox('setValue', row.contact);
		$('#dlg-update_contactPhone').textbox('setValue', row.contactPhone);
		$('#dlg-update_expDate').datebox('setValue',
				toLocalFullDate(row.expDate));
		$('#dlg-update_tasklimit').textbox('setValue', row.tasklimit);
		$('#dlg-update_serviceFeature').val(row.serviceFeature);
		$('#dlg-update_garageNameAbb').textbox('setValue', row.garageNameAbb);
		$('#dlg-update_garageAddrAbb').textbox('setValue', row.garageAddrAbb);
		$('#dlg-update_garageAddr').textbox('setValue', row.garageAddr);
		$('#dlg-update_longitude').textbox('setValue', row.longitude);
		$('#dlg-update_latitude').textbox('setValue', row.latitude);
		if(row.categoryCode==""||row.categoryCode==null){
			$("#categoryCode").val(000);
		}else{
			
			$("#categoryCode").val(row.categoryCode);
			
		}
		var categoryCode = $("#categoryCode").val();
		$('#dlg-update_categoryCode').textbox('setValue', categoryCode);
		
		$('#file').val('');// 清空文件上传内容
		var orgId = row.orgId;
		// console.log('------'+orgId);
		// 自动生成网点编号
		if (row.pointNumber == null || row.pointNumber == '') {
			$.ajax({
						url : getBasePath()
								+ '/garage/getMaxPointNumber?orgId=' + orgId,
						async : false,
						success : function(data) {
							if (data) {
								var pn = data.maxPointNumber;
								if (pn == '') {
									orgId = '07' + orgId.substring(2) + '0001';
								} else {
									var tid = ''
											+ (parseInt(pn.substring(2)) + 1);
									var tid_l = tid.length;
									for ( var i = 0; i < 6 - tid_l; i++) {
										tid = '0' + tid;
									}
									orgId = '07' + tid;
								}
								// console.log('------'+orgId);
								$('#dlg-update_pointNumber').textbox(
										'setValue', orgId);
							}
						}
					});
		}

		url = getBasePath() + '/garage/update?garageId=' + row.garageId;
		garage_id = row.garageId;

		$("#picShow").empty();
		// 获取修理厂图片地址
		$.ajax({
			url : getBasePath() + '/garage/photolist?garageId=' + row.garageId,
			async : false,
			success : function(data) {
				if (data) {
					for ( var i = 0; i < data.total; i++) {
						var garagePhotoId = data.rows[i].garagePhotoId;
						// 构造图片对象
						var img = document.createElement("img");
						binddelete(img, garagePhotoId, garage_id);
						img.src = data.rows[i].photoUrl;
						img.id = garagePhotoId;
						img.height = 100;
						img.width = 200;
						// 图片追加到span中
						$('#picShow').append(img);

						/*
						 * var button = document.createElement("button");
						 * button.width=20; button.height=10; $('#'+
						 * garagePhotoId).append(button);
						 */

					}
				} else {
					$.messager.show({
						title : '提示',
						msg : '请求超时，请稍后再试...'
					});

				}
			}
		});
		$('#dlg-buttons-update').show();
	} else {
		{
			$.messager.show({
				title : '操作提示',
				msg : '请选择一条要编辑的数据！'
			});
			return;
		}
	}
}

/**
 * 图片绑定删除事件
 * 
 * @param element
 * @param garagePhotoId
 */
function binddelete(element, garagePhotoId, garage_id) {
	element.onclick = function() {
		$.messager.confirm('提示', '确定要删除该图片？', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					async : true,
					url : getBasePath()
							+ '/garage/photolist/delete?garagePhotoId='
							+ garagePhotoId,
					success : function(data) {
						if (data.status == 'OK') {
							$.messager.alert('提示', "删除修理厂图片成功", 'info');
							resetPicdig();
						} else {
							$.messager.show({
								title : '提示',
								msg : '删除失败'
							});
						}
					}
				});
			}
		});

	}
}

//保存按钮
function updateRecord() {
	
	var categoryCode = $("#categoryCode").val();
//	alert("categoryCode"+categoryCode);
	$('#dlg-update_categoryCode').textbox('setValue', categoryCode);
	if ($("#fm_update").form('validate')) {
		$('#fm_update').form(
				'submit',
				{
					url : url,
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(result) {
						result = eval('(' + result + ')');
						if (result.status == 'OK') {
							$.messager.show({
								title : '提示',
								msg : '修改修理厂成功！'
							});
							$('#dlg-update').dialog('close'); // close the
							// dialog
							$('#dg').datagrid('reload');
						} else if (result && result.status == 'ERROR'
								&& result.message == 'exist') {
							$.messager.show({
								title : '提示',
								msg : '该修理厂电话已经存在'
							});
						} else {
							$.messager.alert('错误', '更新修理厂失败', 'error');
						}
					}
				});
	} else {
		$.messager.show({
			title : '提示',
			msg : '请完善页面信息内容再提交'
		});
	}
}

// 每条记录后面追加删除操作
function delChangeReason(id) {
	$.messager.confirm('提示', '确定要删除该条记录？', function(r) {
		if (r) {
			$.ajax({
				type : "POST",
				async : true,
				url : getBasePath() + '/garage/delete?id=' + id,
				success : function(data) {
					if (data.status == 'OK') {
						$.messager.alert('提示', "删除成功", 'info', doReset);
					} else {
						$.messager.show({
							title : '提示',
							msg : '删除失败'
						});
					}
				}
			});
		}
	});
}

// 单选删除操作
function deleteByid() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '你确定要删除该修理厂吗?', function(r) {
			if (r) {
				$.post(getBasePath() + '/garage/delete', {
					id : row.garageId
				}, function(result) {
					if (result && result.status == 'OK') {
						$.messager.show({
							title : '提示',
							msg : '删除成功'
						});
						$('#dlg').dialog('close');
						$('#dg').datagrid('reload');
					} else {
						$.messager.show({
							title : '提示',
							msg : '删除失败'
						});
						$('#dlg').dialog('close');
					}
				}, 'json');
			}
		});
	} else {
		{
			$.messager.show({
				title : '操作提示',
				msg : '请选择要删除的行！'
			});
			return;
		}
	}
}

// 批量删除
function delBatch() {

	var rows = $('#dg').datagrid('getSelections');
	if (rows && rows.length > 0) {
		var array = new Array();
		for ( var i = 0; i < rows.length; i++) {
			var id = rows[i].garageId;
			array.push(id);
		}
		$.messager.confirm('提示', '确定要删除所选记录？', function(r) {
			if (r) {
				$
						.ajax({
							type : "POST",
							async : true,
							url : getBasePath() + '/garage/deleteBatch?idList='
									+ array,
							success : function(data) {
								if (data.status == 'OK') {
									$.messager.show({
										title : '提示',
										msg : '删除成功'
									});
									$('#dg').datagrid('reload');
								} else {
									$.messager.show({
										title : '提示',
										msg : '删除失败'
									});
								}
							}
						});
			}
		});
	} else {
		$.messager.show({
			title : '操作提示',
			msg : '请选择要删除的行！'
		});
		return;
	}
}

/**
 * 操作单元格的格式化
 * 
 * @param value
 *            字段的值
 * @param row
 *            行的记录数据。
 * @param index
 *            行的索引。
 * @returns {String}
 */
function fmtterOperate(value, row, index) {
	return "<input type='button' value='[删除]' onclick='delChangeReason(\""
			+ row.id + "\");' class='xw_remove_btn'>";
}

/**
 * 上传文件
 */
function uploadFile() {
	var file = $("#file").val();
	if (file) {
		$.messager.confirm('提示', "确定上传？", function(r) {
			if (r) {
				$('#filefm').form(
						'submit',
						{
							url : getBasePath()
									+ "/garage/uploadFile?garageId="
									+ garage_id,
							success : function(result) {
								if (result) {
									var data = JSON.parse(result);
									if (data.result == 1) {
										$("#file").val('');
										$.messager.show({
											title : '提示',
											msg : "上传成功"
										});
										resetPicdig();
									} else {
										$.messager.show({
											title : '提示',
											msg : "上传失败"
										});
									}
								}

							}
						});
			}
		});

	} else {
		$.messager.show({
			title : '提示',
			msg : "请选择图片"
		});
	}
}

/**
 * 验证修理厂字段
 */
$
		.extend(
				$.fn.validatebox.defaults.rules,
				{
					// 网点编号
					pointNumberValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入ET网点编号! ';
								return false;
							}
							if (value.length > 10) {
								message: '网点编号不能超过10位! ';
								return false;
							} else {
								return true;
							}
						},
						message : '网点编号不能超过10位'
					},

					// 联系人
					contactValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入联系人! ';
								return false;
							}
							if (value.length > 30) {
								message: '联系人名字不超过30位! ';
								return false;
							} else {
								return true;
							}
						},
						message : '联系人名字不超过30位'
					},
					// 名字简称
					garageNameAbbValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入修理厂简称! ';
								return false;
							}
							if (value.length > 50) {
								message: '修理厂简称不超过50位! ';
								return false;
							} else {
								return true;
							}
						},
						message : '修理厂简称不超过50位'
					},
					// 地址简称
					garageAddrAbbValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入修理厂地址简称! ';
								return false;
							}
							if (value.length > 100) {
								message: '修理厂地址简称不超过100位! ';
								return false;
							} else {
								return true;
							}
						},
						message : '修理厂地址简称不超过100位'
					},
					// 地址
					garageAddrValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入修理厂地址简称! ';
								return false;
							}
							if (value.length > 100) {
								message: '修理厂地址不超过100位! ';
								return false;
							} else {
								return true;
							}
						},
						message : '修理厂地址不超过100位'
					},
					expDateValidator : {
						validator : function(value, param) {
							if (!value || value == '' || value.length == 0) {
								message: '请输入合作有效期! ';
								return false;
							}
						}
					},

					// 修理厂电话号码或手机号码
					contactPhoneValidator : {
						validator : function(value, param) {
							var value = $.trim(value);
							var result = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
									.test(value)
									|| /^(13|15|16|17|18|19)\d{9}$/i
											.test(value);
							// /^0\d{2,3}-?\d{7,8}$/
							if (result) {
								return true;
							} else {
								message: '输入正确的电话号或者手机号';
								return false;
							}
						},
						message : '输入正确的电话号或者手机号'
					},
					// 任务号，只能输入数字
					tasklimitValidator : {
						validator : function(value, param) {
							var result = /^\d+(\.\d+)?$/.test(value);
							if (!result) {
								message: '只能输入数字';
								return false;
							} else {
								return true;
							}
						},
						message : '只能输入数字'
					}
				});

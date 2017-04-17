var url;
//加载组织机构列表
$(function() {
	$('#orgId_search').combotree({
		url : getBasePath() + '/orginfo/list/jsonCodeIdTreeByUserOrgId'
	});
	$('#dg').datagrid('doCellTip',{'max-width':'100px'});
});
//加载任务状态列表
$(function() {
	$('#status_search').combotree({
		url : getBasePath() + '/repairtask/statusList/json'
	});
});


/**
 * 进入任务详情
 * @param val
 * @param row
 * @param index
 * @returns {String}
 */
function formatTaskId(val, row, index) {

	var str ="<a style='color:#CCAE33;'  onclick='toTaskdetail(\""+row.taskId+"\")'>"+row.taskId+"</a>";
 	return str;
	
	
//	var taskId = row.taskId;
//	return '<a href="'+ getBasePath() +'/repairtask/viewTaskDetail?taskId='+ taskId + ' "style="color:#CCAE33;">' + taskId + '</a>';
	
}

function toTaskdetail(taskId){
	var title = "任务"+taskId;
	var taskdetail =getBasePath() +'/repairtask/viewTaskDetail?taskId='+taskId;
	top.parent.addTab(title,taskdetail,"");
}


/**
 * 根据不同的状态展示不同的操作
 * @param val
 * @param row
 * @param index
 * @returns {String}
 */
function formatStatus(val, row, index) {
	
	
	var status = row.status;
	/** 状态 0：送修发起 1：维修中 2:车辆抵场放弃 3：车辆未抵厂放弃 4:用户取消放弃 5:车辆已修好 6:用户提车确认 7：用户评分完成*/
	if (status == 0) {
		return '送修发起';
	}
	if (status == 1) {
		return '维修中';
	}
	if (status == 2) {
		return '车辆抵场放弃';
	}
	if (status == 3) {
		return '车辆未抵厂放弃';
	}
	if (status == 4) {
		return '用户取消放弃';
	}
	if (status == 5) {
		return '车辆已修好';
	}
	if (status == 6) {
		return '用户提车确认';
	}
	if (status == 7) {
		return '用户评分完成';
	}
}

/**
 * 根据不同的状态展示不同的操作
 * @param val
 * @param row
 * @param index
 * @returns {String}
 */
function formatOper(val, row, index) {
	var status = row.status;
	var taskId = row.taskId;
	/** 状态 0：送修发起 1：维修中 2:车辆抵场放弃 3：车辆未抵厂放弃 4:用户取消放弃 5:车辆已修好 6:用户提车确认 7：用户评分完成*/
	// 送修发起
	if (status == 0) {
		return '<a href="javascript:void(0)" style="color:red;"  onclick="editstatus(' + index + ',' + '3' + ')">未抵厂弃修</a>'
				+ '&nbsp;&nbsp;<a href="javascript:void(0)" style="color:#BB7444;" onclick="editstatus(' + index + ',' + '2' + ')">抵厂弃修</a>'
				+ '&nbsp;&nbsp;<a href="javascript:void(0)" style="color:#33CC33;" onclick="editstatus(' + index + ',' + '1' + ')">确认维修</a>';
	}
	// 维修中
	if (status == 1) {
		return '<a href="javascript:void(0)" style="color:#1AE642;" onclick="editstatus(' + index + ',' + '5' + ')">维修完成</a>'
				+ '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" style="color:#3CA9C4;" onclick="">配件查询</a>';
	}
	// 维修完成
	if (status == 5) {
		return '<a href="javascript:void(0)" style="color:#7444BB;" onclick="editstatus(' + index + ',' + '99' + ')">再次提醒提车</a>';
	}
}


/**
 * 更新送修任务状态
 */
function editstatus(index,targetStatus) {
	$('#dg').datagrid('selectRow',index);// 设置选中当前行
	var rows = $('#dg').datagrid('getSelected');
	var taskId = rows.taskId;
	var registNo = rows.registNo
	$.messager.confirm('确认', '确定要更新该任务状态?', function(r) {
		if (r) {
			$.post(getBasePath() + '/repairtask/editstatus', {
				taskId : taskId,
				registNo : registNo,
				targetStatus : targetStatus
			}, function(result) {
				if (result.status == 'OK') {
					$.messager.show({
						title : '提示',
						msg : '操作成功'
					});
					$('#dg').datagrid('reload');
				} else {
					$.messager.show({
						title : '提示',
						msg : '操作失败'
					});
				}
			}, 'json');
		}
	});
//	resizeDialog();
}

/**
 * 查询加载数据，附带了请求参数
 */
function searchRepairTask() {
	var taskId = $("#taskId_search").val();
	var registNo = $("#registNo_search").val();
	var orgId = $("#orgId_search").combobox('getValue');
	var status = $("#status_search").combobox('getValue');
	var carOwner = $("#carOwner_search").val();
	var startTime = $("#startTime_search").datebox('getValue');
	var endTime = $("#endTime_search").datebox('getValue');
	var licenseNo = $("#licenseNo_search").val();
	var surveyName = $("#surveyName_search").val();
	
	if(startTime && endTime){
		var beginTimestamp = new Date(Date.parse(startTime.replace(/-/g, "/"))).getTime() /1000;
       	var endTimestamp = new Date(Date.parse(endTime.replace(/-/g, "/"))).getTime() /1000;
		var res = endTimestamp-beginTimestamp;
		if(res<0){
			$.messager.show({
				title : '提示',
				msg : "开始时间不能大于结束时间"
			});
			return;
		}
	}
	$("#dg").datagrid("load", {
		taskId : taskId,
		registNo : registNo,
		orgId : orgId,
		status : status,
		carOwner : carOwner,
		startTime : startTime,
		endTime : endTime,
		licenseNo : licenseNo,
		surveyName : surveyName
	});

}

function reset() {
	$("#taskId_search").val("");
	$("#registNo_search").val("");
	$("#orgId_search").combobox('setValue', '');
	$("#status_search").combobox('setValue', '');
	$("#carOwner_search").val("");
	$("#startTime_search").datebox('setValue', '');
	$("#endTime_search").datebox('setValue', '');
	$("#licenseNo_search").val("");
	$("#surveyName_search").val("");
	$("#dg").datagrid("load", {});
}


/**
 * 查询单个修理厂数据
 */
function searchRepairTaskSingle() {
	var taskId = $("#taskId_search").val();
	var registNo = $("#registNo_search").val();
	var status = $("#status_search").combobox('getValue');
	var carOwner = $("#carOwner_search").val();
	var startTime = $("#startTime_search").datebox('getValue');
	var endTime = $("#endTime_search").datebox('getValue');
	var licenseNo = $("#licenseNo_search").val();
	var surveyName = $("#surveyName_search").val();
	
	if(startTime && endTime){
		var beginTimestamp = new Date(Date.parse(startTime.replace(/-/g, "/"))).getTime() /1000;
       	var endTimestamp = new Date(Date.parse(endTime.replace(/-/g, "/"))).getTime() /1000;
		var res = endTimestamp-beginTimestamp;
		if(res<0){
			$.messager.show({
				title : '提示',
				msg : "开始时间不能大于结束时间"
			});
			return;
		}
	}
	$("#dg").datagrid("load", {
		taskId : taskId,
		registNo : registNo,
		status : status,
		carOwner : carOwner,
		startTime : startTime,
		endTime : endTime,
		licenseNo : licenseNo,
		surveyName : surveyName
	});

}

//重置单个修理厂查询
function resetSingle() {
	$("#taskId_search").val("");
	$("#registNo_search").val("");
	$("#status_search").combobox('setValue', '');
	$("#carOwner_search").val("");
	$("#startTime_search").datebox('setValue', '');
	$("#endTime_search").datebox('setValue', '');
	$("#licenseNo_search").val("");
	$("#surveyName_search").val("");
	$("#dg").datagrid("load", {});
}



//通过地址获取经纬度
function getRepairLonLat() {
	$('#dlg_longitude').val('');
	$('#dlg_latitude').val('');

	var address = $('#dlg_repairfacaddr').val();
	if (address != null && address != '') {
		$.ajax({
			method : "post",
			url : getBasePath() + "/survey/getLonLatByAddress",
			dataType : "json",
			async : false,
			data : {
				"address" : address
			},
			success : function(ret) {
				if (ret.status == 'success') {
					$('#dlg_longitude').val(ret.longitude);
					$('#dlg_latitude').val(ret.latitude);
				} else {
					$.messager.alert('提示', '您输入的地址找不到,请手动输入经纬度', 'info');
					$('#dlg_longitude').val('');
					$('#dlg_latitude').val('');
					$('#dlg_longitude').focus();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.messager.alert('错误', '获取经纬度失败:请求异常或者服务器异常，请稍后在尝试', 'error');
			}
		});
	}

	$('#dlg_longitude').validatebox('validate');
	$('#dlg_latitude').validatebox('validate');
}


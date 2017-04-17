
//加载组织机构列表
$(function() {
	$('#orgId_search').combotree({
		url : getBasePath() + '/orginfo/list/jsonCodeIdTreeByUserOrgId',
		
		
	});
	$('#dg').datagrid('doCellTip',{'max-width':'100px'});

	
});
//加载任务状态列表
$(function() {
	
	$('#status_search').combotree({
		url : getBasePath() + '/repairtaskreport/statusList/json'
	});
});

function formatCarType(val, row, index) {
	var carType = row.carType;
	// 1：标的车 2：三者车
	if (carType == 1) {
		return '标的车';
	}
	if (carType == 2) {
		return '三者车';
	}
}
function formatTaskType(val, row, index) {
	var taskType = row.taskType;
	//  1车主报案 2查勘员报案
	if (taskType == 1) {
		return 'C';
	}
	if (taskType == 2) {
		return 'B';
	}
}

/**
 * 查询加载数据，附带了请求参数
 */
function searchRepairTaskSingle() {
	
	var status = $("#status_search").combobox('getValue');
	var startTime = $("#startTime_search").datebox('getValue');
	var endTime = $("#endTime_search").datebox('getValue');
	var orgId = $("#orgId_search").combobox('getValue');
	if (startTime && endTime) {
		var beginTimestamp = new Date(Date.parse(startTime.replace(/-/g, "/")))
				.getTime() / 1000;
		var endTimestamp = new Date(Date.parse(endTime.replace(/-/g, "/")))
				.getTime() / 1000;
		var res = endTimestamp - beginTimestamp;
		if(res>7948800){
			$.messager.show({
				title : '提示',
				msg : "不能查询三个月以上的数据"
			});
			return;
		}else if(res<0){
			$.messager.show({
				title : '提示',
				msg : "开始时间不能大于结束时间"
			});
			return;
		}
	}
	
	$("#dg").datagrid({
		
		url:getBasePath() + "/repairtaskreport/list?status="+status+"&orgId="+orgId+"&startTime="+startTime+"&endTime="+endTime,

	});
	
//	$("#dg").datagrid("load", {
//		orgId : orgId,
//		status : status,
//		startTime : startTime,
//		endTime : endTime
//	});

	

}


//绑定导出按钮
function exportCSV() {
	var status = $("#status_search").combobox('getValue');
	var startTime = $("#startTime_search").datebox('getValue');
	var endTime = $("#endTime_search").datebox('getValue');
	var orgId = $("#orgId_search").combobox('getValue');

    var form = $("<form>");
    form.attr('style', 'display:none');
    form.attr('target', '');
    form.attr('method', 'post');
    form.attr('action', getBasePath() + '/repairtaskreport/export?status='+status+'&orgId='+orgId+'&startTime='+startTime+'&endTime='+endTime);
    var input1 = $('<input>');
    input1.attr('type', 'hidden');
    input1.attr('name', 'type');
    input1.attr('value', 'Export');
    $('body').append(form);
    form.append(input1);

    form.submit();
};

 
//重置单个修理厂查询
function resetSingle() {
	$("#status_search").combobox('setValue', '');
	$("#startTime_search").datebox('setValue', '');
	$("#orgId_search").combobox('setValue', '');
	$("#endTime_search").datebox('setValue', '');
	
}

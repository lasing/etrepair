
//$(window).resize(function(){
//    $('#tt').treegrid('resize', {
//        width: '100%'
//    })
//});

var url;
function newRole() {
	// 清空消息提示
	 $("#roleCodeValidatorTip").text("角色编码2~10位字符之间,且不为空 ");
	 $("#roleNameValidatorTip").text("角色范围2~8位字符之间,且不为空");
	
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新建角色');
	$('#fm').form('clear');
	url = getBasePath()+'/role/add';
}
var roleCodeUpdate;
var roleNameUpdate;
function editRole() {
 	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg-update').dialog('open').dialog('center').dialog('setTitle', '修改角色');
		$('#fm-update').form('load', row);
		url = getBasePath()+'/role/update?roleId=' + row.roleId;
		roleCodeUpdate =row.roleCode;
		roleNameUpdate =row.roleName;
	}else{
		$.messager.show({ // show error message
			title : '提示',
			msg : '请选择角色'
		});
	}
}
function saveRole() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
 			var result = $.parseJSON(result);
			if (result && result.status=='OK') {
				$.messager.show({
					title : '提示',
					msg : '角色保存成功'
				});
				$('#dlg').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			} else {
				$.messager.show({
					title : '提示',
					msg : '角色保存失败'
				});	
			}
		}
	});
}

function updateRole() {
	var roleCode = $("#roleCodeUpdate").textbox('getValue');
	var roleName = $("#roleNameUpdate").textbox('getValue');
	$.ajax({
			url: encodeURI(encodeURI(getBasePath()+'/role/code/exist?roleCode='+roleCode)),
			async : false,
			success : function(data) {
				 if(!data){//如果角色编码不存在
					//判断角色名称是否存在
					 $.ajax({
						 url: encodeURI(encodeURI(getBasePath()+'/role/name/exist?roleName='+roleName)),
							async : false,
							success : function(data) {
								if(!data){//角色名称不存在
									$('#fm-update').form('submit', {
										url : url,
										onSubmit : function() {
											return $(this).form('validate');
										},
										success : function(result) {
								 			var result = $.parseJSON(result);
											if (result && result.status=='OK') {
												$.messager.show({
													title : '提示',
													msg : '角色更新成功'
												});
												$('#dlg-update').dialog('close'); 
												$('#dg').datagrid('reload'); 
											} else {
												$.messager.show({
													title : '提示',
													msg : '角色更新失败1'
												});	
											}
										}
									});
								}
								else if(data){//角色名称存在
									var roleNameSelect = $('#dg').datagrid('getSelected').roleName;
									if(roleNameSelect==roleName){//如果是选中角色
										$('#fm-update').form('submit', {
											url : url,
											onSubmit : function() {
												return $(this).form('validate');
											},
											success : function(result) {
									 			var result = $.parseJSON(result);
												if (result && result.status=='OK') {
													$.messager.show({
														title : '提示',
														msg : '角色更新成功'
													});
													$('#dlg-update').dialog('close'); 
													$('#dg').datagrid('reload'); 
												} else {
													$.messager.show({
														title : '提示',
														msg : '角色更新失败2'
													});	
												}
											}
										});
									}else{
										$.messager.show({
											title : '提示',
											msg : '该角色名称已存在'
										});	
								 }
								}								
							}
					 });
				 }else if(data){//如果角色编码已存在
					    var roleNameU = $('#dg').datagrid('getSelected').roleName;//选中
					    var roleCodeU = $('#dg').datagrid('getSelected').roleCode;//选中
					 	if(roleCode==roleCodeU&&roleName==roleNameU){//如果角色编码和角色名称信息是选中信息
					 		 $.messager.show({
									title : '提示',
									msg : '更新成功！'
								});
					 		$('#dlg-update').dialog('close'); 
							$('#dg').datagrid('reload'); 
					     }else if(roleCode==roleCodeU&&roleName!=roleNameU){
					    		$('#fm-update').form('submit', {
									url : url,
									onSubmit : function() {
										return $(this).form('validate');
									},
									success : function(result) {
							 			var result = $.parseJSON(result);
										if (result && result.status=='OK') {
											$.messager.show({
												title : '提示',
												msg : '角色更新成功'
											});
											$('#dlg-update').dialog('close'); 
											$('#dg').datagrid('reload'); 
										} else {
											$.messager.show({
												title : '提示',
												msg : '角色更新失败3'
											});	
										}
									}
								});
					    }else{
					    	$.messager.show({
								title : '提示',
								msg : '该角色编码已存在'
							});	
					    }
				}else{
					 $.messager.show({
							title : '提示',
							msg : '请求超时，请稍后再试...'
					 });
					 
				 }
			}
		});
}

// 编辑角色菜单
function editRoleFunction() {
  	var row = $('#dg').datagrid('getSelected');
    
  	$("#tt").remove();
  	$("#dlg-roleFunction").html("<table id=\"tt\" style=\"height: 400px\"></table>");
	// add tree
	if (row) {
		$('#dlg-roleFunction').dialog('open').dialog('center').dialog('setTitle', '权限设置');
		$('#tt').treegrid({
		    url:getBasePath()+'/role/function/list?roleId='+row.roleId,
		    idField:'id',
		    treeField:'text',
		    singleSelect:true,
		    method:'POST',
		    checkbox:true,
		    selectOnCheck:false, 
		    cascadeCheck:true,
	 	    columns:[[
//	 	        {field: 'id', checkbox: true },
		        {title:'菜单名称',field:'text',width:430,align:'left',formatter: function (value, rec, rowIndex) {
	                if(rec.id=='0'){
	    	        	return "<input type=\"checkbox\"   onclick='selectAll()'   name=\"allFID\" value=\"" + rec.id + "\" >"+"全部菜单";                	
	                }else if(rec.checked && rec.leaf){
	                	return "<input type=\"checkbox\" checked=true   name=\"FID\" value=\"" + rec.id + "\" >"+rec.text;
	                }else if(rec.leaf){
	                	return "<input type=\"checkbox\"       name=\"FID\" value=\"" + rec.id + "\" >"+rec.text;
	                }else{
	                	return rec.text;
	                }
		        	
		        }}/*,
		        {field:'isreadableChk',title:'是否只读',width:160,align:'center',  formatter: function (value, rec, rowIndex) {
	                if(rec.id=='0'){
	    	        	return "<input type=\"checkbox\"   onclick='selectAllReadOnly()'  name=\"allPD\"   value=\"" + rec.id + "\" >"+"全部只读";                 	
	                }else if(rec.checked && rec.isreadonly==1 && rec.leaf){
	                	return "<input type=\"checkbox\" checked=true  onclick='isChecked(\""+rec.id+"\")' name=\"PD\" value=\"" + rec.id + "\" >";
	                }else if(rec.leaf){
	                	return "<input type=\"checkbox\"    onclick='isChecked(\""+rec.id+"\")'   name=\"PD\" value=\"" + rec.id + "\" >";
	                }else{
	                	return "";
	                }
		        }}*/
		    ]]
		});
		url = getBasePath()+'/role/function/add?id=' + row.roleId + '&funcs=';
 	}else{
		$.messager.show({ // show error message
			title : '提示',
			msg : '请选择角色'
		});
	}
}



 // 保存角色菜单
function saveRoleFunction() {
	var nodes =$('#tt').treegrid('getChecked');
	 // 是否可读对应菜单id
	var functionIds =[]; 
	$('input[name="FID"]:checked').each(function(){ 
		functionIds.push($(this).val()); 
	}); 
    // 是否可读对应菜单id
	var chk_value =[]; 
	$('input[name="PD"]:checked').each(function(){ 
	chk_value.push($(this).val()); 
	}); 
	 $.ajax({
	         url :url+functionIds+'&isReadableIds='+chk_value,
	         data:{},
	         cache : false, 
	         async : true,
	         type : "POST",
	         dataType : 'json',
	         success : function (result){
	        	 if(result && result.status=='OK'){
	            	   $.messager.show({
	   					title : '提示',
	   					msg : '保存成功'
	   				});
	            	 $('#dlg-roleFunction').dialog('close');  
	            	 $('#dg').datagrid('reload'); // reload the user data
	               }else{
	            	   $.messager.show({
		   					title : '提示',
		   					msg : '保存失败'
		   				});
	            	   $('#dlg-roleFunction').dialog('close');
	               }
	         }
	  });
	
 }
function isChecked(currentFunctionid){
 	if(!isFunctionChecked(currentFunctionid)){
//		   $.messager.show({
//					title : '提示',
//					msg : '只有被添加的菜单才能设置权限'
//		   });
	}
}

function destroyRole() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认',
				'你确定要删除该角色吗?', function(r) {
					if (r) {
						$.post(getBasePath()+'/role/delete', {
							id : row.roleId
						}, function(result) {
							if (result.status == 'OK') {
								$.messager.show({ // show error message
									title : '提示',
									msg : '删除成功'
								});
								$('#dg').datagrid('reload'); // reload the
								// user data
							} else {
								$.messager.show({ // show error message
									title : '提示',
									msg : '删除失败'
								});
							}
						}, 'json');
					}
				});
	}else{
		$.messager.show({ // show error message
			title : '提示',
			msg : '请选择删除行'
		});
		
	}
	resizeDialog();
}

// add tree
function getChecked() {
//	var nodes = $('#tt').treegrid('getCheckedNodes');
//	var nodes  =$('#tt').treegrid('getChecked');
	
	// 是否可读对应菜单id
	var functionIds =[]; 
	$('input[name="FID"]:checked').each(function(){ 
		functionIds.push($(this).val()); 
	}); 
	

	var s = '';
	for ( var i = 0; i < functionIds.length; i++) {
		if (s != '')
			s += ',';
		s += functionIds[i].id;
	}
   	 return s ;
}
function isFunctionChecked(currentFunctionid) {
//	var nodes = $('#tt').treegrid('getCheckedNodes');
//	var nodes  =$('#tt').treegrid('getChecked');
	
	// 是否可读对应菜单id
	var functionIds =[]; 
	$('input[name="FID"]:checked').each(function(){ 
		functionIds.push($(this).val()); 
	}); 
	for ( var i = 0; i < functionIds.length; i++) {
 		 if(functionIds[i].id==currentFunctionid){
 			 return true;
 		 }
	}
    return false;
}

function jqchk(){ //jquery获取复选框值 
	var chk_value =[]; 
	$('input[name="PD"]:checked').each(function(){ 
	chk_value.push($(this).val()); 
	}); 
	alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); 
} 


//验证用户添加部门
$.extend($.fn.validatebox.defaults.rules, {  
    roleNameValidator: {  
        validator: function (value, param) {  
        	var value=$.trim(value);
        	 if(value.length>10 || value.length<2){  
        	        return false;
        	  }else{
          		 var result=true;
     			$.ajax({
     				url: encodeURI(encodeURI(getBasePath()+'/role/name/exist?roleName='+value)),
     				async : false,
     				success : function(data) {
     					if(!data){
           					$(param[0]).text("");
     	            		 $(param[0]).css("color","green");
      	            		  result= true;
      	            		  return true;
       					 }else{
       						 $(param[0]).text("该角色名称已存在!");
    	            	     $(param[0]).css("color","red");
    	            	     result= false;
    	            	     return false;
       					 }
     				}
     			});
     			return  result;
    	   }
        },  
        message: '角色名称范围2~10位字符之间,且不为空  '  
    },
    roleCodeValidator: {  
        validator: function (value, param) {  
        	var value=$.trim(value);
        	 if(value.length>10 || value.length<2){  
        	        return false;
        	  }else{
        		 var result=true;
       			$.ajax({
       				url: encodeURI(getBasePath()+'/role/code/exist?roleCode='+value),
       				async : false,
       				success : function(data) {
       				 if(!data){
       					$(param[0]).text("");
 	            		 $(param[0]).css("color","green");
  	            		  result= true;
  	            		  return true;
   					 }else{
   						 $(param[0]).text("该角色编码已存在!");
	            	     $(param[0]).css("color","red");
	            	     result= false;
	            	     return false;
   					 }
       				}
       			});
       			return  result;
        	   }
        },  
        message: '角色编码2~10位字符之间,且不能重复'  
    },
    reRoleCodeValidator: {  
//        validator: function (value, param) {  
//        	var value=$.trim(value);
//        	 if(value.length>10 || value.length<2){  
//        	     return false;
//        	 }else{
//          		 var result=true;
//          		 var roleCode=	$("#roleCodeUpdate").textbox('getValue');
//         			$.ajax({
//         				url: encodeURI(encodeURI(getBasePath()+'/role/code/exist?roleCode='+roleCode)),
//         				async : false,
//         				success : function(data) {
//         					 if(!data){
//         						 result= true;
//        	            		  return true;
//         					 }else if(data && (roleCode!=roleCodeUpdate)){
//         						 $(param[0]).text("该角色编码已存在!");
//      	            	         $(param[0]).css("color","red");
//      	            	        result= false;
//      	            	        return false;
//         					 }else{
//         						result= false;
//         						return false;
//         					 }
//         				}
//         			});
//         			return  result;
//        	   }
//        },  
//        message: '角色编码2~10位字符之间,且不为空 '  
    	 validator: function (value, param) {  
         	var value=$.trim(value);
         	 if(value.length>10 || value.length<2){  
         	        $(param[0]).text("");
         	        $(param[0]).css("color","red");
         	        return false;
         	   }else{
             		 return true;
         	   }
         },  
         message: '角色编码2~10位字符之间,且不为空 '  
    },
    reRoleNameValidator: {  
    	validator: function (value, param) {  
         	var value=$.trim(value);
         	 if(value.length>10 || value.length<2){  
         	        $(param[0]).text("");
         	        $(param[0]).css("color","red");
         	        return false;
         	   }else{
             		 return true;
         	   }
         },  
        message: '角色范围2~10位字符之间,且不为空  '  
    }
   
}); 

function selectAll(){
	 var result =$("input[name='allFID']").prop("checked");
	$("input[name='FID']").prop("checked",result);
}
function selectAllReadOnly(){
	 var result =$("input[name='allPD']").prop("checked");
	$("input[name='PD']").prop("checked",result);
}
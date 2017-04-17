		var url;
		var updateRoleUrl;
		var userNameForUpdate;
		var userCodeForUpdate;
		$(function(){
 			// 加载组织机构列表
 			/*$('#orgid-search').combotree({
 				url: getBasePath()+'/orginfo/list/jsonCodeIdTree'
 			});*/
 			// 加载公司列表
 			$('#companycode-search').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal=0');
 		});
		
		$(function(){
			//blur事件判断公司改变（新增）
			$('#companycode').combobox({
			    onChange:function(newValue,oldValue){
			    	$('#orgid').combotree({
		 				url: getBasePath()+'/orginfo/list/jsonTreeByCompanyCode?companyCode='+newValue
		 			});
			    }
			});
		});
		
		
		$(function(){
			//blur事件判断公司改变（修改）
			$('#companycode-update').combobox({
			    onChange:function(newValue,oldValue){
			    	$('#orgid-update').combotree({
		 				url: getBasePath()+'/orginfo/list/jsonTreeByCompanyCode?companyCode='+newValue
		 			});
			    }
			});
		});
		
		
		function newUser() {
			$('#usercodeValidatorTip').show();	
			$('#userCode').textbox({readonly:false});
			
			// 加载公司列表
 			$('#companycode').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal=-1');

			// 加载组织机构列表
 			/*$('#orgid').combotree({
 				url: getBasePath()+'/orginfo/list/jsonCodeIdTree'
 			});	*/	
 			
			$('#dlg').dialog('open').dialog('center').dialog('setTitle',
					'添加用户');
			$('#fm').form('clear');
			url = getBasePath()+'/user/add';
		}
		/**
		 * 更新用户
		 */
		function editUser() {
			$('#fm-update').form('clear');
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				// 加载公司列表
	 			$('#companycode-update').combobox('reload', getBasePath()+'/company/list/json/default?defaultVal='+row.companyCode);
	 			/*//加载组织机构
	 			$('#orgid-update').combotree({
	 				url: getBasePath()+'/orginfo/list/jsonCodeIdTree'
	 			});*/
	 			$('#companycode-update').combobox('select',row.companyCode);
	 			$('#companycode-update').combobox('setValue',row.companyCode);


	 			
				$('#userCode').textbox({readonly:true});
				$('#dlg-update').dialog('open').dialog('center').dialog('setTitle',
						'编辑用户');
				$('#fm-update').form('load', row);
				if(row.isEnable){
					$("#isEnable").combobox('setValue',row.isEnable);	
				}else{
					$("#isEnable").combobox('setValue',0);
				}
				userNameForUpdate=row.userName;
				userCodeForUpdate=row.userCode;
				url = getBasePath()+'/user/update?userId=' + row.userId;
			}else{
				$.messager.show({
					title : '提示',
					msg : '请选择用户'
				});
			}
		}
		
		function editRole() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$('#dlg-role').dialog('open').dialog('center').dialog('setTitle',
						'角色分配');
				$('#fm-role').form('load', row);
				updateRoleUrl = getBasePath()+'/user/role/update?userId=' + row.userId+"&roleIds=";
			}else{
				$.messager.show({
					title : '提示',
					msg : '请选择用户'
				});
			}
	       //打开角色选择窗
			$('#username-role').textbox('readonly',true);
			$("#dg-role").remove();
		  	$("#dg-role-container").html("<table id=\"dg-role\" ></table>");
			$('#dg-role').datagrid({
					title: '选择角色',
					url: getBasePath()+'/user/role/all?userId='+row.userId,
					width: '300',
					rownumbers: true,
					idField: 'id',
		            treeField: 'text',
					columns:[[
						{ field:'ck',checkbox:true },
						{ field: 'text', title: '角色名称' }
						]],
					singleSelect: false,
					selectOnCheck: true,
					checkOnSelect: true,
					onLoadSuccess:function(data){                   
							if(data){
								$.each(data.rows, function(index, item){
									if(item.checked){
										$('#dg-role').datagrid('checkRow', index);
									}
								});
							}
					}                
				});
		}
		
		function saveUser() {
			var userCode= $("#userCode").textbox("getValue");
			$.ajax({
				url : getBasePath() + "/user/code/exist",
				data : {userCode:userCode},
				async : false,
				success : function(data) {
					 if(data){
						 $.messager.show({
	 							title : '提示',
	 							msg : '员工编号已存在'
	 					 });
						 //return;
					 }else{//员工编号不存在
				var userName= $("#userName").textbox("getValue"); 
				$.ajax({
					url : getBasePath() + "/user/username/exist",
					data : {userName:userName},
					async : true,
					success : function(data) {
						 if(!data){
								$('#fm').form('submit', {
									url : url,
									onSubmit : function() {
										return $(this).form('validate');
									},
									success : function(data) {
										var result =$.parseJSON(data);
										if(result && result.status=='OK'){
											$.messager.show({
					 							title : '提示',
					 							msg : '添加成功，请为该用户添加角色！'
					 						});
											$('#dlg').dialog('close'); // close the dialog
					 						$('#dg').datagrid('reload'); // reload the user data
										}else{
											$.messager.show({
					 							title : '提示',
					 							msg : '保存失败'
					 						});
											$('#dlg').dialog('close'); // close the dialog
										}
									}
								});
						 }else{
							 $.messager.show({
		 							title : '提示',
		 							msg : '用户名已存在'
		 					 });
					       }
				}});}
		}
			});
		}
		//更新用户
		function updateUser() {
			
			//校验信息
			var userName = $("#usernameUpdate").textbox("getValue");
			var userCode = $("#usercodeUpdate").textbox("getValue");
//			var orgId = $("#orgid-update").textbox("getValue");
			// start *********************************************************  
			 $.when( $.ajax({
				 url: encodeURI(encodeURI(getBasePath()+'/user/username/exist?userName='+userName))
					}),
			   $.ajax({
   			     url : getBasePath() + "/user/code/exist",
   			     data : {userCode:userCode}})).done(function( a1, a2 ) {
   			    	 if(a1[0] && userNameForUpdate!=userName){
   			    		 $.messager.show({
	 							title : '提示',
	 							msg : '保存失败，该用户名已存在'
	 					 });
   			    	  return;
   			    	 }
   			    	if(a2[0] && userCodeForUpdate!=userCode){
  			    		 $.messager.show({
	 							title : '提示',
	 							msg : '保存失败，该用户编码已存在'
	 					 });
  			    	  return;
  			    	 }
   			    	//保存
   			     $('#fm-update').form('submit', {
//						url : url + '&orgId='+orgId ,
						url : url,
						onSubmit : function() {
							return $(this).form('validate');
						},
						success : function(data) {
							var result =$.parseJSON(data);
							if(result && result.status=='OK'){
								$.messager.show({
		 							title : '提示',
		 							msg : '保存成功'
		 						});
								$('#dlg-update').dialog('close'); // close the dialog
		 						$('#dg').datagrid('reload'); // reload the user data
							}else{
								$.messager.show({
		 							title : '提示',
		 							msg : '保存失败'
		 						});
								$('#dlg-update').dialog('close'); // close the dialog
							}
						}
					});
   			     }).fail(function(){
   			    	   $.messager.show({
							title : '提示',
							msg : '网络异常'
						});
   			     });;
			
 			// end  ********************************************************** 
		}
		function saveRole() {
			var names = [];   
			var checkedItems = $('#dg-role').datagrid('getChecked');
			
			$.each(checkedItems, function(index, item){
			names.push(item.id);
			});      
			
			$.ajax({
				url : updateRoleUrl+names,
				data : {},
				async : true,
				method:'POST',
				success : function(data) {
			         var result =$.parseJSON(data);
						if (result && result.status=='OK') {
							$.messager.show({
								title : '提示',
								msg : '保存成功'
							});
							$('#dlg-role').dialog('close'); // close the dialog
	 						$('#dg').datagrid('reload'); // reload the user data
						} else {
							$.messager.show({
								title : '提示',
								msg : result.message
							});
						}

				}
			});

		}
		
		function destroyUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('确认',
						'你确定要删除该用户吗?',
						function(r) {
							if (r) {
								$.post(getBasePath()+'/user/delete', {
									id : row.userId
								}, function(result) { 								
 									if(result && result.status=='OK'){
										$.messager.show({
				 							title : '提示',
				 							msg : '删除成功'
				 						});
										$('#dlg').dialog('close');  
				 						$('#dg').datagrid('reload');  
									}else{
										$.messager.show({
				 							title : '提示',
				 							msg : '删除失败'
				 						});
										$('#dlg').dialog('close');  
									}
								}, 'json');
							}
						});
				resizeDialog();
			}
		}
		 //查询加载数据，附带了请求参数
		function searchUser(){
			    var username=$("#username-search").val();
			    var usercode=$("#usercode-search").val();
			    var realname=$("#realname-search").val();
			    var companycode=$("#companycode-search").combobox('getValue');
//			    var orgid=$("#orgid-search").combobox('getValue');
			    $("#dg").datagrid("load",{userName:username,userCode:usercode,realName:realname,companyCode:companycode});
			 
		}
	    function reset(){
	    	
	    	 $("#username-search").textbox("reset");
 			 $("#usercode-search").textbox("reset");
			 $("#realname-search").textbox("reset");
//			 $("#orgid-search").combobox('setValue','');
			 $("#companycode-search").combobox('setValue','0');
			 $("#dg").datagrid("load", {});
		}
			
			 
	 // 验证用户添加部门
	    $.extend($.fn.validatebox.defaults.rules, {  
	    	//校验用户代码
	    	userCodeValidator: {  
	            validator: function (value, param) { 
	            	var result =false;
	            	var value=$.trim(value);
 		
	            	var value=$.trim(value);
	            	 //if(value.length<5){  
	            		 if(!/^[a-z\d]{5,30}$/i.test(value)){
// 	            	 if(!/^\d{5,}$/.test(value)){  
//	            	        $(param[0]).text("请输入5-30位数字或字母!");
//	            	        $(param[0]).css("color","red");
	            	        result = false;
	            	   }/*else if(value && value!='' && /^\d{5,}$/.test(value)){
	            		   
	            			$.ajax({
	            				url : getBasePath() + "/user/code/exist",
	            				data : {userCode:value},
	            				async : false,
	            				success : function(data) {
	            					 if(!data){
	            						 $(param[0]).text("验证通过!");
		       	            		     $(param[0]).css("color","green");
		       	            		  result = true;
	            					 }else if(data){
	            						 $(param[0]).text("该用户编号已存在!");
	         	            	         $(param[0]).css("color","red");
	         	            	        result = false;
	            					 }else{
	            						 $.messager.show({
	            	 							title : '提示',
	            	 							msg : '请求超时，请稍后再试...'
	            	 					 });
	            						 result =false;
	            					 }
	            				}
	            			});
	            	   }*/else{
	            		  /* $(param[0]).text("验证通过!");
 	            		   $(param[0]).css("color","green");*/
	            		   result = true;
	            	   }
 	            	 	return result;
	            },  
	            message: '员工编号为5-30位数字或字母'  
	        },  
	        //校验用户名
	        userNameValidator: {  
	            validator: function (value, param) {  
	            	var value=$.trim(value);
	            	 if(value.length>20 || value.length<2){  
//	            	        $(param[0]).text("请输入2~20 位字符!");
//	            	        $(param[0]).css("color","red");
	            	        return false;
	            	   }else{
	            		   var result=true;
	            			return  result;
 	            	   }
	            },  
	            message: '用户名范围在2~20位字符 '  
	        }, 
	        
	        realNameValidator: {  
	        	 validator: function (value, param) {  
		            	var value=$.trim(value);
		            	 if(value.length>20 || value.length<2){  
//		            	        $(param[0]).text("请输入2~20 位字符!");
//		            	        $(param[0]).css("color","red");
		            	        return false;
		            	   }else{
		            		   var result=true;
		            			return  result;
	 	            	   }
		            },  
		         message: '真实姓名范围在2~20位字符 '
	        }, 
	        passwordValidator: {  
	            validator: function (value, param) {  
	            	var value=$.trim(value);
	            	 if(value.length>18 || value.length<6){  
/*	            	        $(param[0]).text("请输入6~18个字符!");
	            	        $(param[0]).css("color","red");*/
	            	        return false;
	            	   }else{
	            		   return true;
	            	   }
	            },  
	            message: '密码至少6个字符,最多18个字符 '  
	        },
	        repasswordValidator: {  
	            validator: function (value, param) {
	            	var value=$.trim(value);
	             if(value!='' && 	value !=$(param[0]).textbox('getValue')){
//	            	  $(param[1]).text("两次输入密码不一致!");
//	            	  $(param[1]).css("color","red");
	            	 return false;
	             }else{
          		     return true;
	             }
	            },  
	            message: '两次输入密码不一致 '  
	        },
	    	selectValueRequired: {  
	            validator: function (value, param) {  
	            	var value=$.trim(value);
	                if (value == "" || value.indexOf('选择') >= 0) {
	                	  /*$(param[0]).text("请选择!");
	                   	  $(param[0]).css("color","red");*/
	                	return false; }  
	                else {
	                	return true; }  
	            },  
	            message: '该下拉框为必选项'  
	        },
	        mobile: {  
	        validator: function (value, param) {
	        	var value=$.trim(value);
	        	var result = /^(13|15|16|17|18|19)\d{9}$/i.test(value);
	        	  if(result){
                  }else{
               	   /*$(param[0]).text("手机号码不正确!");
               	  $(param[0]).css("color","red");*/
                  }
           	   return result;  
 	        },  
	         message: '手机号码不正确'  
	       },
	       
//	       phoneAndMobile : {// 电话号码或手机号码  
//               validator : function(value, param) {
//            	   var value=$.trim(value);
//            	   var result =/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value) || /^(13|15|18)\d{9}$/i.test(value);
//                   if(result){
//                	   $(param[0]).text("验证通过!");
//                	   $(param[0]).css("color","green");
//                   }else{
//                	   $(param[0]).text("电话号码不正确!");
//                	   $(param[0]).css("color","red");
//                   }
//            	   return result;  
//               },  
//               message : '电话号码格式不正确'  
//           },  
	        
	        reUserNameValidator: {  
	            validator: function (value, param) {  
	            	var value=$.trim(value);
	            	 if(value.length>20 || value.length<2){  
//	            	        $(param[0]).text("请输入2~20 位字符!");
//	            	        $(param[0]).css("color","red");
	            	        return false;
	            	   }else{
	            		   /*$(param[0]).text("验证通过!");
	                	   $(param[0]).css("color","green");*/
	                	   return true;
	            	   }
	            },  
	            message: '用户名范围在2~20位字符 '  
	        },
	        reUserCodeValidator: {  
	            validator: function (value, param) { 
 	            	var value=$.trim(value);
 	            	 if(!/^[a-z\d]{5,30}$/i.test(value)){  
//	            	        $(param[0]).text("请输入5-30位数字或字母!");
//	            	        $(param[0]).css("color","red");
	            	        return false;
 	            	 }else{
 	            		    /* $(param[0]).text("验证通过!");
		                	 $(param[0]).css("color","green");*/
		                	 return true;
	            	 }
	            },  
	            message: '请输入5-30位数字或字母'  
	        }
	       
	    });  
	    
	    function statusFormatter(val, row) {
	    	if (row.isEnable) {
	    		if(row.isEnable=='1'){
	    			return "已激活";
	    		}else{
	    			return "未激活";
	    		}
	    	}else{
	    		return "未激活";
	    	}
	    	
	    }
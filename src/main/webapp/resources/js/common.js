$.ajaxSetup({
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		if (XMLHttpRequest.status == 403) {
			alert('您没有权限访问此资源或进行此操作');
			return false;
		}
	},
	complete : function(XMLHttpRequest, textStatus) {
		var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头,sessionstatus，
		if (sessionstatus == 'timeout') {
			// 如果超时就处理 ，指定要跳转的页面
			var top = getTopWinow(); // 获取当前页面的顶层窗口对象
			alert('登录超时, 请重新登录');
			top.location.href = getBasePath()+"/login"; // 跳转到登陆页面
		}
	}
});

function getTopWinow(){  
    var p = window;  
    while(p != p.parent){  
        p = p.parent;  
    }  
    return p;  
}  

/**
 * 修改DataGrid对象的默认大小，以适应页面宽度。
 * 
 * @param heightMargin
 *            高度对页内边距的距离。
 * @param widthMargin
 *            宽度对页内边距的距离。
 * @param minHeight
 *            最小高度。
 * @param minWidth
 *            最小宽度。
 * 
 */
$.fn.extend( {
	resizeDataGrid : function(heightMargin, widthMargin, minHeight, minWidth) {
		var height = $(document.body).height() - heightMargin;
		var width = $(document.body).width() - widthMargin;

		height = height < minHeight ? minHeight : height;
		width = width < minWidth ? minWidth : width;

		$(this).datagrid('resize', {
//			height : height,
	//		width : width
		});
	}
});

$(function() {
	//datagrid数据表格ID 
	var datagridId = 'dg';

	// 第一次加载时自动变化大小  
	//$('#' + datagridId).resizeDataGrid(0, 0, 400, 600);

	// 当窗口大小发生变化时，调整DataGrid的大小  
//	$(window).resize(function() {
//		$('#' + datagridId).resizeDataGrid(0, 0, 400, 600);
//	});
});

$(function() {
	/*$.messager.defaults = $.extend($.messager.defaults, {
		ok : "确认",
		cancel : "取消"
	});*/
});

$.extend($.fn.validatebox.defaults.rules, {
    equals: {  
        validator: function(value,param){  
            return value == $(param[0]).val();  
        },  
        message: '密码不一致!'  
    },
    ip: {
        validator: function (value, param) {
            var re = /^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式
            if (re.test(value)) {
                if (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256) return true;
            }
            return false;
        },
        message: 'ip格式不正确'
    },
    checkNum: {
    	  validator: function(value, param) {
    	  return /^([0-9]+)$/.test(value);
    	  },
    	  message: '请输入整数'
    	 } ,
   selectValid: {
		validator: function(value,param){
			//alert(value);
			return (value !='--请选择--') ;
		},
		message: "该项不可为'--请选择--'"
    },
   checkLongi: {  
        validator: function(value, param) {  
            return  /^-?((0|[1-9]\d?|1[1-7]\d)(\.\d{1,7})?|180(\.0{1,7})?)?$/.test(value);  
        },  
        message: '请输入正确的经度'  
    },
   checkLati: {  
        validator: function(value, param) {  
            return /^-?(?:90(?:\.0{1,7})?|(?:[1-8]?\d(?:\.\d{1,7})?))$/.test(value);  
        },  
        message: '请输入正确的纬度'  
    } 
}); 

function toLocalDate(value,row,index){
	if(value){
		var a = new Date(value);
		return a.toLocaleString().replace(/[\\]/,'-');
	}else{
		return "";
	}
};

function toLocalDateYYYYMMDD(value,row,index){
	if(value){
		var date=new Date(value);
		return date.getFullYear()+"-"+fixZero(date.getMonth()+1,2)+"-"+fixZero(date.getDate(),2);
		function fixZero(num,length){
		var str=""+num;
		var len=str.length;
		var s="";
		for(var i=length;i-->len;){
		s+="0";
		}
		return s+str;
		}
	}else{
		return "";
	}
};
//调度方案格式化
		function surveyTypeFormatter(val,row){
	 	var rlt ="";
		if(val=="0"){rlt="修理厂查勘";};
		if(val=="1"){rlt="普通查勘";};
		if(val=="2"){rlt="视频查勘";}
		if(val=="3"){rlt="客户自助";};
		if(val=="4"){rlt="预约";};
		if(val=="5"){rlt="转分公司";};
		if(val=="10"){rlt="申请改派";};
		return rlt;
	}

function toLocalFullDate(value){
	if(value){
		var date=new Date(value);
		return date.getFullYear()+"-"+fixZero(date.getMonth()+1,2)+"-"+fixZero(date.getDate(),2)+" "+fixZero(date.getHours(),2)+":"+fixZero(date.getMinutes(),2)+":"+fixZero(date.getSeconds(),2);
		function fixZero(num,length){
		var str=""+num;
		var len=str.length;
		var s="";
		for(var i=length;i-->len;){
		s+="0";
		}
		return s+str;
		}
	}else{
		return "";
	}
};


function getBasePath() {
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	if (contextPath) {
		return localObj.protocol + "//" + localObj.host + "/" + contextPath;
	}else {
		return localObj.protocol + "//" + localObj.host ;
	}
/*	var systemctx=$("#systemctx").val();
	return systemctx;*/
}


$.extend($.fn.validatebox.defaults.rules, {
	//截止日期校验
	dateAfterBegin: {
        validator: function(value,param){
        	var beginDateStr =$(param[0]).textbox('getValue');
        	if(!value || !param ||value==null || value =='' || beginDateStr ==null || beginDateStr=='' ){
        		return true;
        	}
            var beginTimestamp = new Date(Date.parse(beginDateStr.replace(/-/g, "/"))).getTime() /1000;
        	var endTimestamp = new Date(Date.parse(value.replace(/-/g, "/"))).getTime() /1000;
        	
        	
            return beginTimestamp <= endTimestamp;
        },
        message: '时间无效，截止时间不能先于开始时间.'
    },
    //开始日期校验
	dateBeforeEnd: {
        validator: function(value,param){
        	var endDateStr =$(param[0]).textbox('getValue');
        	if(!value || !param ||value==null || value =='' || endDateStr ==null || endDateStr=='' ){
        		return true;
        	}
            var endTimestamp=  new Date(Date.parse(endDateStr.replace(/-/g, "/"))).getTime() /1000;
        	var beginTimestamp = new Date(Date.parse(value.replace(/-/g, "/"))).getTime() /1000;
            return  beginTimestamp <=  endTimestamp;
        },
        message: '时间无效，截止时间不能先于开始时间.'
    },
    //日期格式验证
    datetime: {
    	validator: function(value, param){
        	var datetimeStr = value;
        	
        	if(!datetimeStr){
        		return true;
        	}
        	
        	var datetimeM = moment(datetimeStr, "YYYY-MM-DD HH:mm:ss");
            
            return datetimeM.isValid();
        },
        message: '时间格式错误（YYYY-MM-DD HH:mm:ss）.'
    },
    //日期格式验证
    date: {
    	validator: function(value, param){
        	var dateStr = value;
        	
        	if(!dateStr){
        		return true;
        	}
        	
        	var dateM = moment(dateStr, "YYYY-MM-DD");
            
            return  dateM.isValid();
        },
        message: '日期格式错误（YYYY-MM-DD）.'
    }
});

function formatterdate(val, row) {
	var hours;
	var minutes;
	var seconds;
	if (val != null) {
	var date = new Date(val);
	hours = date.getHours()=='0'?"00":date.getHours();
	minutes = date.getMinutes()=='0'?"00":date.getMinutes();
	seconds=date.getSeconds()=='0'?"00":date.getSeconds();
	return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
	+ date.getDate()+" "+hours+":"+minutes+":"+seconds;
	}
}
 // 案件锁定者 
function updateByFormatter(val,row){
	if(row && row.isLocked==1){
		return row.updateBy?row.updateBy:"";
	}
}
// 案件打开在新的tab 
var  baseUrl =getBasePath();







//将iframe通过post方式重定向到新的页面
function redirectIframeToUrlByPost(iframe, url, params){
	$(iframe).contents().find("body").empty();
	var form = $("<form></form>").appendTo($(iframe).contents().find("body"));
	
	//设置form提交属性
	form.attr("method", "post");
	form.attr("target", "_self");
	form.attr("action", url);
	
	//添加form提交的隐藏域
	for(var key in params){
		$("<input type=\"hidden\" name=\"" + key + "\" value=\"" + params[key] + "\"/>").appendTo(form);
	}
	//alert($(iframe).contents().find("body").find("form").attr("action"))
	$(form).submit();
}

//在iframe中打开中兴的url
function openZTEUrlInIframeByUrl(iframe, url){
	var status = false, params = {};
	
	//通过ajax后台获取认证参数
	$.ajax({
		url: baseUrl + "/getLoginParamForZTE",
		type: "POST",
		async: false,
		success: function(datas){
			status = true;
			params = datas;
		}, error: function(response){
			
		}
	});
	
	//post重定向页面
	redirectIframeToUrlByPost(iframe, url, params);
}

//重新计算弹出框的位置。并隐藏右上角的最大化、最小华、折叠功能
function resizeDialog(){
	var winWidth = document.body.clientWidth;
	var leftWidth = (winWidth - 300)/2;
	$(".messager-window").css("left",leftWidth+"px");
	$(".window-shadow").css("left",leftWidth+"px");
	$('.panel-tool-max').hide();
	$('.panel-tool-min').hide();
	$('.panel-tool-collapse').hide();
}

/**
 * 单一组合框(combobox)
 * @param url:相对路径
 * @param id:comboobx的id(无需加'#'号)
 * @author zuokunpeng
 * @date 2016-04-28 18:00
 */
function singleCombobox(url,id){
	$.post(getBasePath()+url, function(retJson) {
		var length=(retJson.length)*25;
		if (length>200) {
			length=200;
		}
		$('#'+id).combobox({
			data : retJson,
			panelHeight:length
		});
	});

}

/**
 * 设置combobox自动行高
 * @param id
 * @auther huangkai
 * @2016-05-04
 */
function setComboboxHeight(id){
	var obj = $("#"+id).combobox('options');
	if(obj.length > 200){
		$("#"+id).combobox({panelHeight:'200'});
	}else{
		$("#"+id).combobox({panelHeight:'auto'});
	}
}



/**
 * 多级组合树:多个层级(combotree)
 * @param url:相对路径
 * @param id:comboobx的id(无需加'#'号)
 * @author zuokunpeng
 * @date 2016-04-28 18:00
 */
function multipleComboboxTree(url,id){
	$.post(getBasePath()+url, function(retJson) {
		var length=(retJson[0].children.length)*25;
		if (length>200) {
			length=200;
		}
		$('#'+id).combotree({
			data : retJson,
			panelHeight:length
		});
	});
}

/**
 * 单级组合树:只有一级(combotree)
 * @param url:相对路径
 * @param id:comboobx的id(无需加'#'号)
 * @author zuokunpeng
 * @date 2016-04-28 18:00
 */
function singleComboboxTree(url,id){
	$.post(getBasePath()+url, function(retJson) {
		var length=(retJson.length)*25;
		if (length>200) {
			length=200;
		}
		$('#'+id).combotree({
			data : retJson,
			panelHeight:length
		});
	});
}

//处理键盘事件
function doKey(e) {
    var ev = e || window.event; //获取event对象   
    var obj = ev.target || ev.srcElement; //获取事件源   
    var t = obj.type || obj.getAttribute('type'); //获取事件源类型   
    if (ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea") {
        return false;
    }
}
//禁止后退键 作用于Firefox、Opera   
document.onkeypress=doKey;   
//禁止后退键  作用于IE、Chrome   
document.onkeydown=doKey;

/**
 * Created with JetBrains WebStorm.
 * User: cao.guanghui
 * Date: 13-6-26
 * Time: 下午11:27
 * To change this template use File | Settings | File Templates.
 */
$.extend($.fn.datagrid.methods, {
    /**
     * 开打提示功能（基于1.3.3+版本）
     * @param {} jq
     * @param {} params 提示消息框的样式
     * @return {}
     */
    doCellTip:function (jq, params) {
        function showTip(showParams, td, e, dg) {
            //无文本，不提示。
            if ($(td).text() == "") return;
            params = params || {};
            var options = dg.data('datagrid');
            var styler = 'style="';
            if(showParams.width){
                styler = styler + "width:" + showParams.width + ";";
            }
            if(showParams.maxWidth){
                styler = styler + "max-width:" + showParams.maxWidth + ";";
            }
            if(showParams.minWidth){
                styler = styler + "min-width:" + showParams.minWidth + ";";
            }
            styler = styler + '"';
            showParams.content = '<div class="tipcontent" ' + styler + '>' + showParams.content + '</div>';
            $(td).tooltip({
                content:showParams.content,
                trackMouse:true,
                position:params.position,
                onHide:function () {
                    $(this).tooltip('destroy');
                },
                onShow:function () {
                		 var tip = $(this).tooltip('tip');
                         if(showParams.tipStyler){
                             tip.css(showParams.tipStyler);
                         }
                         if(showParams.contentStyler){
                             tip.find('div.tipcontent').css(showParams.contentStyler);
                         }	
                }
            }).tooltip('show');
        };
        return jq.each(function () {
            var grid = $(this);
            var options = $(this).data('datagrid');
            if (!options.tooltip) {
                var panel = grid.datagrid('getPanel').panel('panel');
                panel.find('.datagrid-body').each(function () {
                    var delegateEle = $(this).find('> div.datagrid-body-inner').length ? $(this).find('> div.datagrid-body-inner')[0] : this;
                    $(delegateEle).undelegate('td', 'mouseover').undelegate('td', 'mouseout').undelegate('td', 'mousemove').delegate('td[field]', {
                        'mouseover':function (e) {
                            //if($(this).attr('field')===undefined) return;
                            var that = this;
                            var setField = null;
                            if(params.specialShowFields && params.specialShowFields.sort){
                                for(var i=0; i<params.specialShowFields.length; i++){
                                    if(params.specialShowFields[i].field == $(this).attr('field')){
                                        setField = params.specialShowFields[i];
                                    }
                                }
                            }
                            if(setField==null){
                                options.factContent = $(this).find('>div').clone().css({'margin-left':'-5000px', 'width':'auto', 'display':'inline', 'position':'absolute'}).appendTo('body');
                                var factContentWidth = options.factContent.width();
                                params.content = $(this).text();
                                if (params.onlyShowInterrupt) {
                                    if (factContentWidth > $(this).width()) {
                                        showTip(params, this, e, grid);
                                    }
                                } else {
                                    showTip(params, this, e, grid);
                                }
                            }else{
                                panel.find('.datagrid-body').each(function(){
                                    var trs = $(this).find('tr[datagrid-row-index="' + $(that).parent().attr('datagrid-row-index') + '"]');
                                    trs.each(function(){
                                        var td = $(this).find('> td[field="' + setField.showField + '"]');
                                        if(td.length){
                                            params.content = td.text();
                                        }
                                    });
                                });
                                showTip(params, this, e, grid);
                            }
                        },
                        'mouseout':function (e) {
                            if (options.factContent) {
                                options.factContent.remove();
                                options.factContent = null;
                            }
                        }
                    });
                });
            }
        });
    },
    /**
     * 关闭消息提示功能（基于1.3.3版本）
     * @param {} jq
     * @return {}
     */
    cancelCellTip:function (jq) {
        return jq.each(function () {
            var data = $(this).data('datagrid');
            if (data.factContent) {
                data.factContent.remove();
                data.factContent = null;
            }
            var panel = $(this).datagrid('getPanel').panel('panel');
            panel.find('.datagrid-body').undelegate('td', 'mouseover').undelegate('td', 'mouseout').undelegate('td', 'mousemove');
        });
    }
});
// 根据Id重置 Combotree
function resetCombotreeById(settingId){
	 $(settingId).combotree('clear');
}
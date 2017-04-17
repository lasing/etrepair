(function($) {
	//Window GET请求
	$.addLiveneoWindow = function (t, p) {
	    window.scrollTo(0,0);
		p = $.extend({
			title: '对话框',
			url : '',
			maximized : true,
			width:820,
			height:412,
			onClose:function(){
			}
		}, p);
		var divid = "win_div";
		var iframeid = "win_iframe";
		var windowHtml = '<div id="'+ divid +'"><iframe id="'+ iframeid +'" border="0" frameborder="0" framespacing="0" marginheight="0" marginwidth="0" vspale="0" scrolling="yes" height="98%" width="100%"></iframe></div>';
		$('body').prepend(windowHtml);
		$('#' + iframeid).attr('src', p.url);
		$('#' + divid).window({
			title: p.title,  
			width: p.width,  
			height: p.height,
			modal: true,
			collapsible: false,
			minimizable: false,
			maximizable: true,
			maximized: p.maximized,
			closable:false,
			noheader:p.noheader,
			onBeforeClose: function(){
				p.onClose.call();
			},
			onClose: function(){
				$('body').css('overflow', 'auto');
				$('#win_div').empty();
				$('#win_div').detach();
			}
		});
	};
	//关闭Window
	$.fn.closeWindow = function () {
		if(parent.window && parent.window != window) {
			parent.$('#win_div').window('close');
			parent.$('#win_div').remove();
		}
	};
	//页面调用
	$.fn.liveneoWindow = function (p) {
		$.addLiveneoWindow($(this), p);
	};

})(jQuery);
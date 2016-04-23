/*!
 * 工具
 * Author: ttm
 * Date: 2016-04-17
 */
(function( $ ) {

	var methods = {
		deletetool : function( $e, formtname ) {
			var $this = $(this);
			var $title = $this.attr("title");
			if (confirm("确定删除 " + $title + "?")) {
				var href = $this.attr("data-href");
				$("." + formtname).attr("action", href).submit();
				return false;
			} else {
				// 取消事件操作
				$e.preventDefault();
			}
		}
	};

	$.fn.tool = function( method ) {
		if ( methods[ method ] ) {
			return methods[ method ].apply( this, Array.prototype.slice.call( arguments, 1 ));
		} else if ( !method || typeof method ) {
			//return methods( this, arguments );
		} else {
			$.error( 'Method ' + method + ' does not exist on jQuery.tooltip');	
		}
	};

})( jQuery )
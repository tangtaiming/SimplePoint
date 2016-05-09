$(function() {
	//美食删除
	//视频删除
	//食品安全删除
	//美食家删除
	//水果删除
	//优惠删除
	$("a[class^='entity-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "entity-rest");
	});
	
	//每页显示数量功能
	$("select[name^='size_length_']").change(function() {
		$(this).tool( "meiyexianshi", "_method" , "entity-rest");
	});
	
	
});
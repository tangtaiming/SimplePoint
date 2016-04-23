$(function() {
	//美食删除
	$("a[class^='meishi-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "meishi-rest");
	});
	
	//视频删除
	$("a[class^='shipin-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "shipin-rest");
	});
	
	//食品安全删除
	$("a[class^='safety-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "safety-rest");
	});
	
	//美食家删除
	$("a[class^='meishijia-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "meishijia-rest");
	});
	
	//水果删除
	$("a[class^='shuiguo-delete-']").click(function(e) {
		$(this).tool( "deletetool", e , "shuiguo-rest");
	});
	
});
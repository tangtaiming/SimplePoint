$.extend({
	myAjax : function ( url, params, method ) {
		$.ajax({
			url : url,
			data : params,
			type : method,
			success : function( trancationResponse ) {
				//console.info("^^^^^^^^^^^^^^" + trancationResponse);
				var requestJson = JSON.parse(trancationResponse);
				var url = requestJson.data;
				var code = requestJson.code;
				var msg = requestJson.msg;
				$.initShow(msg);
				setTimeout("$.initHide()", 5000);
			},
			error : function() {
				$.initShow("请求失败!");
				setTimeout("$.initHide()", 5000);
			}	
		});
	},
	initShow : function( content ) {
		$("#prompt-content").html(content);
		$("#nav-popup").show();	
	},
	initHide : function () {
		$("#nav-popup").fadeOut(5000);
	}
});
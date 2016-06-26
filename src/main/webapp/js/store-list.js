$(document).ready(function() {
	$("#search-button").click(function() {
		storeSearch();
	});
});

/**
 * 店铺搜索
 */
function storeSearch() {
	var $search_text = $("#search-text").val();
	var $school_id = $("#schoolId").val();
	if ($search_text == "店铺名称") {
		$search_text = "";
	}
	var url = "/store/search?s=" + $search_text + "&schoolId=" + $school_id + "&page=1&size=50"; 
	$.ajax({
		url: url,
		type : "get",
		success : function( response ) {
			$("#id-products-section").html(response);
		},
		error : function() {
			alert("请求失败。");
		}
	});
}
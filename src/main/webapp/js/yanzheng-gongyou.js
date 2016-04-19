$(function() {
	
	$(".form-horizontal").submit(function(e) {
		var isError_i = $( "input[need='need']" ).tooltip( "inputVer" );
		var isError_t = $( "textarea[need='need']" ).tooltip( "textareaVer" );
		if (isError_i || isError_t) {
			e.preventDefault();
		}
	});
	
});
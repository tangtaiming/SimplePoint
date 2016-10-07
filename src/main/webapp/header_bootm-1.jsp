<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header_bootm content">
	<div class="col-sm-4 span_1">
		<%@include file="logo.jsp" %>
	</div>
	<div class="col-sm-8 row_2">
		<div class="header_bottom_right">
			<div class="search">
				<input id="search-text" type="text" value="店铺名称"
					onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = '店铺名称';}"> <input
					id="search-button" type="submit" value="">
			</div>
			<ul class="bag">
				<a href="/login"><i class="bag_left"> </i></a>
				<a href="/login"><li class="bag_right"><p>登录</p></li></a>
				<div class="clearfix"></div>
			</ul>
			<%@include file="clearfix.jsp" %>
		</div>
	</div>
	<%@include file="clearfix.jsp" %>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header_bootm content">
	<div class="col-sm-4 span_1">
		<div class="logo">
			<a href="index.html"><img src="/images/logo.png" alt="" /></a>
		</div>
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
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Lookz Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<title>简单点-欢迎你</title>
 	<link href="/css/bootstrap.css?v=${code}" rel="stylesheet" type="text/css" />
	<link href="/css/style.css?v=${code}" rel='stylesheet' type='text/css' />
	<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
	<!--webfont-->
	<link
		href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
		rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="/js/jQuery-2.2.0.min.js"></script>
	<script type="text/javascript" src="/js/store-list.js?v=${code}"></script>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="header_bootm">
				<div class="col-sm-4 span_1">
					<div class="logo">
						<a href="index.html"><img src="/images/logo.png" alt="" /></a>
					</div>
				</div>
				<div class="col-sm-8 row_2">
					<div class="header_bottom_right">
						<div class="search">
							<input id="schoolId" type="hidden" value="${schoolId}" />
							<input id="search-text" type="text" value="店铺名称"
								onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '店铺名称';}">
							<input id="search-button" type="submit" value="">
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
			<div class="content">
				<div class="content_box">
					<ul id="id-products-section" class="grid_2">
						<%@include file="store-list.jsp" %>
					</ul>
					<div class="footer_top">
						<!-- start span_of_2 -->
						<div class="span_of_2">
							<div class="span1_of_2">
								<h5>
									need help? <a href="#">contact us <span> &gt;</span>
									</a>
								</h5>
								<p>(or) Call us: +22-34-2458793</p>
							</div>
							<div class="span1_of_2">
								<h5>follow us</h5>
								<div class="social-icons">
									<ul>
										<li><a href="#" target="_blank"></a></li>
										<li><a href="#" target="_blank"></a></li>
										<li><a href="#" target="_blank"></a></li>
										<li><a href="#" target="_blank"></a></li>
										<li class="last2"><a href="#" target="_blank"></a></li>
									</ul>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="copy">
							<p>
								Copyright &copy; 2015.Company name All rights reserved.More
								Templates <a href="http://www.cssmoban.com/" target="_blank"
									title="模板之家">模板之家</a> - Collect from <a
									href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<link href="/css/flexslider.css" rel='stylesheet' type='text/css' />
</body>
</html>

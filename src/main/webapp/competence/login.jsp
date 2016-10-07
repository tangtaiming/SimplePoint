<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../header-other.jsp"%>
<%-- 内容开始 --%>
<%@include file="../header_bootm-2.jsp"%>

<div class="men">
	<div class="account-in">
		<h2>登录</h2>
		<div class="col-md-7 account-top">
			<form action="/login" method="post">
				<div>
					<span>账号*</span> <input type="text" name="account">
				</div>
				<div>
					<span class="pass">密码*</span> <input type="password"
						name="password">
				</div>
				<input type="submit" value="登录">
			</form>
		</div>
		<div class="col-md-5 left-account ">
			<a href="single.html"><img class="img-responsive "
				src="/images/s4.jpg" alt=""></a>
			<a href="/register" class="create">Create an account</a>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>

<%@include file="../footer_top_1.jsp"%>
<%-- 内容结束 --%>
<%@include file="../footer.jsp"%>
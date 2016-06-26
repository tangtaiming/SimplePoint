<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:forEach var="store" items="${storesList}" varStatus="status">
	<a target="_blank" href="${store.url}">
		<li>
			<span class="btn5" data-phone="${store.phone}">
				<i class="fa fa-fw fa-phone"></i>
				${fn:substring(store.phone, 0, 11)}
			</span>
			<p>
				${fn:substring(store.name, 0, 10)}
				<c:if
					test="${fn:length(store.name) > 10}">...</c:if>
			</p>
				<c:if 
					test="${store.recruitment==1}">
			<p style="color:#e05b5b;">有兼职</p>
				</c:if>
		</li>
	</a>
		<c:if 
			test="${(status.index + 1) % 5 == 0}">
	<div class="clearfix"></div>
		</c:if>
		<c:if 
			test="${(status.index + 1) == storesList.size()}">
			<c:if 
				test="${storesList.size() % 5 <= 5}">
	<div class="clearfix"></div>		
			</c:if>
		</c:if>
</c:forEach>
<c:if test="${storesList==null}">
	<div class="men">
       <div class="error-404 text-center">
             <h1>空</h1>
             <p>请求数据为空</p>
             <a class="b-home" href="/home">返回主页</a>
           </div>
     </div>
</c:if>
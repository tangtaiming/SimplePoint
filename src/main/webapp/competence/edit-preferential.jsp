<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="container-head.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       	优惠模块管理 <small>主页模块化管理-信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li>优惠模块</li>
        <li class="active">编辑优惠</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->
	  <div class="box box-info">
        <div class="form-horizontal">
            <div class="box-body">
            	<c:if test="${preferentialsList==null || fn:length(preferentialsList)==0}">
            	<c:forEach items="${numberList21}" var="number">
            	<div class="form-group">
                    <label class="col-sm-2 control-label" for="ext-${number}">优惠-${number}:</label>
                    <div class="col-sm-5">
                    	<input id="ext-${number}" name="${number}" class="form-control" type="text" placeholder="优惠多多"  data="${number}" />
                    </div>
                    <div class="col-sm-5">
                        <p title="优惠-${number}" class="ext-preferentials-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
            	</c:forEach>
                </c:if>
                
                <%-- 查询数据不等于空的时候 --%>
                <c:if test="${preferentialsList!=null}">
                <c:forEach items="${numberList21}" var="preferentials">
                <c:if test="${empty preferentialsList[preferentials-1]}">
                	<c:set var="number" value="${preferentials}" scope="request"/>
                	<c:set var="name" value="" scope="request"/>
                </c:if>
                <c:if test="${!empty preferentialsList[preferentials-1]}">
                	<c:set var="number" value="${preferentialsList[preferentials-1].id}" scope="request"/>
                	<c:set var="name" value="${preferentialsList[preferentials-1].name}" scope="request"/>
                </c:if>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="ext-${number}">优惠-${number}:</label>
                    <div class="col-sm-5">
                    	<input id="ext-${number}" name="${number}" class="form-control" type="text" placeholder="优惠多多" data="${number}" value="${name}" />
                    </div>
                    <div class="col-sm-5">
                        <p title="优惠-${number}" class="ext-preferentials-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->	
                </c:forEach>
                </c:if>
            </div><!--主体-->
            <div class="box-footer">
            	<div class="col-sm-offset-1 col-sm-11">
                	<button id="submit" class="btn btn-primary margin-r-5" type="button"> 保 存 </button>
                </div>
            </div><!-- 脚步 -->
        </div>
      </div><!-- /.row -->
        
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="container-footer.jsp"%>
<script>
	$(function() {
		$("#submit").click(function(e) {
			var $input = $("input[id^='ext-']");
			var params = {};
			var request = {};
			$input.each(function() {
				var value = $(this).val();
				var $id = $(this).attr("name");
				if (value == null) {
					request[$id] = "";
				} else {
					request[$id] = value;
				}
			});
			params["requestJson"] = JSON.stringify(request);
			console.info(params);
			$.ajax({
				url: "/preferential",
				data: params,
				type: "post",
				success: function(msg) {
					console.info("请求发送成功...");
					window.location.href = "/preferential?page=1&size=25"
				},
				error: function() {
					console.error("请求发送失败...");
				}
			});
			
		});
	});
</script>
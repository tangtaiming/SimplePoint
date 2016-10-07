<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="container-head.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        店铺状态
        <small>店铺状态</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">编辑店铺状态</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->
	  <div class="box box-info">
        <form class="form-horizontal" action="/store/${store.id}" method="post">
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="title">标题:</label>
                    <div class="col-sm-5">
                    	${store.name}
                    </div>
                    <div class="col-sm-5"><p title="标题" class="ext-title-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->  
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="status">状态:</label>
                    <div class="col-sm-5">
                    	<select name="status" class="form-control">
                    		<c:forEach items="${statusSelect}" var="status">
                    			<option value="${status.key}" ${status.value[0]}>${status.value[1]}</option>
                    		</c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-5">
                        <p class="control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 --> 
            </div><!--主体-->
            <div class="box-footer">
            	<div class="col-sm-offset-1 col-sm-11">
					<input type="hidden" name="id" value="${store.id}" />
					<input type="hidden" name="webType" value="editStatus" />
                	<button class="btn btn-primary margin-r-5" type="submit"> 保 存 </button>
                    <button class="btn btn-primary" type="reset"> 重 置 </button>
                </div>
            </div><!-- 脚步 -->
        </form>
      </div><!-- /.row -->
        
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@include file="../buju/script.jsp"%>

<%@include file="../buju/container-footer-2.jsp"%>
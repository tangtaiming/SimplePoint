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
        <form class="form-horizontal" action="/preferential" method="post">
            <div class="box-body">
            	
            	<div class="form-group">
                    <label class="col-sm-2 control-label" for="name">名称:</label>
                    <div class="col-sm-5">
                    	<input id="name" name="name" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="名称" class="ext-name-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="url">请求url:</label>
                    <div class="col-sm-5">
                    	<textarea id="url" name="url" class="form-control" placeholder="/store?p1=reviewScores_ge_0&p2=distributionCost_eq_0&page=50&size=1&sort=desc&sortName=updateDate=50&size=1" need="need"></textarea>
                    </div>
                    <div class="col-sm-5">
                        <p title="请求url" class="ext-url-error control-p text-red" style="word-wrap:break-word;">/store?p1=reviewScores_ge_0&p2=distributionCost_eq_0&page=50&size=1&sort=desc&sortName=updateDate=50&size=1</p>
                    </div>
                </div><!--- 一行结束 -->
            	<div class="form-group">
            		<label class="col-sm-2 control-label" for="url"></label>
                    <label class="col-sm-10 control-label" for="url">
                    	<p class="row">
                    	<c:forEach items="${stromMap}" var="stromName">
							<span class="col-sm-3 text-left">${stromName.key}-${stromName.value}</span>                    	 	
                    	</c:forEach>
                    	</p>
                    </label>
                </div><!--- 一行结束 -->
            </div><!--主体-->
            <div class="box-footer">
            	<div class="col-sm-offset-1 col-sm-11">
                	<button id="submit" class="btn btn-primary margin-r-5" type="submit"> 保 存 </button>
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
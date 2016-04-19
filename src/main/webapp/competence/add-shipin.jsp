<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        视频外链管理
        <small>管理视频外链-基本信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">视频外链</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->
	  <div class="box box-info">
        <form class="form-horizontal" action="/shipin" enctype="multipart/form-data" method="post">
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="title">标题:</label>
                    <div class="col-sm-5">
                    	<input id="title" name="title" class="form-control" type="text" placeholder="不能为空" need="need" />
                    </div>
                    <div class="col-sm-5">
                        <p title="标题" class="ext-title-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->  
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="url">url:</label>
                    <div class="col-sm-5">
                    	<textarea id="url" name="url" class="form-control" need="need"></textarea>
                    </div>
                    <div class="col-sm-5">
                        <p title="url" class="ext-url-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 --> 
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="file">img:</label>
                    <div class="col-sm-5">
                    	<input class="form-control" name="file" type="file" />
                    </div>
                    <div class="col-sm-5">
                        <p class="control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 --> 
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="mark">标识:</label>
                    <div class="col-sm-5">
                    	<select name="mark" class="form-control">
                    		<option value="0">0</option>
                        	<option value="1">1</option>
                        </select>
                    </div>
                    <div class="col-sm-5">
                        <p class="control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 --> 
            </div><!--主体-->
            <div class="box-footer">
            	<div class="col-sm-offset-1 col-sm-11">
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
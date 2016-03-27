<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      新增URL
      <small>管理爬虫地址-美团/饿了麽地址信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li class="active">爬虫地址管理</li>
      <li class="active">新增URL</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
 <div class="box box-info">
      <form class="form-horizontal" action="">
          <div class="box-body">
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="sortId">URL:</label>
                  <div class="col-sm-5">
                  	<textarea id="url" class="form-control"></textarea>
                  </div>
                  <div class="col-sm-5">
                      <p class="control-p text-red">URL 不能为空</p>
                  </div>
              </div><!--- 一行结束 -->               
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="sortTypeId">所属平台:</label>
                  <div class="col-sm-5">
                     <div class="checkbox">
                          <label class="margin-r-5">
                              <input id="sortTypeId1" type="checkbox" name="sortTypeId">
                              美团
                          </label>
                          <label>
                              <input id="sortTypeId2" type="checkbox" name="sortTypeId">
                              饿了麽
                          </label>
                      </div>
                  </div>
              </div><!--- 一行结束 -->
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="schoolId">学校:</label>
                  <div class="col-sm-5">
                      <select id="schoolId" class="form-control">
                      	<option>湖南工学院</option>
                          <option>湘潭大学</option>
                          <option>湖南大学</option>
                          <option>深圳大学</option>
                      </select>
                  </div>
              </div><!--- 一行结束 -->
          </div>
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


<%@include file="container-footer.jsp"%>
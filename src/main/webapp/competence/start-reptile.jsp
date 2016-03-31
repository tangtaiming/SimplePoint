<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      开启爬虫
      <small>管理爬虫地址-美团/饿了麽地址信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li>URL列表</li>
      <li class="active">开启爬虫</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
    <div class="row">
    	 <div class="col-sm-6">
       	<div class="box">
          	<div class="box-body">
              	<div class="row">
                  	<div class="col-sm-3">
                      	<a class="btn btn-app" href="/reptile/${reptile.id}/start?type=open">
                              <i class="fa fa-play"></i>
                              Play
                        </a>
                      </div>
                      <div class="col-sm-9">
                      	<div style="height:55px;">
                          	开启爬虫地址: ${reptile.url}
                          </div>
                          <div>
                          	开启状态:<span class="result">${reptileStatus}</span>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
       </div>
    </div>  
    
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@include file="container-footer.jsp"%>
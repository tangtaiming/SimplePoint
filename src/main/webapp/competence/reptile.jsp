<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      URL列表
      <small>管理爬虫地址-美团/饿了麽地址信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li class="active">URL列表</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
  <div class="row">
    	<div class="col-xs-12">
      	<div class="box">
          	<div class="box-header">
                  <h3 class="box-title"><a href="add-reptile.html"><span class="label label-primary">新增</span></a></h3>
                  <div class="box-tools">
                  	<div class="input-group input-group-sm" style="width: 150px;">
                      	<input class="form-control pull-right" type="text" placeholder="Search" name="table_search">
                          <div class="input-group-btn">
                              <button class="btn btn-default" type="submit">
                              	<i class="fa fa-search"></i>
                              </button>
                          </div>
                      </div>
                  </div>
              </div><!-- 头部操作 -->
              <div class="box-body table-responsive">
              	<!-- 设置表格不换号显示 -->
			<style>
                    	.table-responsive > .table > tbody > tr > td, .table-responsive > .table > tbody > tr > th, .table-responsive > .table > tfoot > tr > td, .table-responsive > .table > tfoot > tr > th, .table-responsive > .table > thead > tr > td, .table-responsive > .table > thead > tr > th {
    white-space: nowrap;
}
                    </style>
              	<table class="table table-hover table-bordered">
                  	<tbody>
                      	<tr>
                          	<th>
                              	<input type="checkbox" name="sortAll" />
                              </th>
                              <th>操作</th>
                              
                          	<th>ID</th>
                              <th>URL</th>
                              <th>创建人</th>
                              <th>创建时间</th>
                              <th>所属平台</th>
                              <th>所属学校</th>
                          </tr>
                          <tr>
                          	<td>
                              	<input type="checkbox" name="sort-110" />
                              </td>
                              <td>
                              	  <a href="#">
                                  	<span class="label label-primary">开启爬虫</span>
                                  </a>
                              	  <a href="#">
                                  	<span class="label label-primary">编辑</span>
                                  </a>
                                  <a href="#">
                                  	<span class="label label-danger">删除</span>
                                  </a>
                              </td>
                              
                              <td>110</td>
                              <td>http://waimai.meituan.com/home/wsb0uwk955j8</td>
                              <td>唐太明</td>
                              <td>2016-03-24 00:00:00</td>
                              <td>美团</td>
                              <th>湖南高速铁路职业技术学院</th>
                          <tr>
                          	<td></td>
                              <td></td>
                              
                          	<td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                          </tr>
                      </tbody>
                  </table>
              </div><!-- 内容数据结束 -->
              <div class="box-footer clearfix">
                  <div class="row">
                  	<div class="col-xs-6">
                          <div class="dataTables_length">
                              <label>
                              	页数 当前第 1 页 - 总共 10 页，每页显示
                                  <select class="form-control input-sm" name="example1_length" aria-controls="example1">
                                      <option value="10">10</option>
                                      <option value="25">25</option>
                                      <option value="50">50</option>
                                      <option value="100">100</option>
                                  </select>
                                  数量
                              </label>
                          </div>
                      </div>
                      <div class="col-xs-6">
                      	<ul class="pagination pagination-sm no-margin pull-right">
                              <li class="disabled">
                                  <a href="#">«</a>
                              </li>
                              <li class="active">
                                  <a href="#">1</a>
                              </li>
                              <li>
                                  <a href="#">2</a>
                              </li>
                              <li>
                                  <a href="#">3</a>
                              </li>
                              <li>
                                  <a href="#">4</a>
                              </li>
                              <li>
                                  <a href="#">5</a>
                              </li>
                              <li>
                                  <a href="#">»</a>
                              </li>
                          </ul>
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
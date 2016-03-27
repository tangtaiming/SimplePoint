<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="container-head.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      学校管理
      <small>管理学校-基本信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li class="active">学校管理</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
 <div class="row">
    	<div class="col-xs-12">
      	<div class="box">
          	<div class="box-header">
                  <h3 class="box-title"><a href="/school"><span class="label label-primary">新增</span></a></h3>
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
                              <th>学校名称</th>
                              <th>学校代码</th>
                              <th>创建人</th>
                              <th>创建时间</th>
                          </tr>
                          <c:forEach items="${schoolsList}" var="school">
                          <tr>
                        	  <td>
                            	<input type="checkbox" name="school-${school.id}" />
                              </td>
                              <td>
                              	<a href="#">
                                  	<span class="label label-primary">编辑</span>
                                  </a>
                                  <a class="school-delete-${school.id}" title="${school.name}" href="/school/${school.id}">
                                  	<span class="label label-danger">删除</span>
                                  </a>
                              </td>
                              <td>${school.id}</td>
                              <td>${school.name}</td>
                              <td>${school.code}</td>
                              <td>
                              <c:if test="${school.creatdId==1}">唐太明</c:if>
                              </td>
                              <td>${school.creatdDate}</td>
                          </tr>	
                          </c:forEach>
<!--                           <tr> -->
<!--                           	<td> -->
<!--                               	<input type="checkbox" name="sort-110" /> -->
<!--                               </td> -->
<!--                               <td> -->
<!--                               	<a href="#"> -->
<!--                                   	<span class="label label-primary">编辑</span> -->
<!--                                   </a> -->
<!--                                   <a href="#"> -->
<!--                                   	<span class="label label-danger">删除</span> -->
<!--                                   </a> -->
<!--                               </td> -->
                              
<!--                               <td>110</td> -->
<!--                               <td>湖南工学院</td> -->
<!--                               <td>10010</td> -->
<!--                               <td>唐太明</td> -->
<!--                               <td>2016-03-24 00:00:00</td> -->
<!--                           </tr> -->
                          <tr>
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
    <div class="hidden">
    	<form class="school-rest" action="" method="POST">
    		<input type="hidden" name="_method" value="DELETE"/>
    	</form>
    </div>
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@include file="container-footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("a[class^='school-delete-']").click(function(e) {
			var $title = $(this).attr("title");
			if (confirm("确定删除 " + $title + "?")) {
				var href = $(this).attr("href");
				$(".school-rest").attr("action", href).submit();
				return false;
			} else {
				//取消事件操作
				e.preventDefault();
			}
		});
	});
</script>
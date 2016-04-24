<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  <div class="row">
      	<div class="col-xs-12">
        	<div class="box">
            	<div class="box-header">
                    <h3 class="box-title"><a href="/shipin?type=s"><span class="label label-primary">新增</span></a></h3>
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
                                <th>标题</th>
                                <th>url</th>
                                <th>图片名称</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                            </tr>
                            <c:forEach items="${shiPinsList}" var="shipin">
                            <tr>
                            	<td>
                                	<input type="checkbox" name="shipin-${shipin.id}" />
                                </td>
                                <td>
                                	<a href="#">
                                    	<span class="label label-primary">编辑</span>
                                    </a>
                                    <a href="javascript:;" data-href="/shipin/${shipin.id}" class="entity-delete-${shipin.id}" title="${shipin.title}">
                                    	<span class="label label-danger">删除</span>
                                    </a>
                                </td>
                                
                                <td>${shipin.id}</td>
                                <td>${shipin.title}</td>
                                <td><a alt="url地址" href="${shipin.url}" target="_blank">查看</a></td>
                                <td><a alt="图片" href="/images/upload/${shipin.img}" target="_blank">查看</a></td>
                                <td><c:if test="${shipin.creatdId==1}">唐太明</c:if></td>
                                <td>${shipin.creatdDate}</td>
                            </tr>
                            </c:forEach>
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
                              	页数 当前第 ${page.pageNumber}页 - 总共 ${page.totalPage}页，每页显示
                                  <c:choose>
                                  	<c:when test="${page.pageSize==10}">
                                  		<c:set var="select_10" value="selected='selected'" scope="request" />
                                  	</c:when>
                                  	<c:when test="${page.pageSize==25}">
                                  		<c:set var="select_25" value="selected='selected'" scope="request" />
                                  	</c:when>
                                  	<c:when test="${page.pageSize==50}">
                                  		<c:set var="select_50" value="selected='selected'" scope="request" />
                                  	</c:when>
                                  	<c:when test="${page.pageSize==100}">
                                  		<c:set var="select_100" value="selected='selected'" scope="request" />
                                  	</c:when>
                                  </c:choose>
                                  <select class="form-control input-sm" name="size_length_safety" aria-controls="example1">
                                      <option value="/shipin?page=1&size=10" option-data="10" ${select_10}>10</option>
                                      <option value="/shipin?page=1&size=25" option-data="25" ${select_25}>25</option>
                                      <option value="/shipin?page=1&size=50" option-data="50" ${select_50}>50</option>
                                      <option value="/shipin?page=1&size=100" option-data="100" ${select_100}>100</option>
                                  </select>
                                  数量
                              </label>
                              
                              
                            </div>
                        </div>
                        <div class="col-xs-6">
                        	<ul class="pagination pagination-sm no-margin pull-right">
                                <c:if test="${page.previous==true}">
                              <li>
                                  <a href="/shipin?page=${page.pageNumber-1}&size=${page.pageSize}">«</a>
                              </li>
                              </c:if>
                              <c:if test="${page.previous==false}">
                              <li class="disabled">
                                  <a href="javascript:;">«</a>
                              </li>
                              </c:if>
                                
                              <c:forEach items="${showPage}" var="sp">
                           	  <c:choose>
                           	  	<c:when test="${sp==page.pageNumber}">
                           	  	  <c:set var="active" value="class='active'" scope="request" />
                           	  	  <c:set var="href" value="" scope="request" />
                           	  	</c:when>
                           	  	<c:otherwise>
                           	  	  <c:set var="active" value="" scope="request" />
                           	  	  <c:set var="href" value="href='/shipin?page=${sp}&size=${page.pageSize}'" scope="request" />
                           	  	</c:otherwise>
                           	  </c:choose>
                           	  
                           	  <li ${active}>
                                <a ${href}>${sp}</a>
                              </li>
                           	</c:forEach>
                                
                                
                              <c:if test="${page.next==true}">
							  <li>
                                  <a href="/shipin?page=${page.pageNumber+1}&size=${page.pageSize}">»</a>
                              </li>
							  </c:if>
							  <c:if test="${page.next==false}">
							  <li class="disabled">
                                  <a href="javascript:;">»</a>
                              </li>
							  </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>
      <div class="hidden">
    	<form class="entity-rest" action="" method="POST">
    		<input type="hidden" name="_method" value="DELETE"/>
    	</form>
      </div>  
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@include file="../buju/script-liebiao.jsp"%>
<%@include file="../buju/container-footer-2.jsp"%>
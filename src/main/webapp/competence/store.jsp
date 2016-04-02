<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="container-head.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      店铺列表
      <small>管理店铺数据-美团/饿了麽店家信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li class="active">店铺列表</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
 <div class="row">
    	<div class="col-xs-12">
      	<div class="box">
          	<div class="box-header">
                  <h3 class="box-title"><a href="add-starter.html"><span class="label label-primary">新增</span></a></h3>
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
                              
                              <th width="250">店铺ID</th>
                              <th>学校</th>
                              <th width="550">店名</th>
                              <th>评分</th>
                              <th>销售量(月)</th>
                              
                              <th>销售量(总)</th>
                              <th>起送价格</th>
                              <th>配送费</th>
							  <th>送餐所需时间</th>
                              <th>送餐到达率</th>
                              
                              <th>收藏数量</th>
                              <th>营业时间</th>
                              <th>地址</th>
                              <th>电话</th>
                              <th>url</th>
                              
                              <th>店铺是否关闭</th>
							  <th>店铺属于公司</th>
                              <th>首单优惠</th>
                              <th>减免</th>
                              <th>达到就送</th>
                              
                              <th>创建人</th>
                              <th>创建时间</th>
                              <th>修改时间</th>
                          </tr>
                          <c:forEach items="${storesList}" var="store">
                          <tr>
                          	<td>
                              	<input type="checkbox" name="sort-${store.id}" />
                              </td>
                              <td>
                              	<a href="#">
                                  	<span class="label label-primary">编辑</span>
                                  </a>
                                  <a class="store-delete-${store.id}"  title="${store.name}"  href="/store/${store.id}">
                                  	<span class="label label-danger">删除</span>
                                  </a>
                              </td>
                              
                              <td>${store.storeId}</td>
                              <td>
                              	${store.schoolId.name}
                              </td>
                              <td>${store.name}</td>
                              <td>
                              	<c:if test="${store.reviewScores==null}">
                              		0
                              	</c:if>
                              	<c:if test="${store.reviewScores!=null}">
                              		${store.reviewScores}
                              	</c:if>
                              </td>
                              <td>${store.salesQuantity}</td>
                              
                              <td>
                              	<c:if test="${store.salesAllQuantity==null}">0</c:if>
                              	<c:if test="${store.salesAllQuantity!=null}">${store.salesAllQuantity}</c:if>
                              </td>
                              <td>${store.sendThePrice} 元</td>
                              <td>${store.distributionCost} 元</td>
                              <td>${store.shopHours} 分钟</td>
                              <td>
                              	<c:if test="${store.shoprReach==null}">
                              		暂无
                              	</c:if>
                              	<c:if test="${store.shoprReach!=null}">
                              		${store.shoprReach} %
                              	</c:if>
                              </td>
                              
                              <td>${store.collectQuantity}</td>
                              <td>${store.businessDate}</td>
                              <td>${store.address}</td>
                              <td>${store.phone}</td>
                              <td>${store.url}</td>
                              
                              <td>
                              	<c:if test="${store.status==1}">正常</c:if>
                              	<c:if test="${store.status!=1}">其他</c:if>
                              </td>
                              <td>
                              	<c:if test="${store.sortTypeId==1}">美团</c:if>
                              	<c:if test="${store.sortTypeId==2}">饿了么</c:if>
                              </td>
                              <td>
                              	${store.firstOrder}
                              </td>
                              <td>
                              	${store.minusExempt}
                              </td>
                              <td>
                              	${store.give}
                              </td>
                              <td>
                              	<c:if test="${store.creatdId==1}">唐太明</c:if>
                              	<c:if test="${store.creatdId==0}">系统</c:if>
                              </td>
                              <td>
                              	${store.creatdDate}
                              </td>
                              <td>
                              	${store.updateDate}
                              </td>
                          </tr><!-- 一条数据结束 -->
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
                              <td></td>
                              <td></td>
                              
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              <td></td>
                              
                              <td></td>
                              <td></td>
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
                                  <select class="form-control input-sm" name="size_length_store" aria-controls="example1">
                                      <option value="/store?page=1&size=10" option-data="10" ${select_10}>10</option>
                                      <option value="/store?page=1&size=25" option-data="25" ${select_25}>25</option>
                                      <option value="/store?page=1&size=50" option-data="50" ${select_50}>50</option>
                                      <option value="/store?page=1&size=100" option-data="100" ${select_100}>100</option>
                                  </select>
                                  数量
                              </label>
                          </div>
                      </div>
                      <div class="col-xs-6">
                      	<ul class="pagination pagination-sm no-margin pull-right">
                              <c:if test="${page.previous==true}">
                              <li>
                                  <a href="/store?page=${page.pageNumber-1}&size=${page.pageSize}">«</a>
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
                           	  	  <c:set var="href" value="href='/store?page=${sp}&size=${page.pageSize}'" scope="request" />
                           	  	</c:otherwise>
                           	  </c:choose>
                           	  
                              <li ${active}>
                                <a ${href}>${sp}</a>
                              </li>
	                          </c:forEach>
                              
                              
                              <c:if test="${page.next==true}">
							  <li>
                                  <a href="/store?page=${page.pageNumber+1}&size=${page.pageSize}">»</a>
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
    	<form class="store-rest" action="" method="POST">
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
		$("a[class^='store-delete-']").click(function(e) {
			var $title = $(this).attr("title");
			if (confirm("确定删除 " + $title + "?")) {
				var href = $(this).attr("href");
				$(".store-rest").attr("action", href).submit();
				return false;
			} else {
				//取消事件操作
				e.preventDefault();
			}
		});
		
		$("select[name^='size_length_']").change(function() {
			var $href = $(this).val();
			console.info("url:" + $href);
			$("input[name='_method']").val("GET");
			$(".store-rest").attr("action", $href).submit();
		});
	});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                              
                          	<th width="50">ID</th>
                              <th width="250">店铺ID</th>
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
                          </tr>
                          <tr>
                          	<td>
                              	<input type="checkbox" name="sort-110" />
                              </td>
                              <td>
                              	<a href="#">
                                  	<span class="label label-primary">编辑</span>
                                  </a>
                                  <a href="#">
                                  	<span class="label label-danger">删除</span>
                                  </a>
                              </td>
                              
                              <td>110</td>
                              <td>34341</td>
                              <td>麦多基（米饭，汉堡，小吃）</td>
                              <td>4.6</td>
                              <td>0</td>
                              
                              <td>4176</td>
                              <td>20元</td>
                              <td>0元</td>
                              <td>36分钟</td>
                              <td>0</td>
                              
                              <td>226</td>
                              <td>09:00-22:30</td>
                              <td>师范学院对面</td>
                              <td>0734-2588729/13307472833</td>
                              <td>http://waimai.meituan.com/restaurant/34341?pos=2</td>
                              
                              <td>-1</td>
                              <td>美团</td>
                              <td>新用户首次下单,立减4元<span class="special">(手机客户端专享)</span></td>
                              <td>满20元减1元<span class="special">(手机客户端专享)</span></td>
                              <td>--</td>
                          </tr><!-- 一条数据结束 -->
                          <tr>
                          	<td>
                              	<input type="checkbox" name="sort-110" />
                              </td>
                              <td>
                              	<a href="#">
                                  	<span class="label label-primary">编辑</span>
                                  </a>
                                  <a href="#">
                                  	<span class="label label-danger">删除</span>
                                  </a>
                              </td>
                              
                              <td>110</td>
                              <td>34341</td>
                              <td>麦多基（米饭，汉堡，小吃）</td>
                              <td>4.6</td>
                              <td>0</td>
                              
                              <td>4176</td>
                              <td>20元</td>
                              <td>0元</td>
                              <td>36分钟</td>
                              <td>0</td>
                              
                              <td>226</td>
                              <td>09:00-22:30</td>
                              <td>师范学院对面</td>
                              <td>0734-2588729/13307472833</td>
                              <td>http://waimai.meituan.com/restaurant/34341?pos=2</td>
                              
                              <td>-1</td>
                              <td>美团</td>
                              <td>新用户首次下单,立减4元<span class="special">(手机客户端专享)</span></td>
                              <td>满20元减1元<span class="special">(手机客户端专享)</span></td>
                              <td>--</td>
                          </tr><!-- 一条数据结束 -->
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
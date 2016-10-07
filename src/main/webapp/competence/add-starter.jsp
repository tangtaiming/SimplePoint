<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>
<%@taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
                        店铺管理
        <small>店铺管理-基本信息</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">新增店铺</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->
	  <div class="box box-info">
	  	<from:form modelAttribute="store" action="/storeToIn" method="post" cssClass="form-horizontal">
	  		<div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="sortId">店铺ID:</label>
                    <div class="col-sm-5">
                        <input id="sortId" name="store.storeId" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="店铺ID" class="ext-sortId-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="store">店名:</label>
                    <div class="col-sm-5">
                    	<from:input path="name" cssClass="form-control" placeholder="不能为空" need="need"/>
                    </div>
                    <div class="col-sm-5">
                        <p title="店名" class="ext-store-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="reviewScores">评分:</label>
                    <div class="col-sm-5">
                        <input id="reviewScores" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="评分"  class="ext-reviewScores-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="salesAllQuantity">销售量(总):</label>
                    <div class="col-sm-5">
                        <input id="salesAllQuantity" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="销售量(总)"  class="ext-salesAllQuantity-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="sendThePrice">起送价格:</label>
                    <div class="col-sm-5">
                        <input id="sendThePrice" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="起送价格" class="ext-sendThePrice-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="distributionCost">配送费用:</label>
                    <div class="col-sm-5">
                        <input id="distributionCost" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="配送费用" class="ext-distributionCost-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="shopHours">送餐时间:</label>
                    <div class="col-sm-5">
                        <input id="shopHours" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="送餐时间" class="ext-shopHours-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="shopReach">送餐及时率:</label>
                    <div class="col-sm-5">
                        <input id="shopReach" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="送餐及时率" class="ext-shopReach-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="collectQuantity">收藏数量:</label>
                    <div class="col-sm-5">
                        <input id="collectQuantity" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="收藏数量" class="ext-collectQuantity-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="businessDate">营业时间:</label>
                    <div class="col-sm-5">
                        <input id="businessDate" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="营业时间" class="ext-businessDate-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="address">地址:</label>
                    <div class="col-sm-5">
                        <textarea id="address" class="form-control"></textarea>
                    </div>
                    <div class="col-sm-5">
                        <p class="control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="phone">电话:</label>
                    <div class="col-sm-5">
                        <input id="phone" class="form-control" type="text" placeholder="不能为空" need="need">
                    </div>
                    <div class="col-sm-5">
                        <p title="电话" class="ext-phone-error control-p text-red"></p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="url">url:</label>
                    <div class="col-sm-5">
                    	<textarea id="url" class="form-control"></textarea>
                    </div>
                    <div class="col-sm-5">
                        <p class="control-p text-red">url 不能为空</p>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="status">店铺状态:</label>
                    <div class="col-sm-10">
                        <div class="radio">
                            <label class="margin-r-5">
                                <input id="status1" type="radio" name="status">
                                开
                            </label>
                            <label>
                                <input id="status2" type="radio" name="status">
                                关
                            </label>
                        </div>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="sortTypeId">类型:</label>
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
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="firstOrder">首单优惠:</label>
                    <div class="col-sm-5">
                    	<textarea id="firstOrder" class="form-control"></textarea>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="minusExempt">减免:</label>
                    <div class="col-sm-5">
                    	<textarea id="minusExempt" class="form-control"></textarea>
                    </div>
                </div><!--- 一行结束 -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="give">达到就送:</label>
                    <div class="col-sm-5">
                    	<textarea id="give" class="form-control"></textarea>
                    </div>
                </div><!--- 一行结束 -->
            </div>
            <div class="box-footer">
            	<div class="col-sm-offset-1 col-sm-11">
                	<button class="btn btn-primary margin-r-5" type="submit"> 保 存 </button>
                    <button class="btn btn-primary" type="reset"> 重 置 </button>
                </div>
            </div><!-- 脚步 -->
	  	</from:form>
        <form class="form-horizontal" action="/storeToIn" method="post">
            
        </form>
      </div><!-- /.row -->
        
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- /.content-wrapper -->
<%@include file="../buju/script.jsp"%>

<%@include file="../buju/container-footer-2.jsp"%>
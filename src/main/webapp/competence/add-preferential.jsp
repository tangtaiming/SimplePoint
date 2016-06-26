<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
							<input id="name" name="name" class="form-control" type="text"
								placeholder="不能为空" need="need" data-en="add-entity"
								value="${preferential.name}" />
						</div>
						<div class="col-sm-5">
							<p title="名称" class="ext-name-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group">
						<label class="col-sm-2 control-label" for="schoolId">学校:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-5">
									<select id="schoolId" class="form-control" name="schoolId"
										data-en="add-entity">
										<option value="1">湖南工学院</option>
										<option value="2">衡阳师范学院</option>
									</select>
								</div>
								<div class="col-xs-7"></div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="评分" class="ext-mark-error control-p text-red"></p>
						</div>
					</div>
					<!-- 一行结束 -->

					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="mark">评分:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="mark" type="checkbox" name="fix" value="mark"
										data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" value="${mlist.value}" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="评分" class="ext-mark-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="salesQuantity">销售量:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="salesQuantity" type="checkbox" name="fix"
										value="salesQuantity" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="销售量" class="ext-salesQuantity-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="sendThePrice">起送价格:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="sendThePrice" type="checkbox" name="fix"
										value="sendThePrice" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="起送价格" class="ext-sendThePrice-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="distributionCost">配送费:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="distributionCost" type="checkbox" name="fix"
										value="distributionCost" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="配送费"
								class="ext-distributionCost-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="shopHours">送餐所需时间:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="shopHours" type="checkbox" name="fix"
										value="shopHours" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="送餐所需时间" class="ext-shopHours-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="shoprReach">送餐到达率:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="shoprReach" type="checkbox" name="fix"
										value="shoprReach" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="送餐到达率" class="ext-shoprReach-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="collectQuantity">收藏数量:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="collectQuantity" type="checkbox" name="fix"
										value="collectQuantity" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="收藏数量"
								class="ext-collectQuantity-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="businessDate">营业时间:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="businessDate" type="checkbox" name="fix"
										value="businessDate" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="营业时间" class="ext-businessDate-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="phone">电话:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="phone" type="checkbox" name="fix" value="phone"
										data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="电话" class="ext-phone-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="firstOrder">首单优惠:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="firstOrder" type="checkbox" name="fix"
										value="firstOrder" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="首单优惠" class="ext-firstOrder-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="minusExempt">减免:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="minusExempt" type="checkbox" name="fix"
										value="minusExempt" data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="减免" class="ext-minusExempt-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
					<div class="form-group" data-group="url-group">
						<label class="col-sm-2 control-label" for="give">达到就送:</label>
						<div class="col-sm-5">
							<div class="row">
								<div class="col-xs-1">
									<input id="give" type="checkbox" name="fix" value="give"
										data-en="add-entity-fix" />
								</div>
								<div class="col-xs-4">
									<select class="form-control" name="sign" data-en="add-entity-sign"
										data-change="change">
										<option value="gt">大于</option>
										<option value="not">不为空</option>
									</select>
								</div>
								<div class="col-xs-7">
									<input class="form-control" type="text" name="value"
										data-en="add-entity-value" />
								</div>
							</div>
						</div>
						<div class="col-sm-5">
							<p title="达到就送" class="ext-give-error control-p text-red"></p>
						</div>
					</div>
					<!--- 一行结束 -->
				</div>
				<!--主体-->
				<div class="box-footer">
					<div class="col-sm-offset-1 col-sm-11">
						<input type="hidden" name="id" value="${preferential.id}" />
						<button id="submit" class="btn btn-primary margin-r-5"
							type="button">保 存</button>
						<button class="btn btn-primary" type="reset">重 置</button>
					</div>
				</div>
				<!-- 脚步 -->
			</form>
		</div>
		<!-- /.row -->

	</section>
	<!-- /.content -->
	<c:if test="${requestScope.mList!=null}">
		<div id="requestJson" style="display: none">${requestScope.mList}</div>
	</c:if>
</div>
<!-- /.content-wrapper -->
<!-- jQuery 2.2.0 -->
<script src="/js/jQuery-2.2.0.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/js/app.min.js"></script>
<script>
$.extend({
	myAjax : function ( url, params, method ) {
		$.ajax({
			url : url,
			data : params,
			type : method,
			contentType : "application/json",
			success : function( trancationResponse ) {
				//console.info("^^^^^^^^^^^^^^" + trancationResponse);
				var requestJson = JSON.parse(trancationResponse);
				var url = requestJson.data;
				var code = requestJson.code;
				var msg = requestJson.msg;
				$.initShow(msg);
				if (Number(code) == 1) {
					var fun = "$.successRedirect(\"" + url + "\")";
					//console.log(fun);
					setTimeout(fun, 5000);
				} else {
					setTimeout("$.initHide()", 5000);
				}
			},
			error : function() {
				$.initShow("请求失败!");
				setTimeout("$.initHide()", 5000);
			}	
		});
	},
	removeNext : function(obj) {
		var $thisSelect = obj;
		var $removeText, $value, $index, $option;
		
		$index = $thisSelect[0].selectedIndex;
		$option = $thisSelect[0].options[$index];
		$value = $option.value;
		$removeText = $thisSelect.parent("div").next("div").first();
		if ($value == "gt") {
			$removeText.show();	
		} else {
			$removeText.hide();	
		}
	},
	editRow : function () {
		var $requestObj = $("#requestJson");
		if ($requestObj.size() <= 0) {
			console.info("新建页面");
			return;
		}
		var $requestJson = JSON.parse($requestObj.text());
		
		console.info($requestJson);
		
		for (var x = 0; x < $requestJson.length; x++) {
			var $inputFix, $selectSign, $inputValue, $en, $in;
			var $sel, $inv;
			$en = $requestJson[x];
			$inputFix = $en.name;
			$selectSign = $en.sign;
			if ($selectSign == "gt") {
				$inputValue = $en.value;
			}
			
			$in = $("#" + $inputFix);
			if ($in.size() <= 0) {
				continue;
			}
			$sel = $in.parent().next().children(".form-control");
			$inv = $in.parent().next().next().children(".form-control");
			
			$in[0].checked = true;
			for (var y = 0; y < $sel[0].options.length; y++) {
				var $option, $selVal;
				$option = $sel[0].options[y];
				$selVal = $option.value;
				if ($selVal == $selectSign) {
					$option.selected = true;
				}
			}
			
			if ($selectSign == "gt") {
				$inv.parent().show();
				$inv.val($inputValue);
			} else {
				$inv.parent().hide();
			}
			console.info($in.size());
		}
	},
	initShow : function( content ) {
		$("#prompt-content").html(content);
		$("#nav-popup").show();	
	},
	initHide : function () {
		$("#nav-popup").fadeOut(5000);
	},
	successRedirect : function ( url ) {
		//请求成功并且进行跳转
		$.initHide();
		window.location.href = url;
	}
});

$("document").ready(function() {
	
	$.editRow();
	
	$('select[data-change="change"]').change(function() {
		$.removeNext($(this));
	});
	
	$("#submit").click(function() {
		var url, method;
		url = "/preferential";
		method = "post";
		
		var $val = {};
		var $params = new Array();
		var $url, $id, $schoolId, $name;
		
		var $naObj, $na, $value, $selObj, $selValue, $optionObj ,$optionVal, $optionIndex, $schoolParams;
		//优惠名称
		$naObj = $("#name");
		$na = $naObj.attr("name");
		$value = $naObj.val();
		$val[$na] = $value;
		
		//优惠条件 学校
		$selObj = $("#schoolId");
		$selValue = $selObj.attr("name");
		$optionIndex = $selObj[0].selectedIndex;
		$optionObj = $selObj[0].options[$optionIndex];
		$optionVal = $optionObj.value;
		//$val[$selValue] = $optionVal;
		$schoolParams = $selValue + "_eq_" + $optionVal;
		$params.push($schoolParams);
		
		//获取添加数据行数
		var $fromEle = $(".form-horizontal").find("div[data-group='url-group']");
		//遍历行
		$fromEle.each(function( index, el) {
			var $valR = {};
			//console.log( index + ": " + el.nodeName);
			var $rows;
			var $index = 0;	//索引位置 0
			var $rowKeyObj, $rowSignObj, $rowValueObj;
			var $rowKeyObjChecked, $rowKeyObjValue, $rowSignObjOption, $rowSignObjIndex, $rowSignObjOptionValue, $rowValueObj
			
			//拼凑参数
			var $mP;
			
			$rowKey = $($fromEle[index]).find("input[data-en='add-entity-fix']");
			$rowSignObj = $($fromEle[index]).find("select[data-en='add-entity-sign']");	
			$rowValueObj = $($fromEle[index]).find("input[data-en='add-entity-value']");
			$rowKeyObjChecked = $rowKey[$index].checked;
			if ($rowKeyObjChecked) {
				$rowKeyObjValue = $rowKey.val();
				
				$rowSignObjIndex = $rowSignObj[$index].selectedIndex;
				$rowSignObjOption = $rowSignObj[$index].options[$rowSignObjIndex];
				$rowSignObjOptionValue = $rowSignObjOption.value;
				if ($rowSignObjOptionValue == "gt") {
					$rowValueObj = $rowValueObj.val();
					$mP = $rowKeyObjValue + "_" + $rowSignObjOptionValue + "_" + $rowValueObj;
				} else {
					$mP = $rowKeyObjValue + "_" + $rowSignObjOptionValue;
				}
				$params.push($mP);
			}
		});
		
		if (($params.length - 1) >= 3 || ($params.length - 1) <= 0) {
			$.initShow("选择参数小于 1 或者 大于 3");
			setTimeout("$.initHide()", 1000);
			return;
		}
		
// 		$val["requestJson"] = $params;
		var urlParams = "";
		for (var x = 0; x < $params.length; x++) {
			var temp = "";
			if (x == 0 || x == $params.length) {
				temp = "p" + (x + 1) + "=" + $params[x];
			} else {
				temp = "&p" + (x + 1) + "=" + $params[x];
			}
			urlParams += temp;
		}
		
		$val["url"] = urlParams;
		console.info($val);
		$.myAjax(url, JSON.stringify($val), method);
	});
	
});
</script>

<%@include file="../buju/container-footer-2.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <form class="form-horizontal" action="/reptile" method="post">
          <div class="box-body">
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="sortId">URL:</label>
                  <div class="col-sm-5">
                  	<textarea id="ext-url" name="url" class="form-control"></textarea>
                  </div>
                  <div class="col-sm-5">
                      <p title="URL" class="ext-url-error control-p text-red"></p>
                  </div>
              </div><!--- 一行结束 -->               
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="sortTypeId">所属平台:</label>
                  <div class="col-sm-5">
                     <div class="checkbox">
                          <label class="margin-r-5">
                              <input id="extredio-sortTypeId1" type="radio" name="sortTypeId" value="1">
                              美团
                          </label>
                          <label>
                              <input id="extredio-sortTypeId2" type="radio" name="sortTypeId" value="2">
                              饿了麽
                          </label>
                      </div>
                  </div>
                  <div class="col-sm-5">
                      <p title="平台" class="extredio-sortTypeId-error control-p text-red"></p>
                  </div>
              </div><!--- 一行结束 -->
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="schoolId">学校:</label>
                  <div class="col-sm-5">
                      <select id="ext-schoolId" name="schoolId.id" class="form-control">
                      	  <option value="">--Select--</option>
                      	  <c:forEach items="${schoolsList}" var="school">
	                  	  	<option value="${school.id}">${school.name}</option>
	                  	  </c:forEach>
                      </select>
                  </div>
                  <div class="col-sm-5">
                      <p title="学校" class="ext-schoolId-error control-p text-red"></p>
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
<script type="text/javascript">
	$(function() {
		$(".form-horizontal").submit(function(e) {
			var $input = $("*[id^='ext-']");
			var error = false;
			$input.each(function() {
				var value = $(this).val();
				var $id = $(this).attr("id");
				var $class = "." + $id + "-error";
				var $error = $($class);
				if (value == null || value == "") {
					error = true;
					$error.html($error.attr("title") + " 值不能为空");
				} else {
					$error.html("");
				}
			});
			
			/** 单选按钮验证 */
			var $radio1 = $("#extredio-sortTypeId1");
			var $radio2 = $("#extredio-sortTypeId2");
			var $errorRadio = $(".extredio-sortTypeId-error");
			var isRadio1 = $radio1[0].checked;
			var isRadio2 = $radio2[0].checked;
			if (isRadio1 || isRadio2) {
				$errorRadio.html("");
			} else {
				error = true;
				$errorRadio.html($errorRadio.attr("title") + " 是必选项");
			}
			
			//取消表单提交
			if (error) {
				e.preventDefault();
			}
		});
	});
</script>
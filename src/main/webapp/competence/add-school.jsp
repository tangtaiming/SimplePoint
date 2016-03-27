<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="container-head.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      新增学校
      <small>管理学校-学校信息</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
      <li>学校管理</li>
      <li class="active">新增学校</li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->
 <div class="box box-info">
      <form class="form-horizontal" action="/school" method="post">
          <div class="box-body">
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="name">学校名称:</label>
                  <div class="col-sm-5">
                  	<input id="ext-name" class="form-control" type="text" name="name" placeholder="不能为空">
                  </div>
                  <div class="col-sm-5">
                      <p title="学校名称" class="ext-name-error control-p text-red"></p>
                  </div>
              </div><!--- 一行结束 -->  
              <div class="form-group">
                  <label class="col-sm-2 control-label" for="code">学校代码:</label>
                  <div class="col-sm-5">
                  	<input id="ext-code" class="form-control" type="text" name="code" placeholder="不能为空">
                  </div>
                  <div class="col-sm-5">
                      <p title="学校代码" class="ext-code-error control-p text-red"></p>
                  </div>
              </div><!--- 一行结束 --> 
          </div><!--主体-->
          <div class="box-footer">
          	<div class="col-sm-offset-1 col-sm-11">
              	<button id="submit-school" class="btn btn-primary margin-r-5" type="submit"> 保 存 </button>
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
<script>
	$(function() {
		$(".form-horizontal").submit(function(e) {
			var $input = $("input[id^='ext-']");
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
			//取消表单提交
			if (error) {
				e.preventDefault();
			}
		});
	});
</script>
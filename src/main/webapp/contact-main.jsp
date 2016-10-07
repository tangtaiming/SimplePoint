<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="men">
	<h1 class="contact_head">我的地址</h1>
	<div class="contact_box">
		<div class="col-sm-4">
			<address class="addr">
				<p>广州省深圳市龙岗区五和大道南星河WORLD A栋16楼 通拓科技有限公司</p>
				<dl>
					<dt>Telephone:</dt>
					<dd>+152 1163 6823</dd>
				</dl>
				<p>
					E-mail: <span> tangtaiming0918@gmail.com</span>
				</p>
			</address>
		</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4"></div>
		<div class="clearfix"></div>
	</div>
	<div class="contact_form">
		<h2>问题反馈</h2>
		<form action="/problemFeedBack" method="post">
			<div class="row_5">
				<input name="name" type="text" class="text" value="名字"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '名字';}"> 
				<input name="email" type="text" class="text" value="邮箱" 
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '邮箱';}"
					style="margin-left: 20px"> 
				<input name="theme" type="text" class="text" value="主题" 
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '主题';}"
					style="margin-left: 20px">
				<div class="clearfix"></div>
			</div>
			<div class="row_6">
				<textarea name="themeContent" value="问题:" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '问题';}">问题:</textarea>
			</div>
			<input name="submit" type="button" id="submit" value="提交">
			<div class="clearfix"></div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#submit").click(function() {
			var url = "/problemFeedBack";
			var method = "post";
			var params = {};
			var $name = $("input[name='name']").val();
			var $email = $("input[name='email']").val();
			var $theme = $("input[name='theme']").val();
			var $themeContent = $("textarea[name='themeContent']").val();
			params["name"] = $name;
			params["email"] = $email;
			params["theme"] = $theme;
			params["themeContent"] = $themeContent;
			$.myAjax(url, params, method);
		});
	});
</script>
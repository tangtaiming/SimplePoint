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
					<dd>+1 5211 636 823</dd>
				</dl>
				<p>
					E-mail: <span> accountnum@sina.cn</span>
				</p>
			</address>
		</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4"></div>
		<div class="clearfix"></div>
	</div>
	<div class="contact_form">
		<h2>问题反馈</h2>
		<form>
			<div class="row_5">
				<input type="text" class="text" value="名字"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '名字';}"> <input
					type="text" class="text" value="邮箱" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '邮箱';}"
					style="margin-left: 20px"> <input type="text" class="text"
					value="主题" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '主题';}"
					style="margin-left: 20px">
				<div class="clearfix"></div>
			</div>
			<div class="row_6">
				<textarea value="问题:" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '问题';}">问题:</textarea>
			</div>
			<input name="submit" type="submit" id="submit" value="提交">
			<div class="clearfix"></div>
		</form>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

  <!-- sidebar: style can be found in sidebar.less -->
  <section class="sidebar">

    <!-- Sidebar user panel (optional) -->
    <div class="user-panel">
      <div class="pull-left image">
        <img src="/images/user2-160x160.jpg" class="img-circle" alt="User Image">
      </div>
      <div class="pull-left info">
        <p>Alexander Pierce</p>
        <!-- Status -->
        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
      </div>
    </div>

    <!-- search form (Optional) -->
    <form action="#" method="get" class="sidebar-form">
      <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="Search...">
            <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
      </div>
    </form>
    <!-- /.search form -->

    <!-- Sidebar Menu -->
    <ul class="sidebar-menu">
      <li class="header">HEADER</li>
      <!-- Optionally, you can add icons to the links -->
      <li class="active">
      	<a href="javascript:;"><i class="fa fa-link"></i> <span>店铺管理</span> <i class="fa fa-angle-left pull-right"></i></a>
      	<ul class="treeview-menu">
          	<li><a href="/store?page=1&size=25"><i class="fa fa-circle-o"></i> 店铺列表</a></li>
              <li><a href="/storeToIn"><i class="fa fa-circle-o"></i> 新增店铺</a></li>
          </ul>
      </li>
      <li>
      	<a href="javascript:;"><i class="fa fa-link"></i> <span>学校管理</span> <i class="fa fa-angle-left pull-right"></i></a> 
      	<ul class="treeview-menu">
          	<li><a href="/school?page=1&size=25"><i class="fa fa-circle-o"></i> 学校列表</a></li>
              <li><a href="/school"><i class="fa fa-circle-o"></i> 新增学校</a></li>
          </ul>
      </li>
      <li>
      	<a href="javascript:;"><i class="fa fa-link"></i> <span>爬虫地址管理</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
          	<li><a href="/reptile?page=1&size=25"><i class="fa fa-circle-o"></i> url列表</a></li>
              <li><a href="/reptile"><i class="fa fa-circle-o"></i> 新增url</a></li>
          </ul>
      </li>
      <li>
      	<a href="javascript:;"><i class="fa fa-link"></i> <span>模块管理</span> <i class="fa fa-angle-left pull-right"></i></a>
          <ul class="treeview-menu">
          	  <li><a href="/preferential?page=1&size=25"><i class="fa fa-circle-o"></i> 优惠模块</a></li>
          	  <li><a href="/school_module?page=1&size=25"><i class="fa fa-circle-o"></i> 首页学校店铺模块</a></li>
          	  <li><a href="/safety?page=1&size=25"><i class="fa fa-circle-o"></i> 食物安全模块</a></li>
          	  <li><a href="/meishi?page=1&size=25"><i class="fa fa-circle-o"></i> 美食/微博模块</a></li>
          	  <li><a href="/shipin?page=1&size=25"><i class="fa fa-circle-o"></i> 视频模块</a></li>
          	  <li><a href="/meishijia?page=1&size=25"><i class="fa fa-circle-o"></i> 美食家模块</a></li>
          	  <li><a href="/shuiguo?page=1&size=25"><i class="fa fa-circle-o"></i> 水果模块</a></li>
          </ul>
      </li>
    </ul>
    <!-- /.sidebar-menu -->
  </section>
  <!-- /.sidebar -->
</aside>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单点</title>
<link href="/css/bootstrap.css?v=${code}" rel="stylesheet" type="text/css"  />
<link href="/css/tengxun.css?v=${code}" rel="stylesheet" type="text/css"  />
<style type="text/css">
	.width-lg .widget-site {
		width: 660px;
	}
	.widget-famoussite {
		clear:both
	}
	.width-lg .widget-site .widget-famoussite {
		padding-bottom:4px;
		padding-top:9px;
		padding-left:5px;
	}
	
	.width-lg .widget-site span {
		vertical-align: top;
		position:relative;
		width:210px;
		overflow:hidden;	
	}
	.widget-famoussite span {
		display:inline-block;
		height:28px;
		line-height:28px;
		width:120px;
	}
	.widget-famoussite span a {
		font-size:14px;
	}
	.contentMod.contentMod-height {
		height:243px;		
	}
	.span_1{
		background:#15be74;
		padding:2.9em 0;
	}
	.logo {
		display:block;
		text-align:center;	
	}
	.row_2{
		background: #fff;
		padding: 34px;
	}
	.search{
		float: left;
		width:100%;
		margin-right: 6%;
	}
	.search input[type="text"] {
		padding:15px;
		outline: none;
		color:#B6B2AE;
		background:#fff;
		border:1px solid #f8d5d1;
		width:85%;
		line-height: 1.5em;
		font: 500 13px/13px 'Raleway', sans-serif;
		-webkit-appearance: none;
	}
</style>
</head>

<body class="width-lg">

<!--logo+搜索 开始-->
<div class="soso" id="soso">
	<div class="header_bootm">
		<div class="col-sm-12 span_1">
		  <div class="logo">
			<a href="index.html"><img src="/images/logo.png" alt="" /></a>
		  </div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--logo+搜索 结束-->

<div id="contentLayout">
	
    <!--个性化通栏1 开始-->
	<div class="contentLayout" id="contentLayout01">
	
    	<div id="finance" class="contentMod contentModBig contentMod-height" style="margin-right: 20px;">
        	<div class="hd">
				<h2>
                	<a href="http://finance.qq.com/" target="_blank">电话订餐/催单电话</a> 
                </h2>
			</div>
            <div class="bd widget-site">
               <div id="box_famoussite_1" class="box-famoussite widget-famoussite">
                   <c:forEach items="${schoolsList}" var="school">
                   <span>
                      <a class="famoussite-mainlink" target="_blank"  href="/phone/${school.id}?page=1&size=50&storeName=recruitment">${school.name}</a>
                   </span>
                   </c:forEach>	
               </div>
            </div>
        </div>
        <div id="tech" class="contentMod contentMod-height" style="margin-right: 0px;">
            <div class="hd">
                    <h2><a target="_blank" href="http://tech.qq.com/">食物安全</a>·<a target="_blank" href="http://gd.qq.com/food/">外卖</a></h2>
            </div>
            <div class="bd">
                <div class="contentLeft">
                	<c:forEach items="${safetiesList}" var="safetie" varStatus="index">
                		<c:if test="${index.count==1}">
                		 <div class="imgArea">
	                         <a href="${safetie.url}" target="_blank">
	                             <img alt="${safetie.title}" src="/images/upload/${safetie.img}" />
	                         </a>
	                     </div>
	                     <div class="txtArea">
	                          <h3><a href="${safetie.url}" target="_blank">${safetie.title}</a></h3>
	                     </div>	
                		</c:if>
                		
                	</c:forEach>
                	<ul>
                	 <c:forEach items="${safetiesList}" var="safetie" varStatus="index">
                		 <c:if test="${index.count>1}">
	                		 <li><a href="${safetie.url}" target="_blank" class="">${safetie.title}</a>
	                         </li>
                		 </c:if>
                	 </c:forEach>
                	</ul>
                </div>
            </div>
        </div>
    
	</div>
	<!--个性化通栏1 结束-->
    
    <!--个性化通栏2 开始-->
	<div class="contentLayout" id="contentLayout02">
	
    	<div id="finance" class="contentMod contentModBig" style="margin-right: 20px;">
        	<div class="hd">
				<h2>
                	<a href="http://finance.qq.com/" target="_blank">湖南工学院(店铺)</a> <span class="fn">/</span>
                    <a href="http://finance.qq.com/" target="_blank">衡阳师范学院(店铺)</a>
                </h2>
			</div>
            
            <div class="bd widget-site">
            	
                <div id="box_famoussite_2" class="box-famoussite widget-famoussite">
                    <c:forEach items="${storesList}" var="store">
                     <span>
	                    <a class="famoussite-mainlink" target="_blank" href="${store.url}">${store.name}</a>
	                 </span>
                    </c:forEach>
                </div>
                
            </div>
        </div>
        <div id="tech" class="rightArea txDynamic" style="margin-right: 0px;">
            <div class="hd">
                    <h2><a target="_blank" href="http://tech.qq.com/">水果美颜</a></h2>
            </div>
            <div class="bd">
                <div class="contentLeft">
                	<ul style="margin-top:5px;height:166px;overflow:hidden;">
                	 <c:forEach items="${shuiGuosList}" var="shuiGuo" varStatus="index">
                		 <li>
                		 	<a href="${shuiGuo.url}" target="_blank" class="">${shuiGuo.title}</a>
                		 </li>
                	 </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
	</div>
	<!--个性化通栏2 结束-->
    
    <!--美食微博通栏1 开始-->
	<div class="contentLayout" id="contentLayout05">
		
	<div class="contentMod" id="cul" style="margin-right: 20px;">
			<div class="hd">
				<h2><a href="http://cul.qq.com/" target="_blank">美食微博</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd">
				<div class="contentLeft">
					<c:forEach items="${meiShisList}" var="meishi" varStatus="index">
						<c:if test="${index.count==1}">
						 <div class="imgArea">
							 <a target="_blank" href="<c:out value="${meishi.url}" default="--" />">
								 <img src="/images/upload/${meishi.img}" alt="${meishi.title}" />
							 </a>
						 </div>
						 <div class="txtArea">
							<h3><a target="_blank" href="<c:out value="${meishi.url}" default="--" />">${meishi.title}</a></h3>
						 </div>
						</c:if>
					</c:forEach>
					<ul>
					 <c:forEach items="${meiShisList}" var="meishi" varStatus="index">
						 <c:if test="${index.count>1}">
						 <li>
						  	  <a class="" target="_blank" href="${meishi.url}">${meishi.title}</a>
						 </li>
						 </c:if>
					 </c:forEach>
					</ul>
				</div>
		    </div>
	    </div>
		   
		<div style="margin-right: 20px;" class="contentMod" id="dajia">
			<div class="hd">
				<h2><a href="http://dajia.qq.com/" target="_blank">视频</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd">
				<div class="contentLeft">
					<c:forEach items="${shiPins}" var="shipin" varStatus="index">
						<c:if test="${index.count==1}">
						 <div class="imgArea">
							 <a target="_blank" href="<c:out value="${shipin.url}" default="--" />">
								 <img src="/images/upload/${shipin.img}" alt="${shipin.title}" />
							 </a>
						 </div>
						 <div class="txtArea">
							<h3><a target="_blank" href="<c:out value="${shipin.url}" default="--" />">${shipin.title}</a></h3>
						 </div>
						</c:if>
					</c:forEach>
					<ul>
					 <c:forEach items="${shiPins}" var="shipin" varStatus="index">
						 <c:if test="${index.count>1}">
						 <li>
						  	  <a class="" target="_blank" href="${shipin.url}">${shipin.title}</a>
						 </li>
						 </c:if>
					 </c:forEach>
					</ul>
				</div>
			</div>
		</div><div class="contentMod" id="astro" style="margin-right: 0px;">
			<div class="hd">
				<h2><a href="http://astro.fashion.qq.com/" target="_blank">美食家</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd">
				<div class="contentLeft">
					<c:forEach items="${meiShiJiasList}" var="meishijia" varStatus="index">
						<c:if test="${index.count==1}">
						 <div class="imgArea">
							 <a target="_blank" href="${meishijia.url}">
								 <img src="/images/upload/${meishijia.img}" alt="${meishijia.title}" />
							 </a>
						 </div>
						 <div class="txtArea">
							<h3><a target="_blank" href="<c:out value="${meishijia.url}" default="--" />">${meishijia.title}</a></h3>
						 </div>
						</c:if>
					</c:forEach>
					<ul>
					 <c:forEach items="${meiShiJiasList}" var="meishijia" varStatus="index">
						 <c:if test="${index.count>1}">
						 <li>
					 	 	 <a class="" target="_blank" href="<c:out value="${meishijia.url}" default="--" />">${meishijia.title}</a>
						 </li>
						 </c:if>
					 </c:forEach>
					</ul>
				</div>
			</div>
		</div></div>
		<!--频道通栏1 结束-->
    
</div>
<!--底部广告 开始-->
<div class="layout mt12">
	<!--QQ_HP_bottom_Width_div AD begin...."l=QQ_HP_bottom_Width&log=off"-->
<div display="banner" oid="2598081" adconfig_lview_template="http://l.qq.com/lview?c=www&amp;loc={loc}" adconfig_charset="gbk" adconfig_lview="l.qq.com" id="QQ_HP_bottom_Width" style="width: 1000px; height: 90px; display: block; position: relative;" class="l_qq_com"><a href="http://c.l.qq.com/lclick?oid=2598081&amp;cid=1344155&amp;loc=QQ_HP_bottom_Width&amp;click_data=dXNlcl9pbmZvPXZCXzduanNfRVJHNEZlT2RJem9WQzdvZV9KNDI=&amp;soid=ZCgxtyuFVvypugtxdwn0gkI5AY5x&amp;chl=478&amp;index=1&amp;page_type=1&amp;aver=0&amp;dtype=0" target="_blank" style="display:block;cursor:pointer;width:1000px;height:90px;background-image:url(http://wa.gtimg.com/201603/30/xxsmzg_QHbW_201603301620.jpg);background-size:1000px 90px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='http://wa.gtimg.com/201603/30/xxsmzg_QHbW_201603301620.jpg',sizingMethod='scale');"></a><a class="absolute a_cover" href="http://c.l.qq.com/lclick?oid=2598081&amp;cid=1344155&amp;loc=QQ_HP_bottom_Width&amp;click_data=dXNlcl9pbmZvPXZCXzduanNfRVJHNEZlT2RJem9WQzdvZV9KNDI=&amp;soid=ZCgxtyuFVvypugtxdwn0gkI5AY5x&amp;chl=478&amp;index=1&amp;page_type=1&amp;aver=0&amp;dtype=0&amp;k=&amp;t=%E8%85%BE%E8%AE%AF%E9%A6%96%E9%A1%B5&amp;r=&amp;s=" target="_blank" rel="nofollow" style="position:absolute;width:1000px;height:90px;left:0px;top:0px;cursor:pointer;z-index:10;background-color:#fff;filter:alpha(opacity=0);opacity:0;"></a><div style="position: absolute; left: 0px; bottom: 0px; width: 26px; height: 16px; z-index: 12; background: transparent url(&quot;http://ra.gtimg.com/web/res/icon/leftbottom_new.png&quot;) no-repeat scroll right top;"></div></div>
<!--QQ_HP_bottom_Width AD end --><!--[if !IE]>|xGv00|ae5fc9a647cf29b12ee0977b382e9e62<![endif]-->
</div>
<!--底部广告 结束-->

<!--底部 开始-->
<div class="foot" id="footer" bosszone="footer">
	<div class="footernew" role="contentinfo" style="height:50px;">
		<span><a href="http://www.tencent.com/law/mo_law.shtml?/law/copyright.htm" target="_blank" rel="nofollow">版权所有</a> <a href="http://www.qq.com/icp1.shtml" target="_blank" rel="nofollow">B2-20090028</a> 违法和不良信息举报电话：0755-83767606</span>
		<span style="font-family:Arial;">Copyright &#169; 1998 - 2016 Tencent. All Rights Reserved</span>
	</div>
</div>
<!--[if !IE]>|xGv00|c1943c55c54bd00bb153c873c28434dc<![endif]-->
<!--底部 结束-->

</body>
</html>
    
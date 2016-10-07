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
	.noContentMod {
		border-top:0px;
	}
</style>
</head>

<body class="width-lg">

<!--logo+搜索 开始-->
<div class="soso" id="soso">
	<div class="header_bootm">
		<div class="col-sm-12 span_1">
		  <%@include file="logo.jsp" %>
		</div>
		<%@include file="clearfix.jsp" %>
	</div>
</div>
<!--logo+搜索 结束-->

<div id="contentLayout">
	
    <!--个性化通栏1 开始-->
	<div class="contentLayout" id="contentLayout01">
	
    	<div id="finance" class="contentMod contentModBig contentMod-height noContentMod" style="margin-right: 20px;">
        	<div class="hd">
				<h2>
                	<b>电话订餐/催单电话</b> 
                </h2>
			</div>
            <div class="bd widget-site">
               <div id="box_famoussite_1" class="box-famoussite widget-famoussite">
                   <c:forEach items="${schoolsList}" var="school">
                   <span>
                      <a class="famoussite-mainlink" href="/phone/${school.id}?page=1&size=50&storeName=recruitment">${school.name}</a>
                   </span>
                   </c:forEach>	
               </div>
            </div>
        </div>
        <div id="tech" class="contentMod contentMod-height noContentMod" style="margin-right: 0px;">
            <div class="hd">
                    <h2><b>食物安全</b>·<b>外卖</b></h2>
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
                	<b>湖南工学院(店铺)</b>
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
                    <h2><b>水果美颜</b></h2>
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
				<h2><b>美食微博</b></h2>
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
				<h2><b>视频</b></h2>
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
				<h2><b>美食家</b></h2>
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
</div>
<!--底部广告 结束-->

<!--底部 开始-->
<div class="foot" id="footer" bosszone="footer">
	<div class="footernew" role="contentinfo" style="height:50px;">
		<span><span>版权所有</span> <span>TTM</span> 违法和不良信息举报电话：0755-83767606</span>
		<span style="font-family:Arial;">Copyright &#169; 2016 <a href="www.look23.com">www.look23.com</a>. All Rights Reserved</span>
	</div>
</div>
<!--底部 结束-->

</body>
</html>
    
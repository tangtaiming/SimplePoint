<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>简单点</title>

<link href="/css/tengxun.css" rel="stylesheet" type="text/css"  />
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
</style>
</head>

<body class="width-lg">

<!--logo+搜索 开始-->
<div class="soso" id="soso">
	<div class="logo" id="tencentlogo" bosszone="logo">
		<h1>
			<a href="http://www.qq.com/" class="qqlogo">
				<span class="undis">腾讯网</span>
			</a>
		</h1>
	</div>

	<div class="search" id="sosobar" role="search" bosszone="search">
		<form id="searchForm" method="get" name="soso_search_box" action="https://www.sogou.com/sogou?pid=sogou-wsse-3f7bcd0b3ea82268&amp;ie=utf-8&amp;query=" target="_blank">
			<div id="searchTxt" class="searchTxt" onmouseover="this.className='searchTxtHover';">
				<div class="radius" style="top:-1px;"></div>
				<div id="radiusLeftBottom" class="radius" style="top:35px;"></div>
				<div class="searchMenu">
					<div class="searchSelected" id="searchSelected">网页</div>
					<div style="display: none;" class="searchTab" id="searchTab">
						<div class="radius" style="top:259px;"></div>
						<div class="radius" style="top:259px;left:59px;"></div>
					<ul><li class="selected">网页</li><li>图片</li><li>视频</li><li>音乐</li><li>地图</li><li>问问</li><li>百科</li><li>新闻</li><li>购物</li></ul></div>
				</div>
				<input data-defaultword="曝男篮集训推迟" style="color: rgb(102, 102, 102);" autocomplete="off" id="sougouTxt" value="曝男篮集训推迟" name="w" type="text">
				<input value="w.q.in.sb.web" style="display:none" name="cid" type="text">
				<a id="sogouLogoLink" href="https://www.sogou.com/?pid=sogou-wsse-3f7bcd0b3ea82268-0001" target="_blank" onclick="registerZone2({bossZone:'searchlogo',url:''},1);"><img id="sogouLogo" alt="搜狗" class="sosoLogo" src="%E8%85%BE%E8%AE%AF%E9%A6%96%E9%A1%B5_files/sogouSearchLogo20140629.png" style="width:23px;height:23px;"></a>
				<div style="visibility: hidden;" class="searchSmart" id="searchSmart">
					<ul>
					</ul>
				</div>
			</div>
			<div class="searchBtn">
				<button id="searchBtn" type="submit" onclick="registerZone2({bossZone:'searchbutton',url:''},1);">搜狗</button>
			</div>
		<input name="hidden" type="hidden"></form>
	</div>

	<div class="loginGray" id="loginGray">
		<div id="loginGrayIcon" class="fr">
			<a target="_self" href="javascript:void(0)" class="login" id="loginGrayLayout" onclick="userLogin();" bosszone="onekey"></a>
		</div>
		<div id="dingyueGrayIcon" class="fr">
			<a href="http://dy.qq.com/" class="dingyue" target="_blank" bosszone="booking"></a>
		</div>
		<div id="mailGrayIcon" class="fr">
			<a href="http://mail.qq.com/" class="mail" target="_blank" bosszone="qmail"></a>
		</div>
		<div id="qzoneGrayIcon" class="fr">
			<a href="http://qzone.qq.com/" class="qzone" target="_blank" bosszone="qzone"></a>
		</div>
		<div id="weiboGrayIcon" class="fr">
			<a href="http://t.qq.com/?pref=qqcom.home.weiboenter" class="weibo" target="_blank" bosszone="weibo"></a>
		</div>
	</div>
	<div class="loginGray undis" id="loginedGray">
		<div id="loginGrayIconLogin" class="fr">
			<a href="http://ilike.qq.com/" class="logined" id="loginGrayLayoutLogin" target="_blank" bosszone="touxiang">
				<img id="loginGrayLayoutImg" src="">
			</a>
			<a id="userVipHead" class="userVipHead" href="http://ilike.qq.com/" target="_blank" bosszone="touxiang"></a>
			<div class="loginGraySmartBox undis" id="loginGraySmart" style="right:-4px;">
				<div class="loginGraySmartTop" style="left:40px;"></div>
				<div class="loginGraySmartContent">
					<div class="loginGraySmartInner">
						<ul>
							<li id="loginGrayTitle" bosszone="name"><a href="http://ilike.qq.com/" target="_blank" id="userNameGray"></a></li>
							<li id="loginGrayLi" bosszone="logquit"><span id="userVipLayout" class="userVip"></span> <a id="loginGrayOut" href="javascript:void(0);">[退出]</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="dingyueGrayIconLogin" class="fr" bosszone="bookinginfor">
			<a href="http://dy.qq.com/" class="dingyue" target="_blank"></a>
			<div class="dingyueGrayNum" id="dingyueGrayNum">
				<div id="dingyueGrayNumLayout"></div>
			</div>		
			<div class="loginGraySmartBox undis" id="dingyueGraySmart" style="right:-43px;">
				<div class="loginGraySmartTop"></div>
				<div class="loginGraySmartContent">
					<div class="loginGraySmartInner">
						<ul>
							<li id="dingyueGrayTitle">订阅：</li>
							<li id="dingyueGrayLi" class="undis"><a href="http://dy.qq.com/" target="_blank"><span id="dingyueGrayLiNum" class="txtRight"></span>今日更新</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="mailGrayIconLogin" class="fr" bosszone="qmailinfor">
			<a href="http://mail.qq.com/" class="mail" target="_blank"></a>
			<div class="mailGrayNum" id="mailGrayNum">
				<div id="mailGrayNumLayout"></div>
			</div>
			<div class="loginGraySmartBox undis" id="mailGraySmart" style="right:-44px;">
				<div class="loginGraySmartTop"></div>
				<div class="loginGraySmartContent">
					<div class="loginGraySmartInner">
						<ul>
							<li id="mailGrayTitle">QQ邮箱：</li>
							<li id="inboxGrayLi" class="undis"><a href="http://mail.qq.com/" target="_blank"><span id="inboxGrayNum" class="txtRight"></span>未读邮件</a></li>
							<li id="bottleGrayLi" class="undis"><a href="http://mail.qq.com/" target="_blank"><span id="bottleGrayNum" class="txtRight"></span>漂流瓶</a></li>
							<li id="gmailGrayLi" class="undis"><a href="http://mail.qq.com/" target="_blank"><span id="gmailGrayNum" class="txtRight"></span>群邮件</a></li>
							<li id="dmailGrayLi" class="undis"><a href="http://mail.qq.com/" target="_blank"><span id="dmailGrayNum" class="txtRight"></span>文件夹</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="qzoneGrayIconLogin" class="fr" bosszone="qzoneinfor">
			<a href="http://qzone.qq.com/" class="qzone" target="_blank"></a>
			<div class="qzoneGrayNum" id="qzoneGrayNum">
				<div id="qzoneGrayNumLayout"></div>
			</div>
			<div class="loginGraySmartBox undis" id="qzoneGraySmart" style="right:-42px;">
				<div class="loginGraySmartTop"></div>
				<div class="loginGraySmartContent">
					<div class="loginGraySmartInner">
						<ul>
							<li id="qzoneGrayTitle">QQ空间：</li>
							<li id="passiveGrayLi" class="undis"><a href="http://qzone.qq.com/" target="_blank"><span id="passiveGrayNum" class="txtRight"></span>我的动态</a></li>
							<li id="InitGrayLi" class="undis"><a href="http://qzone.qq.com/" target="_blank"><span id="InitGrayNum" class="txtRight"></span>好友动态</a></li>
							<li id="AboutGrayLi" class="undis"><a href="http://qzone.qq.com/" target="_blank"><span id="AboutGrayNum" class="txtRight"></span>我的参与</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="weiboGrayIconLogin" class="fr" bosszone="weiboinfor">
			<a href="http://t.qq.com/?pref=qqcom.home.weiboenter" class="weibo" target="_blank"></a>
			<div class="weiboGrayNum" id="weiboGrayNum">
				<div id="weiboGrayNumLayout"></div>
			</div>
			<div class="loginGraySmartBox undis" id="weiboGraySmart" style="left:-52px;">
				<div class="loginGraySmartTop"></div>
				<div class="loginGraySmartContent">
					<div class="loginGraySmartInner">
						<ul>
							<li id="weiboGrayTitle">腾讯微博：</li>
							<li id="msgGrayLi" class="undis"><a href="http://t.qq.com/messages/inbox?pref=qqcom.home.wbinbox" target="_blank"><span id="msgGrayNum" class="txtRight"></span>私信</a></li>
							<li id="atGrayLi" class="undis"><a href="http://t.qq.com/at?pref=qqcom.home.wbat" target="_blank"><span id="atGrayNum" class="txtRight"></span>提到我的</a></li>
							<li id="fansGrayLi" class="undis"><a href="http://t.qq.com/follower.php?pref=qqcom.home.wbfollow" target="_blank"><span id="fansGrayNum" class="txtRight"></span>新增听众</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--logo+搜索 结束-->

<div id="contentLayout">
	
    <!--个性化通栏1 开始-->
	<div class="contentLayout" id="contentLayout01">
	
    	<div id="finance" class="contentMod contentModBig contentMod-height" style="margin-right: 20px;">
        	<div class="hd" bosszone="fintab">
				<h2>
                	<a href="http://finance.qq.com/" target="_blank">优惠多多，安全多多</a> 
                </h2>
			</div>
            
            <div class="bd widget-site" bosszone="fin_1">
            	
                <div id="box_famoussite_1" class="box-famoussite widget-famoussite">
                	<c:forEach items="${preferentialsList}" var="preferential">
                     <span>
                         <a class="famoussite-mainlink " href="">${preferential.name}</a>
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
        	<div class="hd" bosszone="fintab">
				<h2>
                	<a href="http://finance.qq.com/" target="_blank">湖南工学院(店铺)</a> <span class="fn">/</span>
                    <a href="http://finance.qq.com/" target="_blank">衡阳师范学院(店铺)</a>
                </h2>
			</div>
            
            <div class="bd widget-site" bosszone="fin_2">
            	
                <div id="box_famoussite_2" class="box-famoussite widget-famoussite">
                    <c:forEach items="${storesList}" var="store">
                     <span>
	                    <a class="famoussite-mainlink " href="${store.url}">${store.name}</a>
	                 </span>
                    </c:forEach>
                </div>
                
            </div>
        </div>
        <div id="tech" class="rightArea txDynamic" style="margin-right: 0px;">
            <div bosszone="techDigitab" class="hd">
                    <h2><a target="_blank" href="http://tech.qq.com/">水果美颜</a></h2>
         
            </div>
            <div bosszone="techDigi" class="bd">
                <div class="contentLeft">
                    <ul style="margin-top:5px;height:166px;overflow:hidden;">
                        <li bosszone="tech"><a href="http://tech.qq.com/a/20160331/009181.htm" target="_blank" class="">深圳，高房价会让科技业失去竞争力吗？</a>
                        </li>
                        <li bosszone="tech"><a href="http://tech.qq.com/a/20160331/011809.htm" target="_blank" class="">泡沫的后裔：影视公司该如何估值和积聚价值</a>
                        </li>
                        <li bosszone="tech"><a href="http://tech.qq.com/a/20160331/010629.htm" target="_blank" class="qm_c_2">濒临倒闭的蜜淘绝不是第一家倒下的跨境电商</a>
                        </li>
                        <li bosszone="digi"><a href="http://digi.tech.qq.com/p/topic/20160328042204/index.html" target="_blank" class="">一眼看尽微软大会 Win10更新将至</a>        
                          <a href="http://v.qq.com/live/p/topic/4740/review.html" target="_blank" class="">原声视频回顾</a>    
                        </li>
                        <li bosszone="digi"><a href="http://digi.tech.qq.com/a/20160331/008642.htm" target="_blank" class="">小米电饭煲评测：还是会粘锅</a> <a href="">开箱体验</a>  
                        </li>
                        <li bosszone="digi"><a href="http://digi.tech.qq.com/a/20160331/010434.htm" target="_blank" class="">搞机番外篇：索尼大法好 PS VR也一样好吗？</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    
	</div>
	<!--个性化通栏2 结束-->
    
    <!--频道通栏1 开始-->
	<div class="contentLayout" id="contentLayout05">
		
		
		
	<div class="contentMod" id="cul" style="margin-right: 20px;">
			<div class="hd" bosszone="cultab">
				<h2><a href="http://cul.qq.com/" target="_blank">美食微博</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd" bosszone="cul">
				<div class="contentLeft">
					<div class="imgArea">
								<a target="_blank" href="http://cul.qq.com/a/20160331/013473.htm#p=1">
									<img src="/images/user4-128x128.jpg" alt="中国王牌军3小时突破越军红河防线">
								</a>
							</div>
							<div class="txtArea">
								<h3><a target="_blank" href="http://cul.qq.com/a/20160331/013473.htm#p=1">中国王牌军3小时突破越军红河防线</a></h3>
							</div>
                            			<ul>
																																	  										<li><a class="" target="_blank" href="http://cul.qq.com/a/20160331/013404.htm">陈志武：人类社会应如何应对金融风险挑战？</a></li>
																																			  										<li><a class="																																							" target="_blank" href="http://cul.qq.com/a/20160331/013523.htm">王建勋：美国革命发生的原因究竟是什么？ </a></li>
																																			  										<li><a class="																																							" target="_blank" href="http://cul.qq.com/a/20160331/013840.htm">《山海经》记载几千年前就有人造出"飞机"</a></li>
																																			  										<li><a class="																																							" target="_blank" href="http://cul.qq.com/a/20160331/015256.htm">《史记》：暴脾气的国王只会打败仗 </a></li>
																																			  										<li><a class="																																							" target="_blank" href="http://cul.qq.com/a/20160331/009021.htm">努尔哈赤戕害同族兄弟 造就清史第一疑案</a></li>
																																			  										<li><a class="																																							" target="_blank" href="http://cul.qq.com/a/20160331/021751.htm">日本大正时代：法西斯主义抬头扑灭左翼力量</a></li>
																																																																								
																																																																							</ul>
				</div>
			</div>
		</div><div style="margin-right: 20px;" class="contentMod" id="dajia">
			<div class="hd" bosszone="dajiatab">
				<h2><a href="http://dajia.qq.com/" target="_blank">视频</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd" bosszone="dajia">
				<!--0aba916b2227529d5150ff8af1309865--><div class="contentLeft">
																							<div class="imgArea">
								<a target="_blank" href="http://dajia.qq.com/">
									<img src="/images/avatar.png" alt="黄金4分钟等不到中国人落后的急救观">
								</a>
							</div>
							<div class="txtArea">
								<h3><a target="_blank" href="http://dajia.qq.com/">黄金4分钟等不到中国人落后的急救观</a></h3>
							</div>
																																																																								
																																																																								
																																																																								
																																																																								
																																																																								
																														<ul>
																												  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/category/yxh160331.html">易小荷：中国篮球让我从记者变成诗人</a></li>
																														  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/category/jm160331.html">姜鸣：晚清政局大变动的"甲申易枢"</a></li>
																														  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/category/sxj160330.html">孙骁骥：中国山寨建筑里的城市生活真相</a></li>
																														  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/football/shl160330.html">沈雷：国足仍未学会赢得该赢得的比赛</a></li>
																														  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/jinritoutiao/ykf160330.html">叶克飞：撇开道义与情怀，谈难民背后真问题</a></li>
																														  										<li><a class="																																							" target="_blank" href="http://dajia.qq.com/original/tiaowang/lyt160329.html">龙应台：一个人只要说他爱猫，他就是朋友</a></li>
																																																																			
																																																																			
																																																																			
																																																																			
																																																																			
																														</ul>
				</div>
				<!--[if !IE]>|xGv00|87a0e7605f69b080c9e9ee61a2cd0866<![endif]-->
			</div>
		</div><div class="contentMod" id="astro" style="margin-right: 0px;">
			<div class="hd" bosszone="astrotab">
				<h2><a href="http://astro.fashion.qq.com/" target="_blank">美食家</a></h2>
				<div class="orderLayout">
					<p>更换频道</p>
				</div>
			</div>
			<div class="bd" bosszone="astro">
				<!--7896a2a73bde9c03243d8b791128bc32--><div class="contentLeft">
																							<div class="imgArea">
								<a target="_blank" href="http://astro.fashion.qq.com/">
									<img src="/images/photo3.jpg" alt="星运365：12星座谁分手时最心狠无情">
								</a>
							</div>
							<div class="txtArea">
								<h3><a target="_blank" href="http://astro.fashion.qq.com/">星运365：12星座谁分手时最心狠无情</a></h3>
							</div>
																																																																								
																																																																								
																																																																								
																																																																								
			<ul>
																																											<li><a class="																														qm_i_2									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/012561.htm">将成大事的六种梦境</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/011242.htm">嫉妒恋爱融合的星座</a></li>
																																													<li><a class="																														qm_i_2									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/013383.htm">中韩男神卖萌表情包</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/011206.htm">12星座最完美的组合</a></li>
																																													<li><a class="																														qm_i_2									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/011226.htm">测你人生像哪种雷剧</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/011178.htm">最会珍惜婚姻的星座</a></li>
																																													<li><a class="																														qm_i_2									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010993.htm">易撕X闺蜜星座组合</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010974.htm">爱勾男人出轨的星女</a></li>
																																													<li><a class="																														qm_i_2									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010881.htm">2016高考生运势堪忧</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010859.htm">小白脸怕靠近的星女</a></li>
																																													<li><a class="																														qm_i_3									" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010802.htm">易有特殊癖好的星座</a>&nbsp;&nbsp;
																																																													<a class="																													" target="_blank" href="http://astro.fashion.qq.com/a/20160331/010763.htm">不爱不啪的专一星男</a></li>
																																																																								
																																																																								
																																																			</ul>
				</div>
				<!--[if !IE]>|xGv00|8579dbe6c613c54d14c99b65c7db3b39<![endif]-->
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
    
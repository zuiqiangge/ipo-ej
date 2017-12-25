<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<!-- saved from url=(0030)http://wyq.sina.com/home.shtml -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<!-- saved from url=(0014)index:internet -->

		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="renderer" content="webkit">

		<title>鹏越舆情-互联网大数据平台</title>
		<meta name="author" content="">
		<meta name="keywords"
			content="微信舆情监测,微博舆情监控,舆情监测, 舆情APP ,舆情客户端，舆情软件,互联网舆情,视频舆情,海外媒体，舆情APP ,舆情客户端，舆情预警">
		<meta name="description"
			content="微舆情是中国最大的免费舆情服务平台，提供网页、微博、微信、电子报、视频等全媒体舆情监测方案，以及舆情事件分析、舆情简报制作，舆情日周月报自动发送、海外媒体监测、竞争情报服务等">
		<meta name="searchtitle"
			content="舆情监控,舆情监测,微博舆情监控,舆情监控软件,舆情监测系统,互联网舆情监测,舆情监控系统,互联网舆情监控,舆情监测软件,网络舆情监控系统">
		
		<script type="text/javascript">

var njxImgSrc = '';
var actionBase = '';
var staticResourcePath = 'http://files.wyq.cn/web';
var qrCodeImg = 'http://app.wyq.cn/QRCode/wyq_d_entry.png';
</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery-1.10.2.min.js">
		</script>
		<script type="text/javascript" src="<%=basePath%>sinaStyle/index.js">
		</script>

		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/navigate.js">
		</script>
		<link href="<%=basePath%>sinaStyle/style.css" rel="stylesheet"
			type="text/css">

		<link href="<%=basePath%>sinaStyle/font-icon.css" rel="stylesheet"
			type="text/css">

		<script src="<%=basePath%>sinaStyle/fingerprint2.min.js"
			type="text/javascript" charset="utf-8">
		</script>
		
		<script src="<%=basePath%>sinaStyle/My97DatePicker/WdatePicker.js"></script>

		<style type="text/css">
a.bshareDiv,#bsPanel,#bsMorePanel,#bshareF {
	border: none;
	background: none;
	padding: 0;
	margin: 0;
	font: 12px Helvetica, Calibri, Tahoma, Arial, 宋体, sans-serif;
	line-height: 14px;
}

#bsPanel div,#bsMorePanel div,#bshareF div {
	display: block;
}

.bsRlogo .bsPopupAwd,.bsRlogoSel .bsPopupAwd,.bsLogo .bsPopupAwd,.bsLogoSel .bsPopupAwd
	{
	line-height: 16px !important;
}

a.bshareDiv div,#bsFloatTab div { *
	display: inline;
	zoom: 1;
	display: inline-block;
}

a.bshareDiv img,a.bshareDiv div,a.bshareDiv span,a.bshareDiv a,#bshareF table,#bshareF tr,#bshareF td
	{
	text-decoration: none;
	background: none;
	margin: 0;
	padding: 0;
	border: none;
	line-height: 1.2
}

a.bshareDiv span {
	display: inline;
	float: none;
}

div.buzzButton {
	cursor: pointer;
	font-weight: bold;
}

.buzzButton .shareCount a {
	color: #333
}

.bsStyle1 .shareCount a {
	color: #fff
}

span.bshareText {
	white-space: nowrap;
}

span.bshareText:hover {
	text-decoration: underline;
}

a.bshareDiv .bsPromo,div.bshare-custom .bsPromo {
	display: none;
	position: absolute;
	z-index: 100;
}

a.bshareDiv .bsPromo.bsPromo1,div.bshare-custom .bsPromo.bsPromo1 {
	width: 51px;
	height: 18px;
	top: -18px;
	left: 0;
	line-height: 16px;
	font-size: 12px !important;
	font-weight: normal !important;
	color: #fff;
	text-align: center;
	background:
		url(http://static.bshare.cn/frame/images/bshare_box_sprite2.gif)
		no-repeat 0 -606px;
}

div.bshare-custom .bsPromo.bsPromo2 {
	background:
		url(http://static.bshare.cn/frame/images/bshare_promo_sprite.gif)
		no-repeat;
	cursor: pointer;
}
</style>
		<style type="text/css">
.bsBox {
	display: none;
	z-index: 100000001;
	font-size: 12px;
	background:
		url(http://static.bshare.cn/frame/images//background-opaque-dark.gif)
		!important;
	padding: 6px !important;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

.bsClose {
	_overflow: hidden;
	cursor: pointer;
	position: absolute;
	z-index: 10000000;
	color: #666;
	font-weight: bold;
	font-family: Helvetica, Arial;
	font-size: 14px;
	line-height: 20px;
}

.bsTop {
	color: #666;
	background: #f2f2f2;
	height: 24px;
	line-height: 24px;
	border-bottom: 1px solid #e8e8e8;
}

.bsTop span {
	float: left;
}

.bsFrameDiv,#bsMorePanel {
	border: none;
	background: #fff;
}

.bsReturn {
	float: right; *
	margin-right: 20px;
	margin-right: 36px;
	text-align: right;
	cursor: pointer;
	line-height: 24px;
	color: #666;
	opacity: 0.5;
}

#bsReturn:hover {
	text-decoration: underline;
	opacity: 1;
}
</style>

		<style type="text/css">
div.bsClear {
	clear: both;
	height: 0;
	line-height: 0;
	overflow: hidden;
	font-size: 0;
}

.bsSearchDiv {
	padding: 5px 15px;
	background-color: #fafafa;
}

.bFind-wrapper-top {
	background: #fff;
	border-color: #ccc #aaa #aaa #ccc;
	border-style: solid;
	border-width: 1px;
	height: 16px;
	padding: 4px;
	margin: 0;
}

.bFind-wrapper-top input {
	padding: 0 !important;
	border: none !important;
	box-shadow: none !important;
	line-height: 16px !important;
}

.bFind-placeholder {
	background: url("http://static.bshare.cn/css/images/search-icon.gif")
		no-repeat;
	display: block;
	float: left;
	height: 16px;
	width: 16px;
}

.bFind {
	background: none;
	border: none;
	float: left;
	font-size: 11px !important;
	height: 16px !important;
	margin-left: 3px;
	outline: none;
	padding: 0;
	width: 400px;
}

.bsPlatDiv {
	height: 322px;
	background: #fff;
	overflow: auto;
	padding: 0 15px;
}

#bsLogoList {
	display: block;
	list-style: none;
	overflow: hidden;
	margin: 0;
	padding: 0;
}

#bsLogoList li {
	float: left;
	display: inline-block;
	width: 71px;
	text-align: center;
	font-size: 12px;
	height: 80px;
	margin: 0 !important;
}

#bsLogoList .bsPlatIcon {
	cursor: pointer;
	display: block !important;
	text-align: center;
}

#bsLogoList .bsPlatImg {
	width: 32px;
	height: 32px;
	border: none !important;
	display: inline-block;
}

#bsLogoList .bsPlatImg:hover {
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 7px;
	box-shadow: 0 0 15px #a7a8ac;
}

#bsLogoList .bsPlatName {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	text-align: center;
	color: #333 !important;
	margin-top: 2px;
	line-height: 140%; *
	width: 70px;
}

#bsLogoList .bsPromoM {
	text-align: center;
}

.bsFooterDiv {
	height: 24px;
	line-height: 24px;
	padding: 0 15px;
	border-top: 1px solid #e8e8e8;
	background: #f2f2f2;
	text-align: right;
}

a.bsLogoLink {
	color: #666;
}

.bsLogoLink:hover {
	text-decoration: underline;
}

.bsPromoM {
	background:
		url(http://static.bshare.cn/frame/images//bshare_box_sprite2.gif)
		no-repeat top left;
}

.bsNew,.bsHot,.bsRec,.bsAwd {
	background-position: 0 -552px;
	width: 19px;
	margin: 5px auto 1px;
	line-height: 16px;
	height: 18px;
	font-size: 12px;
	color: #fff;
	overflow: hidden;
}

.bsNew {
	background-position: 0 -570px;
}

.bsRec {
	width: 30px;
	background-position: 0 -588px;
}

.bsAwd {
	background:
		url(http://static.bshare.cn/frame/images//promot/promote.gif)
		no-repeat;
}
</style>
		<script src="<%=basePath%>sinaStyle/bshare_view"
			type="text/javascript" charset="utf-8">
		</script>
		<script src="<%=basePath%>sinaStyle/bsPlatforms.js"
			type="text/javascript" charset="utf-8">
		</script>

		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta charset="GBK">
		<title>舆情监控</title>
		<meta name="author" content="">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta name="searchtitle" content="">
		<script type="text/javascript">
var basePath = '';
</script>

		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/common.css">
		<link href="<%=basePath%>sinaStyle/home.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/jquery-ui-1.9.1.custom.css"
			rel="stylesheet" type="text/css">

		<link href="<%=basePath%>sinaStyle/prettify.css" type="text/css"
			rel="stylesheet">

		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery-1.10.2.min.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery-ui-1.9.1.custom.js">
		</script>
		<script type="text/javascript" src="<%=basePath%>sinaStyle/index.js">
		</script>
		<script src="<%=basePath%>sinaStyle/jquery.JPlaceholder.js">
		</script>

		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/shouye_v2.js">
		</script>


		<script type="text/javascript">
var operateLogPageCode = '1040';
var operateLogPageName = '热度查询';
var operateLogRequestPath = '';
</script>



		<link href="<%=basePath%>sinaStyle/openWeiboImg.css" rel="stylesheet"
			type="text/css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/accordion.css">
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/prettify.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery.slimscroll.js">
		</script>


		<script>
var jquery2 = $;
var njxBasePath = '';
var baseAction = '';
function logout() {
	window.location.href = "/logout.action";
}<!--选中文字显示按钮效果 end-->


        $(function(){
            $("#noticeLink").on("click",function(){
                $("#notice").addClass('rightIn');
                $("#notice").removeClass('rightOut');

            });
            $("#closeNotice").on("click",function(){
                $("#notice").addClass('rightOut');
                $("#notice").removeClass('rightIn');
            });
        });
    </script>
	</head>



	<!-- 导航条用户的下拉效果-->

	<!-- 页面右侧的客户端展示的效果-->





	<body class="loginHome">
		<div id="wx_pic" style="margin: 0 auto; display: none;">
			<img src="<%=basePath%>sinaStyle/share.png">
		</div>



		<!--系统公告 start-->
		<div id="notice" class="topFloat_r">
			<div class="notice">
				<a class="close" id="closeNotice" href="#" style="background: none;">×</a>
				<div>

					<div class="nTit">
						<h1>
							系统公告
						</h1>
					</div>

					<div class="accordion" id="noticeCon">
						<div class="slimScrollDiv"
							style="position: relative; overflow: hidden; width: auto; height: 100%;">
							<ul style="overflow: hidden; width: auto; height: 100%;">

							</ul>
							<div class="slimScrollBar"
								style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 79.9261px; background: rgb(0, 0, 0);"></div>
							<div class="slimScrollRail"
								style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--系统公告 end-->

		<form name="buyForm" method="post" action=" ">
			<input type="hidden" name="myProduct.keywordId" id="buyKeywordId"
				value="0">
			<input type="hidden" name="myProduct.keywordPackageNum"
				id="buyKeywordPackageNum" value="1">
			<input type="hidden" name="myProduct.keywordPackagePrice"
				id="buyKeywordPackagePrice" value="0">
		</form>
		<input type="hidden" id="sucaiTotal" value="0">
		<input type="hidden" id="collectTotal" value="0">
		<input type="hidden" id="cartTotal" value="0">
		<input type="hidden" id="userId" value="185482">
		<input type="hidden" id="firstLoginSign" value="0">
		<div id="top"></div>
		<!--head代码 start-->
		<div id="head" class="rel h_line">
			<span class="logon abs"></span>
			<nav class="abs">
			<ul>
				<li class="curr">
					<a href="<%=basePath%>search_index">首页</a>
				</li>
				<!-- 引入部分菜单 -->
				<%@ include file="/main/home/menu2.jsp" %>
				<li>
					<a href="<%=basePath%>report_findReportPage">舆情简报</a>
				</li>
				<c:if test="${sessionScope.user.loginId == 'admin'}">
					<li>
						<a href="<%=basePath%>home_queryUser">用户管理</a>
					</li>
				</c:if>
			</ul>

			</nav>

			<!-- headinfo -->
			<%@ include file="/main/home/headinfo.jsp" %>

		</div>
		<!--head代码 end-->


		<script type="text/javascript">

function isMobile() {
	var bs = {
		versions : function() {
			var u = navigator.userAgent, app = navigator.appVersion;
			return {
				windowsPhone : u.indexOf('IEMobile') > -1,
				trident : u.indexOf('Trident') > -1,
				presto : u.indexOf('Presto') > -1,
				webKit : u.indexOf('AppleWebKit') > -1,
				gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') === -1,
				mobile : !!u.match(/AppleWebKit.*Mobile.*/)
						|| !!u.match(/AppleWebKit/) || !!u.match(/IEMobile/),
				ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
				android : u.indexOf('Android') > -1
						|| u.indexOf('UCBrowser') > -1,
				iPhone : u.indexOf('iPhone') > -1,
				iPad : u.indexOf('iPad') > -1,
				webApp : u.indexOf('Safari') === -1
			};
		}(),
		language : (navigator.browserLanguage || navigator.language)
				.toLowerCase()
	};
	if (bs.versions.mobile) {
		if (bs.versions.android || bs.versions.iPhone || bs.versions.iPad
				|| bs.versions.windowsPhone) {
					//$('.fenxiang').css('display', 'none');
					//$('#weibo_task_result_star_content_div,#weibo_task_result_line_content_div,#weibo_task_result_fans_div').css('height', '220px');
					location.href = "onclick",
					"http://h5.wyq.cn/register.action";
		}
	} else {
		location.href = "/user/goRegister.shtml";
	}
}
</script>












		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<title>网络舆情</title>



		<script type="text/javascript">

var njxImgSrc = '';
var actionBase = '';
var staticResourcePath = 'http://files.wyq.cn/web';
function qwss() {

}

//设置时间
function settime(){
	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	$(".starttime").val(starttime);
	$(".endtime").val(endtime);
}

//搜索
function mtSearch(fenci){
	settime();
	var keyword = $("#title").val();
	$(".queryWord").val(keyword);
	$(".fenci").val(fenci);
	$("#searchForm").submit();
}

</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery-1.10.2.min.js">
		</script>



		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>sinaStyle/tips.css">
		<script type="text/javascript" src="<%=basePath%>sinaStyle/tips.js">
		</script>
		<input id="style" name="style" value="0" type="hidden">
		<div id="BgDiv" style="display: none"></div>
		<div id="SystemSetDiv">
			<iframe style="margin: 0px;" frameborder="0" marginheight="0"
				marginwidth="0" id="search_set" name="search_set" width="700"
				height="420" src="">
			</iframe>
		</div>

		<div class="content" style="margin-top: 40px;">
			<div class="row-fluid">
				<div class="align_c">
					<div class="hotWordsList" id="hotKeyword"
						style="width: 802px;   text-align: center;">
				 
					 
						<span> 
						检索时间：
						 <input type="text" value="<s:property value="startTime"/>"
								class="input time hasDatepicker" id="starttime" readonly="readonly"
								style="width: 120px;" onclick="WdatePicker({dateFmt:'yyyyMMdd'})">
						- <input type="text" value="<s:property value="endTime"/>"
							class="input time hasDatepicker" id="endtime" readonly="readonly"
							style="width: 120px;" onclick="WdatePicker({dateFmt:'yyyyMMdd'})">
						
						</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</div>
			</div>
			
			<div class="row-fluid">
				<div class="">

					<div class="search-wrapper" style="padding-right: 100px;">
						<form id="searchForm" action="<%=basePath%>search_newsKeyword"
							method="post">
							<!-- <input type="hidden" name="keyword" id="keyword" value="">
							<input type="hidden" name="filterKeyword" id="filterKeyword" value=""> -->
							
							<input type="hidden" name="queryWord" class="queryWord" value="<s:property value="queryWord"/>">
							<input type="hidden" name="fenci" class="fenci" value="true">
							<input type="hidden" name="startTime" class="starttime" value="<s:property value="startTime"/>"/>
							<input type="hidden" name="endTime" class="endtime" value="<s:property value="endTime"/>"/>
							
							<div class="search" style="">
								<span> <input type="text" style="display: none">
									<i class="icon-search"></i> <input type="text" class="keyWord"
										name="title" autocomplete="off" maxlength="20" id="title"
										placeholder="人名、事件名等关键词" style="color: rgb(170, 170, 170);">
								</span>
								<span> 
									<a href="javascript:mtSearch(false)" class="searchBtn">标题检索</a>
								</span>
								<a
									href="javascript:mtSearch(true)"
									class="btn btn-info abs"
									style="top: -1px; right: -121px; padding: 11.5px; font-size: 16px; display: block;">
									<i class="icon-whatshot"></i>全文检索 </a>
								<div id="history_search" style="display: none;">
									<ul id="keyWordLogs_ul" class="hotwords"
										style="display: block;">
										<li class="hwtitle">
											<span style="display: block; float: left;">最近搜索</span>
											<span onclick="deleteUserSearch()" class="scjl">删除搜索记录</span>
										</li>
										<li style="cursor: pointer;" onclick="ajaxClickEvl(this)">
											<h1>
												asfd
											</h1>
										</li>
										<li style="cursor: pointer;" onclick="ajaxClickEvl(this)">
											<h1>
												sadf
											</h1>
										</li>
									</ul>
								</div>
								<ul id="hotwords" class="hotwords" style="display: none;">

								</ul>
							</div>
						</form>
					</div>

				</div>
			</div>
			<div class="row-fluid">
				<div class="align_c">
					<div class="hotWordsList" id="hotKeyword"
						style="width: 802px; padding-left: 20px;">
						<s:iterator value="keywordList" id="kw">
							<a
								href="javascript:hotSearch('<s:property value="#kw.KEYWORD"/>')"><s:property
									value="#kw.KEYWORD" />
							</a>
						</s:iterator>
					</div>
				</div>
			</div>



			<!-- 去掉了 -->







			<div class="row-fluid" style="margin-top: 50px;">
				<div class="rankingListMore">
					<div class="right">
						<div class="title">
							<h2 id="rankingName">
								舆情热点
							</h2>
						</div>
					</div>
				</div>
				<input type="hidden" id="hotsPage" value="1">
				<div class="feature feature2" id="hotEvents">


					<script type="text/javascript">

function GotoPage(i) {
	$("#hotsPage").val(i);
	getHotEvents();
}
</script>

					<s:iterator value="%{newsList}">
						<dl class="item"  >
							<img
								src="<%=basePath%>images/home<%=(int) (Math.random() * 11) + 1%>.jpg">

							<dd>
							 
									<a href="<s:property value="url"/>" target="_blank">
																<s:property value="title" escape="false"/>
															</a>
							</dd>
							<dd class="time">
								发布时间：
								<s:property value="pubnisihTime.substring(0,10)" />
							</dd>
						</dl>
					</s:iterator>
 

					<link rel="stylesheet" type="text/css"
						href="<%=basePath%>sinaStyle/bottom_style.css" media="screen">
					<table
						style="border: solid 0px #ededed; border-bottom: 0; font-size: 14px;">










						<script src="<%=basePath%>sinaStyle/jquery-1.10.2.min(1).js"
							type="text/javascript">
						</script>
						<script src="<%=basePath%>sinaStyle/jquery.paginate.js"
							type="text/javascript">
						</script>


						<style type="text/css">
ul.jPag-pages {
	height: 28px;
	text-align: right;
}
</style>
						<tbody>
							<tr bgcolor="#ffffff">

								<td colspan="15" class="page_info"
									style="font-size: 12px; height: 60px;">
									<div style="float: right; padding-right: 0px; width: auto;">
										<div id="Pagination">
											<%@include file="/main/page.jsp"%>
										</div>
									</div>
								</td>
							</tr>

						</tbody>
					</table>


				</div>
			</div>

		</div>
		</div>
		<div class="hot_frame" id="hot_frame">

			<iframe id="hotIframe" frameborder="no" border="0" src=""
				style="width: 100%; height: 99.6%">

			</iframe>

		</div>

		<!--底部部分代码 start-->








		<div class="h35 clear"></div>
		<%@ include file="/main/home/foot.jsp" %>


		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/operatelog.js">
		</script>
		<!--底部部分代码 end-->
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/prettify.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/jquery.slimscroll.js">
		</script>
		<script type="text/javascript">
$(function() {
	$('#sharesList').slimScroll( {
		height : '368'
	});

});

//分页查询
function searchPage(page) {
	window.location.href = "<%=basePath%>search_index?currentPage=" + page;
}
//点击关键词搜索方法
function hotSearch(keyword) {
	settime();
	$(".queryWord").val(keyword);
	$("#searchForm").submit();
}
</script>



		&gt;
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/twitter-bootstrap-hover-dropdown.js">
		</script>
		<script src="<%=basePath%>sinaStyle/bootstrap.min.js">
		</script>

	</body>
</html>
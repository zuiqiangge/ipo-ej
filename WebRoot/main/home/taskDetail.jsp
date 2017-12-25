<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



			<meta http-equiv="X-UA-Compatible" content="IE=Edge">
				<meta name="renderer" content="webkit">

					<title>[鹏越微舆情]${tbXtTask.taskname }的全网事件分析，用数据挖掘真相</title>
					<meta name="author" content="">
						<meta name="keywords"
							content="微信舆情监测,微博舆情监控,舆情监测, 舆情APP ,舆情客户端，舆情软件,互联网舆情,视频舆情,海外媒体，舆情APP ,舆情客户端，舆情预警">
							<meta name="description"
								content="微舆情是中国最大的舆情服务平台，提供网页、微博、微信、电子报、视频等全媒体舆情监测方案，以及舆情事件分析、舆情简报制作，舆情日周月报自动发送、海外媒体监测、竞争情报服务等">
								<meta name="searchtitle"
									content="舆情监控,舆情监测,微博舆情监控,舆情监控软件,舆情监测系统,互联网舆情监测,舆情监控系统,互联网舆情监控,舆情监测软件,网络舆情监控系统">
									<script>
// 百度统计代码
// 	var _hmt = _hmt || [];
// 	(function() {
// 		var hm = document.createElement("script");
// 		hm.src = "//hm.baidu.com/hm.js?aaac48a09e76ccc8767f661174d83b89";
// 		var s = document.getElementsByTagName("script")[0];
// 		s.parentNode.insertBefore(hm, s);
// 	})();
</script>
									<script type="text/javascript">

var njxImgSrc = '';
var actionBase = '';
var staticResourcePath = 'http://files.wyq.cn/web';
var qrCodeImg = 'http://app.wyq.cn/QRCode/wyq_d_entry.png';
</script>
									<script type="text/javascript"
										src="<%=basePath%>sinaStyle/detail/jquery-1.10.2.min.js">
									</script>
									<script type="text/javascript"
										src="<%=basePath%>sinaStyle/detail/index.js">
									</script>
									<script type="text/javascript"
										src="<%=basePath%>sinaStyle/detail/zzsc.js">
									</script>
									<script type="text/javascript"
										src="<%=basePath%>sinaStyle/detail/navigate.js">
									</script>
									<link href="<%=basePath%>sinaStyle/detail/style.css"
										rel="stylesheet" type="text/css">
										<link href="<%=basePath%>sinaStyle/detail/zzsc.css"
											rel="stylesheet" type="text/css">
											<link href="<%=basePath%>sinaStyle/detail/font-icon.css"
												rel="stylesheet" type="text/css">
												<script src="<%=basePath%>sinaStyle/detail/bsStatic.js"
													type="text/javascript" charset="utf-8">
												</script>
												<script
													src="<%=basePath%>sinaStyle/detail/fingerprint2.min.js"
													type="text/javascript" charset="utf-8">
												</script>
												<script src="<%=basePath%>sinaStyle/detail/bs-engine.js"
													type="text/javascript" charset="utf-8">
												</script>
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
												<script src="<%=basePath%>sinaStyle/detail/bsMore.js"
													type="text/javascript" charset="utf-8">
												</script>
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
												<script data-require-id="echarts/chart/bar"
													src="<%=basePath%>sinaStyle/detail/bar.js" async="">
												</script>
												<script data-require-id="echarts/chart/tree"
													src="<%=basePath%>sinaStyle/detail/tree.js" async="">
												</script>
												<script data-require-id="echarts/chart/pie"
													src="<%=basePath%>sinaStyle/detail/pie.js" async="">
												</script>
												<script data-require-id="echarts/chart/force"
													src="<%=basePath%>sinaStyle/detail/force.js" async="">
												</script>
												<script data-require-id="echarts/chart/wordCloud"
													src="<%=basePath%>sinaStyle/detail/wordCloud.js" async="">
												</script>
												<script data-require-id="echarts/chart/line"
													src="<%=basePath%>sinaStyle/detail/line.js" async="">
												</script>
												<script src="<%=basePath%>sinaStyle/detail/bshare_view"
													type="text/javascript" charset="utf-8">
												</script>
	</head>



	<!-- 导航条用户的下拉效果-->

	<!-- 页面右侧的客户端展示的效果-->





	<body class="mobileStyle">
		<div id="wx_pic" style="margin: 0 auto; display: none;">
			<img src="<%=basePath%>sinaStyle/detail/share.png">
		</div>
		<!--
// 轻应用
<script type='text/javascript' src='http://tjs.sjs.sinajs.cn/open/thirdpart/js/frame/appclient.js' charset='utf-8'></script>
<script>
	$(function() {
		setInterval(function() {
			if (App) {
				document.body.style.height = '0px';
				document.body.style.height = 'auto';
				App.trigger('setPageHeight', $('body').css('height'));
			}
		}, 1000);
	});
</script>

// 微博内部应用
<script src="http://js.t.sinajs.cn/t5/page/js/lib/open/iframeconnect.js"></script>
<script>
	$(function() {
		setInterval(function() {
			document.body.style.height = '0px';
			document.body.style.height = 'auto';
			iconnect.trigger('setHeight', $('body').css('height').replace('px', ''));
		}, 1000);
	});
</script>
 -->


		<!-- saved from url=(0014)index:internet -->
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
			<meta name="renderer" content="webkit|ie-comp|ie-stand">
				<meta name="viewport"
					content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no">
					<meta name="format-detection" content="telephone=no">
						<meta charset="GBK">
							<title>微舆情_网络舆情监测</title>
							<meta name="keywords" content="微舆情_网络舆情监测">
								<meta name="description" content="">
									<link rel="stylesheet" type="text/css"
										href="<%=basePath%>sinaStyle/detail/common.css">
										<link rel="stylesheet" type="text/css"
											href="<%=basePath%>sinaStyle/detail/frame.css">
											<link href="<%=basePath%>sinaStyle/detail/eventAnalysis.css"
												rel="stylesheet" type="text/css">
												<link href="<%=basePath%>sinaStyle/detail/report.css"
													rel="stylesheet" type="text/css">
													<script type="text/javascript"
														src="<%=basePath%>sinaStyle/detail/jquery-1.10.2.min.js">
													</script>
													<script type="text/javascript"
														src="<%=basePath%>sinaStyle/detail/jquery-ui-1.9.1.custom.js">
													</script>
													<script
														src="<%=basePath%>sinaStyle/detail/bootstrap.min.js"
														type="text/javascript">
													</script>
													<script type="text/javascript"
														src="<%=basePath%>Scripts/echarts.js"
														charset="UTF-8">
													</script>
													<script type="text/javascript"
														src="<%=basePath%>sinaStyle/detail/map.js" charset="UTF-8">
													</script>
													<script type="text/javascript"
														src="<%=basePath%>sinaStyle/detail/treemap.js"
														charset="UTF-8">
													</script>
													<script src="<%=basePath%>sinaStyle/detail/report.js"
														type="text/javascript">
													</script>
													<!--分享-->

													<script type="text/javascript" charset="utf-8"
														src="<%=basePath%>sinaStyle/detail/buttonLite.js">
													</script>
													<script type="text/javascript">
var operateLogPageCode = '1014';
var operateLogPageName = '事件分析查看';
var operateLogRequestPath = '';
</script>
													<script type="text/javascript" charset="utf-8">
$(function() {
	var href = location.href;
	if (href.indexOf('shareCode') != -1) {
		var ti = '${tbXtTask.taskname}';
		var title = "[微舆情]" + ti + "的全网事件分析，用数据挖掘真相";
		document.title = title;
	}
});

$(function() {
	var href = location.href;
	if (href.indexOf('isShare') != -1) {
		document.title = "[微舆情]${tbXtTask.taskname}的全网事件分析，用数据挖掘真相";
	}
});

 
</script>


													<script language="javascript">
var phone = false;
var echarts;require.config({
        paths: {
            echarts: 'http://files.wyq.cn/web/js/echarts',
        }
    });
    function checkLength(which) {
        iCount = which.value.replace(/[^\u0000-\u00ff]/g,"aa");
        which.size=iCount.length+1;
    }

    $(function(){

        var bs = {
            versions: function () {
                var u = navigator.userAgent, app = navigator.appVersion;
                return {
                    windowsPhone: u.indexOf('IEMobile') > -1,
                    trident: u.indexOf('Trident') > -1,
                    presto: u.indexOf('Presto') > -1,
                    webKit: u.indexOf('AppleWebKit') > -1,
                    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') === -1,
                    mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/) || !!u.match(/IEMobile/),
                    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
                    android: u.indexOf('Android') > -1 || u.indexOf('UCBrowser') > -1,
                    iPhone: u.indexOf('iPhone') > -1,
                    iPad: u.indexOf('iPad') > -1,
                    webApp: u.indexOf('Safari') === -1
                };
            } (),
            language: (navigator.browserLanguage || navigator.language).toLowerCase()
        };

        if (bs.versions.mobile) {
            if (bs.versions.android || bs.versions.iPhone || bs.versions.iPad || bs.versions.windowsPhone) {
                //$('.fenxiang').css('display', 'none');
                //$('#weibo_task_result_star_content_div,#weibo_task_result_line_content_div,#weibo_task_result_fans_div').css('height', '220px');
                $('.echartAdpter').css('width', '80%');
                $('.echartAdpter').css('height', '300px');
                $('.echartAdpter2').css('width', '100%');
                phone = true;
                $(".fenxiang span").hide();
                $(".fenxiang a[class='icon icon_wx']").hide();
                $(".fenxiang").addClass("fenxiang2");
                $(".fenxiang").css("margin-top","10px");
                $(".fenxiang").removeClass("fenxiang float_l");

                $(".reportBox").append('<div class="row-fluid foot" style="text-align: center;">'+
                '<a href="http://a.app.qq.com/o/simple.jsp?pkgname=com.xd.wyq"><img src="/images/bottomPic.jpg" /></a></div>');
            }
        }
        $(".fenxiang,.fenxiang2").show();
    });
</script>



													<form method="post" name="frmPopWin">
														<input type="hidden" name="checkedIds" id="checkedIds">
															<input type="hidden" name="tickets" id="tickets"
																value="oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0">
																<input type="hidden" name="reportName" id="reportName"
																	value="${tbXtTask.taskname}">
																	<div id="top2" style="display: none;">
																		<div id="izl_rmenu" class="izl-rmenu">
																			 
																			<div class="btn btn-top" style="display: none;"></div>
																		</div>
																	</div>
																	<div
																		class="page-container reportWeb rel phoneTopHeight">


																		<ul id="nav2">


																			<li class="" id="r1">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr1">事件简介</a>
																			</li>
																			<li id="r2" class="current">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr2">事件走势</a>
																			</li>
																			<li id="r3" class="">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr3">网站统计</a>
																			</li>
																		 
																			<li id="r6">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr6">热门信息</a>
																			</li>
																			<li id="r7">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr7">热点网民</a>
																			</li>
																	 
																		 
																			<li id="r10">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr10">网民观点</a>
																			</li>
																			<li id="r11">
																				<a
																					href="http://wyq.sina.com/analysisPreview.shtml?isShare=1&shareType=1&tickets=oh7r8mJGefvgs59ds2VgdNES6ivY3Xm0&bsh_bid=1572883987#pr11">舆情总结</a>
																			</li>

																		</ul>

																		<!--分析完毕 start-->
																		<div class="reportPreview">
																			<div class="logo">
																				<img src="<%=basePath%>images/logon.png"
																					style=" width:240px;height:34px;">
																			</div>
																			<div class="reportCon">

																				<!--报告标题 start-->
																				<div class="row-fluid" id="ui-accordion-0">
																					<div class="reportTit">
																						<div class="textShow">

																							<ul class="column ui-sortable">
																								<li>
																									<div class="text tool tools">
																										<ul class="control" style="display: none;">

																											<li>
																												<b title="编辑" id="editorBtn"
																													class="icon-pencil"></b>
																											</li>
																											<li>
																												<b title="确定" id="okBtn" class="icon-check"
																													style="display: none;"></b>
																											</li>
																										</ul>
																										<h1 id="analysisTitle" contenteditable="false"
																											class="contenteditable">


																											${tbXtTask.taskname}的网络传播分析报告

																										</h1>
																									</div>
																								</li>
																							</ul>
																						</div>


																					</div>
																				</div>
																				<!--报告标题 end-->

																				<!--分享 start-->
																				 
																				<!--分享 end-->

																				<div class="reportBox ui-sortable">


																					<!--事件简介 start-->
																					<div class="row-fluid" id="ui-accordion-1"
																						name="r1">
																						<div class="textShow">
																							<div class="tit" id="pr1">
																								<div class="text">
																									<h2 id="contentTitle" contenteditable="false"
																										class="contenteditable modification">
																										事件简介
																									</h2>
																								</div>
																							</div>
																							<div class="tool toolhover"
																								style="display: none;">
																								<div class="btn-group btn-group2">
																									<a class="btn moveBtn"><i
																										class="icon-arrows"></i>移动</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn dropdown-toggle js-activated"
																										data-toggle="dropdown"
																										href="javascript:void(0)"> 插入 <i
																										class="icon-keyboard_arrow_down"></i> </a>
																									<ul class="dropdown-menu align_l">
																										<li>
																											<a href="javascript:void(0)" class="addText">文本框</a>
																										</li>

																										<li style="display: none;">
																											<a href="javascript:void(0)">图表</a>
																										</li>
																									</ul>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn editBtn"><i class="icon-edit"></i>编辑</a>
																									<a class="btn saveBtn" style="display: none;"><i
																										class="icon-check"></i>保存</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn removeBtn"><i
																										class="icon-remove"></i>移除</a>

																								</div>
																							</div>
																							<ul class="column ui-sortable">
																								<li>
																									<div class="text tool tools">
																										<ul class="control" style="display: none;">
																											<li>

																											</li>
																											<li>
																												<b title="编辑" id="editorBtn"
																													class="icon-pencil"></b>
																											</li>
																											<li>
																												<b title="确定" id="okBtn" class="icon-check"
																													style="display: none;"></b>
																											</li>
																											<li>
																												<b title="删除" id="deleteBtn"
																													class="icon-trash-o"></b>
																											</li>
																										</ul>
<div contenteditable="false"
	class="textCon contenteditable"
	id="introduce">${testaf }${tyxx.id} ${tyxxxx.fastigiumDate}
	本报告围绕关键词“${tbXtTask.queryword}”，对${tbXtTask.querydateks}~${tbXtTask.querydatejs}
期间，互联网上采集到的${tbXtTask.totalitem}条信息进行了深入分析。全网信息量最高峰出现在<fmt:formatDate value="${taskDetailVo.fastigiumDate}" pattern="yyyy-MM-dd"/>，当天共产生${taskDetailVo.fastigiumCount}篇相关讯息；事件源头于
${taskDetailVo.taskResList[0].resultpubtime}发布在${taskDetailVo.taskResList[0].resultsource}上，题名为：『${taskDetailVo.taskResList[0].resulttitle}』。
	后续报道主要来源于
<c:forEach var="site" items="${taskDetailVo.siteSource}" varStatus="No">
	${site}<c:if test="${fn:length(taskDetailVo.siteSource) ne No.index+1}">、</c:if>
</c:forEach>
等几大站点。总体来说，整个事件的发展趋势较为突出，详细报告如下。
</div>
																									</div>
																								</li>
																							</ul>
																						</div>

																					</div>
																					<!--事件简介 end-->

																					<!--事件走势 start-->
																					<div class="row-fluid" id="ui-accordion-2"
																						name="r2">
																						<div class="textShow">
																							<div class="tit" id="pr2">
																								<div class="text">
																									<h2 id="contentTitle" contenteditable="false"
																										class="contenteditable modification">
																										事件走势
																									</h2>
																								</div>
																							</div>
																							<div class="tool toolhover"
																								style="display: none;">
																								<div class="btn-group btn-group2">
																									<a class="btn moveBtn"><i
																										class="icon-arrows"></i>移动</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn dropdown-toggle js-activated"
																										data-toggle="dropdown"
																										href="javascript:void(0)"> 插入 <i
																										class="icon-keyboard_arrow_down"></i> </a>
																									<ul class="dropdown-menu align_l">
																										<li>
																											<a href="javascript:void(0)" class="addText">文本框</a>
																										</li>

																										<li style="display: none;">
																											<a href="javascript:void(0)">图表</a>
																										</li>
																									</ul>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn editBtn"><i class="icon-edit"></i>编辑</a>
																									<a class="btn saveBtn" style="display: none;"><i
																										class="icon-check"></i>保存</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn removeBtn"><i
																										class="icon-remove"></i>移除</a>

																								</div>
																							</div>

																							<ul class="column ui-sortable">

																								<li class="" style="">
																									<div class="text tool tools">
																										<ul class="control" style="display: none;">
																											<li>
																												<b id="moveBtn" class="icon-arrows"
																													title="移动"></b>
																											</li>
																											<li>
																												<b id="editorBtn" class="icon-pencil"
																													style="display: none;" title="编辑"></b>
																											</li>
																											<li>
																												<b id="okBtn" class="icon-check" title="确定"></b>
																											</li>
																											<li>
																												<b id="deleteBtn" class="icon-trash-o"
																													title="删除"></b>
																											</li>
																										</ul>
																									</div>
																								</li>
																								<li>
																									<div class="yb2 rel" id="eventProfile">
																										<h2>
																											<div>
																												<span class="contenteditable"
																													contenteditable="false">${taskDetailVo.taskResList[0].resultpubtime}</span>
																											</div>
																										</h2>
																										<div class="more">
																											<span class="packUp2"><a
																												href="javascript:void(0)"><label>
																														展开事件进展&nbsp;
																														<i></i>
																													</label>
																											</a>
																											</span>
																										</div>
																										<ul id="trend" class="ui-sortable"
																											style="padding-bottom: 0;">
																											
			<c:forEach var="res" items="${taskDetailVo.taskResList}" varStatus="No">
			<c:choose>
				<c:when test="${No.index ge 5}">
					<li style="display: none;">
						<div class="float_l">
							<span class="line"></span><span
								class="round"></span><span class="line"></span>
						</div>
						<div class="sz"></div>
							<div class="text text2">
							<i class="icon-arrows yb-move"
								style="display: none;"></i><i
								class="icon-trash-o yb-delete"
								onclick="del(this);"
								style="display: none;"></i><i
								class="icon-control_point yb-add"
								onclick="add();" style="display: none;"></i>
								
									<div class="contenteditable"
										contenteditable="false"
										style="padding-bottom: 10px;">
											<a
											style="color: #000; text-decoration: none;"
											target="_blank"
											href="${res.resulturl}">[${res.resultpubtime}]${res.resulttitle}[${res.resultsource}] 点击量：${res.clickedCounts}</a>
									</div>
							</div>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<div class="float_l">
							<span class="line"></span><span
								class="round"></span><span class="line"></span>
						</div>
						<div class="sz"></div>
							<div class="text text2">
							<i class="icon-arrows yb-move"
								style="display: none;"></i><i
								class="icon-trash-o yb-delete"
								onclick="del(this);"
								style="display: none;"></i><i
								class="icon-control_point yb-add"
								onclick="add();" style="display: none;"></i>
								
									<div class="contenteditable"
										contenteditable="false"
										style="padding-bottom: 10px;">
											<a
											style="color: #000; text-decoration: none;"
											target="_blank"
											href="${res.resulturl}">[${res.resultpubtime}]${res.resulttitle}[${res.resultsource}] 点击量：${res.clickedCounts}</a>
									</div>
							</div>
					</li>
				</c:otherwise>
			</c:choose>
					
			</c:forEach>
																											
	</ul>
	<ul style="padding-top: 2px;">
		<li>
			<div class="float_l">
				<span class="roundEnd">续</span>
							</div>
						</li>
					</ul>
				</div>
			</li>
		</ul>
	</div>
</div>
																					<!--事件走势 end-->


																					<!--网站统计 start-->
																					<div class="row-fluid" id="ui-accordion-3"
																						name="r3">
																						<div class="textShow">
																							<div class="tit" id="pr3">
																								<div class="text">
																									<h2 id="contentTitle" contenteditable="false"
																										class="contenteditable modification">
																										网站统计
																									</h2>

																								</div>

																							</div>
																							<div class="tool toolhover"
																								style="display: none;">
																								 
																							</div>

																							<ul class="column ui-sortable">
																								<div class="wyqBorder chartMapBK">

																									<div class="chartMap">
												<div id="tongjitu" style="width: 600px; height: 400px;  "></div>
			<script>
     var myCharts1 = echarts.init(document.getElementById('tongjitu'));
     var option = {
    		    title : {
    		        text: '微舆情主要网站来源',
    		        subtext: '鹏越分析技术',
    		        x:'center'
    		    },
    		    tooltip : {
    		        trigger: 'item',
    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
    		    },
    		    legend: {
    		    	show:true,
    		        orient: 'vertical',
    		        left: 'left',
    		        data: ${taskDetailVo.siteSourceJson} 
    		    },
    		    series : [
    		        {
    		            name: '网站来源',
    		            type: 'pie',
    		            radius : '70%',
    		            center: ['50%', '60%'],
    		            data:${taskDetailVo.siteSourcePieJson},
    		            itemStyle: {
    		                emphasis: {
    		                    shadowBlur: 10,
    		                    shadowOffsetX: 0,
    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    		                }
    		            }
    		        }
    		    ]
    		};
     myCharts1.setOption(option);
 </script>
 
										</div>

																								</div>

																							</ul>
																						</div>
																					</div>
																					<!--网站统计 end-->

																					<!--数据类型 start-->
																					 
																					<!--数据类型 end-->

																					<!--关键词云 start-->
																					 
																					<!--关键词云 end-->


																					<!--热门信息 start-->
																					<div class="row-fluid" id="ui-accordion-6"
																						name="r6">
																						<div class="textShow">
																							<div class="tit" id="pr6">
																								<div class="text">
																									<h2 id="contentTitle" contenteditable="false"
																										class="contenteditable modification">
																										热门信息
																									</h2>
																								</div>
																							</div>

																							<div class="tool toolhover"
																								style="display: none;">
																								<div class="btn-group btn-group2">
																									<a class="btn moveBtn"><i
																										class="icon-arrows"></i>移动</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn dropdown-toggle js-activated"
																										data-toggle="dropdown"
																										href="javascript:void(0)"> 插入 <i
																										class="icon-keyboard_arrow_down"></i> </a>
																									<ul class="dropdown-menu align_l">
																										<li>
																											<a href="javascript:void(0)" class="addText">文本框</a>
																										</li>

																									</ul>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn editBtn"><i class="icon-edit"></i>编辑</a>
																									<a class="btn saveBtn" style="display: none;"><i
																										class="icon-check"></i>保存</a>
																								</div>
																								<div class="btn-group btn-group2">
																									<a class="btn removeBtn"><i
																										class="icon-remove"></i>移除</a>
																								</div>
																							</div>

																							<ul class="column ui-sortable">
																								<li>
																									<div class="text chart">
																										<div class="textCon">
																											<table border="0" id="hotTable"
																												cellspacing="0" cellpadding="0"
																												class="table table2 float_l">
																												<thead>
																													<tr>
																														<th width="">
																															标题
																														</th>
																														<th width="25%">
																															来源站点
																														</th>
																														<th width="15%" class="phone_hide">
																															时间
																														</th>
																														<th width="15%">
																															点击量
																														</th>
																														<th width="10%" style="display: none;">
																															操作
																														</th>
																													</tr>
																												</thead>
																												<tbody id="hotNews" class="ui-sortable">
																													
		<c:forEach var="res" items="${taskDetailVo.taskResListByClickTop10}">
			<tr>
				<td>
					<div class="contenteditable"
						contenteditable="false">
						<a class="shareA blackLink" target="_blank" href="${res.resulturl}">
							${res.resulttitle}
						</a>
					</div>
				</td>
				<td>
					<div class="contenteditable"
						contenteditable="false">
						${res.resultsource}
				</div>
				</td>
				<td class="phone_hide">
					<div class="contenteditable"
						contenteditable="false">
						${res.resultpubtime}
					</div>
				</td>
				<td>
					<div class="contenteditable"
						contenteditable="false">
						${res.clickedCounts}
					</div>
				</td>
				<td style="display: none;">
					<i class="icon-arrows td-move"></i><i
						class="icon-control_point td-add"></i><i
						class="icon-trash-o td-delete"></i>
				</td>
			</tr>
</c:forEach>										
								</tbody>
						</table>
					</div>
				</div>
			</li>
		</ul>
	</div>

</div>
<!--热门信息 end-->


				<!--热点网民 start-->
				<div class="row-fluid" id="ui-accordion-7"
					name="r7">
					<div class="textShow">
						<div class="tit" id="pr7">
							<div class="text">
								<h2 id="contentTitle" contenteditable="false"
									class="contenteditable modification">
									热点网民
								</h2>
							</div>
						</div>																	

																							 

				<ul class="column ui-sortable">
					<li>
						<div class="text chart">
							<div class="textCon">
								<div class="wyqBorder wyqBorder2">
									<div class="yq_con yqtabs tabsBorder">
										<div class="tool">
											<div class="btn-group btn-group2">
												<a id="listBox" class="btn listMo"
													style="display: none;" title="列表样式"><i
													class="icon-th"></i>列表样式</a>
												<a id="circularRing" class="btn cirMo"
													style="display: none;" title="圆环样式"><i
													class="icon-dot-circle-o"></i>圆环样式</a>
											</div>
										</div>
										<ul class="tab_menu clear">
											<li class="current">
												全部
											</li>
											<c:forEach var="fourm" items="${taskDetailVo.tbXtSourceList }">
												<li>
													${fourm}
												</li>
											</c:forEach>
										</ul>
										<div class="tab_box" id="hotPeople">
										<c:forEach var="fourm" items="${taskDetailVo.forumUserList}" varStatus="No">
												<c:choose>
													<c:when test="${No.index eq '0'}">
														<div>
														<div class="mwblist">
														<div class="tabName">
																<i class="icon-user"></i>
																<p>
																	热点网民
																</p>
																<p>
																	(全部)
																</p>
															</div>
															<ul>
																<c:forEach var="user" items="${fourm}">
																	<li>
																		<div class="tx">
																			<img
																				src="<%=basePath%>sinaStyle/detail/app-more-icon-bbs.jpg">
																		</div>
																		<p class="mscrame">
																			<a
																				href="#"
																				target="_blank" class="a1">${user.userName }</a><a
																				href="#"><i
																				class="W_icon"></i>
																			</a>
																		</p>
																		<p class="msfs">
																			发帖数：${user.count}
																		</p>
																	</li>
																</c:forEach>
															</ul>
														</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="hide">
														 	<div class="mwblist">
														<div class="tabName">
																<i class="icon-user"></i>
																<p>
																	热点网民
																</p>
																<p>
																	(全部)
																</p>
															</div>
															<ul>
																<c:forEach var="user" items="${fourm}">
																	<li>
																		<div class="tx">
																			<img
																				src="<%=basePath%>${user.image}">
																		</div>
																		<p class="mscrame">
																			<a
																				href="#"
																				target="_blank" class="a1">${user.userName }</a><a
																				href="#"><i
																				class="W_icon"></i>
																			</a>
																		</p>
																		<p class="msfs">
																			发帖数：${user.count}
																		</p>
																	</li>
																</c:forEach>
															</ul>
														</div>
														</div>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>

				</ul>
			</div>



</div>
<!--热点网民 end-->


<!--传播途径 start-->

<!--传播途径 end-->


<!--相关词 start-->

<!--相关词 end-->


<!--网民观点 start-->
<div class="row-fluid" id="ui-accordion-10"
	name="r10">
	<div class="textShow">
		<div class="tit" id="pr10">
			<div class="text">
				<h2 id="contentTitle" contenteditable="false"
					class="contenteditable modification">
					网民观点
				</h2>
			</div>
		</div>

		 

		<ul class="column ui-sortable">
			<li>
				<div class="wyqBorder chartMapBK">
					<h2 contenteditable="false"
						class="contenteditable">
						新闻观点分析
					</h2>
					<div class="chartMap">
						<div class="viewpoint" id="container10List">
							<div class="title">
								<h1>
									<i class="icon-users"></i>
									媒体观点主要表现在如下几个方面：
								</h1>
							</div>
							<ul>
							<c:forEach var="news" items="${taskDetailVo.taskResListByNews}">
								<li>
									<h2 contenteditable="false"
										class="contenteditable">
										<i class="icon-close deleLi"></i>
										<a
										class="shareA"
										style="text-decoration: none;"
										href="${news.resulturl}"
										target="_blank">${news.resulttitle}----------【${news.resultsource}】</a>
									</h2>
								</li>
							</c:forEach>
							</ul>
					</div>
				</div>
			</div>
		</li>


		<li>
			<div class="wyqBorder chartMapBK">
				<h2 contenteditable="false"
					class="contenteditable">
					论坛观点分析
				</h2>
				<div class="chartMap">
					 
					<div class="viewpoint" id="container11List">
						<div class="title">
							<h1>
								<i class="icon-users"></i>
								网友观点主要表现在如下几个方面：
							</h1>
						</div>
						<ul>
						<c:forEach var="forum" items="${taskDetailVo.taskResListByForum}">
							<li>
								<h2 contenteditable="false"
									class="contenteditable">
									<i class="icon-close deleLi"></i>
									<a class="shareA"
										style="text-decoration: none;"
										href="${forum.resulturl}"
										target="_blank">${forum.resulttitle}----------【${forum.resultsource}】</a>
								</h2>
							</li>
						</c:forEach>
						</ul>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</div>
<!--网民观点 end-->

<!--舆情总结 start-->
<div class="row-fluid" id="ui-accordion-11"
	name="r11">
	<div class="textShow">
		<div class="tit" id="pr11">
			<div class="text">
				<h2 id="contentTitle" contenteditable="false"
					class="contenteditable modification">
					舆情总结
				</h2>
			</div>

		</div>
		<div class="tool toolhover"
			style="display: none;">
<div class="btn-group btn-group2">
	<a class="btn moveBtn"><i
		class="icon-arrows"></i>移动</a>
</div>
<div class="btn-group btn-group2">
	<a class="btn dropdown-toggle js-activated"
		data-toggle="dropdown"
		href="javascript:void(0)"> 插入 <i
		class="icon-keyboard_arrow_down"></i> </a>
	<ul class="dropdown-menu align_l">
		<li>
			<a href="javascript:void(0)" class="addText">文本框</a>
		</li>

	</ul>
</div>
<div class="btn-group btn-group2">
	<a class="btn editBtn"><i class="icon-edit"></i>编辑</a>
	<a class="btn saveBtn" style="display: none;"><i
			class="icon-check"></i>保存</a>
	</div>
	<div class="btn-group btn-group2">
		<a class="btn removeBtn"><i
			class="icon-remove"></i>移除</a>
	</div>
</div>
<ul class="column ui-sortable">
	<li>
		<div class="text tool tools">
			<ul class="control" style="display: none;">
	<li>
		<b title="编辑" id="editorBtn"
			class="icon-pencil" style="display: block;"></b>
	</li>
	<li>
		<b title="确定" id="okBtn" class="icon-check"
			style="display: none;"></b>
						</li>
						<li>
							<b title="删除" id="deleteBtn"
								class="icon-trash-o"></b>
						</li>
					</ul>
					<div contenteditable="false"
						class="textCon contenteditable" id="summary">
						综上所述，在『${tbXtTask.taskname}』事件/话题中，媒体主流报道为『${taskDetailVo.taskResListByNews[0].resulttitle}』，
						网民主流意见为『${taskDetailVo.taskResListByForum[0].resulttitle}』；应深入挖掘网民意见和情感倾向，识别事件传播过程中的意见领袖和主要信息来源，预测或追踪舆论走向，以便对不良舆论进行疏导。
					</div>
				</div>
			</li>
		</ul>



	</div>
</div>
<!--舆情总结 end-->



																					 

																				</div>

																				<div class="row-fluid">


																				</div>
																 

																			</div>
																		</div>
																		<!--分析完毕 end-->

																	</div>
													</form>





													<!-- 修改观点弹窗 start -->
													 
													<!-- 修改观点弹窗 end -->

													<script
														src="<%=basePath%>sinaStyle/detail/twitter-bootstrap-hover-dropdown.min.js">
													</script>

													<script src="<%=basePath%>sinaStyle/detail/jquery.nav2.js">
													</script>
													<script src="<%=basePath%>sinaStyle/detail/jquery.tabs.js">
													</script>
													<script>
$(function() {
	$('.js-activated').dropdownHover();
	$('#nav2').onePageNav();
	$('.yqtabs').Tabs( {
		event : 'click'
	});

});
</script>

													<script type="text/javascript">
/*----外置函数star----*/
var ie = !!window.attachEvent && !window.opera;
var ie9 = ie && (!!+"\v1");
var inputhandler = function(node, fun) {
	if ("oninput" in node) {
		node.oninput = fun;
	} else {
		node.onpropertychange = fun;
	}
	if (ie9)
		node.onkeyup = fun;
}

/*----外置函数end---*/
var main = document.getElementById("textarea3");
inputhandler(main, function() {
	if (!ie)
		main.style.height = 48 + "px";
	var height = main.scrollHeight;
	if (height >= 48) {
		main.style.height = height + "px";
	} else {
		main.style.height = 48 + "px";
	}
});
</script>

													<!--表格头部固定JS start-->
													<script type="text/javascript"
														src="<%=basePath%>sinaStyle/detail/jquery.chromatable.js">
													</script>
													<script type="text/javascript">

$(document).ready(function() {

	$("#map_table").chromatable( {
		width : "100%",
		height : "350px",
		scrolling : "yes"
	});

});
</script>


													<script type="text/javascript">
$(".toolhover").hide();
$("ul.control").hide();
$("div.align_c").hide();

$(".listMo").hide();
$(".cirMo").hide();
</script>

													<!--表格头部固定JS end-->
													<script type="text/javascript">

 
    var num=1;
    $(".more").on("click",function(){
        if(num){
            num--;
            $("#trend > li:gt(3)").show();
            $(this).html("<span class='packUp'><a href='javascript:void(0)'><label>收拢事件进展&nbsp;<i></i></label></a></span>");
        }else{
            num++;
            $("#trend > li:gt(3)").hide();
            $(this).html("<span class='packUp2'><a href='javascript:void(0)'><label>展开事件进展&nbsp;<i></i></label></a></span>");
        }
    });

 
</script>
							 

													 
	</body>
</html>

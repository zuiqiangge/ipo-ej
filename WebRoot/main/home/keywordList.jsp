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
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">



		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="renderer" content="webkit">

		<title>鹏越微舆情-互联网大数据平台</title>
		<meta name="author" content="">
		<meta name="keywords"
			content="微信舆情监测,微博舆情监控,舆情监测, 舆情APP ,舆情客户端，舆情软件,互联网舆情,视频舆情,海外媒体，舆情APP ,舆情客户端，舆情预警">
		<meta name="description"
			content="鹏越微舆情是中国最大的舆情服务平台，提供网页、微博、微信、电子报、视频等全媒体舆情监测方案，以及舆情事件分析、舆情简报制作，舆情日周月报自动发送、海外媒体监测、竞争情报服务等">
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
			src="<%=basePath%>sinaStyle/index/jquery-1.10.2.min.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/index.js">
		</script>

		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/navigate.js">
		</script>
		<link href="<%=basePath%>sinaStyle/index/style.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/index/zzsc.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/index/font-icon.css"
			rel="stylesheet" type="text/css">
		<!-- layer -->
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>/layer/mobile/need/layer.css">
	<SCRIPT src="<%=basePath%>/layer/layer.js"></SCRIPT>	
	</head>



	<!-- 导航条用户的下拉效果-->

	<!-- 页面右侧的客户端展示的效果-->





	<body>
		<div id="wx_pic" style="margin: 0 auto; display: none;">
			<img src="<%=basePath%>sinaStyle/index/share.png">
		</div>
		<!--
 

		<!-- saved from url=(0014)index:internet -->
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta charset="GBK">
		<title>鹏越微舆情_网络舆情监测</title>
		<meta name="keywords" content="鹏越微舆情_网络舆情监测">
		<meta name="description" content="鹏越微舆情_网络舆情监测">
		<link href="<%=basePath%>sinaStyle/index/style.css" rel="stylesheet"
			type="text/css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/index/common.css">
		<link href="<%=basePath%>sinaStyle/index/eventAnalysis.css"
			rel="stylesheet" type="text/css">
		<link href="<%=basePath%>sinaStyle/index/zzsc.css" rel="stylesheet"
			type="text/css">
		<!--浮动栏样式-->
		<link rel="stylesheet"
			href="<%=basePath%>sinaStyle/index/jquery.Framer.css">
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery-1.10.2.min.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/index.js">
		</script>
		<script src="<%=basePath%>sinaStyle/index/jquery.JPlaceholder.js">
		</script>


		<!--时间插件-->
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>sinaStyle/index/date-style.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/index/date-jquery-ui.css">
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery-ui-1.10.4.custom.min.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery.ui.datepicker-zh-CN.js"
			charset="UTF-8">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery-ui-timepicker-addon.js"
			charset="UTF-8">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery-ui-timepicker-zh-CN.js"
			charset="UTF-8">
		</script>
		<script type="text/javascript">
var operateLogPageCode = '1013';
var operateLogPageName = '事件分析';
var operateLogRequestPath = '';
</script>
		<script type="text/javascript">
var jquery = $;
$(function() {

	jquery(".showStarttime,.showEndtime").datetimepicker( {
		maxDate : new Date(),
		minDate : new Date(2016, 1 - 1, 1)
	});//{maxDate:new Date(),minDate:new Date(2016,1-1,1)}
})
</script>

<!--浮动栏JS-->
	<script type="text/javascript"
		src="<%=basePath%>sinaStyle/index/event.js">
												</script>
		<style>
div#framer #framerContainer {
	background-color: #fff;
}

.tdClick {
	cursor: pointer
}

.tdClick:hover {
	color: #e66100
}
</style>














		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<title>鹏越微舆情_网络舆情监测</title>
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
</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery-1.10.2.min.js">
		</script>



		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>sinaStyle/index/tips.css">
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/tips.js">
		</script>
		<input id="style" name="style" value="0" type="hidden">
		<div id="BgDiv" style="display: none"></div>
		<div id="SystemSetDiv">
			<iframe style="margin: 0px;" frameborder="0" marginheight="0"
				marginwidth="0" id="search_set" name="search_set" width="700"
				height="420" src="">
			</iframe>
		</div>
		<div id="InfoDiv">
			<div class="td_title rel">
				<h1>
					温馨提示
				</h1>
				<a href="http://wyq.sina.com/view/eventAnalysis/taskList.action#"
					class="info_close abs">×</a>
			</div>
			<div class="td_msg">
				<span id="msg" class="msg"></span>
			</div>
			<div class="btn_div">
				<a id="submitBtn" class="submitBtn button float_l">确定</a>
				<a id="cancelBtn" class="cancelBtn button float_r">取消</a>
			</div>

		</div>
		<div id="SmsDiv">
			<iframe scrolling="no" style="" frameborder="0" marginheight="0"
				marginwidth="0" id="send_sms_frame" width="100%" height="100%"
				src="">
			</iframe>
		</div>
		<div id="EditBSDiv">
			<iframe scrolling="no" style="" frameborder="0" marginheight="0"
				marginwidth="0" id="edit_bs_frame" width="100%" height="100%" src="">
			</iframe>
		</div>










		<link href="<%=basePath%>sinaStyle/index/openWeiboImg.css"
			rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/index/accordion.css">
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/prettify.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/jquery.slimscroll.js">
		</script>


		<script>
var jquery2 = $;
var njxBasePath = '';
var baseAction = '';
function logout() {
	window.location.href = "/logout.action";
}
$(function() {
	$('.Oper1a').click(function() {
		$('.fold1').stop().hide();
		$('.open1').stop().show(); //显示
		});
	$('.Oper1b').click(function() {
		$('.fold1').stop().show();
		$('.open1').stop().hide(); //隐藏
		});
	parent.hideEventDiv();
});

$(function() {
	jquery2('#noticeCon ul').slimScroll( {
		height : '100%'
	});
});

function getSelectedText() {
	if (window.getSelection) { //FF
		return window.getSelection().toString();
	} else { //IE
		return document.selection.createRange().text;
	}
}/* 选中文字显示按钮效果 end */


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

		<!--系统公告 start-->
		<div id="notice" class="topFloat_r">
			<div class="notice">
				<a class="close" id="closeNotice"
					href="#"
					style="background: none;">×</a>
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
								style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 74.6155px; background: rgb(0, 0, 0);"></div>
							<div class="slimScrollRail"
								style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; background: rgb(51, 51, 51);"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--系统公告 end-->

		<form name="buyForm" method="post"
			action="http://wyq.sina.com/pay/confirm.shtml">
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
		<input type="hidden" id="userId" value="232379">
		<input type="hidden" id="firstLoginSign" value="">
		<div id="top">
			<div id="izl_rmenu" class="izl-rmenu">
				<a href="javascript:;"> </a>
				<div style="display: none;" id="commonShare" class="btn btn-fx">

					<div class="btn btn-top"></div>
				</div>
			</div>
			<!--head代码 start-->
				<div id="head" class="rel h_line">
			<div class="head-top">
				<span class="logon float_l"></span>
				<div class="user">
					<div class="userNav float_l">
						<ul>
							<li>
								<a href="javascript:void(0);" id="noticeLink">系统公告</a>
							</li>


							<li>
								<a href="<%=basePath%>home_logout">退出</a>
							</li>
						</ul>
					</div>
					<div class="float_r">
						<span class="user_pic rel"> <em></em> <a
							href=""> <img
									src="<%=basePath%>sinaStyle/reportStyle/default.jpg" width="30"
									height="30" class="tx"> </a> <span class="f_c6"> <a
								href="">${sessionScope.user.loginId} </a> </span>
						</span>
					</div>
				</div>
			</div>
			<nav class="">
			<ul>
				<li>
					<a href="<%=basePath%>search_index">首页</a>
				</li>
				<%@ include file="/main/home/menu2.jsp" %>
				<li>
					<a href="<%=basePath%>report_findReportPage">舆情简报</a>
				</li>
				<li class="curr">
					<a href="<%=basePath%>news_keyWordList">过滤词</a>
				</li>
				<li>
					<a href="<%=basePath%>home_queryUser">用户管理</a>
				</li>
				<li>
					<a href="<%=basePath%>regionkeyword_findAll">地区关键词管理</a>
				</li>
			</ul>
			</nav>
		</div>	
			<!--head代码 end-->


			<script type="text/javascript">
$(function() {
	$(".jcfaNav li").mouseover(function() {
		$(this).find(".dele").show();
	});
	$(".jcfaNav li").mouseout(function() {
		$(this).find(".dele").hide();
	});
});

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

$(function() {
	//温馨提示
	$(".user_pic .UserPrompt .UPclose").on("click", function(e) {
		$(".user_pic").find(".UserPrompt").css("display", "none");
		$(".user_pic").find("em").css("display", "none");
	});
});

$(document).ready(function() {
	$(".user_pic").find(".UserPrompt").css("display", "block");
});
</script>

			<div class="page-container2">
				<input type="hidden" id="heatName">
				<!--预警设置 start-->
				<div class="content eventAnalysis rel" id="wrap">
					<!--关键词分析列表 start-->
					<div class="frameCon pading10">
						<form id="loginRecordForm"
							action="http://wyq.sina.com/view/hotSearch/verifyOperateInfo.action"
							method="post">
							<input type="hidden" name="notLoginOperateRecord.name"
								id="recordName" value="">
							<input type="hidden" name="notLoginOperateRecord.keyword"
								id="recordKeyword" value="">
							<input type="hidden" name="notLoginOperateRecord.filterKeyword"
								id="recordFilterKeyword" value="">
							<input type="hidden" name="notLoginOperateRecord.jsonData"
								id="recordData" value="">
							<input type="hidden" name="notLoginOperateRecord.operateType"
								id="recordType" value="">
						</form>
						<div class="tit rel titlBar">
							<h1>
								<li class="current">
									过滤词
								</li>
							</h1>
							<span class="small">—</span>
							<i class="icon-help"></i>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							搜索过滤词：
							<input class="input" type="text" value="${newsKeyWord.keyWord}" name="keyWord" id="keyWord"/>
							<button class="submitBtn2 button" id="seek">搜索</button>
						</div>
						
						<script type="text/javascript">
							$("#seek").click(function(){
								var keyword=$("#keyWord").val();
								window.location.href="<%=basePath%>news_keyWordList?newsKeyWord.keyWord="+keyword;
							});
						</script>

						<div class="tipinfo showing">
							<div class="tiparro">
								<i class="icon-remove close"></i>
							</div>
							<div class="tipcont">
								对系统的过滤词进行管理
							</div>
						</div>

						<ul class="tab_menu clear mt10 rel">
						<div class="tool" style="top: 5px; right: 5px;">
								<button type="button" class="button button3"
									onclick="goCreate('<%=basePath%>main/home/keywordcpm.jsp');">
									创建过滤词
								</button>
						</div>
					<li	class="current">
						词列表</li>
						</ul>
						<div class="tab_box">
							<div class="table table2 float_l">
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
									style="margin-bottom: 1px;">
									<thead>
										<tr>
											<th width="5%">
												序号
											</th>
											<th width="">
												过滤词
											</th>
											<th width="28%">
												创建时间
											</th>
											<th width="18%">
												操作
											</th>
										</tr>
									</thead>
									<tbody>
										<input type="hidden" id="tickets"
											value="">
									<c:forEach items="${newsKeyWord.results}" var="word" varStatus="No">
										<tr id="${word.id}">
											<td>
												${No.index+1}
											</td>
											<td>
												${word.keyWord}
											</td>
											<td>
												${word.addTime}
											</td>
                                        <td  class="link">
                                            <a href="javascript:void(0);" onclick="goCreate('<%=basePath%>main/home/keywordcpm.jsp?id=${word.id}&keyword=${word.keyWord}');">修改</a> |
                                            <a href="javascript:void(0);" onclick="javascript:del('${word.id}');">删除</a>
                                        </td>
										</tr>
									</c:forEach>

									</tbody>
								</table>

								<!--翻页 start-->
								<link rel="stylesheet" type="text/css"
									href="<%=basePath%>sinaStyle/index/bottom_style.css"
									media="screen">
								<table
									style="border: solid 0px #ededed; border-bottom: 0; font-size: 14px;">
									<script
										src="<%=basePath%>sinaStyle/index/jquery-1.10.2.min(1).js"
										type="text/javascript">
									</script>
									<script src="<%=basePath%>sinaStyle/index/jquery.paginate.js"
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
														<ul class="pagination">
															<c:choose>
																<c:when test="${newsKeyWord.pageNo==1 }"><li class="first disabled"><a href="#">首页</a></li></c:when>
																<c:otherwise><li class="first active"><a href="<%=basePath%>news_keyWordList?newsKeyWord.pageNo=1&newsKeyWord.keyWord=${newsKeyWord.keyWord}">首页</a></li></c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${newsKeyWord.pageNo==1 }"><li class="prev disabled"><a href="#">上一页</a></li></c:when>
																<c:otherwise><li class="prev"><a href="<%=basePath%>news_keyWordList?newsKeyWord.pageNo=${newsKeyWord.pageNo-1}&newsKeyWord.keyWord=${newsKeyWord.keyWord}">上一页</a></li></c:otherwise>
															</c:choose>
															<c:forEach begin="${newsKeyWord.startPage}" end="${newsKeyWord.endPage}" var="No">
																<c:choose>
																<c:when test="${newsKeyWord.pageNo==No }"><li class="page active"><a href="#">${No}</a></li></c:when>
																<c:otherwise><li class="page"><a href="<%=basePath%>news_keyWordList?newsKeyWord.pageNo=${No}&newsKeyWord.keyWord=${newsKeyWord.keyWord}">${No}</a></li></c:otherwise>
																</c:choose>
															</c:forEach>
															<c:choose>
																<c:when test="${newsKeyWord.pageNo==newsKeyWord.totalPage }">
																	<li class="next disabled"><a href="#">下一页</a></li>
																	<li class="next disabled"><a href="#">末页</a></li>
																</c:when>
																<c:otherwise>
																<li class="next"><a href="<%=basePath%>news_keyWordList?newsKeyWord.pageNo=${newsKeyWord.pageNo+1}&newsKeyWord.keyWord=${newsKeyWord.keyWord}">下一页</a></li>
																<li class="next"><a href="<%=basePath%>news_keyWordList?newsKeyWord.pageNo=${newsKeyWord.totalPage}&newsKeyWord.keyWord=${newsKeyWord.keyWord}">末页</a></li>
																</c:otherwise>
															</c:choose>
														</ul>
													</div>
												</div>
											</td>
										</tr>

									</tbody>
								</table>
								<!--翻页 end-->


							</div>
						</div>

					</div>
					<!--关键词分析列表 end-->
					<div class="h10 clear"></div>
				</div>
				<!--预警设置 end-->
			</div>
			<!-- 条件设置 -->
			<div id="eventDiv" class="zz_content"
				style="left: 50%; top: 10%; width: 800px; height: 200px; position: absolute; margin-left: -400px; display: none;">
				<a href="javascript:parent.hideEventDiv();" class="info_close abs">×</a>
				<iframe id="event_frame" scrolling="no" style="" frameborder="0"
					 width="100%" height="100%" src="">
				</iframe>
			</div>

			<!-- 新版购买 -->








			<link href="<%=basePath%>sinaStyle/index/common.css" rel="stylesheet"
				type="text/css">
			<script src="<%=basePath%>sinaStyle/index/bootstrap.min.js">
			</script>



			<!--增强复选框和单选按钮 js-->
			<script src="<%=basePath%>sinaStyle/index/icheck.js">
			</script>
			<script>
			function del(id) {
				layer.confirm('您确定要删除吗？', {
					  btn: ['确定','算了']
					}, function(){
						$.ajax( {
							url : "<%=basePath%>news_delWord",
							type : "POST",
							data : {
								"newsKeyWord.id" : id
							},
							success : function(data) {
								if (data == true) {
									layer.msg('删除成功', {icon: 1});
									location.reload([true]);                                              
								} else {
									layer.msg('系统繁忙请稍后再试！', {icon: 2});
								}
							},
							error : function(jqXHR, textStatus, errorThrown) {
								layer.msg('系统繁忙请稍后再试！', {icon: 2});
							}
						});
					}, function(){
						layer.msg('已撤销', {icon: 1});
					});
			}
var buyJq;
if ($.fn.iCheck) {
	buyJq = $;
} else if (jquery.fn.iCheck) {
	buyJq = jquery;
} else if (jquery2.fn.iCheck) {
	buyJq = jquery2;
}
</script>



			<!--事件分析功能过期提示弹窗 start-->


			<!--事件分析功能过期提示弹窗 end-->

			<form target="_blank" method="post" action="" id="aForm">
				<input type="hidden" value="" name="tickets">
			</form>

			<!--底部部分代码 start-->






			<div class="h35 clear"></div>
			<%@include file="/main/home/foot.jsp"%>


			<!-- Live800在线客服图标:默认图标[浮动图标] 开始-->
			<!-- <div style='display:none;'><a href='http://www.live800.com'>live800Link.webchat</a></div><script language="javascript" src="http://chat32.live800.com/live800/chatClient/floatButton.js?jid=9159033947&companyID=676194&configID=96834&codeType=custom"></script><div style='display:none;'><a href='http://en.live800.com'>live chat</a></div> -->
			<!-- 在线客服图标:默认图标 结束-->

			<!-- Live800默认跟踪代码: 开始-->
			<!-- <script language="javascript" src="http://chat32.live800.com/live800/chatClient/monitor.js?jid=9159033947&companyID=676194&configID=96833&codeType=custom"></script> -->
			<!-- Live800默认跟踪代码: 结束-->

			<!-- 
<script>
  (function(a,h,c,b,f,g){a["UdeskApiObject"]=f;a[f]=a[f]||function(){(a[f].d=a[f].d||[]).push(arguments)};g=h.createElement(c);g.async=1;g.src=b;c=h.getElementsByTagName(c)[0];c.parentNode.insertBefore(g,c)})(window,document,"script","http://13482648312.udesk.cn/im_client/js/udeskApi.js?_t=1464241045985","ud");
  ud({"code":"hdkh17h","link":"http://13482648312.udesk.cn/im_client","mobile":{"mode":"blank","color":"#307AE8","pos_flag":"crb","onlineText":"联系客服，在线咨询","offlineText":"客服下班，请留言","pop":{"direction":"top","arrow":{"top":0,"left":"70%"}}},"mode":"inner","color":"#307AE8","pos_flag":"srb","onlineText":"联系客服，在线咨询","offlineText":"客服下班，请留言","pop":{"direction":"top","arrow":{"top":0,"left":"80%"}}});
</script>
 -->

			<!-- 
<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F903d554109671963f8baf8bf8150c297' type='text/javascript'%3E%3C/script%3E"));

$(function() {
	$('a[href*="tongji.baidu.com"]').css('display', 'none')
});
</script>
 -->

			<!-- 
<script src="https://qiyukf.com/script/4e1ee2d955f4928e32e137853e1e9e21.js" defer async></script>
 -->

			<!--底部部分代码 end-->


			<script type="text/javascript">
function GotoPage(i) {
	location.href = "taskList.action?page=" + i;
}

function queryTaskStatus(tickets) {
	$
			.ajax( {
				url : "queryTaskInfo.action",
				type : "post",
				data : {
					"tickets" : tickets
				},
				success : function(data) {
					if (data) {
						var list = data.tasksList;
						$
								.each(
										list,
										function() {
											var taskId = this.analysisTaskTicket;
											if (this.analysisStatus == 2
													|| this.analysisStatus == 3
													|| this.analysisStatus == 4) {
												var percent = (parseFloat(this.analysisSchedulePercent) * 100)
														.toFixed(1)
														+ "%";
												var tr = document
														.getElementById(taskId);
												//$(tr).find(".progressLine").css("width",percent).text(percent);
												$(tr).find(".badge")
														.text("分析中").addClass(
																"blue");
												$(tr)
														.find("td:last")
														.removeClass("link")
														.html(
																'<div class="progress rel"><span style="position: absolute; top: 0; left: 45%;">'
																		+ percent
																		+ '</span><span style="width: '
																		+ percent
																		+ ';" class="progressLine">&nbsp;</div>');
											} else if (this.analysisStatus == 5) {
												/*var tickets = $("#tickets").val().split(taskId).join();
												 $("#tickets").val(tickets.replace(",,",","));
												 var tr = document.getElementById(taskId);
												 $(tr).find(".badge").text("分析完成").removeClass("blue").addClass("green");
												 $(tr).find("td:eq(1)").css("cursor","pointer");
												 $(tr).find("td:eq(1)").bind("click",showEventFrame(3,this));*/
												location.reload();
											} else if (this.analysisStatus == 0) {
												/*var tickets = $("#tickets").val().split(taskId).join();
												 $("#tickets").val(tickets.replace(",,",","));
												 var tr = document.getElementById(taskId);
												 $(tr).find(".badge").text("分析失败").removeClass("blue").addClass("red");
												 $(tr).find("td:last").addClass("link").html('<a href="javascript:showEventFrame(3,"11952");">详情</a> |'
												 +'<a href="javascript:void(0);" onclick="del(this);">删除</a> |'
												 +'<a href="javascript:showEventFrame(2,"11952");">更新</a>');*/
												location.reload();
											}

										});
						if ($("#tickets").val() != "") {
							setTimeout(function() {
								queryTaskStatus(tickets)
							}, 5000);
						}
					}

				}
			})
}
function saveCompleteTask(obj) {
	$.ajax( {
		url : "saveCompleteTask.action",
		type : "post",
		data : {
			"analysisReport.taskId" : obj.incidentAnalysisTaskId,
			"analysisReport.userId" : obj.userTag,
			"analysisReport.taskTicket" : obj.analysisTaskTicket,
			"analysisReport.incidentTitle" : obj.incidentTitle
		}
	});
}

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return (r[2]);
	return null;
}


function goCreate(url) {

	showEventFrame(1, '', url);

}

var updateFlag = true;
function updateTask(obj) {
	if (!updateFlag) {
		return false;
	}
	updateFlag = false;
	$(obj).parents(".taskTimeSegment").show();
	var taskId = $(obj).parents("tr").find("input:first").val();
	var startTime = $(obj).parents("td").find(".showStarttime ").val();
	var endTime = $(obj).parents("td").find(".showEndtime ").val();
	var params = {
		"analysisTask.taskId" : taskId,
		"analysisTask.startTime" : startTime,
		"analysisTask.endTime" : endTime,
		"createType" : 2
	};

	var inputval = $(obj).parents(".other_timeBox.rel");
	var spans = inputval.find("h3").find("span");
	/* $(obj).parents(".other_time").show(); */

	if (startTime == "" || startTime == null) {
		spans.text("请选择开始时间");
		updateFlag = true;
	} else {

		$.ajax( {
			url : "/view/eventAnalysis/addTask.action",
			type : "post",
			data : params,
			success : function(result) {
				if (result == "true") {
					hideUpdate();
					spans.text("");
					location.reload();
				} else {
					showMsgInfo(0, result, 0);
					updateFlag = true;
				}
			}
		})
	}

}
//点击的不是显示操作时将他隐藏
document.onclick = function(event) {
	var e = event || window.event;
	var elem = e.srcElement || e.target;
	while (elem) {

		if ($(elem).hasClass("updateA") || $(elem).hasClass("ui-state-default")
				|| $(elem).hasClass("ui-corner-all")
				|| $(elem).hasClass("other_timeBox")) {

			return;
		}
		elem = elem.parentNode;
	}
	//$(".taskTimeSegment").find("h3").find("span").text("");
	$(".taskTimeSegment").find(".showStarttime").val("");
	$(".taskTimeSegment").hide();//隐藏更新弹窗
};
function showUpdate(obj) {
	$(".taskTimeSegment").hide();

	$(obj).parent().find(".other_time").show();
}
function hideUpdate() {
	//$(".taskTimeSegment").find("h3").find("span").text("");
	$(".taskTimeSegment").find(".showStarttime").val("");
	$(".taskTimeSegment").hide();
}

function preview(obj) {
	var tickets = $(obj).parents("tr").attr("id");
	$("#aForm").find("input").val(tickets);
	$("#aForm").attr("action", "analysisPreview.action");
	$("#aForm").submit();
}

var flag = true;
//重新分析
function restartAnalysis(taskId) {
	if (!flag) {
		return false;
	}
	flag = false;
	var params = {
		"analysisTask.taskId" : taskId,
		"createType" : 3
	};
	$.ajax( {
		url : "/view/eventAnalysis/addTask.action",
		type : "POST",
		data : params,
		success : function(data) {
			if (data == "true") {
				location.reload();
			} else {
				flag = true;
				showMsgInfo(0, data, 0);
			}
		}
	});

}
</script>

			<script language="javascript">
$(function() {
	//说明文字显示隐藏
	$(".titlBar .icon-help").on("click", function() {
		$(this).parents(".titlBar").next(".tipinfo").toggle(300)
	});
	$(".tipinfo .close").on("click", function() {
		$(this).parents(".tipinfo").hide(300)
	});
});
</script>
	</body>
</html>

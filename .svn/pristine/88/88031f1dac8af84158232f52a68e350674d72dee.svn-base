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
<!-- saved from url=(0073)http://wyq.sina.com/view/eventAnalysis/createAnalysis.action?createType=1 -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">



		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="renderer" content="webkit">

		<title>新浪微舆情-互联网大数据平台</title>
		<meta name="author" content="">
		<meta name="keywords"
			content="微信舆情监测,微博舆情监控,舆情监测, 舆情APP ,舆情客户端，舆情软件,互联网舆情,视频舆情,海外媒体，舆情APP ,舆情客户端，舆情预警">
		<meta name="description"
			content="新浪微舆情是中国最大的舆情服务平台，提供网页、微博、微信、电子报、视频等全媒体舆情监测方案，以及舆情事件分析、舆情简报制作，舆情日周月报自动发送、海外媒体监测、竞争情报服务等">
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
			src="<%=basePath%>sinaStyle/index/zzsc.js">
		</script>
		<script type="text/javascript"
			src="<%=basePath%>sinaStyle/index/navigate.js">
		</script>
		<script language="javascript" type="text/javascript"
			src="<%=basePath%>Scripts/My97DatePicker/WdatePicker.js">
		</script>
		<script type="text/javascript" src="<%=basePath%>Scripts/echarts.js">
		</script>
		<link href="<%=basePath%>sinaStyle/index/style.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/index/zzsc.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/index/font-icon.css"
			rel="stylesheet" type="text/css">
	</head>



	<!-- 导航条用户的下拉效果-->

	<!-- 页面右侧的客户端展示的效果-->





	<body marginwidth="0" marginheight="0"
		style="width: 100%; background: rgb(255, 255, 255);">
		<div id="wx_pic" style="margin: 0 auto; display: none;">
			<img src="<%=basePath%>sinaStyle/index/share.png">
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
		<meta charset="GBK">
		<title>网络舆情系统</title>
		<meta name="keywords" content="网络舆情系统">
		<meta name="description" content="网络舆情系统">
		<link href="<%=basePath%>sinaStyle/index/other.css" rel="stylesheet"
			type="text/css">
		<link href="<%=basePath%>sinaStyle/index/eventAnalysis.css"
			rel="stylesheet" type="text/css">
		<link type="text/css" rel="stylesheet"
			href="<%=basePath%>sinaStyle/index/popModal.css">
		<link href="<%=basePath%>sinaStyle/index/tips.css" rel="stylesheet"
			type="text/css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/index/common.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>sinaStyle/index/font-icon.css">

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

		<script src="<%=basePath%>sinaStyle/index/bootstrap.min.js">
		</script>
		<!--[if lt IE 10]>
<script type="text/javascript" src="http://files.wyq.cn/web/js/PIE.js"></script>
<![endif]-->
		<script language="javascript">
var jquery = $;
$(function() {
	jquery("[data-toggle='tooltip']").tooltip();
	if (window.PIE) {
		$('.rounded').each(function() {
			PIE.attach(this);
		});

	}

	jquery("#starttime,#endtime").datetimepicker( {
		maxDate : new Date(),
		minDate : new Date(2016, 1 - 1, 1)
	});//{maxDate:new Date(),minDate:new Date(2016,1-1,1)}

});
</script>



		<style>
.unClick {
	background-color: gray !important;
	border: 1px solid gray !important;
}
</style>











		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<title>微舆情_网络舆情监测</title>
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
				<a
					href="http://wyq.sina.com/view/eventAnalysis/createAnalysis.action?createType=1#"
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
		<!--提示框 start-->
		<form action="<%=basePath%>report_createReport" method="post"
			name="frmPopWin" id="frmPopWin">

			<div class="td_title rel">
				<h1>
					创建简报
				</h1>
				<a href="javascript:parent.hideEventDiv();" class="info_close abs">×</a>
			</div>
			<ul class="frmPopWin2">

				<li>
					<span class="float_l"><font class="f_c2">*</font>简报名称：</span>
					<span> <input style="width: 495px;" name="reportname"
							type="text" class="input " id="reportname" value="" size="65"
							maxlength="10"> </span>
					<span class="help_outline" style="color: #888;"><i
						class="icon icon-help_outline" data-toggle="tooltip"
						data-placement="top" title=""
						data-original-title="请为您的简报创建一个便于记忆的名字。"></i> </span>
				</li>

				<li>
					<span class="float_l"><font class="f_c2">*</font>选择模板：</span><span>

						<select style="width: 507px;" name="modelid"
							cols="67" rows="3" class="inputDH  " id="keyword">
							<option value="1">
								默认
							</option>
							<option value="1"> 
								经典版
							</option>
						</select> </span>
					<span class="help_outline" style="color: #888;"><i
						class="icon icon-help_outline" data-toggle="tooltip"
						data-placement="top" title=""
						data-original-title="默认使用经典模板，在简报模板页可以查看相应的模板"></i> </span>
					<!--信息量过大提示文字 start -->
					<div id="errordiv" class="wprompt1"
						style="display: none; margin-Top: 40px;">
						<div id="jindudiv">
							报告生成中.......
						</div>
					</div>
					<!--信息量过大提示文字 end -->
				</li>
				<li>
					<span class="float_l"><font class="f_c2">*</font>统计时间：</span><span>
						<input name="reportstartTime" type="text" id="reportstartTime"
							class="input time hasDatepicker"
							onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							value="" readonly="readonly" style="width: 170px;"> 至 <input
							name="reportendTime" type="text" class="input time hasDatepicker"
							id="reportendTime"
							onClick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"
							value="" readonly="readonly" style="width: 170px;"> </span>
				</li>

				<li>
					<span class="float_l">&nbsp;</span>
					<span class="promptNumber yellow" style="display: none;"><i
						class="icon-notification"></i><span id="tips"></span> </span>
				</li>
			</ul>
			<div class="h10 clear"></div>
			<div class="btn_div" style="">

				<a onclick="createTask()" class="submitBtn2 button" id="submit222"
					style="">创建简报</a>
				<a href="javascript:parent.hideEventDiv1();"
					class="cancelBtn2 button">取消</a>
				 


			</div>
		</form>

		<script type="text/javascript">
function trimStr(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
function createTask() {

	var reportstartTime = document.getElementById("reportstartTime").value;
	var reportendTime = document.getElementById("reportendTime").value;
	var reportname = document.getElementById("reportname").value;
	var modelid = $("#keyword").val();
	if (reportname == null || trimStr(reportname).length == 0) {
		document.getElementById("errordiv").style.display="block"; 
		document.getElementById("jindudiv").innerHTML="请填写简报名称!";
		return;
	}
	if (reportstartTime == null || trimStr(reportstartTime).length == 0) {
		document.getElementById("errordiv").style.display="block"; 
		document.getElementById("jindudiv").innerHTML="请选择统计时间!";
		return;
	}
	if (reportendTime == null || trimStr(reportendTime).length == 0) {
		document.getElementById("errordiv").style.display="block"; 
		document.getElementById("jindudiv").innerHTML="请选择统计时间!";
		return;
	}
	
	$("#errordiv").show();
	
	$.ajax({
		type:'POST',
		url:'<%=basePath%>report_createReport',
        data:{reportname:reportname,reportstartTime:reportstartTime,reportendTime:reportendTime,modelid:modelid},
		success:function(data){
			if(data == "1"){
	        	parent.hideEventDiv1();
			}else{
				alert("未生成成功");
			}
		}
    });
	return;

}
</script>

		<div id="main" style="width: 800px; height: 300px; display: none;"></div>
		<script type="text/javascript">

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

function initt() {

	// 指定图表的配置项和数据
	var option
= {
    title: {
        text: ''
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        show:true,
       orient:'vertical',
        data:[ '正面','负面','中立'],
         y: 'center',
         x:'right',
   
    },
    
    grid: {
        left: '3%',
        right: '4%',
        bottom: '9%',
        containLabel: true
         
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : [${reportImgDate}],
                 axisLabel : {
             rotate:45,
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
       
        
        {
            name:'正面',
            type:'line',
            stack: '总量',
            
            data:[${zmNuberString}]
        },
        {
            name:'中立',
            type:'line',
            stack: '总量',
             
            data:[${zlNuberString}]
        },
        {
            name:'负面',
            type:'line',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            
            data:[${fmNuberString}]
        }
    ]
};


// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);
document.getElementById("errordiv").style.display="block";  
//延时三秒防止没有拿到完整的图片
 setTimeout(function(){
testimage();
},1000);

}

function testimage()
{
	var reportname='${reportname}';
	var reportstartTime='${reportstartTime}';
	var reportendTime='${reportendTime}';
		var modelid='${modelid}';
	var img = new Image();
img.src = myChart.getDataURL("png");
//获取到img base64提交到服务器
//alert(myChart.getDataURL("png"));
$.ajax({
			type:'POST',
			url:'<%=basePath%>report_saveImage',
			timeout:999999,
	        data:{reportImg:img.src,reportname:reportname,reportstartTime:reportstartTime,reportendTime:reportendTime,modelid:modelid},
			success:function(data){
	        	  parent.hideEventDiv1();
				}
		    }
		    
		 );
}

//打开检索页面
function tojiansuo(){
	var startTime = '<s:property value="reportstartTime"/>';
	var endTime = '<s:property value="reportendTime"/>';
	startTime = startTime.replace(/-/g, "");
	endTime = endTime.replace(/-/g, "");
	parent.location.href="<%=basePath%>search_newsKeyword?startTime="+startTime+"&endTime="+endTime;
}
  
</script>

		<script type="">
//判断创建是否成功

if ('${createFlag}' == 'success') {
	//var ss='${reportImgDate}';
	initt();
}
</script>
		<div class="h10 clear"></div>


		<!--提示框 end-->

		<script src="popModal.js">
</script>
		<!--提示语js-->



		<div id="ui-datepicker-div"
			class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
	</body>
</html>
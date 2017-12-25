<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>港澳台舆情控制平台</title>
	<meta name="keywords" content=" " />
	<meta name="description" content=" " />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="<%=basePath%>main/reportpreview/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/jquery-ui-1.10.3.custom.min.css" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/jquery.gritter.css" />
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/ace.min.css" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/ace-skins.min.css" />
	<link rel="stylesheet" href="<%=basePath%>main/reportpreview/assets/css/index.css" />
	<script type="text/javascript" src="<%=basePath%>main/reportpreview/assets/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>layer/layer.js"></script>
	<script type="text/javascript" src="<%=basePath%>main/reportpreview/assets/js/ace-extra.min.js"></script>
	<style>
		.spinner-preview {
			width:100px;
			height:100px;
			text-align:center;
			margin-top:60px;
		}

		.dropdown-preview {
			margin:0 5px;
			display:inline-block;
		}
		.dropdown-preview  > .dropdown-menu {
			display: block;
			position: static;
			margin-bottom: 5px;
		}
		.btn2
		{
			background-color:#f9f9f9;
		}
		.pbtn1
		{	
			border:solid 2px #333;
			padding:4px 14px;
			color:#333;
		}
		
	</style>
	
	<script type="text/javascript">
		function deleteRecord(){
			if($("input[type='checkbox']:checked").length == 0){
				layer.alert("请选择要删除的项");
				return;
			}
			$("#myrecordform").submit();
		}
	</script>
	
</head>

<body>
<!--头部蓝色部分-->
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
					<i class="icon-leaf"></i>
					港澳台舆情平台
				</small>
			</a><!-- /.brand -->
		</div><!-- /.navbar-header -->
	</div><!-- /.container -->
</div>
<!--头部蓝色部分-->

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>

	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>

		<!-- 左边导航 -->
		<%@ include file="/main/reportpreview/left.jsp" %>

		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

			</div>

			<div class="page-content">
				<div class="page-header">
					<h1>
						<s:if test="addresscode == 1 || addresscode == 2 || addresscode == 3">
							港台涉大陆重点舆情
						</s:if>
						<s:elseif test="addresscode == 4 || addresscode == 5 || addresscode == 6">
							港澳台媒体焦点
						</s:elseif>
						<s:elseif test="addresscode == 7">
							香港社交网站舆情热点
						</s:elseif>
						<s:else>
							一周重点舆情
						</s:else>
						<small>
							<i class="icon-double-angle-right"></i>
							<s:if test="addresscode == 1">
								涉及党和国家领导人的信息
							</s:if>
							<s:elseif test="addresscode == 2">
								涉大陆热点事件信息
							</s:elseif>
							<s:elseif test="addresscode == 3">
								涉上海热点事件信息
							</s:elseif>
							<s:elseif test="addresscode == 4">
								香港媒体焦点
							</s:elseif>
							<s:elseif test="addresscode == 5">
								澳门媒体焦点
							</s:elseif>
							<s:elseif test="addresscode == 6">
								台湾媒体焦点
							</s:elseif>
						</small>
					</h1>
				</div><!-- /.page-header -->
				<div class="row">
				
				<s:if test="recordList != null && recordList.size() > 0">
					<form action="report_deleteRecord" method="post" id="myrecordform">
						<input type="hidden" name="addresscode" value="<s:property value="addresscode"/>"/>
						<input type="hidden" name="reportId" value="<s:property value="reportId"/>"/>
						<s:iterator var="record" value="recordList">
						<p class="p1">
							<input type="checkbox" name="recordIdList" value="<s:property value="#record.id"/>"/>
							<s:property value="#record.title"/>
						</p>
						</s:iterator>
						
						<p class="p1">
							<input class="btn2 pbtn1" onmouseover="this.style.borderColor='#f76b00'" onmouseout="this.style.borderColor='#dcdcdc'" 
								type="button" value="删除选中项" onclick="deleteRecord()" style="border-color: rgb(220, 220, 220);"/>
						</p>
					</form>
				</s:if>
				<s:else>
					<h2><font color="red">暂无数据</font></h2>
				</s:else>

				</div><!-- /.row -->
			</div><!-- /.page-content -->

		</div><!-- /#ace-settings-container -->
	</div><!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=basePath%>main/reportpreview/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=basePath%>main/reportpreview/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='<%=basePath%>main/reportpreview/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=basePath%>main/reportpreview/assets/js/bootstrap.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="<%=basePath%>main/reportpreview/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="<%=basePath%>main/reportpreview/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/bootbox.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/jquery.gritter.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/spin.min.js"></script>

<!-- ace scripts -->

<script src="<%=basePath%>main/reportpreview/assets/js/ace-elements.min.js"></script>
<script src="<%=basePath%>main/reportpreview/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
	jQuery(function($) {
		/**
		 $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  console.log(e.target.getAttribute("href"));
				})
		 */


		$('#accordion-style').on('click', function(ev){
			var target = $('input', ev.target);
			var which = parseInt(target.val());
			if(which == 2) $('#accordion').addClass('accordion-style2');
			else $('#accordion').removeClass('accordion-style2');
		});


		var oldie = /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase());
		$('.easy-pie-chart.percentage').each(function(){
			$(this).easyPieChart({
				barColor: $(this).data('color'),
				trackColor: '#EEEEEE',
				scaleColor: false,
				lineCap: 'butt',
				lineWidth: 8,
				animate: oldie ? false : 1000,
				size:75
			}).css('color', $(this).data('color'));
		});

		$('[data-rel=tooltip]').tooltip();
		$('[data-rel=popover]').popover({html:true});


		$('#gritter-regular').on(ace.click_event, function(){
			$.gritter.add({
				title: 'This is a regular notice!',
				text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="blue">magnis dis parturient</a> montes, nascetur ridiculus mus.',
				image: $path_assets+'/avatars/avatar1.png',
				sticky: false,
				time: '',
				class_name: (!$('#gritter-light').get(0).checked ? 'gritter-light' : '')
			});

			return false;
		});

		$('#gritter-sticky').on(ace.click_event, function(){
			var unique_id = $.gritter.add({
				title: 'This is a sticky notice!',
				text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="red">magnis dis parturient</a> montes, nascetur ridiculus mus.',
				image: $path_assets+'/avatars/avatar.png',
				sticky: true,
				time: '',
				class_name: 'gritter-info' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
			});

			return false;
		});


		$('#gritter-without-image').on(ace.click_event, function(){
			$.gritter.add({
				// (string | mandatory) the heading of the notification
				title: 'This is a notice without an image!',
				// (string | mandatory) the text inside the notification
				text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="orange">magnis dis parturient</a> montes, nascetur ridiculus mus.',
				class_name: 'gritter-success' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
			});

			return false;
		});


		$('#gritter-max3').on(ace.click_event, function(){
			$.gritter.add({
				title: 'This is a notice with a max of 3 on screen at one time!',
				text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="green">magnis dis parturient</a> montes, nascetur ridiculus mus.',
				image: $path_assets+'/avatars/avatar3.png',
				sticky: false,
				before_open: function(){
					if($('.gritter-item-wrapper').length >= 3)
					{
						return false;
					}
				},
				class_name: 'gritter-warning' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
			});

			return false;
		});


		$('#gritter-center').on(ace.click_event, function(){
			$.gritter.add({
				title: 'This is a centered notification',
				text: 'Just add a "gritter-center" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
				class_name: 'gritter-info gritter-center' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
			});

			return false;
		});

		$('#gritter-error').on(ace.click_event, function(){
			$.gritter.add({
				title: 'This is a warning notification',
				text: 'Just add a "gritter-light" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
				class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
			});

			return false;
		});


		$("#gritter-remove").on(ace.click_event, function(){
			$.gritter.removeAll();
			return false;
		});


		///////


		$("#bootbox-regular").on(ace.click_event, function() {
			bootbox.prompt("What is your name?", function(result) {
				if (result === null) {
					//Example.show("Prompt dismissed");
				} else {
					//Example.show("Hi <b>"+result+"</b>");
				}
			});
		});

		$("#bootbox-confirm").on(ace.click_event, function() {
			bootbox.confirm("Are you sure?", function(result) {
				if(result) {
					//
				}
			});
		});

		$("#bootbox-options").on(ace.click_event, function() {
			bootbox.dialog({
				message: "<span class='bigger-110'>I am a custom dialog with smaller buttons</span>",
				buttons:
				{
					"success" :
					{
						"label" : "<i class='icon-ok'></i> Success!",
						"className" : "btn-sm btn-success",
						"callback": function() {
							//Example.show("great success");
						}
					},
					"danger" :
					{
						"label" : "Danger!",
						"className" : "btn-sm btn-danger",
						"callback": function() {
							//Example.show("uh oh, look out!");
						}
					},
					"click" :
					{
						"label" : "Click ME!",
						"className" : "btn-sm btn-primary",
						"callback": function() {
							//Example.show("Primary button");
						}
					},
					"button" :
					{
						"label" : "Just a button...",
						"className" : "btn-sm"
					}
				}
			});
		});



		$('#spinner-opts small').css({display:'inline-block', width:'60px'})

		var slide_styles = ['', 'green','red','purple','orange', 'dark'];
		var ii = 0;
		$("#spinner-opts input[type=text]").each(function() {
			var $this = $(this);
			$this.hide().after('<span />');
			$this.next().addClass('ui-slider-small').
			addClass("inline ui-slider-"+slide_styles[ii++ % slide_styles.length]).
			css({'width':'125px'}).slider({
				value:parseInt($this.val()),
				range: "min",
				animate:true,
				min: parseInt($this.data('min')),
				max: parseInt($this.data('max')),
				step: parseFloat($this.data('step')),
				slide: function( event, ui ) {
					$this.attr('value', ui.value);
					spinner_update();
				}
			});
		});





		$.fn.spin = function(opts) {
			this.each(function() {
				var $this = $(this),
						data = $this.data();

				if (data.spinner) {
					data.spinner.stop();
					delete data.spinner;
				}
				if (opts !== false) {
					data.spinner = new Spinner($.extend({color: $this.css('color')}, opts)).spin(this);
				}
			});
			return this;
		};

		function spinner_update() {
			var opts = {};
			$('#spinner-opts input[type=text]').each(function() {
				opts[this.name] = parseFloat(this.value);
			});
			$('#spinner-preview').spin(opts);
		}



		$('#id-pills-stacked').removeAttr('checked').on('click', function(){
			$('.nav-pills').toggleClass('nav-stacked');
		});


	});
</script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

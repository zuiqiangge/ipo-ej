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
		<link href="<%=basePath%>/main/reportpreview/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=basePath%>/main/reportpreview/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<link rel="stylesheet" href="<%=basePath%>/main/reportpreview/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=basePath%>/main/reportpreview/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=basePath%>/main/reportpreview/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="<%=basePath%>/main/reportpreview/assets/css/index.css" />
		<script type="text/javascript" src="<%=basePath%>main/reportpreview/assets/js/jquery-1.10.2.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/ace-extra.min.js"></script>
		
		<style type="text/css">
			table{font-size: 16px;width:100%}
			table tr th,td{text-align:center;vertical-align:middle;height:36px;}
		</style>
		
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


					<!--简述-->
					<div class="page-content">
						<div class="page-header">
							<h1>
								一周重点舆情
								<small>
									<i class="icon-double-angle-right"></i>
									 简述
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">

							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本时段内，
								港澳台网上舆情条目<s:property value="reportBean.yqztm"/>篇，
								其中正面舆情<s:property value="reportBean.zmyq"/>篇，
								中立舆情<s:property value="reportBean.zlyq"/>篇，
								负面舆情<s:property value="reportBean.fmyq"/>篇。
								经分析发现舆情话题<s:property value="reportBean.yqht"/>个，
								其中涉及港澳台本地及大陆的高热度话题<s:property value="reportBean.grdht"/>个：
								<s:property value="reportBean.grdhtcontext"/>等。本时段内，港澳台网上舆情信息量走势下图所示：
							</p>
							<h3 class="h3">
								<s:property value="reportBean.zsttitle"/>
							</h3>
							<div class="img1"><img src="data:image/png;base64,<s:property value="reportBean.yqzst"/>"></div><br>
							<!--1_1-->
							<h3>一、本周港台涉大陆重点舆情</h3>
							<h4>（一）涉及党和国家领导人的信息</h4>
							<p class="p1">
								<s:iterator var="dhgjldr" value="reportBean.dhgjldrList">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#dhgjldr.colname1"/></strong>
									<s:property value="#dhgjldr.colname2"/>
									<br/>
								</s:iterator>
							</p><br>
							<!--1_2-->
							<h4>（二）涉大陆热点事件信息</h4>
							<p class="p1">
								<s:iterator var="sdlrd" value="reportBean.sdlrdList">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#sdlrd.colname1"/></strong>
									<s:property value="#sdlrd.colname2"/>
									<br/>
								</s:iterator>
							</p><br>
							<!--1_3-->
							<h4>（三）涉上海热点事件信息</h4>
							<p class="p1">
								<s:iterator var="sshrd" value="reportBean.sshrdList">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#sshrd.colname1"/></strong>
									<s:property value="#sshrd.colname2"/>
									<br/>
								</s:iterator>
							</p><br>
							<!--2_1-->
							<h3>二、本周港澳台媒体焦点</h3>
							<h4>（一）香港媒体焦点</h4>
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="reportBean.xgmtjdTitle"/>
							</p>
							<h3 class="h3">
								<s:property value="reportBean.xgzlmtTabTitle"/>
							</h3>
							<div class="img1">
								<table cellspacing="0" border="1" align="center">
									<tr>
										<th width="5%">序号</th>
										<th width="40%">标题</th>
										<th width="15%">来源</th>
										<th width="15%">时间</th>
										<th width="15%">信息类型</th>
										<th width="10%">网名倾向</th>
									</tr>
									<s:iterator var="xgzlmt" value="reportBean.xgzlmtTabList">
									<tr>
										<td><s:property value="#xgzlmt.colname1"/></td>
										<td><s:property value="#xgzlmt.colname2"/></td>
										<td><s:property value="#xgzlmt.colname3"/></td>
										<td><s:property value="#xgzlmt.colname4"/></td>
										<td><s:property value="#xgzlmt.colname5"/></td>
										<td><s:property value="#xgzlmt.colname6"/></td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<br>
							<s:iterator var="xgzlmtcon" value="reportBean.xgzlmtcontextList">
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#xgzlmtcon.colname1"/></strong>
								<s:property value="#xgzlmtcon.colname2"/>
							</p>
							</s:iterator>
							<br>
							<!--2_2-->
							<h4>（二）澳门媒体焦点</h4>
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="reportBean.ammtjdTitle"/>
							</p>
							<h3 class="h3">
								<s:property value="reportBean.amzlmtTabTitle"/>
							</h3>
							<div class="img1">
								<table cellspacing="0" border="1" align="center">
									<tr>
										<th width="5%">序号</th>
										<th width="40%">标题</th>
										<th width="15%">来源</th>
										<th width="15%">时间</th>
										<th width="15%">信息类型</th>
										<th width="10%">网名倾向</th>
									</tr>
									<s:iterator var="amzlmt" value="reportBean.amzlmtTabList">
									<tr>
										<td><s:property value="#amzlmt.colname1"/></td>
										<td><s:property value="#amzlmt.colname2"/></td>
										<td><s:property value="#amzlmt.colname3"/></td>
										<td><s:property value="#amzlmt.colname4"/></td>
										<td><s:property value="#amzlmt.colname5"/></td>
										<td><s:property value="#amzlmt.colname6"/></td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<br>
							<s:iterator var="amzlmtcon" value="reportBean.amzlmtcontextList">
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#amzlmtcon.colname1"/></strong>
								<s:property value="#amzlmtcon.colname2"/>
							</p>
							</s:iterator>
							<br>
							<!--2——3-->
							<h4>（三）台湾媒体焦点</h4>
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="reportBean.twmtjdTitle"/>
							</p>
							<h3 class="h3">
								<s:property value="reportBean.twzlmtTabTitle"/>
							</h3>
							<div class="img1">
								<table cellspacing="0" border="1" align="center">
									<tr>
										<th width="5%">序号</th>
										<th width="40%">标题</th>
										<th width="15%">来源</th>
										<th width="15%">时间</th>
										<th width="15%">信息类型</th>
										<th width="10%">网名倾向</th>
									</tr>
									<s:iterator var="twzlmt" value="reportBean.twzlmtTabList">
									<tr>
										<td><s:property value="#twzlmt.colname1"/></td>
										<td><s:property value="#twzlmt.colname2"/></td>
										<td><s:property value="#twzlmt.colname3"/></td>
										<td><s:property value="#twzlmt.colname4"/></td>
										<td><s:property value="#twzlmt.colname5"/></td>
										<td><s:property value="#twzlmt.colname6"/></td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<br>
							<s:iterator var="twzlmtcon" value="reportBean.twzlmtcontextList">
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#twzlmtcon.colname1"/></strong>
								<s:property value="#twzlmtcon.colname2"/>
							</p>
							</s:iterator>
							<br>
							
							<!--3——1-->
							<h3>三、本周香港社交网站舆情热点</h3>
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;针对香港本地重点论坛方面，“香港讨论区”、
								“高登讨论区”、“Uwants”等热门论坛，
								监控系统共抓取新帖文<s:property value="reportBean.xtw"/>篇，
								累计点击量<s:property value="reportBean.djl"/>万次，
								回帖量<s:property value="reportBean.htl"/>万多条，讨论主题较为分散。
								网情热点列表具体如下：
							</p>
							<h3 class="h3">
								<s:property value="reportBean.sjzlmtTabTitle"/>
							</h3>
							<div class="img1">
								<table cellspacing="0" border="1" align="center">
									<tr>
										<th width="15%">来源</th>
										<th width="10%">序号</th>
										<th width="50%">标题</th>
										<th width="15%">时间</th>
										<th width="10%">网名倾向</th>
									</tr>
									<tr>
										<td rowspan="<s:property value="reportBean.xgtlsjzlmtTabList.size() + 1"/>">香港讨论区</td>
										<td><s:property value="reportBean.xgtlq1"/></td>
										<td><s:property value="reportBean.xgtlq2"/></td>
										<td><s:property value="reportBean.xgtlq3"/></td>
										<td><s:property value="reportBean.xgtlq4"/></td>
									</tr>
									<s:iterator var="xgtlsjzlmt" value="reportBean.xgtlsjzlmtTabList">
									<tr>
										<td><s:property value="#xgtlsjzlmt.colname1"/></td>
										<td><s:property value="#xgtlsjzlmt.colname2"/></td>
										<td><s:property value="#xgtlsjzlmt.colname3"/></td>
										<td><s:property value="#xgtlsjzlmt.colname4"/></td>
									</tr>
									</s:iterator>
									
									<tr>
										<td rowspan="<s:property value="reportBean.gdtlsjzlmtTabList.size() + 1"/>">高登讨论区</td>
										<td><s:property value="reportBean.gdtlq1"/></td>
										<td><s:property value="reportBean.gdtlq2"/></td>
										<td><s:property value="reportBean.gdtlq3"/></td>
										<td><s:property value="reportBean.gdtlq4"/></td>
									</tr>
									<s:iterator var="gdtlsjzlmt" value="reportBean.gdtlsjzlmtTabList">
									<tr>
										<td><s:property value="#gdtlsjzlmt.colname1"/></td>
										<td><s:property value="#gdtlsjzlmt.colname2"/></td>
										<td><s:property value="#gdtlsjzlmt.colname3"/></td>
										<td><s:property value="#gdtlsjzlmt.colname4"/></td>
									</tr>
									</s:iterator>
									
									<tr>
										<td rowspan="<s:property value="reportBean.uwantstlsjzlmtTabList.size() + 1"/>">Uwants</td>
										<td><s:property value="reportBean.uwantstlq1"/></td>
										<td><s:property value="reportBean.uwantstlq2"/></td>
										<td><s:property value="reportBean.uwantstlq3"/></td>
										<td><s:property value="reportBean.uwantstlq4"/></td>
									</tr>
									<s:iterator var="uwantstlsjzlmt" value="reportBean.uwantstlsjzlmtTabList">
									<tr>
										<td><s:property value="#uwantstlsjzlmt.colname1"/></td>
										<td><s:property value="#uwantstlsjzlmt.colname2"/></td>
										<td><s:property value="#uwantstlsjzlmt.colname3"/></td>
										<td><s:property value="#uwantstlsjzlmt.colname4"/></td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<br>
							
							<s:iterator var="sjzlmtcon" value="reportBean.sjzlmtcontextList">
							<p class="p1">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><s:property value="#sjzlmtcon.colname1"/></strong>
								<s:property value="#sjzlmtcon.colname2"/>
							</p>
							</s:iterator>


						</div><!-- /.row -->
					</div><!-- /.page-content -->
					<!--简述-->
				</div><!-- /.main-content -->

				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; 选择皮肤</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl">切换到左边</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								切换窄屏
								<b></b>
							</label>
						</div>
					</div>
				</div>
				<!-- /#ace-settings-container -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

<!--script-->
		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=basePath%>/main/reportpreview/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=basePath%>/main/reportpreview/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=basePath%>/main/reportpreview/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="<%=basePath%>/main/reportpreview/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="<%=basePath%>/main/reportpreview/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/jquery.sparkline.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/flot/jquery.flot.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="<%=basePath%>/main/reportpreview/assets/js/ace-elements.min.js"></script>
		<script src="<%=basePath%>/main/reportpreview/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
				});
			
			
			
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			
			
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
			
			
			
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').slimScroll({
					height: '300px'
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				});
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
				
			
			})
		</script>
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

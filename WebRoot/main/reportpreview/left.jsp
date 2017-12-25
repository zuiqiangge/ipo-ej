<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar" id="sidebar">

<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>
<script type="text/javascript">
	$(function(){
		var addresscode = '${addresscode}';
		var lis = $(".nav-list>li");
		var sublis1 = $("#submenu1>li");
		var sublis2 = $("#submenu2>li");
		
		if(addresscode == "1" || addresscode == "2" || addresscode == "3"){
			$(lis[1]).addClass("open");
			$(lis[1]).find("ul").css("display","block");
		}else if(addresscode == "4" || addresscode == "5" || addresscode == "6"){
			$(lis[2]).addClass("open");
			$(lis[2]).find("ul").css("display","block");
		}else if(addresscode == "7"){
			$(lis[3]).addClass("active");
		}else{
			$(lis[0]).addClass("active");
		}
		
		if(addresscode == "1"){
			$(sublis1[0]).addClass("active");
		}else if(addresscode == "2"){
			$(sublis1[1]).addClass("active");
		}else if(addresscode == "3"){
			$(sublis1[2]).addClass("active");
		}else if(addresscode == "4"){
			$(sublis2[0]).addClass("active");
		}else if(addresscode == "5"){
			$(sublis2[1]).addClass("active");
		}else if(addresscode == "6"){
			$(sublis2[2]).addClass("active");
		}
	});
</script>
<ul class="nav nav-list">
	<li>
		<a href="<%=basePath%>report_reportView.action?reportId=<s:property value="reportId"/>">
			<i class="icon-dashboard"></i>
			<span class="menu-text">周舆情概述</span>
		</a>
	</li>
<!--港台涉大陆重点舆情-->
	<li>
		<a href="#" class="dropdown-toggle">
			<i class="icon-list"></i>
			<span class="menu-text">港台涉大陆重点舆情</span>

			<b class="arrow icon-angle-down"></b>
		</a>

		<ul class="submenu" id="submenu1">
			<!--涉及党和国家领导人的信息-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=1">
					<i class="icon-double-angle-right"></i>
					涉及党和国家领导人的信息
				</a>
			</li>
			<!--涉大陆热点事件信息-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=2">
					<i class="icon-double-angle-right"></i>
					涉大陆热点事件信息
				</a>
			</li>
			<!--涉上海热点事件信息-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=3">
					<i class="icon-double-angle-right"></i>
					涉上海热点事件信息
				</a>
			</li>
		</ul>
	</li>
<!--港澳台媒体焦点-->
	<li>
		<a href="#" class="dropdown-toggle">
			<i class="icon-list"></i>
			<span class="menu-text">港澳台媒体焦点</span>

			<b class="arrow icon-angle-down"></b>
		</a>

		<ul class="submenu" id="submenu2">
<!--香港媒体焦点-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=4">
					<i class="icon-double-angle-right"></i>
					香港媒体焦点
				</a>
			</li>
<!--澳门媒体焦点-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=5">
					<i class="icon-double-angle-right"></i>
					澳门媒体焦点
				</a>
			</li>
<!--台湾媒体焦点-->
			<li>
				<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=6">
					<i class="icon-double-angle-right"></i>
					台湾媒体焦点
				</a>
			</li>
		</ul>
	</li>
<!--香港社交网站舆情热点-->
	<li>
		<a href="<%=basePath%>report_findRecordByCode?reportId=<s:property value="reportId"/>&addresscode=7">
			<i class="icon-desktop"></i>
			<span class="menu-text"> 香港社交网站舆情热点 </span>
		</a>
	</li>
</ul><!-- /.nav-list -->

<div class="sidebar-collapse" id="sidebar-collapse">
	<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
</div>

<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
</script>
</div>

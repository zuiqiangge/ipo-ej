<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
							<span class="user_pic rel"> <em></em> <a href=" "> <img
										src="<%=basePath%>sinaStyle/index/default.jpg" width="30"
										height="30" class="tx"> </a> <span class="f_c6"> <a
									href=" ">${sessionScope.user.loginId}</a> </span> </span>
						</div>
					</div>
				</div>
				<nav class="">
				<ul>
					<li>
						<a href="<%=basePath%>search_index">首页</a>
					</li>
					<c:choose>
						<c:when test="${tbXtTask.type eq '2'}">
							<li>
								<a href="<%=basePath%>taskIndex_taskIndex?type=1">涉大陆重点舆情</a>
							</li>
							<li  class="curr">
								<a href="<%=basePath%>taskIndex_taskIndex?type=2">媒体焦点分析</a>
							</li>
							<li>
								<a href="<%=basePath%>taskIndex_taskIndex?type=3">社交网站舆情热点分析</a>
							</li>
						</c:when>
						<c:when test="${tbXtTask.type eq '3'}">
							<li >
								<a href="<%=basePath%>taskIndex_taskIndex?type=1">涉大陆重点舆情</a>
							</li>
							<li>
								<a href="<%=basePath%>taskIndex_taskIndex?type=2">媒体焦点分析</a>
							</li>
							<li  class="curr">
								<a href="<%=basePath%>taskIndex_taskIndex?type=3">社交网站舆情热点分析</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="curr">
								<a href="<%=basePath%>taskIndex_taskIndex?type=1">涉大陆重点舆情</a>
							</li>
							<li>
								<a href="<%=basePath%>taskIndex_taskIndex?type=2">媒体焦点分析</a>
							</li>
							<li>
								<a href="<%=basePath%>taskIndex_taskIndex?type=3">社交网站舆情热点分析</a>
							</li>
						</c:otherwise>
					</c:choose>
					<li>
						<a href="<%=basePath%>report_findReportPage">舆情简报</a>
					</li>
					<c:if test="${sessionScope.user.loginId == 'admin'}">
					
					 
					</c:if>
				</ul>
				</nav>
			</div>
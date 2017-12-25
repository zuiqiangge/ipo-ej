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
    <meta charset="UTF-8">
    <title>微舆情-互联网大数据平台</title>
    <!--兼容IE浏览器-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--会根据设备的尺寸来约束window的大小-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--引入bootstrap-->
    <link href="<%=basePath%>main/login/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!--引入css-->
    <link href="<%=basePath%>main/login/css/index.css" rel="stylesheet">
    <script type="text/javascript" src="<%=basePath%>main/login/bootstrap/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>main/login/bootstrap/js/scripts.js"></script>
    <script type="text/javascript" src="<%=basePath%>sinaStyle/index/event.js"></script>
    <!-- layer -->
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>/layer/mobile/need/layer.css">
	<SCRIPT src="<%=basePath%>/layer/layer.js"></SCRIPT>
    <script>
        $(document).ready(function () {
            //点击登录按钮时
            $('#submit_btn').click(function () {
                if($("#loginId").val() == ''){
                	layer.msg('账号不能为空！', {icon: 2});
                    $("#loginId").focus();
                    return;
                }else if($('#password').val() == ''){
                	layer.msg('密码不能为空！', {icon: 2});
                    $('#password').focus();
                    return;
                }
                $.ajax({
                	type:'post',
                	url:"<%=basePath%>home_index",
                	data:$("#login_form").serialize(),
                	success:function (result){
                		if (result==1) {
                			window.location.href = "<%=basePath%>search_index";
						}else{
							layer.msg("账号和密码不匹配！请检查重新登录", {icon: 2});
							return;
						}
                	},
                	error:function(jqXHR, textStatus, errorThrown) {
                		layer.msg('系统繁忙！', {icon: 2});
            		}
                })
            });
        });
        
        function goCreate(url) {
			showEventFrame(1, '',url);
		}
    </script>
</head>
<body>
<div id="main">
    <div id="main_header">
        <!--<img src="images/logon.png">-->
        <div class="header">
            <ul class="uls">
                <li><p class="t1">热度查询</p></li>
                <li><p class="t2">信息监测</p></li>
                <li><p class="t4">全文搜索</p></li>
                <li><p class="t5">事件分析</p></li>
            </ul>
        </div>

    </div>
    <div class="container-fluid">
        <div class="row">
            <!--左边栏-->
            <div class="col-md-3">
                <!--<p class="t1">热度查询</p>-->
                <!--<p class="t1">信息监测</p>-->
                <!--<p class="t1">排行榜单</p>-->
                <!--<p class="t1">全文搜索</p>-->
            </div>

            <!--中间拦-->
            <div class="col-md-6">
                    <div class="login_box">
                        <div class="login_form">

                            <div class="login_logo"><span></span> <img src="<%=basePath%>main/login/images/bgc2.png" alt=""> </div>

                            <form action="" id="login_form" method="post">

                                <div class="form-group">
                                    <label class="test">用户名：</label>
                                    <input id="loginId"  name="loginId" value="${tbXtYhxx.loginId}" type="text" placeholder="请输入用户名"  class="form-control x319" >
                                </div>

                                <div class="form-group">
                                    <label class="test">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                                    <input id="password" name="password"  value="${tbXtYhxx.password}" placeholder="请输入密码"   type="password" class="password form-control x319">
                                </div>

                                <div class="form-space">
                                    <label class="t"></label>
                                    <a href="#" onclick="goCreate('<%=basePath%>main/home/usercpm.jsp');" class="btn btn-default btn-lg">&nbsp;注&nbsp;册&nbsp;</a>
                                    <a id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp; </a>
                                </div>
                            </form>
                        </div>
                    </div>

                <!--<div class="bottom"> 建议使用谷歌chrome、IE11浏览器、火狐moz、IE11浏览器和Safari </div>-->

            </div>
            
            <div id="eventDiv" class="zz_content"
				style="left: 50%; top: 10%; width: 800px; height: 300px; position: absolute; margin-left: -400px; display: none;">
				<a href="javascript:parent.hideEventDiv();" class="info_close abs">×</a>
				<iframe id="event_frame" scrolling="no" style="" frameborder="0"
					 width="100%" height="100%" src="">
				</iframe>
			</div>

            <!--右边栏-->
            <div class="col-md-3">
                <!--<p class="t1">事件分析</p>-->
                <!--<p class="t1">传播分析</p>-->
                <!--<p class="t1">排行榜单</p>-->
                <!--<p class="t1">竞品分析</p>-->
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="bottom"> 建议使用谷歌chrome、IE11浏览器、火狐moz、IE11浏览器和Safari </div>
</footer>
<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
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
  
    <!-- layer -->
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>/layer/mobile/need/layer.css">
	<SCRIPT src="<%=basePath%>/layer/layer.js"></SCRIPT>
    <script>
        $(document).ready(function () {
        	//延时三秒防止没有拿到完整的图片
 setInterval("testimage()",10000);//1000为1秒钟
             });
        
        function testimage(){
        	 $.ajax({
            "url" : "http://edu.shgb.gov.cn/student/player/trace.html",
            "type" : "post",
            data:"type=trace&trace_id=0574bbc9-f7ff-4922-9c2a-5febfb73065b&courseid=2c9e84eb552b39d3015605fe6c2117a1&courseunitid=3428a92f550aef90015605fe77a12592&userid=5cffcbc6-88b9-4abe-a2df-1889803ff951&categoryid=&interval=300000"});
      
        }
  
    </script>
</head>
<body>
 
 
 
</body>
</html>
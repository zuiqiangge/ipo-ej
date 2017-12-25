<%@ page language="java" import="java.util.*,com.zhuozhengsoft.pageoffice.*" pageEncoding="gb2312"%>
<%
FileSaver fs=new FileSaver(request,response);
//System.out.print(request.getSession().getServletContext().getRealPath("main/SimpleWord/doc/")+"/"+fs.getFileName());
 String filePath = request.getSession().getServletContext().getRealPath((String)request.getSession().getAttribute("wordPath"));

fs.saveToFile(filePath);
fs.close();
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title> </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  </body>
</html>

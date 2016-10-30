<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>navigation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <style type="text/css">
  	#navigation{
  			height:10%;
  		}
  
  </style>
  
  <body>
  	<!-- 导航栏 -->
  	<!-- 底色反转、固定顶端 -->
  	<div id="navigation">
  	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
 	 <div class="container-fluid">
 	 <!-- Brand and toggle get grouped for better mobile display -->
  	 <div class="navbar-header">
<!--       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> -->
<!--         <span class="sr-only">Toggle navigation</span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--       </button> -->
      <a class="navbar-brand" href="javascript:;">DC</a>
    </div>
    
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="PageServlet">查重名单</a></li>
	        <li><a href="javascript:;">查重结果</a></li>
	    </ul>
	    </div>    
    </div>
    </nav>
  	</div>
  	
  
  </body>
</html>

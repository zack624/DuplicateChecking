<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Duplicate Checking</title>
    
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
  <div align="center">
  	<h2>Duplicate Checking Table</h2>
  	<table border="1" cellspacing="0">
  		<thead>
  		<tr>
  			<th>索引</th>
  			<th>名字</th>
  			<th>专业</th>
  			<th>论文标题</th>
  			<th>导师</th>
  			<th>上传时间</th>
  		</tr>
  		</thead>
  		<tbody>
  		<c:forEach items="${page.records }" var="record" varStatus="s">
  			<tr>
  				<td>${s.index + 1 + (page.currentPage - 1)*page.everyPageRecord }</td>
  				<td>${record.name }</td>
  				<td>${record.major }</td>
  				<td>${record.paperTitle }</td>
  				<td>${record.teacher }</td>
  				<c:choose>
					<c:when test="${record.timeOfDelivery eq null }"><td>未上传</td></c:when>
					<c:otherwise><td>${record.timeOfDelivery }</td></c:otherwise>
  				</c:choose>
  			</tr>
  		</c:forEach>
  		</tbody>
  	</table>
  	
  	<div>
  		<c:forEach begin="1" end="${page.totalPage }" varStatus="s">
  			<c:choose>
  				<c:when test="${s.index eq page.currentPage }">${s.index }</c:when>
  				<c:otherwise><a href="PageServlet?currentPage=${s.index }">${s.index }</a></c:otherwise>
  			</c:choose>
  		</c:forEach>
  	</div>
  </div>  
  </body>
</html>

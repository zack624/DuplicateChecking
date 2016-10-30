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
    
   	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
	
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    
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
  	<!-- 面板 -->
  	<div class="panel panel-default">
  	<!-- 带条纹的表格 -->
  	<table class="table table-striped">
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
  	</div>
  	
  	<div>
  		<!-- 分页组件 -->
  		<ul class="pagination">
  			
  			<c:if test="${!(page.currentPage eq 1)}">
  				<li><a href="PageServlet?currentPage=1">首页</a>
  				<li><a href="PageServlet?currentPage=${page.currentPage - 1 }">&laquo;</a></li>
  			</c:if>
  			<!-- if(cP-2 <= 0 || tP < 5) begin=1;
  				 else 
  				 	if(cP+2 > tP) begin=tP-4;
  				 	else begin=cP-2; -->
  			<!-- if(cP+2 > tP || tP < 5) end=tP;
  				 else
  				 	if(cP-2 > 0) end=cP+2;
  				 		else end=5-->
  			<c:forEach begin="${( (page.currentPage - 2) > 0 && page.totalPage >= 5 ) ? ( (page.currentPage + 2) <= page.totalPage ? (page.currentPage - 2):(page.totalPage - 4) ) : 1}" 
  				end="${( (page.currentPage + 2) <= page.totalPage && page.totalPage >= 5) ? ( (page.currentPage - 2) > 0 ? (page.currentPage + 2): 5 ) : page.totalPage}" varStatus="s">
  				<!-- class=disabled即不能点击 -->
  				<li class="<c:if test="${s.index eq page.currentPage}">disabled</c:if>"><a href="PageServlet?currentPage=${s.index }">${s.index }</a></li>
  			</c:forEach>
			<c:if test="${!(page.currentPage eq page.totalPage)}">
				<li><a href="PageServlet?currentPage=${page.currentPage + 1 }">&raquo;</a></li>
			</c:if>
  		</ul>
  	</div>
  </div>  
  </body>
</html>

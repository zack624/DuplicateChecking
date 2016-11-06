<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>毕设查重主页</title>
    
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
  	<!-- 样式 -->
  	<style type="text/css">
  		#main{
  			width:90%;
  			margin: auto;
  		}
  		#main tr td{
  			font-size: 14px;
  			font-family: inherit;
  		}
  	</style>
  
  <body>
  
<!-- Tab标签实现导航 -->  	
<!--   	<div id="navigation"> -->
<!--    	<ul class="nav nav-tabs" role="tablist"> -->
<!-- 	  <li role="presentation" class="active"><a href="PageServlet">查重名单</a></li> -->
<!-- 	  <li role="presentation"><a href="#">查重结果</a></li> -->
<!-- 	</ul> -->
<!--    	</div> -->
	<!-- 引入导航页面 -->
	<jsp:include page="navigation.jsp"></jsp:include>

   <!-- 显示区 -->
   <div id="main">
  	<!-- 面板 -->
  	<div class="panel panel-default">
  	<div class="panel-heading">
  		<h4 align="center">Duplicate Checking Table</h4>
  	</div>
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
  				<td>${record.papertitle }</td>
  				<td>${record.teacher }</td>
  				<c:choose>
					<c:when test="${record.timeofdelivery eq null }"><td>未上传</td></c:when>
					<c:otherwise><td>${record.timeofdelivery }</td></c:otherwise>
  				</c:choose>
  			</tr>
  		</c:forEach>
  		</tbody>
  	</table>
  	</div>
  	
  	<div align="center">
  		<!-- 分页组件 -->
  		<nav>
  		<ul class="pagination">
  			
  			<c:if test="${!(page.currentPage eq 1)}">
  				<li><a href="index.do?currentPage=1">首页</a>
  				<li><a href="index.do?currentPage=${page.currentPage - 1 }">&laquo;</a></li>
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
  				<li class="<c:if test="${s.index eq page.currentPage}">disabled</c:if>"><a href="index.do?currentPage=${s.index }">${s.index }</a></li>
  			</c:forEach>
			<c:if test="${!(page.currentPage eq page.totalPage)}">
				<li><a href="index.do?currentPage=${page.currentPage + 1 }">&raquo;</a></li>
			</c:if>
  		</ul>
  		</nav>
  	</div>
  </div>  

  </body>
</html>

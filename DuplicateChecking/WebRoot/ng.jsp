<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ng.jsp' starting page</title>
    <script src="resource/angular.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body  ng-app="myApp" ng-controller="Servlet">
    This is my JSP page. {{yourname || 'world' }}<br>
    <input type="text" placeholder="enter your name" ng-model="yourname">
    
    <br>
    <div>
    <table>
    	<thead>
    	<tr>
    		<th>名字</th>
    		<th>国家</th>
    	</tr>
    	</thead>
    	<tbody>
    	<tr ng-repeat="x in names">
    		<td>{{x.Name}}</td>
    		<td>{{x.Country}}</td>
    	</tr>
    	</tbody>
    </table>
    </div>
    <script>
    	var app = angular.module('myApp',[]);
    	app.controller('Servlet',function($scope,$http){
    		$http.get("http://localhost:8080/DuplicateChecking/NgServlet").success(function(response){$scope.names = response.records;});
    	});
    </script>
    <style>
		table, th , td {
		  border: 1px solid grey;
		  border-collapse: collapse;
		  padding: 5px;
		}
		table tr:nth-child(odd) {
		  background-color: #f2f2f2;
		}
		table tr:nth-child(even) {
		  background-color: #ffffff;
		}	
	</style>
    
  </body>
</html>

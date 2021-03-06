<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>chart</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- jQuery文件 -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
	
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	<!-- 引入highchart.js -->
	<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
	
  </head>
  
  <body>
  		<jsp:include page="navigation.jsp"/>
  		
  		<!-- 通过highchart绘制柱头图 -->
  		<div class="main">
  			<div id="column" style="min-width: 310px; height: 400px; margin: 0 auto;"></div>
  		</div>
  </body>
  
  <script type="text/javascript">
		$(function () {
			var url = "${pageContext.request.contextPath}/showDCChart.do";
			var majorArr = [];			
			var countArr = [];
			$.ajax({
				url : url,
				dataType : "json",
				success : function(data){
					$(data).each(function(index,item){
						countArr.push(item[0]);
						majorArr.push(item[1]);
					});				
					columnDraw(majorArr,countArr);
				},
				
				error : function(){
					alert("error");
				}
			});
		
		
		function columnDraw(xArr,yArr){
		    $('#column').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: '各专业抽检查重情况'
		        },
		        subtitle: {
		            text: '南京理工大学-机械工程学院'
		        },
		        credits:{
		        	enabled : true,
		        	text : "zack"
		        },
		        xAxis: {
		            categories: xArr,
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: '人数'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.0f}</b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: [{
		            name: '人数',
		            data: yArr
		        }]
		    });
		    }
		});
  </script>
</html>

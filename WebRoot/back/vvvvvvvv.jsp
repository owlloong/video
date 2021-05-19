<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cilicili - 管理系统</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/back/css/back.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/font-awesome-4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
	a:hover {
	color: white;
	text-decoration: none;
}

</style>
 <style>
    * { margin: 0; padding: 0; }
    body { font-family: 'Microsoft Yahei'; font-size: 18px; background-color: #f8f8f8; }

    #table {
      width: 1200px;
      margin: 40px auto 0;
      border-collapse: collapse;
      background-color: #fff;
    }
    #table td,
    #table th {
      padding: 0.75em 1.5em;
    }
    #table thead {
      color: #fff;
      background-color: #74a8bb;
    }
    #table thead th {
      text-align: left;
    }
    #table tbody {}
    #table tbody tr {
      border-bottom: 2px dashed #000;
      cursor: default;
      transition: all .125s ease-in-out;
    }
    #table tbody tr:hover {
      background-color: rgba(94,146,166,.5); 
    }
  </style>
</head>
<body>
	<%@ include file="/back/top.jsp" %>
	<%@ include file="/back/left.jsp" %>
	<div class="center" id="main">
	</div>
</body>
<script type="text/javascript">
	var projectLog="${pageContext.request.contextPath }";
</script>
<script src="${ pageContext.request.contextPath }/back/js/back.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript">

/* window.onload = function() {
	doubleBgColor(document.getElementById("table"),"#f8fbfc","#e5f1f4");
	}
	function doubleBgColor(Table,Bg1,Bg2) {
	for (var i=1;i<Table.rows.length;i++) Table.rows[i].bgColor=i%2?Bg2:Bg1;
	} */
</script>
</html>
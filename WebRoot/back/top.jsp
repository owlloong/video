<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="shortcut icon" href="${ pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="top">
      <font id="navFont">cilicili管理系统</font>
      <a href="${ pageContext.request.contextPath }/User/LogOut.do">
      	<font id="navUser">
      		<i class="fa fa-cog fa-fw"></i>
      		<span id="logUser" onmouseover="toLayout('${user.userName }')" onmouseout="LayoutOff()">
      		${user.userName }
      		</span>
      		<span class="caret">
      		</span>
      	</font>
      </a>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="left" id="leftBar">
      <ul>
        <li class="active navbtn">
        	<a href="javascript:navButton(0)">
          	<i class="fa fa-home fa-fw"></i>系统首页
          	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(1)">
        	<i class="fa fa-user fa-fw"></i>用户管理
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(2)">
        	<i class="fa fa-check fa-fw"></i>视频审核
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(3)">
        	<i class="fa fa-laptop fa-fw"></i>视频管理
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(4)">
        	<i class="fa fa-gears fa-fw"></i>类目管理
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(5)">
        	<i class="fa fa-globe fa-fw"></i>视频统计
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(6)">
        	<i class="fa fa-bar-chart fa-fw"></i>热门视频
        	</a>
        </li>
        <li class="navbtn">
        	<a href="javascript:navButton(7)">
        	<i class="fa fa-laptop fa-fw"></i>评论管理
        	</a>
        </li>
      </ul>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div class="searchBar">
		<input id="videoName" type="text" placeholder="输入视频名">
		<button onclick="searchVideo()" type="button">搜索</button>
		<br>
		<hr>
	</div>
	<div id="searchResult" style="height: 600px;overflow: auto;"></div>
</body>
</html>
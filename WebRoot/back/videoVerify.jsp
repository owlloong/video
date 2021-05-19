<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Microsoft Yahei';
	font-size: 18px;
	background-color: #f8f8f8;
}

#table {
	width: 1200px;
	margin: 40px auto 0;
	border-collapse: collapse;
	background-color: #fff;
}

#table td, #table th {
	padding: 0.75em 1.5em;
}

#table thead {
	color: #fff;
	background-color: #74a8bb;
}

#table thead th {
	text-align: left;
}

#table tbody {
	
}

#table tbody tr {
	border-bottom: 2px dashed #000;
	cursor: default;
	transition: all .125s ease-in-out;
}

#table tbody tr:hover {
	background-color: rgba(94, 146, 166, .5);
}
</style>
</head>
<body>
	<table id="table">
		<thead>
			<tr>
				<th>名称</th>
				<th>简介</th>
				<th>分类</th>
				<th>上传用户</th>
				<th>上传时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${VideoList }" var="vl">
				<tr>
					<td><a
						href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${vl.videoId}"">${vl.videoName }</a>
					</td>
					<td>${vl.videoBrief }</td>
					<td>${vl.category.categoryName }</td>
					<td>${vl.user.userName }</td>
					<td>${vl.videoTime }</td>
					<td><c:choose>
							<c:when test="${vl.status==200 }">已发布</c:when>
							<c:when test="${vl.status==201 }">上传中</c:when>
							<c:when test="${vl.status==202 }">待审核</c:when>
							<c:when test="${vl.status==203 }">已删除</c:when>
							<c:otherwise>状态异常</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${vl.status==202 }">
								<a class="btn-accept"
									href="javascript:acceptVideo(${vl.videoId })">通过</a>
								<a class="btn-deny" href="javascript:denyVideo(${vl.videoId })">拒绝</a>
							</c:when>
							<c:otherwise>不可操作</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		window.onload = function() {
			doubleBgColor(document.getElementById("table"), "#f8fbfc",
					"#e5f1f4");
		}
		function doubleBgColor(Table, Bg1, Bg2) {
			for (var i = 1; i < Table.rows.length; i++)
				Table.rows[i].bgColor = i % 2 ? Bg2 : Bg1;
		}
	</script>

</body>
</html>
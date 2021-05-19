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
<body style="height: 600px;overflow: auto;">
	<table id="table">
	<thead>
		<tr>
			<td>名称</td>
			<td>简介</td>
			<td>分类</td>
			<td>上传用户</td>
			<td>上传时间</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${VideoList }" var="vl">
				<tr>
					<td><a
						href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${vl.videoId}">${vl.videoName }</a>
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
							<c:when test="${vl.status==200 }">
								<a href="javascript:deleteVideo(${vl.videoId })">删除</a>
								<a
									href="${ pageContext.request.contextPath }/JSP/picUpload.jsp
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">编辑视频</a>
								<a
									href="${ pageContext.request.contextPath }/delete.do
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">彻底删除</a>
							</c:when>
							<c:when test="${vl.status==203 }">
								<a href="javascript:recoverVideo(${vl.videoId })">恢复</a>
								<a
									href="${ pageContext.request.contextPath }/JSP/picUpload.jsp
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">编辑视频</a>
								<a
									href="${ pageContext.request.contextPath }/delete.do
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">彻底删除</a>
							</c:when>
							<c:otherwise>
								<a
									href="${ pageContext.request.contextPath }/JSP/picUpload.jsp
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">编辑视频</a>
								<a
									href="${ pageContext.request.contextPath }/delete.do
						?videoId=${vl.videoId}&videoURL=${vl.videoURL}&videoSRC=${vl.videoSRC}
						"
									target="_blank">彻底删除</a>
							</c:otherwise>
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
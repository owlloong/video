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
	<script src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
		<script src="${ pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/player.js"></script>
		<script src="${ pageContext.request.contextPath }/js/danmuplayer.min.js"></script>
<script type="text/javascript">
	function sadsasda(id){
		$.post(
				"${ pageContext.request.contextPath}"+"/Comment/deleteCommCount.do",
				{
					"commentId":id,
				}, function(resText) {
					if(resText=="success"){
						alert("操作成功");
						$("#ssadadasda").load(
								"${ pageContext.request.contextPath}"+"/Comment/GetallComment.do?pageNum="+pageNum,
								{
								}, function() {
								});
					} else {
						alert("操作失败");
					}
				});
		}
	
</script>
<script type="text/javascript">
var pageNum=${pageNum};
var totalPage=${totalPage};
function prePage(){
	if(pageNum>1){
		pageNum--;
		//document.getElementById("presentPage").innerHTML=pageNum;
		$("#ssadadasda").load(
				"${ pageContext.request.contextPath}"+"/Comment/GetallComment.do?pageNum="+pageNum,
				{
				}, function() {
				});
	} else {
		alert("没有上一页了");
	}
}
function nextPage(){
	if(pageNum<totalPage){
		pageNum++;
		$("#ssadadasda").load(
				"${ pageContext.request.contextPath}"+"/Comment/GetallComment.do?pageNum="+pageNum,
				{
				}, function() {
				});
		
		//document.getElementById("presentPage").innerHTML=pageNum;
	} else {
		alert("没有下一页了");
	}
}
</script>
</head>
<body >
<div id="ssadadasda">
	<table id="table">
	<thead>
		<tr>
			<td>序号</td>
			<td>评论标号</td>
			<td>子评论数目</td>
			<td>用户名</td>
			<td>评论内容</td>
			<td>评论时间</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${commList}" var="cl" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${cl.commentId }</td>
					<td>${cl.subCommCount }</td>
					<td>${cl.user.userName }</td>
					<td>${cl.commContext }</td>
					<td>${cl.commentTime}</td>
					<td>
					<c:if test="${cl.subCommCount==0 }">
							<a style="color:#87CEEB;" href="javascript:sadsasda('${cl.commentId}')">删除</a>
					</c:if>
				<c:if test="${cl.subCommCount!=0 }">
							有子评论，不能删除该评论
					</c:if>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						<%-- <a href="${ pageContext.request.contextPath}/Comment/GetallComment.do?pageNum=${pageNum-1}">上一页</a>
						<a href="${ pageContext.request.contextPath}/Comment/GetallComment.do?pageNum=${pageNum+1}">下一页</a> --%>
						<button class="play_last-button" type="button" onclick="prePage()" >上一页</button>
		<button class="play_next-button" type="button" onclick="nextPage()">下一页</button>
		<span >共${totalPage }页</span><span >第${pageNum }页</span>
					</td>
				</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
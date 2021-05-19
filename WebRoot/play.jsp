<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${video.videoName}</title>

<link rel="icon" href="images/logo1.png"> 
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/player.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/danmuplayer.css">
<script type="text/javascript">
var pageNum=1;
var totalPage=${totalPage};
var videoId=${video.videoId}
function loadComment(){
	$("#commentList").load(
			"${pageContext.request.contextPath }/Comment/GetComment.do", {
		"videoId" : videoId,
		"pageNum" : 1
		}, function() {
			
		});
}
function prePage(){
	if(pageNum>1){
		pageNum--;
		//document.getElementById("presentPage").innerHTML=pageNum;
		$("#commentList").load(
				"${pageContext.request.contextPath }/Comment/GetComment.do", {
			"videoId" : videoId,
			"pageNum" : pageNum
			}, function() {
			});
	} else {
		alert("没有上一页了");
	}
}
function nextPage(){
	if(pageNum<totalPage){
		pageNum++;
		$("#commentList").load(
				"${pageContext.request.contextPath }/Comment/GetComment.do", {
			"videoId" : videoId,
			"pageNum" : pageNum,
			"comment" : value
			}, function() {
			});
		//document.getElementById("presentPage").innerHTML=pageNum;
	} else {
		alert("没有下一页了");
	}
}
function submitComm(parentId,commType){
	var userId = '${sessionScope.user.userId}';
	if(parentId==0){
		parentId=videoId;
	}
	if (userId == null || userId == '') {
		alert("请先登录");
	} else {
		if(commType==0){
			var contextEle=document.getElementById('commContext');
		} else {
			var contextEle=document.getElementById('commContext'+parentId);
		}
		if(contextEle.value==null||contextEle.value==''){
			alert("请输入内容");
		} else {
			var value=contextEle.value;
			$("#commentList").load(
					"${ pageContext.request.contextPath }/Comment/PostComment.do",
					{
						"videoId" : videoId,
						"parentId" : parentId,
						"comment" : value
					}, function() {
						loadComment();
					});
			
			pageNum = 1;
			contextEle.value="";
			//document.getElementById('presentPage').innerHTML = pageNum;
			totalPage=${totalPage};
		}
	}
}
</script>
</head>
<body onload="loadComment()">
	<div class="paly_all">
		<div><%@include file="header.jsp"%></div>
		<div class="play_main">
			<div class="sidebar" id="box">
				<ul id="leftBox">
					<li>详情</li>
					<li>评论</li>
					<li>相关视频</li>
				</ul>
				<div id="rightBox">
					<div class="box" style="display: block;">
						<ul class="right_top">
							<li class="video_img"><img class="img" src="/cili_back/images${video.videoSRC }" />
							</li>
							<li class="information">名称:${video.videoName }</li>
							<li class="information">发布者：${video.user.userName }</li>
							<li class="information">类型:${video.category.categoryName}</li>
							<li class="information">播放量:${video.count }</li>
							<li class="information">详细内容:<br />${video.videoBrief }</li>
							<li class="information">&nbsp;&nbsp;</li>
							<li class="information">
								<a href="${pageContext.request.contextPath }/download.do?videoId=${video.videoId}&videoURL=D:/apache-tomcat-8.0.23/webapps/cili_back/temp${video.videoURL}&videoSRC=D:/apache-tomcat-8.0.23/webapps/cili_back/images${video.videoSRC}"
								style="color:#0F99D5;">下载</a>

							</li>
						</ul>
					</div>
					<div style="overflow: hidden; height: 520px;" id="commentList">
						
					</div>
					<div>
						<ul class="right_top">
							<%-- <li class="video_img"><img class="img" src="${ pageContext.request.contextPath }/images/006.jpg" /> --%>
							<a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${hotVideoList[0].videoId}" >
							<li class="video_img"><img class="img" src="/cili_back/images${hotVideoList[0].videoSRC}" />
							</li></a>
							<li class="information">名称:${hotVideoList[0].videoName }</li>
							<li class="information">发布者：${hotVideoList[0].user.userName}</li>
							<li class="information">类型:${hotVideoList[0].category.categoryName}</li>
							<li class="information">播放量:${hotVideoList[0].count }</li>
							<li class="information">详细内容:<br />${hotVideoList[0].videoBrief }</li>
							<li class="play_page"><input class="play_last-button"
								type="button" value="上一页" onclick="" /> <input
								class="play_next-button" type="button" value="下一页" onclick="" /></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="player">
				<div id="danmup">
				</div>
			</div></div>
			<c:if test="${flag==1 }">
			<%@ include file="hot2.jsp" %> 
			</c:if>
			<c:if test="${flag==0 }">
			<%@ include file="hot.jsp" %> 
			</c:if>
			
			<%-- <%@ include file="tuijian.jsp" %> --%>
			<br><br><br><br><br><br><br><br><br><br><br>
			<div><%@include file="foot.jsp"%></div>
		</div>
		<script src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
		<script src="${ pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script>
		<script src="${ pageContext.request.contextPath }/js/player.js"></script>
		<script src="${ pageContext.request.contextPath }/js/danmuplayer.min.js"></script>
		<script type="text/javascript">
			var userId = "${sessionScope.user.userId}";
		</script>
		<script type="text/javascript">
			$("#danmup")
					.DanmuPlayer(
							{
								src : "/cili_back/temp${video.videoURL}",
								height : "480px", //区域的高度
								width : "1060px", //区域的宽度
								urlToGetDanmu : "${ pageContext.request.contextPath }/Danmu/GetDanmu.do?videoId="
										+ "${video.videoId}",
								urlToPostDanmu : "${ pageContext.request.contextPath }/Danmu/PostDanmu.do?videoId="
										+ "${video.videoId}"
							});
			function Download(){
				window.open("feeWarning/download.do");
			}
		</script>
</body>
</html>
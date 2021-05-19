<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索结果</title>

<link rel="icon" href="images/logo1.png">

<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/all_reset.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/all.css">
</head>
<body onload="loadVideo()">

  <div class="main" id="mv">
  <div><%@include file="header.jsp" %></div>
    <div class="main-inner">
      <div class="main-title">
        <h2 class="title"><i>Result</i></h2>
        <span class="line line-left"></span>
        <span class="line line-right"></span>
      </div>
      
      <div style="margin-left: 100px;" id="videoList">
      <ul class="mv-list tab-cont">
		<c:forEach items="${VideoList}" var="vl">
		<li class="item"><a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${vl.videoId}" class="img"><img
				src="/cili_back/images${vl. videoSRC}"
				alt="#"><i class="icon-play"></i></a>
			<div class="info">
				<a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${vl.videoId}" class="title">${vl.videoName }</a> <a href="#"
					class="author">${vl.user.userName }</a> <span class="play-total"><img
					src="${ pageContext.request.contextPath }/images/003.png" />${vl.count }</span>
			</div></li>
		</c:forEach>
	</ul></div>
      
    </div>
   <div><%@include file="foot.jsp" %></div> 
  </div>
  <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
  <script src="${ pageContext.request.contextPath }/js/script.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function changeTotal(){
		totalPage=${totalPage};
		document.getElementById("spnnPage").innerHTML=totalPage;
	}
</script>
</head>
<body onload="changeTotal()">
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
	</ul>
</body>
</html>
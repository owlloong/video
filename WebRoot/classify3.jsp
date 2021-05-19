<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/classify.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/Category/CategoryList.do?categoryId=${CategoryList[4].categoryId}" class="readAll1">全部<i class="icon-sprite"></i></a>
 <div class="classify_title"><span>${CategoryList[4].categoryName}</span></div>
<div class="wrap">
<a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${CategoryList[4].video[0].videoId}" class="playIcon">
  <div class="tile1">
    <div class="text1">
      <h1 class="first">${CategoryList[4].video[0].videoName}</h1>
      <img class="first_img" src="/cili_back/images${CategoryList[4].video[0].videoSRC}"/>
     <!--  <img class="animate-text" src="images/13.png"/> -->
      <p class="animate-text1">${CategoryList[4].video[0].videoBrief}</p>
    </div>
  </div>
</a>
  <div class="tile2">
  <c:forEach items="${CategoryList[4].video}" var="clv" begin="1">
  <a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${clv.videoId}" class="playIcon">
  <div class="tile">
    <div class="text">
      <h1>${clv. videoName}</h1>
      <img src="/cili_back/images${clv. videoSRC}"/>
      <h2 class="animate-text">${clv.user.userName}</h2>
      <p class="animate-text">${clv. videoBrief}</p>
    </div>
  </div>
  </a>
  </c:forEach>
  </div>


</div>

</body>
</html>
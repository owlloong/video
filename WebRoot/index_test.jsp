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
${user.userName }
<c:forEach items="${CategoryList}" var="cl">
	<a href="${pageContext.request.contextPath}/Category/CategoryList.do?categoryId=${cl.categoryId}">
		${cl.categoryName}
	</a>
	<c:forEach items="${cl.video }" var="clv">
		${clv.videoName}
	</c:forEach>
</c:forEach>
<br>热门
<c:forEach items="${hotVideoList}" var="hl">
	${hl.videoName }
</c:forEach>
<br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hot_style.css" />
</head>
<body>   
   <div class="new_mv1 new_common1">
   <a href="${pageContext.request.contextPath}/Category/CategoryList.do?categoryId=${CategoryList[1].categoryId}" class="readAll">全部<i class="icon-sprite"></i></a>
        <div class="new_mv_title new_common_title index_mv_title">
            <span>${CategoryList[1].categoryName}</span>
        </div> 
            <div class="mvList" id="mv_rank_list" style="display:block;">
                <ul class="sb" id="main">
                <c:forEach items="${CategoryList[1].video}" var="clv" end="4">
                	<li>
                        <a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${clv.videoId}" class="playIcon">
                            <img width="220" height="145" src="/cili_back/images${clv.videoSRC }" class="attachment-220x125 wp-post-image" alt="" />
                            <strong>${clv.user.userName }</strong>
                            <span>
                                <!-- <font>God of ink &#8211;  SawanoHiroyuki</font> -->
                                <font>${clv.videoName }</font>
                                <font><i></i></font>
                                <font><i></i><em>播放量：${clv.count }</em></font>
                            </span>
                        </a>
                    </li>
                </c:forEach>
		          
			    </ul>
            </div>
      </div>
</body>
</html>



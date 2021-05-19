<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>cilicili</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hot_style.css" />
</head>
<body>   
   <div class="new_mv new_common">
        <div class="new_mv_title new_common_title index_mv_title">
            <span>热门推荐</span>
        </div> 
            <div class="mvList" id="mv_rank_list" style="display:block;">
                <ul class="sb" id="main">
			        <li style="width: 460px;height: 300px;">
                        <a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${hotVideoList[0].videoId}" class="playIcon" >
                            <img width="460" height="300" src="/cili_back/images${hotVideoList[0].videoSRC}" class="attachment-220x125 wp-post-image" alt="mv_1x2_10" /> 
                            <strong>${hotVideoList[0].user.userName}</strong>
                            <span class="first_hide">
                                 <font style="font-size: 22px;color: #fff;">${hotVideoList[0].videoName}</font>
                                 <font><i style="margin-top: 85px;"></i></font>
                                 <font><i style="margin-top: 80px;"></i><em style="margin-top: 80px;">${hotVideoList[0].count}</em></font>
                            </span>
                        </a>
                    </li>
                    <c:forEach items="${hotVideoList}" var="hl" begin="1">
                    <li>
                        <a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${hl.videoId}" class="playIcon">
                            <img width="220" height="145" src="/cili_back/images${hl.videoSRC}" class="attachment-220x125 wp-post-image" alt="" />
                            <strong>${hl.user.userName }</strong>
                            <span>
                                <font>${hl.videoName }</font>
                                <font><i></i></font>
                                <font><i></i><em>播放量：${hl.count }</em></font>
                            </span>
                        </a>
                    </li>
                    </c:forEach>
		            
				   
			    </ul>
            </div>
      </div>
</body>
</html>



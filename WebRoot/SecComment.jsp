<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	function listMoreSubComm(){
		if(pageId!='${commList[0].parentId}'){
			//ID不匹配
			//检查是否有当前页记录
			if(correntPage==undefined){
				//无记录
				subPageNum=1;
			} else {
				subPageNum=correntPage;
			}
			pageId='${commList[0].parentId}';
		}
			if(${totalPage}==subPageNum||subPageNum>${totalPage}){
				alert("没有更多了");
			} else {
			var btn_listMore=document.getElementById("listMore"+'${commList[0].parentId}');
			btn_listMore.innerHTML="";
			var moreSubComm=document.getElementsByName("moreSubComm")[subPageNum-1];
			subPageNum++;
			var correntPage=subPageNum;
			$("#moreSubComm"+'${commList[0].parentId}').load(
				"${pageContext.request.contextPath }/Comment/GetSubComment.do", {
					"parentId" : '${commList[0].parentId}',
					"pageNum" : subPageNum
				}, function() {
				});
			var moreSubComms=document.getElementsByName("moreSubComm");
			for(var i = moreSubComms.length - 1; i >= 0; i--){
				moreSubComms[i].id+="m";
			}
		}
	}
</script>
</head>
<body style="margin-left:10px;">
	<c:forEach items="${commList }" var="cl">
	<br>
		<span style="background-color: #2F4F4F;margin-left: 5px;">
			<span>${cl.user.userName }：</span>
			${cl.commContext}<br>(${cl.commentTime })
			<hr>
		</span>
	</c:forEach>
	<c:if test="${totalPage>0 }">
		<a href="javascript:listMoreSubComm()">
		<span id="listMore${commList[0].parentId}" style="color:#87CEEB" name="listMore${commList[0].parentId}">查看更多</span>
		</a>
	</c:if>
	<span id="moreSubComm${commList[0].parentId}" name="moreSubComm"></span>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function secComment(commId) {
	//检查是否已有结点
	var commSpn = document.getElementById("commSpn" + commId);
	var commdiv=document.getElementById("secComm"+commId);
	if (commSpn.innerHTML == '回复') {
		//修改'回复'为'取消'
		commSpn.innerHTML="取消";
		commdiv.style.display="";
	} else {
		commSpn.innerHTML="回复";
		commdiv.style.display="none";
	}
}
function listsecComment(commId) {
	//检查是否已有结点
	var commSpn = document.getElementById("listcommSpn" + commId);
	if (commSpn.innerHTML == '查看') {
		//修改'回复'为'收起'
		commSpn.innerHTML="收起";
		$("#subComm"+commId).load(
			"${pageContext.request.contextPath }/Comment/GetSubComment.do", {
				"parentId" : commId,
				"pageNum" : '1'
			}, function() {
			});
	} else {
		commSpn.innerHTML="查看";
		subPageNum=1;
		pageId=commId;
		document.getElementById("subComm"+commId).innerHTML="";
	}
}

</script>
</head>
<body>
	<ul class="right_top" style="overflow: auto; overflow-x: hidden;">
		<li class="comment-text"><input class="send-text" type="text" id="commContext" /></li>
		<li class="comment-button">
		<button class="send-button" type="button" onclick="submitComm(0,0)" >发送</button>
		</li>
			<c:forEach items="${commList}" var="cl" varStatus="vs">
				<li class="information">${cl.user.userName }:
				<br>${cl.commContext }(${cl.commentTime})
				
				<br> 共${cl.subCommCount }条回复
					<a style="color:#87CEEB;" href="javascript:secComment('${cl.commentId}')"><span id="commSpn${cl.commentId}">回复</span></a>
					<span id="secComm${cl.commentId}" style="display:none;">
						<input type="text" name="secCommTex${cl.commentId}" id="commContext${cl.commentId}" placeholder="请在此处输入评论~"/>
						<%-- <button type="button" onclick="submitComm('${cl.commentId}',1)">发送</button> --%>
						<button  type="button" onclick="submitComm('${cl.commentId}',1)">发送</button>
					</span>
					<c:if test="${cl.subCommCount!=0 }">
					<a style="color:#87CEEB;" href="javascript:listsecComment('${cl.commentId}')"><span id="listcommSpn${cl.commentId}">查看</span></a>
					</c:if>
					<span id="subComm${cl.commentId}"></span>
				</li>
			</c:forEach>
		

		<li class="play_page">
		<button class="play_last-button" type="button" onclick="prePage()" >上一页</button>
		<button class="play_next-button" type="button" onclick="nextPage()">下一页</button>
		<span style="color:white">共${totalPage }页</span>
		</li>
		
	</ul>
</body>
</html>
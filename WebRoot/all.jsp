<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category.categoryName}</title>

<link rel="icon" href="images/logo1.png"> 
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/all_reset.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/all.css">
<script type="text/javascript">
//分页
	var pageNum=1;
	var categoryLV=1;
	var categoryId=${category.categoryId};
	var totalPage=${totalPage};
	function loadVideo(){
		$("#videoList").load(
			"${pageContext.request.contextPath }/Category/CateVideoList.do", {
				"categoryId" : categoryId,
				"categoryLV" : categoryLV,
				"pageNum" : pageNum
			}, function() {
			});
	}
	function prePage(){
		if(pageNum==1){
			alert("没有上一页了");
		} else {
			pageNum--;
			document.getElementById('presentPage').innerHTML=pageNum;
			loadVideo();
		}
	}
	function nextPage(){
		if(pageNum<totalPage){
			pageNum++;
			document.getElementById('presentPage').innerHTML=pageNum;
			loadVideo();
		} else {
			alert("没有下一页了");
		}
	}
//次导航栏
function navButton(btn_cateId,btn_cateLV){
	//取消之前的item-cur
	var btns=document.getElementsByClassName("item");
	for(i=0;i<btns.length;i++){
		btns[i].classList.remove("item-cur");
	}
	//当前加上item_cur
	var prebtn=document.getElementById("navbtn"+btn_cateId);
	prebtn.classList.add("item-cur");
	categoryId=btn_cateId;
	categoryLV=btn_cateLV;
	pageNum=1;
	loadVideo();
	document.getElementById("presentPage").innerHTML=pageNum;
}
</script>
</head>
<body onload="loadVideo()">

	<div class="main" id="mv">
		<div><%@include file="header.jsp"%></div>
		<div class="main-inner">
			<div class="main-title">
				<h2 class="title">
					<i>${category.categoryName }</i>
				</h2>
				<span class="line line-left"></span> <span class="line line-right"></span>
			</div>
			<!-- <a href="#" class="readAll">全部<i class="icon-sprite"></i></a> -->
			<div class="main-tab tab-title">
				<a href="javascript:navButton(${category.categoryId },1);" id="navbtn${category.categoryId }" class="item item-cur">全部</a>
				<c:forEach items="${category.subCategory }" var="csl">
					<a href="javascript:navButton(${csl.categoryId},2);" id="navbtn${csl.categoryId}" class="item">${csl.categoryName }</a>
				</c:forEach>
			</div>
			<div style="margin-left: 100px;" id="videoList">
				
			</div>
			<div class="btn_page">
				<button class="all_last-button" type="button" onclick="prePage()">上一页</button>
				<span id="presentPage" style="margin-left:25px">1</span>
				<button class="all_next-button" type="button" onclick="nextPage()">下一页</button>
				<span style="margin-left:25px">共
				<span id="spnnPage">${totalPage }</span>
				页</span>
			</div>
		</div>
		
		<div><%@include file="foot.jsp"%></div>
	</div>
	<script type="text/javascript"
		src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<!-- <script src="js/script.js"></script> -->

</body>
</html>
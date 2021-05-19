<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cilicili - 首页</title>
<!-- 
	<link rel="stylesheet" type="text/css" href="css/normalize.css" /> -->
	<!-- <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css"> -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	
</head>
<body style="background-color: #1c1c1c;">

<div><%-- <%@ include file="header.jsp"%> --%>
<jsp:include page="header.jsp"></jsp:include>
</div>

<div class="htmleaf-container">	

		<div class="main_banner">
		<!-- 轮播图开始 -->
			<div class="main_banner_wrap">
				<div class="main_banner_box" id="m_box">
					<a href="javascript:void(0)" class="banner_btn js_pre">
						<span class="banner_btn_arrow"><i></i></span>
					</a>
					<a href="javascript:void(0)" class="banner_btn btn_next js_next">
						<span class="banner_btn_arrow"><i></i></span>
					</a>
					<ul>
						<li id="imgCard0">
							<a href=""><span style="opacity:0;"></span></a>      
							<img src="${pageContext.request.contextPath}/images/1.jpg" alt="">
							<p style="bottom:0">周杰伦粉丝版MV</p>
						</li> 
						<li id="imgCard1">
							<a href=""><span style="opacity:0.4;"></span></a>      
							<img src="${pageContext.request.contextPath}/images/2.jpg" alt="">
							<p>乐侃有声节目第二期</p>
						</li> 
						<li id="imgCard2">
							<a href=""><span style="opacity:0.4;" ></span></a>        
							<img src="${pageContext.request.contextPath}/images/3.jpg" alt="">
							<p>乐见大牌：”荣“耀之声，”维“我独尊</p>
						</li> 
						<li id="imgCard3">
							<a href=""><span style="opacity:0.4;"></span></a>      
							<img src="${pageContext.request.contextPath}/images/4.jpg" alt="">
							<p>王力宏四年心血结晶</p>
						</li> 
						<li id="imgCard4">
							<a href=""><span style="opacity:0.4;"></span></a>      
							<img src="${pageContext.request.contextPath}/images/5.jpg" alt="">
							<p>MV精选：《武媚》女神团美艳大比拼</p>
						</li> 
					</ul>
					<!--火狐倒影图层-->
					<p id="rflt"></p>
					<!--火狐倒影图层-->
				</div>
				<!--序列号按钮-->
				<div class="btn_list">
					<span class="curr"></span><span></span><span></span><span></span><span></span>        
				</div>
			</div>
		</div>
		<!-- 轮播图结束 -->
	</div>
	<!-- 热点推荐 -->	
	<%@ include file="hot.jsp" %>
	<%@ include file="classify.jsp" %>
	<%@ include file="classification.jsp" %>
	<%@ include file="classify2.jsp" %>
	<%@ include file="classification2.jsp" %>
	<%@ include file="classify3.jsp" %>
	<%@ include file="classification3.jsp" %>
	<br><br><br><br>
	<jsp:include page="foot.jsp"></jsp:include>
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
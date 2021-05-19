<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cilicili - 登录</title>
<script type="text/javascript">
	function changeCode(){
		var img = document.getElementById("valiImg");
		img.src = "${ pageContext.request.contextPath }/servlet/ValiCode?method=MakeCode&time="+new Date().getTime();
	}
</script>

<!-- 背景 -->
<style>
body {
	text-align: center;
	background: #F7FAFC;
	overflow: hidden;
	background: #fff;
}

#canvas {
	display: inline-block;
}

.skiplogin {
	text-align: center;
	margin: 10px;
	color: #BEBEBE;
}

.alerttext {
	color: #FF5151;
	margin-left: 15px;
}
</style>
<link rel="shortcut icon" href="${ pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/login.css">
</head>
<body class="zhi ">
	<div class="index-main">
		<div class="index-main-body">
			<div class="index-header">
				<h1 class="logo hide-text">cilicili</h1>
				<h2 class="subtitle">
					<img src="img/logo.png"
						style="border: 0px solid; width: 200px; margin-top: -50px;">
				</h2>
			</div>
			<div class="desk-front sign-flow clearfix sign-flow-simple">
				<div class="index-tab-navs">
					<div class="navs-slider">
						<a id="signupbtn" href="register.jsp">注册</a> <a id="signinbtn"
							href="" class="active">登录</a>
					</div>
				</div>
				<div class="view view-signup selected" data-za-module="SignUpForm">
					<form class="zu-side-login-box"
						action="${ pageContext.request.contextPath }/User/Login.do"
						id="logform" autocomplete="off" method="POST">
						<div class="group-inputs">
							<div class="email input-wrapper">
								<input required type="email" class="account" name="email"
									aria-label="邮箱" placeholder="邮箱" id="email">
							</div>
							<div class="input-wrapper">
								<input required type="password" name="password" aria-label="密码"
									id="password" placeholder="密码" autocomplete="off">
								<c:if test="${ !empty message }">
									<c:choose>
										<c:when test="${message=='nolog'}">
											<font class="alerttext">*请先登录</font>
										</c:when>
										<c:when test="${message=='loginerror'}">
											<font class="alerttext">*邮箱或密码错误</font>
										</c:when>
									</c:choose>
								</c:if>
							</div>
							<div class="col-sm-3 input-wrapper">
								<input required type="text" class="form-control"
									id="code" name="code" aria-label="验证码"
									autocomplete="off" placeholder="验证码">
							</div>
							<div class="col-sm-3 input-wrapper">
								<img id="valiImg"
									src="${ pageContext.request.contextPath }/ValiCode/MakeCode.do"
									onclick="changeCode()" height="40px" width="300px">
							</div>
						</div>
						<div class="button-wrapper command">
							<button class="sign-button submit" type="button" onclick="submitfun()">登录</button>
						</div>
						<div class="skiplogin">
							<a href="${pageContext.request.contextPath }/Category/Index.do">跳过登录，先浏览看看--></a>
						</div>
						<div class="signin-misc-wrapper clearfix">

							<a class="unable-login" href="#">无法登录？</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<canvas id="canvas"
		style="position: absolute; left: 0px; top: 0px; z-index: -1;">
	</canvas>


	<!-- 绘制背景 -->
	<script>
		var codecheck=0;
		//定义画布宽高和生成点的个数
		var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;
		var canvas = document.getElementById('canvas');
		canvas.width = WIDTH,
		canvas.height = HEIGHT;
		var context = canvas.getContext('2d');
		context.strokeStyle = 'rgba(0,0,0,0.02)',
		context.strokeWidth = 2,
		context.fillStyle = 'rgba(0,0,0,0.05)';
		var circleArr = [];

		//线条：开始xy坐标，结束xy坐标，线条透明度
		function Line (x, y, _x, _y, o) {
			this.beginX = x,
			this.beginY = y,
			this.closeX = _x,
			this.closeY = _y,
			this.o = o;
		}
		//点：圆心xy坐标，半径，每帧移动xy的距离
		function Circle (x, y, r, moveX, moveY) {
			this.x = x,
			this.y = y,
			this.r = r,
			this.moveX = moveX,
			this.moveY = moveY;
		}
		//生成max和min之间的随机数
		function num (max, _min) {
			var min = arguments[1] || 0;
			return Math.floor(Math.random()*(max-min+1)+min);
		}
		// 绘制原点
		function drawCricle (cxt, x, y, r, moveX, moveY) {
			var circle = new Circle(x, y, r, moveX, moveY)
			cxt.beginPath()
			cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
			cxt.closePath()
			cxt.fill();
			return circle;
		}
		//绘制线条
		function drawLine (cxt, x, y, _x, _y, o) {
			var line = new Line(x, y, _x, _y, o)
			cxt.beginPath()
			cxt.strokeStyle = 'rgba(0,0,0,'+ o +')'
			cxt.moveTo(line.beginX, line.beginY)
			cxt.lineTo(line.closeX, line.closeY)
			cxt.closePath()
			cxt.stroke();
		}
		//初始化生成原点
		function init () {
			circleArr = [];
			for (var i = 0; i < POINT; i++) {
				circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
			}
			draw();
		}

		//每帧绘制
		function draw () {
			context.clearRect(0,0,canvas.width, canvas.height);
			for (var i = 0; i < POINT; i++) {
				drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
			}
			for (var i = 0; i < POINT; i++) {
				for (var j = 0; j < POINT; j++) {
					if (i + j < POINT) {
						var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
							B = Math.abs(circleArr[i+j].y - circleArr[i].y);
						var lineLength = Math.sqrt(A*A + B*B);
						var C = 1/lineLength*7-0.009;
						var lineOpacity = C > 0.03 ? 0.03 : C;
						if (lineOpacity > 0) {
							drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
						}
					}
				}
			}
		}
		//调用执行
		window.onload = function () {
			init();
			setInterval(function () {
				for (var i = 0; i < POINT; i++) {
					var cir = circleArr[i];
					cir.x += cir.moveX;
					cir.y += cir.moveY;
					if (cir.x > WIDTH) cir.x = 0;
					else if (cir.x < 0) cir.x = WIDTH;
					if (cir.y > HEIGHT) cir.y = 0;
					else if (cir.y < 0) cir.y = HEIGHT;
					
				}
				draw();
			}, 16);
			//验证码
			var codeElement = document.getElementById("code");
			codeElement.onblur = function() {
					var code = this.value;//this等价于emailElement
					//创建XMLHttpRequest对象
					var xhr;
					if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
						xhr = new XMLHttpRequest();
					} else {// code for IE6, IE5
						xhr = new ActiveXObject("Microsoft.XMLHTTP");
					}
					//处理结果
					xhr.onreadystatechange = function() {
						if (xhr.readyState == 4) {//请求一切正常
							if (xhr.status == 200) {//服务器响应一切正常
								if (xhr.responseText == "correct") {
									codeElement.style.backgroundColor="#7FFF00";
									codeElement.style.transition="background-color 0.5s";
									codecheck=1;
								} else {
									codeElement.style.backgroundColor="#FA8072";
									codeElement.style.transition="background-color 0.5s";
									codecheck=0;
								}
							}
						}
					}
					//创建连接
					xhr.open("get",
							"${pageContext.request.contextPath }/servlet/ValiCode?method=CheckCode&code="+ code);
					//发送请求
					xhr.send(null);
				}
		}
		
		function submitfun(){
			var logform = document.getElementById("logform");
			var emailElement=document.getElementById("email");
			var pwdElement=document.getElementById("password");
			var emailcheck=0;
			var passwordcheck=0;
			if(emailElement.value==null||emailElement.value==""){
				//邮箱为空
				emailElement.style.backgroundColor="#FA8072";
				emailElement.style.transition="background-color 0.5s";
				emailcheck=0;
			} else {
				emailElement.style.backgroundColor="";
				emailcheck=1;
			}
			
			if(pwdElement.value==null||pwdElement.value==""){
				//密码为空
				pwdElement.style.backgroundColor="#FA8072";
				pwdElement.style.transition="background-color 0.5s";
				passwordcheck=0;
			} else {
				pwdElement.style.backgroundColor="";
				passwordcheck=1;
			}
			
			if(emailcheck==1&&passwordcheck==1){
				//用户名密码非空
				if(codecheck==1){
					logform.submit();
				} else {
					alert("验证码错误");
				}
			}
		}
	</script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</body>
</html>
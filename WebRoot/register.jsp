<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh-CN" class="">
<head>
<meta charset="utf-8">
<title>cilicili - 注册</title>

<!-- 背景 -->
<style>
body {
	text-align: center;
	overflow: hidden;
}

#canvas {
	display: inline-block;
}
.alerttext{
	color:#FF5151;
	margin-left:15px;
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
				<h2 class="subtitle"><img src="img/logo.png"
						style="border: 0px solid; width: 200px; margin-top: -50px;"></h2>
			</div>
			<div class="desk-front sign-flow clearfix sign-flow-simple">
				<div class="index-tab-navs">
					<div class="navs-slider">
						<a id="signupbtn" href="#" class="active">注册</a> <a id="signinbtn"
							href="login.jsp">登录</a>
					</div>
				</div>
				<div class="view view-signup selected" data-za-module="SignUpForm">
					<form class="zu-side-login-box" action="${pageContext.request.contextPath }/User/Register.do"
						id="resform" autocomplete="off" method="POST">
						<div class="group-inputs">
							<div class="name input-wrapper">
								<input required type="text" id="userName" name="userName" aria-label="姓名"
									placeholder="用户名（不小于3位）">
								<div id="userNamemsg"></div>
							</div>
							<div class="email input-wrapper">
								<input required type="email" class="account" id="email" name="email"
									aria-label="邮箱" placeholder="邮箱">
								<div id="emailmsg"></div>
							</div>
							<div class="input-wrapper">
								<input required type="password" id="password1" name="password" aria-label="密码"
									placeholder="密码（不少于 6 位）" autocomplete="off">
								<div id="pwd1msg"></div>
							</div>
                         <div class="input-wrapper">
						<div class="col-sm-6 input-wrapper">
							<input type="password" class="form-control" id="password2" name="repassword"
								placeholder="请再次输入密码">
							<div id="pwdmsg"></div>
						</div>
					</div>
						</div>
						<div class="button-wrapper command">
							<button class="sign-button submit" type="button" onclick="submitfun()">注册</button>
						</div>
					</form>
					<p class="agreement-tip">
						点击「注册」按钮即代表你同意<a href="agreement.jsp" target="_blank">《cilicili协议》</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<canvas id="canvas"
		style="position: absolute; left: 0px; top: 0px; z-index: -1;">
	</canvas>



	<!-- 登录动画 -->
	<script
		src="https://static.zhihu.com/static/revved/-/js/vendor.cb14a042.js"></script>
	<script
		src="https://static.zhihu.com/static/revved/-/js/closure/base.ecc1e150.js"></script>
	<script
		src="https://static.zhihu.com/static/revved/-/js/closure/page-index.352df081.js"></script>
	<meta name="entry" content="ZH.entrySignPage"
		data-module-id="page-index">

	<!-- 绘制背景 -->
	<script>
	var namecheck=0;
	var emailcheck=0;
	var pwdcheck1=0;
	var pwdcheck2=0;
		//定义画布宽高和生成点的个数
		var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;
		
		var canvas = document.getElementById('canvas');
		canvas.width = WIDTH,
		canvas.height = HEIGHT;
		var context = canvas.getContext('2d');
		context.strokeStyle = 'rgba(0,0,0,0.03)',
		context.strokeWidth = 1,
		context.fillStyle = 'rgba(0,0,0,0.1)';
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
			
			//验证用户名
			var nameElement = document.getElementById("userName");
			
			nameElement.onblur = function() {
				
					var name = this.value;//this等价于nameElement
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
								//alert(xhr.responseText);//得到响应结果
								var msg = document.getElementById("userNamemsg");
								if (xhr.responseText == "false") {
									msg.innerHTML = "<font color='red'>*用户名已存在</font>";
									namecheck=0;
								} else if (xhr.responseText == "true"){
									msg.innerHTML = "<font color='green'>*可以使用</font>";
									namecheck=1;
								} else if (xhr.responseText == "short"){
									msg.innerHTML = "<font color='red'>*用户名过短</font>";
									namecheck=0;
								} else if (xhr.responseText == "empty"){
									msg.innerHTML = "<font color='red'>*用户名不可为空</font>";
									namecheck=0;
								}
							}
						}
					}
					//创建连接
					xhr.open("get",
							"${pageContext.request.contextPath }/User/CheckName.do?name="+ name);
					//发送请求
					xhr.send(null);
				}
			
		//验证邮箱
			var emailElement = document.getElementById("email");
			emailElement.onblur = function() {
				
					var email = this.value;//this等价于emailElement
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
								var msg = document.getElementById("emailmsg");
								if (xhr.responseText == "false") {
									msg.innerHTML = "<font color='red'>*邮箱已存在</font>";
									emailcheck=0;
								} else if (xhr.responseText == "true")  {
									msg.innerHTML = "<font color='green'>*可以使用</font>";
									emailcheck=1;
								} else if (xhr.responseText == "format")  {
									msg.innerHTML = "<font color='red'>*邮箱格式错误</font>";
									emailcheck=0;
								} else if (xhr.responseText == "empty")  {
									msg.innerHTML = "<font color='red'>*邮箱不可为空</font>";
									emailcheck=0;
								} 
							}
						}
					}
					//创建连接
					xhr.open("get",
							"${pageContext.request.contextPath }/User/CheckMail.do?email="+ email);
					//发送请求
					xhr.send(null);
				}
			
			//验证密码长于6位
			var pwdElement = document.getElementById("password1");
			pwdElement.onblur = function(){
				
            	var password1=document.getElementById("password1");
				var pwd1msg=document.getElementById("pwd1msg");
				if(password1.value.length>=6){
					pwd1msg.innerHTML="<font color='green'>*密码长度合格</font>";
					pwdcheck1=1;
				} else {
					pwd1msg.innerHTML="<font color='red'>*密码过短</font>"
					pwdcheck1=0;
				}
			}
			
			//验证确认密码
			var pwdElement = document.getElementById("password2");
			pwdElement.onblur = function(){
            	var password1=document.getElementById("password1");
				var password2=document.getElementById("password2");
				var pwdmsg=document.getElementById("pwdmsg");
				if(password1.value==password2.value){
					pwdmsg.innerHTML="<font color='green'>*密码输入正确</font>";
					pwdcheck2=1;
				} else {
					pwdmsg.innerHTML="<font color='red'>*两次密码不一致请重新输入</font>"
					pwdcheck2=0;
				}
			}
		}
		
		function submitfun(){
			var resform = document.getElementById("resform");
			if(namecheck==1&&emailcheck==1&&pwdcheck1==1&&pwdcheck2==1){
				resform.submit();
			} else {
				alert("仍有错误项！");
			}
		}

	</script>
</body>
</html>
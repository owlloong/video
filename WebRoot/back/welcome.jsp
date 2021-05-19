<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎来到后台管理系统</title>
<style>
body {
	background: url('${pageContext.request.contextPath}/back/img/6.jpg') no-repeat;
	background-size: cover;
}

#Input {
	width: 250px;
}

#Mianban {
	height: 800px;
	width: 80%;
	margin: 0 auto;
}

#Biaoti {
	font-size: 35px;
	color: grey;
}

#logo {
	width: 20px;
	height: 20px;
	margin-left: 77.5%;
}

.Wenzi {
	float: right;
	padding-top: 15%;
	font-size: 25px;
}

.lll {
	margin: 0 auto;
	float: right;
	margin-right:10%;
	font-size: 15px;
}

.LLL {
	margin-left: 10%;
	float: left;
	margin-top:2%;
	font-size: 15px;
}
</style>

</head>
<body>
	<div id="background">
	
	</div>

	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div id="logo">
		<img src="${pageContext.request.contextPath}/back/img/logo.png" style="width: 300px; height: 120px;">
	</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div class="panel panel-default" id="Mianban">
		<div class="panel-heading">
			<h3 class="panel-title" id="Biaoti">欢迎来到cilicili后台管理系统</h3>
		</div>
		<div class="panel-body">
			<div>
				<img src="${pageContext.request.contextPath}/back/img/7.jpg"
					style="width: 380px; height: 180px; margin-left: 50px; margin-left: 50px;">
				<div class="Wenzi">
					
				</div>
				<div class="lll">
					<p>ciilcili后台管理系统是一个功能完备的管理系统</P>
					<p>我们始终秉承观点独到、全面深入、有料有趣的宗旨，</p>
					<p>在为人民服务与人文之间寻找开发新价值。</p>
					<p>坚持以人文的视角解读开发，用专业的精神剖析时代，</P>
					<p>孜孜不倦探索软件开发的未来。</p>
				</div>
			</div>
		</div>
		<div style="background-color:black;">
		<div class="LLL">
			    <p>关于我们的前台系统cilicili</p>
				<p>我们专注一件事，只做一件事：用视频与世界交流。</P>
				<p>后台管理系统是为了更好地管理我们的视频网站</p>
				<p>为管理员更好地了解网站各项指标提供了条件</p>
			</div>
			<div style="width:200px;height:100px;float:right;margin-right:10%;">
		<img src="${pageContext.request.contextPath}/back/img/pic.png"
				style="width: 360px; height: 160px; margin-left: 550px;float:right;margin-right:5%;">
		
			</div>
		</div>
	</div>

</body>
</html>
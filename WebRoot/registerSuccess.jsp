<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/font-awesome-4.7.0/css/font-awesome.min.css" />
<style type="text/css">
	#main{
		width: 400px;
        height: 200px;
        background: #FFEBCD;
		position:absolute;
        left:0;
        top: 0;
        bottom: 0;
        right: 0;
        margin: auto;
	}
</style>
</head>
<body>
	<div id="main">
		<h2>恭喜您注册成功，</h2>
		<h2>请赶快前往注册邮箱激活您的帐户</h2>
		<div>
			<div>
				<a href="http://mail.163.com/"> <i class="fa fa-skyatlas fa-fw"></i>
					网易163邮箱
				</a>
			</div>

			<div>
				<a href="https://mail.qq.com/cgi-bin/loginpage"> <i
					class="fa fa-tencent-weibo fa-fw"></i> 腾讯QQ邮箱
				</a>
			</div>

			<div>
				<a href="https://mail.sina.com/"> <i class="fa fa-weibo fa-fw"></i>
					新浪Sina邮箱
				</a>
			</div>
		</div>
	</div>
</body>
</html>
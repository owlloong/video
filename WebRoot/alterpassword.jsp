<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
      <meta charset="UTF-8">
      <title>修改密码</title>
     <link href="${ pageContext.request.contextPath }/css/password.css" rel="stylesheet" type="text/css">
</head>
<body>
     <div class="wapper">
	<%@ include file="header.jsp" %>

	<div class="password">
		<div class="pass_update"><span>修改密码</span></div>
		<div class="center">
			<div class="tishi"><span> 温馨提示：为了保护您的帐号安全，修改密码前请先进行安全验证。</span></div>
			<div class="center_top">
				<ul>
					<li class="top top1"><a href="#">设置新密码</a></li>
					<li class="top top2"><a href="#">密码修改成功</a></li>
				</ul>
			</div>
			<div class="main">
				<div class="pass pass_ok">
					<ul>
						<li><img src="images/gou.png" alt="对勾"></li>
						<li class="word_ok"><span class="update_ok">密码修改成功</span></li>
					</ul>						
				</div>
				<div class="pass pass_update">
					<form action="${ pageContext.request.contextPath }/User/AlterPassword.do" method="post" id="resform">
						<ul >
							<li class="mi" >原&nbsp;&nbsp;密 &nbsp; &nbsp;码：<input type="password" id="oldpwd" name="oldpwd"></li>
							 <div id="passwordmsg"></div>
							<li class="mi">新&nbsp; &nbsp;密 &nbsp; &nbsp;码：<input type="password" name="newpwd" id="newpwd1"></li>
							<div id="pwd1msg"></div>
							<li class="mi">确认新密码：<input type="password" name="confirm" id="newpwd2"></li>
							<div id="pwdmsg"></div>
							<li class="but"><button id="sub" type="button" statis-event="click" onclick="submitfun()"> 确认 </button></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="foot.jsp" %>
</div>

<script type="text/javascript">
function changeStatus(){
	var newpwd=document.getElementById("newpwd1");
	$.post(
			"${ pageContext.request.contextPath }/User/AlterPassword.do",
		{
			"newpwd":newpwd.value
		}, function(resText) {
			if(resText=="success"){
				$(".pass_ok").show();
				$(".pass_update").hide();
			} else if(resText=="empty"){
				alert("不可为空");
				$(".pass_update").show();
				$(".pass_ok").hide();
			} else {
				alert("修改失败");
				$(".pass_update").show();
				$(".pass_ok").hide();
			}
		});
}


    //验证旧密码
    var nameElement = document.getElementById("oldpwd");
	
    nameElement.onblur = function() {
		var pwd = this.value;//this等价于nameElement
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
					var msg = document.getElementById("passwordmsg");
					if (xhr.responseText == "false") {
						msg.innerHTML = "<font color='red'>*原密码输入不正确</font>";
						passwordcheck=0;
					} else if (xhr.responseText == "true") {
						msg.innerHTML = "<font color='green'>*原密码输入正确</font>";
						passwordcheck=1;
					} else if (xhr.responseText == "nolog") {
							msg.innerHTML = "<font color='red'>*请先登录</font>";
							passwordcheck=0;
						}
				}
			}
		};
		//创建连接
		xhr.open("get",
				"${pageContext.request.contextPath }/User/CheckPassword.do?password="+ pwd);
		//发送请求
		xhr.send(null);
	}
  //验证密码长于6位
	var pwdElement = document.getElementById("newpwd1");
	pwdElement.onblur = function(){
		
    	var newpwd1=document.getElementById("newpwd1");
		var pwd1msg=document.getElementById("pwd1msg");
		if(newpwd1.value.length>=6){
			pwd1msg.innerHTML="<font color='green'>*密码长度合格</font>";
			pwdcheck1=1;
		} else {
			pwd1msg.innerHTML="<font color='red'>*密码过短</font>"
			pwdcheck1=0;
		}
	}
    var pwdcheck2=0;
      //验证确认密码
			var pwdElement = document.getElementById("newpwd2");
			pwdElement.onblur = function(){
            	var newpwd1=document.getElementById("newpwd1");
				var newpwd2=document.getElementById("newpwd2");
				var pwdmsg=document.getElementById("pwdmsg");
				if(newpwd1.value==newpwd2.value&&newpwd1.value!=""){
					pwdmsg.innerHTML="<font color='green'>*两次密码一致 </font>";
					pwdcheck2=1;
				} else if(newpwd1.value==""||newpwd1.value==null){
					pwdmsg.innerHTML="";
					pwdcheck2=0;
				} else {
					pwdmsg.innerHTML="<font color='red'>*两次密码不一致请重新输入</font>"
					pwdcheck2=0;
				}
			}
		
		
		function submitfun(){
			if(passwordcheck==1&&pwdcheck1==1&&pwdcheck2==1){
				changeStatus();
			} else {
				alert("仍有错误项！");
			}
		}
		
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
	.table{
		margin:10px;
	}
	input{
		background-color: grey;
	}
	button{
		background-color: grey;
		border: grey;
	}
</style>

<body>
	<div style="margin: 10px;font-size: 20px;">
		<div class="photo" id="userphoto">
			<img alt="头像"
				src="${pageContext.request.contextPath}/cili_back/images/${userData.portraitSRC}">
				</span>
				<form action="${pageContext.request.contextPath}/User/chanePhoto.do" id="formaa" method="post" enctype="multipart/form-data">
					<input type="file" name="file" id="filess"/>
					<button onclick="asdssad()" >提交</button>
				</form> 
		</div>
		<div class="infor_name" id="userName">
			昵称：<span class="name">${user.userName }</span> <a
				href="javascript:editName()" style="color: #0F99D5;" id="editname_a">修改</a>
		</div>
		<div>&nbsp;&nbsp;</div>
		<div>
			<a href="javascript:editdata_btn()" style="color: #0F99D5;" id="editdata_a">修改个人信息</a>
		</div>
		<table class="table" id="pretable">
			<tr>
				<td>个性签名：</td>
				<td colspan="3">${userData.brief }</td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td>${user.email }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>性别：</td>
				<td>
					<c:choose>
						<c:when test="${userData.gender==1 }">男</c:when>
						<c:otherwise>女</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td>${userData.qq }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>生日：</td>
				<td>${userData.birthday }</td>
			</tr>
		</table>
		<form action="${pageContext.request.contextPath}/User/editUserData.do" method="post">
		<table class="table" id="edittable" style="display: none;">
			<tr>
				<td>个性签名：</td>
				<td colspan="3"><input type="text" name="brief" value="${userData.brief }"></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td>${user.email }</td>
				<td>性别：</td>
				<td>
					<c:choose>
						<c:when test="${userData.gender==1 }">
						<input type="radio" name="gender" value="1" checked="checked" />男
						<input type="radio" name="gender" value="2" />女
						</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>QQ：</td>
				<td><input type="text" name="qq" value="${userData.qq }"></td>
				<td>生日：</td>
				<td><input type="date" name="birthday" value="${userData.birthday }"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">提交</button></td>
				<td colspan="2"><button type="reset">重置</button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
<script type="text/javascript">
function asdssad() {
	if($("#filess".val()=='')){
		alert("不能为空");
		return false;
	}
	$.post("${pageContext.request.contextPath}/User/chanePhoto.do", {
		$("#formaa").serialize(),
	}, function(resText) {
		if (resText == "success") {
			alert("修改成功");
			reload();
		}
		else {
			alert("修改失败");
		}
	});
}
</script>
<script type="text/javascript">

	function editName() {
		var userNameArea = document.getElementById("userName");
		var a_editname = document.getElementById("editname_a");
		if (a_editname.innerHTML == "修改") {
			//新建结点
			//input
			var node_input = document.createElement("input");
			var attr_placeholder = document.createAttribute("placeholder");
			attr_placeholder.value = "修改昵称";
			var attr_type = document.createAttribute("type");
			attr_type.value = "text";
			var attr_id = document.createAttribute("id");
			attr_id.value = "name_input";
			node_input.setAttributeNode(attr_placeholder);
			node_input.setAttributeNode(attr_type);
			node_input.setAttributeNode(attr_id);
			//save_button
			var node_button = document.createElement("button");
			var text = document.createTextNode("保存");
			var attr_type = document.createAttribute("type");
			var attr_onclick = document.createAttribute("onclick");
			attr_type.value = "button";
			attr_onclick.value = "saveUserName()";
			node_button.setAttributeNode(attr_type);
			node_button.setAttributeNode(attr_onclick);
			node_button.appendChild(text);
			//将结点添加
			userNameArea.appendChild(node_input);
			userNameArea.appendChild(node_button);
			a_editname.innerHTML = "取消";
		} else if (a_editname.innerHTML == "取消") {
			a_editname.innerHTML = "修改";
			var childs = userNameArea.childNodes;
			for (var i = childs.length - 1; i > 3; i--) {
				userNameArea.removeChild(childs[i]);
			}
		}
	}

	
	
	function saveUserName() {
		var nameElement = document.getElementById("name_input");
		$.post("${pageContext.request.contextPath}/User/changeName.do", {
			"userName" : nameElement.value
		}, function(resText) {
			if (resText == "success") {
				alert("修改成功");
				reload();
			}
			if (resText == "notunique") {
				alert("昵称已存在");
			} else {
				alert("修改失败");
			}
		});
	}
	function editdata_btn(){
		var editbtn=document.getElementById("editdata_a");
		var pretable=document.getElementById("pretable");
		var edittable=document.getElementById("edittable");
		if(editbtn.innerHTML=="修改个人信息"){
			editbtn.innerHTML="取消";
			pretable.style.display="none";
			edittable.style.display="";
		} else if(editbtn.innerHTML=="取消"){
			editbtn.innerHTML="修改个人信息";
			pretable.style.display="";
			edittable.style.display="none";
		}
	}
</script>
<%-- <div class="r_user">
	<div class="dd">
		<ul class="r_boder">
			<li><div class="photo">
					<img alt="头像"
						src="${pageContext.request.contextPath}${userData.portraitSRC }">
				</div></li>
			<li>
				<ul class="r_people">
					<li style="padding-top: 5px;">
						<div class="infor_name">
							<span class="name">${user.userName }</span>
							<!-- <span class="uid">UID：34254546</span> -->
							<button id="update_name" statis-event="click">修改</button>
						</div>
						<div class="infor_jname">
							<form action="updateUserName" method="post">
								<span class="name">昵称：<input name="username" type="text"
									value="${user.userName }"></span>
								<!-- <span class="uid">UID：34254546</span> -->
								<button type="submit" id="cun" statis-event="click">保存</button>
							</form>
						</div>
					</li>
					<li class="r_shuo">
						<div id="infor_infor">
							<span class="shuo">个性签名：${userData.brief }</span>
							<button id="update_infor">编辑</button>
						</div>
						<div class="infor_info" id="infor_jinfor">
							个性签名：
							<form action="UpdateBrief" method="get">
								<input type="text" name="brief" value="${userData.brief }">
								<button type="submit" id="update_in">保存</button>
							</form>
						</div>
					</li>
				</ul>
			</li>
		</ul>
		<br />
		<br />
		<div class="infor" id="personal">
			<ul>
				<li>
					<div class="p" id="birth11">
						<span>生 日 ： ${userData.birthday }</span>
					</div>

				</li>
				<li>
					<div class="p" id="sex11">
						性别：
						<c:choose>
							<c:when test="${userData.gender==1 }">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose>
					</div>
					<div class="p p2" id="sex21">
						<span>性别 : <input type="radio" name="sex" value="男">男<input
							type="radio" name="sex" value="女">女
						</span>
					</div>
				</li>
				<li>
					<div class="p" id="QQ11">
						<span>Q &nbspQ : ${userData.qq }</span>
					</div>

				</li>
			</ul>
			<button type="button" id="update">修改基本信息</button>
		</div>
		<div class="infor infor_update" id="update_form">
			<form action="information" method="get">
				<ul>
					<li>
						<div class="p p2" id="birth21">
							<span>生 日 ： <input name="birthday" style="background-color:white" type="date"
								value=" ${userData.birthday }" /></span>
						</div>
					</li>
					<li>

						<div class="p p2" id="QQ21">
							<span>Q &nbspQ : <input name="qq" style="background-color:white" type="text"
								value="${userData.qq }"></span>
						</div>

					</li>
				</ul>
				<button type="submit" id="baocun">保存</button>
				<button type="button" id="update2">取消</button>
			</form>
		</div>

	</div>
</div>
<!-- <script type="text/javascript">
window.onload =function() { 
//这个是jquery代码 
var  data = "${requestScope.success}";

if(data="ok"){
	//alert("修改成功！");
}else if(data="none"){
	//alert("对不起修改失败！");
}else{
	
}

request.setAttribute("success", "dd");
data = "${requestScope.success}";
	alert(data);
};
//${requestScope.key}
</script> -->

<script type="text/javascript">
	$("#update").click(function() {
		$("#personal").hide();
		$("#update_form").show();
	});
	$("#update2").click(function() {
		$("#update_form").hide();
		$("#personal").show();
	});
	$("#update_name").click(function() {
		$(".infor_name").hide();
		$(".infor_jname").show();
	});
	$("#cun").click(function() {
		$(".infor_jname").hide();
		$(".infor_name").show();
	});
	$("#update_infor").click(function() {
		$("#infor_infor").hide();
		$("#infor_jinfor").show();
	});
	$("#update_in").click(function() {
		$("#infor_jinfor").hide();
		$("#infor_infor").show();
	});
</script> --%>
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>


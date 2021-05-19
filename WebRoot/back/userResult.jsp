<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Microsoft Yahei';
	font-size: 18px;
	background-color: #f8f8f8;
}

#table {
	width: 1200px;
	margin: 40px auto 0;
	border-collapse: collapse;
	background-color: #fff;
}

#table td, #table th {
	padding: 0.75em 1.5em;
}

#table thead {
	color: #fff;
	background-color: #74a8bb;
}

#table thead th {
	text-align: left;
}

#table tbody {
	
}

#table tbody tr {
	border-bottom: 2px dashed #000;
	cursor: default;
	transition: all .125s ease-in-out;
}

#table tbody tr:hover {
	background-color: rgba(94, 146, 166, .5);
}
</style>
</head>
<body style="height: 600px;overflow: auto;">
	<table id="table">
	<thead>
		<tr>
			<td>用户名</td>
			<td>邮箱</td>
			<td>角色</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${UserList}" var="ul">
				<tr>
					<td>${ul.userName}</td>
					<td>${ul.email }</td>
					<td><c:choose>
							<c:when test="${ul.roleId==1}">管理员</c:when>
							<c:when test="${ul.roleId==2}">注册用户</c:when>
							<c:otherwise>角色异常</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${ul.state==100 }">正常使用</c:when>
							<c:when test="${ul.state==101 }">等待激活</c:when>
							<c:when test="${ul.state==102 }">修改密码</c:when>
							<c:when test="${ul.state==103 }">已被冻结</c:when>
							<c:otherwise>状态异常</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${ul.state==103 }">
								<a href="javascript:frozeUser('${ul.userId }',1)">解冻</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:frozeUser('${ul.userId }',0)">冻结</a>
							</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${ul.roleId==1}">
								<a href="javascript:changeRoleId('${ul.userId }',0)">降级</a>
							</c:when>
							<c:when test="${ul.roleId==2}">
								<a href="javascript:changeRoleId('${ul.userId }',1)">升级</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:changeRoleId('${ul.userId }',0)">降级</a>
								<a href="javascript:changeRoleId('${ul.userId }',1)">升级</a>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		window.onload = function() {
			doubleBgColor(document.getElementById("table"), "#f8fbfc",
					"#e5f1f4");
		}
		function doubleBgColor(Table, Bg1, Bg2) {
			for (var i = 1; i < Table.rows.length; i++)
				Table.rows[i].bgColor = i % 2 ? Bg2 : Bg1;
		}
	</script>

</body>
</html>
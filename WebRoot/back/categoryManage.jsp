<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	.newCate{
		margin: 10px;
		background-color: #3C3C3C;
		color: white;
	}
	.delCate{
		margin: 10px;
		background-color: #3C3C3C;
		color: white;
	}
	.searchBar{
		margin:10px;
	}
</style>
</head>
<body>
	<input class="searchBar" type="text" id="categoryName" placeholder="输入新的分类名称"><br>
	
	<c:forEach items="${CateList }" var="cl">
		<div>
			${cl.categoryName }
			<button class="newCate" type="button" onclick="newCategory(${cl.categoryId})"><i class="fa fa-plus fa-fw"></i>新增子分类</button>
		</div>
		<c:forEach
			items="${cl.subCategory }" var="scl">
				<span class="subCategory">
					${scl.categoryName }
					<button class="delCate" onclick="deleteCategory(${scl.categoryId})">
						<i class="fa fa-plus fa-fw"></i>删除分类
					</button>
				</span>
		</c:forEach>
	</c:forEach>
</body>
</html>
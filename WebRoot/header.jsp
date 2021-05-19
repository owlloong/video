<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<title>header</title>
 
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/css/global.css"/>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/myJS.js"></script>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/font-awesome-4.7.0/css/font-awesome.min.css"/>
	<link rel="shortcut icon" href="${ pageContext.request.contextPath }/img/favicon.ico" type="image/x-icon" />
</head>

<div class="wrapper"> 
        <div class="head">
          <div class="head-main clearfix">
            <div class="logo">
              <img src="${ pageContext.request.contextPath }/img/logo.png" alt="">
            </div> 
            <!-- logo结束 -->  
            <!-- 导航栏开始 -->         
            <div class="menuDiv">            
              <ul class="menu clearfix">
                <li>
                  <a href="${ pageContext.request.contextPath }/Category/Index.do">
                   		 首页
                  </a>
                </li>
                <c:forEach items="${CategoryList}" var="categoryHeader">
                <li>
                  <a href="${pageContext.request.contextPath}/Category/CategoryList.do?categoryId=${categoryHeader.categoryId}">
                  		${categoryHeader.categoryName}
                  </a>
                </li>
                </c:forEach>
              </ul>
              </div>
              <!-- 搜索框 -->
              
                            
             <div class="sousuo">
              	<div class="text">
              		<!-- <input type="text" name="" id="select"><a href="#"> 搜索</a> -->
              		
              		<form action="${pageContext.request.contextPath}/Video/HeadSearchVideo.do" method="post">
              			<input type="hidden" name="pageNum" value="1"/>
						<input id="select" type="text" name="keyword" autocomplete="off"
							   placeholder="搜索"/>
			
				<button type="submit" statis-event="click" statis-value="ZDH_Search_button"></button>
			</form>
              		
          
              	</div>
              	<div id="msg" class="smsg">
              		<div class="msg_infor">
              			<ul>
              				<li><a href="#">1.小猪佩奇</a></li>
              				<li><a href="#">2.黑科技</a></li>
              				<li><a href="#">3.养猫日常</a></li>
              				<li><a href="#">4.爆笑虫子</a></li>
              				<li><a href="#">5.飞驰人生</a></li>
              				<li><a href="#">6.动物剪纸教程</a></li>
              				<li><a href="#">7.百变布鲁可</a></li>
              			</ul>
              		</div>
              	</div>
              </div>
              <c:choose>
              <c:when test="${sessionScope.user==null }">
              <!-- 连入注册登录信息，登陆后隐藏显示用户名 -->
              	<div class="login">
		              <ul>
		              		<li class="ce"><a href="${ pageContext.request.contextPath }/register.jsp">注册</a></li>
		              		<li class="shu"><a><span style="padding-left:5px;padding-right: 5px;">|</span></a></li>
		              		<li class="deng"><a href="${ pageContext.request.contextPath }/login.jsp">登录</a></li>
		              </ul>
              </div>
              </c:when>
              <c:otherwise>
              <!-- 先隐藏，登陆后显示用户名并连入个人中心 -->
             	 <div class="us">
	              <div class="us_infor" id="user">
	              	 <div class="us_name"><a href="#">${sessionScope.user.userName }</a></div>
	              	<div class="us_logo"><a href="#"><span></span></a></div>
	              </div>
	              <div id="msg1" class="smsg1">
	              		<div class="msg1_span"><span></span></div>
	              		<div class="msg1_ren">
	              		<ul>
	              			<li>
		              			<div class="msg1_photo">
		              				<div><a href="images/person.png"><a href="${ pageContext.request.contextPath }/User/ListUserData.do"><span>${sessionScope.user.userName }</span></a></div>
		              			</div>
	              			</li>
	              			<li>
	              				<div class="msg1_password">
	              				<i class="fa fa-cog fa-fw"></i>
	              				<a href="${ pageContext.request.contextPath }/alterpassword.jsp" onclick="showPassword(200,100)">修改密码</a></div>
	              			</li>
	              			<li>
	              				<div class="msg1_user">
	              				<i class="fa fa-user fa-fw"></i><a href="${ pageContext.request.contextPath }/User/ListUserData.do">个人中心</a>
	              				</div>
	              			</li>
	              			<c:if test="${sessionScope.user.role.roleId==1 }">
	              			<li>
	              				<div class="msg1_user">
	              				<i class="fa fa-reorder fa-fw"></i>
	              				<a href="${ pageContext.request.contextPath }/back/index.jsp" target="_blank">后台管理</a>
	              				</div>
	              			</li>
	              			</c:if>
	              			<li><div class="msg1_over"><button onclick="location.href='${ pageContext.request.contextPath }/User/LogOut.do'" type="button">注销</button></div></li>
	              		</ul>
	              		</div>
	              </div>
              </div>
              </c:otherwise>
              </c:choose>
          </div>
        </div>
     </div>

     
<div id="tan_password"><div>您好！修改密码所需要的链接已发送到您的邮箱，请前往查看！</div>
 <button onclick="closetan()">确定</button></div>  
 <script  type="text/javascript">
 function showPassword(w,h){ 
     var popUp = document.getElementById("tan_password"); 
     popUp.style.top = "200px"; 
     popUp.style.left = "600px"; 
     popUp.style.width = w + "px"; 
     popUp.style.height = h + "px";  
     popUp.style.visibility = "visible"; 
     }
 function closetan(){ 
	    var popUp = document.getElementById("tan_password"); 
	    popUp.style.visibility = "hidden"; 
	   }
 </script>
 <script type="text/javascript">

 $(document).ready(function(){
	  $("#select").bind("click",function(){$("#msg").slideToggle();
	});
});
 $(document).ready(function(){
	  $("#user").bind("click",function(){$("#msg1").slideToggle();
	});
});
		</script> 
     <script src="js/jquery-1.11.0.js"></script>
    <script src="js/jquery.min.js"></script>   
   <!--  <script src="js/gloabl.js"></script> -->
    
    
    
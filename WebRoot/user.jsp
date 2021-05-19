<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

 <meta charset="utf-8">
<title>个人中心</title>

<link href="${ pageContext.request.contextPath }/css/index_style.css" rel="stylesheet" type="text/css">
<script src="${ pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<!-- 
<link rel="stylesheet" type="text/css" href="css/bomb_default.css" />
		<link rel="stylesheet" type="text/css" href="css/bomb_component.css" /> -->

	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/myJS.js"></script>
	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</head>
<body>
<!-----HEADER STAR----->
  <div class="nav" id="main"> 
    	<div id="header"><jsp:include page="header.jsp"></jsp:include> </div>  	
    		<div class="wapper">
		    	<ul class="menu2">
		    		<li class="menu2_left">
			    		<div class="left">
			    		<ul>
			    			<li><img alt="头像" src="${pageContext.request.contextPath}/cili_back/images/${userData.portraitSRC}"></li>
			    			<li><a id="showpeople" class="gv">个人基本信息</a></li>
			    			<li><a class="gv" id="showupload">我的上传</a></li>
			    			<li><a class="gv" id="showdown">我的下载</a></li>		    			
			    			<li><a class="gv" id="showzhu">我的关注</a></li>
			    		</ul>
			    		</div>
		    		</li>
		    		<li class="menu2_right" >
			    		<div class="right">
			    			<div id="show1"><jsp:include page="user/information.jsp"></jsp:include></div>
			    			<div id="show2"><jsp:include page="user/upload.jsp"></jsp:include></div>
			    			<div id="show3"><jsp:include page="user/down.jsp"></jsp:include></div>
			    			<div id="show4"><jsp:include page="user/guanzhu.jsp"></jsp:include></div>
			    		</div>
		    		</li>
		    	</ul>
    		</div>
    		<div id="foot"><jsp:include page="foot.jsp"></jsp:include>  </div>     		
	</div>








<!-- 上传弹出窗口 -->
<div id="popupcontent">
	<div class="p_title">这里在上传视频</div>
	<div class="p_center">
		<form method="post" enctype="multipart/form-data" action="">
			<div class="p_infor">
				<div class="p_file"><a href="javascript:;" class="file"><div>封<br><br>面</div>
		    	<input type="file" name="" id=""></a>
				</div>
			<div class="p_infor_infor">
				<ul>
					<li>视 &nbsp 频 &nbsp 名 ： <input type="text"></li>
					<li>视 频 类 型 ： <select>
							<option class="option">请选择</option>
							<option class="option">游戏</option>
							<option class="option">游戏</option>
							<option class="option">游戏</option>
							<option class="option">娱乐</option>
							<option class="option">娱乐</option>
							</select></li>
					<li class="pin_file">上 传 视 频 ： <a class="vodio_file">点击上传视频<input type="file"></a></li>
					<li>视 频 描 述 ： <input type="text"></li>
				</ul>
			</div>
			<!-- <table>
				<tr class="p_tr">
					<td>视频名：<input type="text"></td>
				</tr>
				<tr class="p_tr">
					<td>视频类型：<select>
						<option>请选择</option>
						<option>游戏</option>
						<option>游戏</option>
						<option>游戏</option>
						<option>娱乐</option>
						<option>娱乐</option>
						</select>
					</td>
				</tr>
				<tr class="p_tr">
					<td><input type="file"></td>
				</tr>
				<tr class="p_tr p_tr_infor">
					<td>视频描述：<input type="text"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table> -->
			
	
			</div>
			<div class="p_button">
				<button type="submit"  onclick="hidePopup()">提交</button><button type="button"  statis-event="click" onclick="hidePopup()">取消</button>
			</div>
		</form>
	</div>
</div>

<!-----HEADER END----->
<!-- 链接 -->
<script type="text/javascript">
$("#showpeople").click(function(){
	$("#show2").hide();
	$("#show3").hide();
	$("#show4").hide();
    $("#show1").show();
});
$("#showupload").click(function(){
	$("#show1").hide();
	$("#show3").hide();
	$("#show4").hide();
    $("#show2").show();
});
$("#showdown").click(function(){
	$("#show2").hide();
	$("#show1").hide();
	$("#show4").hide();
    $("#show3").show();
});
$("#showzhu").click(function(){
	$("#show2").hide();
	$("#show3").hide();
	$("#show1").hide();
    $("#show4").show();
});

</script>

<!-- <script src="js/bomb_classie.js"></script>
		<script src="js/bomb_modalEffects.js"></script>
		<script>
			var polyfilter_scriptpath = '/js/';
		</script> -->
</body>
</html>
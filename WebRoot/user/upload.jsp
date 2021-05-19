<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
.uploadname{
color:#6495ED;
}
</style>
<div class="upload">
		<div class="up">
			<span class="ss">我的上传</span><br>
			<hr width="84%" color=#0099E1 SIZE=1>
		</div>
		<div class="upload_infor">
		<div class="up_add">
			
						<a href="${ pageContext.request.contextPath }/JSP/Upload.jsp" style="color:white;">上传</a>
					</div>
			</div>
			<div  style="height: 600px;overflow: auto;">
			<c:forEach items="${PersonalVList }" var="pvl">
			<div class="up_xi" style="border-color: white;border: 1px;">
				<ul class="menu1">
					<li class="menu_fen">
						<div class="fen">
						<a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${pvl.videoId}">
							<img alt="封面" src="/cili_back/images${pvl.videoSRC }" width="100px" height="50px">
							</a>
						</div>
					</li>
					<li>
						<span class="up_sname">
						<a href="${ pageContext.request.contextPath }/Video/VideoPage.do?videoId=${pvl.videoId}" class="uploadname">
						${pvl.videoName }
						</a>
						<a href="${ pageContext.request.contextPath }/JSP/picUpload.jsp
						?videoId=${pvl.videoId}&videoURL=${pvl.videoURL}&videoSRC=${pvl.videoSRC}
						" target="_blank" style="color: #FFA042">编辑视频</a>
						<a href="javascript:delVideo(${pvl.videoId })" style="color: #FFA042">删除视频</a>
						</span>
					</li>
					<li>
						<span class="time">${pvl.videoTime } ${pvl.category.categoryName }</span>
					</li>
					<li>
						<span class="time">
						<c:choose>
							<c:when test="${pvl.status==200 }">已发布</c:when>
							<c:when test="${pvl.status==201 }">上传中</c:when>
							<c:when test="${pvl.status==202 }">待审核</c:when>
							<c:when test="${pvl.status==203 }">已删除</c:when>
						</c:choose>
						</span>
					</li>
				</ul>
			
			</div>
			</c:forEach>
			</div>
		</div>
<script type="text/javascript">

function delVideo(videoId){
	$.post(
		"${ pageContext.request.contextPath }/Video/ChangeState.do",
		{
			"videoId":videoId,
				"state":203
		}, function(resText) {
			if(resText=="success"){
				alert("操作成功");
				searchVideo();
			} else {
				alert("操作失败");
			}
		});
}
 
function showPopup(w,h){  /* setTimeout(function(){
	    //选择document.body下所有非.shade class的第一级元素
	    var others = document.querySelectorAll('body > *:not( .dialog)'); 
	    //遍历nodeList, 如果该元素不是script, 则给该元素添加滤镜
	    [].forEach.call(others, function(elem){
	        if(elem.nodeName != 'SCRIPT'){
	            elem.style.webkitFilter = 'blur(6px)'; 
	        }
	    })
	}, 50);  */
	var popUp = document.getElementById("popupcontent"); 
	popUp.style.top = "160px"; 
	popUp.style.left = "400px"; 
	popUp.style.width = w + "px"; 
	popUp.style.height = h + "px"; 
	popUp.style.visibility = "visible"; 
	
	document.getElementById("main").style.webkitFilter = 'blur(6px)';
	document.getElementById("header").style.webkitFilter = 'blur(6px)';
	document.getElementById("foot").style.webkitFilter = 'blur(6px)';
}
function hidePopup(){ 
    var popUp = document.getElementById("popupcontent"); 
    popUp.style.visibility = "hidden"; 
    document.getElementById("main").style.webkitFilter = 'blur(0)';
	document.getElementById("header").style.webkitFilter = 'blur(0)';
	document.getElementById("foot").style.webkitFilter = 'blur(0)';
    }
    
$(document).ready(function(){
	//弹出窗口的拖动
	var bool=false;
	var offsetX=0;
	var offsetY=0;
	$(".p_title").mousedown(function(){
		bool=true;
		offsetX = event.offsetX;
		offsetY = event.offsetY;
		})
		 $(document).mousemove(function(e){
		  if(!bool) return;
		  var x = event.clientX-offsetX;
		  var y = event.clientY-offsetY;
		  $("#popupcontent").css("left", x);
		  $("#popupcontent").css("top", y);
		  })
		  .mouseup(function(){
		  bool=false;
		  })
	});
</script>
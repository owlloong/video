<%@ page language="java" import ="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
    	String path = request.getContextPath();
    	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/Upload.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="../css/normalize.css" />
<link rel="stylesheet" type="text/css" href="../css/demo.css" />
<link rel="stylesheet" type="text/css" href="../css/component.css" />
<link rel="stylesheet" href="../css/combo.select.css">
<link rel="stylesheet" type="text/css" href="../css/progress.css">
<script type="text/javascript" src="../js/ul.js" charset="utf-8"></script>
<title>CiliCili上传视频</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="Cilicili上传视频">
<!-- 美化上传文件框 -->
<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
<script type="text/javascript">
function test(){
    var filePath = document.getElementById("uploadFile").value;
    var file =$('#uploadFile').get(0).files[0];
    var fileLx = filePath.toString().substring(filePath.toString().lastIndexOf(".")+1) ;
    if(fileLx == "avi" || fileLx == "rmvb"|| fileLx == "mpg"|| fileLx == "mpeg"|| fileLx == "qt"|| fileLx == "rm"|| fileLx == "asf"|| fileLx == "divx"|| fileLx == "mpg"|| fileLx == "mpeg"|| fileLx == "mpe"|| fileLx == "wmv"|| fileLx == "mp4"|| fileLx == "mkv"|| fileLx == "vob"|| fileLx == "flv")
    {
    	if(file.size>1024*1024*1024){
        	alert("视频太大了！最大可传1G的视频！");
        	document.getElementById("uploadFile").value="";
        }
    	document.getElementById("btn").disabled=false;
     return true ;
    }
    else
    {
     alert("只支持视频文件的上传！");
     document.getElementById("btn").disabled=true; 
     document.getElementById("uploadFile").value="";
     return false ;
    }
    
}
</script>
<script type="text/javascript">
function check(){

	var title=document.getElementById("title").value;
	var vcategory=document.getElementById("vcategory").value;
	var descript=document.getElementById("descript").value;
	if(title.length==0||vcategory.length==0||descript.length==0){
	   if(title.length==0){
	            alert('视频名称不能为空!');
				document.upload.title.focus(); 
		 
	                }
	
	   else if(vcategory.length==0){
           		alert('视频不能没有标签!');
				document.upload.vcategory.focus(); 
           }
	   else if(descript.length==0){
          		 alert('视频描述不能为空!');
				document.upload.descript.focus(); 
           }  
            }else{
            	document.getElementById("id").style.display="block";
            	alter("啊啊啊");
            	return true;
            }
}
</script>   
<style>
.btn{
            -webkit-appearance: none;
            background: #009dff;
            border: none;
            border-radius: 2px;
            color: #fff;
            cursor: pointer;
            height: 50px;
            font-family: 'Open Sans', sans-serif;
            font-size: 1.2em;
            letter-spacing: 0.05em;
            text-align: center;
            text-transform: uppercase;
            transition: background 0.3s ease-in-out;
            width: 400px;
        }
        .btn:hover {

            background: #00c8ff;
        }</style>
</head>
<body>
	<div class="all">
	<div data-role="header" class="header"></div>
	
		<div data-role="body" class="body" >
		<div class="body-left"><img src="../img/timg (1).jpg" width=100% height=100% class="leftImg"> </div>
		<div class="body-medium" background-image="../img/timg (3).jpg">
		<div class="form">
		<form class="form-horizontal" id="upload" name="upload" method="post" action="${pageContext.request.contextPath }/Up/upload.do" enctype="multipart/form-data">
		<div class="file"><div class="file1"><font color=white >视频上传:</font></div>
		<div class="file2"><!-- <input type="file" class = "uploadFile" name="uploadFile" id="uploadFile" onchange="test()"> -->
		<!-- 美化上传文件框框 -->
		<div class="content"><div class="box">
					<input type="file" name="uploadFile" id="uploadFile" class="inputfile inputfile-1" data-multiple-caption="{count} files selected"   onchange="test()"/>
					<label for="uploadFile"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>选取视频&hellip;</span></label>
				</div>
				<script src="../js/custom-file-input.js"></script>
			</div>
		</div></div>
		<div class="loading" id="id" style="display:none;" ><img src="../img/loading3.gif" width=100px htight=100px  name="img" ></div>
		<div class="name"><div class="name1"><font color=white >视频名称:</font></div>
		<div class="name2"><input type="text" class="title" name="title" id ="title"  /></div></div>
		<div class="category"><div class="category1"><font color=white >视频标签:</font></div>
		<div class="category2">
		<select name="vcategory" id="vcategory">
		<option value="">视频标签</option>
		<c:forEach items="${CategoryList}" var="catelist">
			<optgroup label="${catelist.categoryName }">
				<option value="${catelist.categoryId }">${catelist.categoryName }</option>
				<c:forEach items="${catelist.subCategory }" var="scl">
					<option value="${scl.categoryId }">${scl.categoryName }</option>
				</c:forEach>
			</optgroup>
		</c:forEach>
	</select>
	
		</div></div>
		<script src="../js/jquery-1.11.3.min.js"></script>
		<script src="../js/jquery.combo.select.js"></script>
		<script>
		$(function() {
				$('select').comboSelect()
			});
		</script>
		<div class="description"><div class="description1"><font color=white >视频描述:</font></div>
		<!-- <input type="text" class="descript" name="descript" size="100"><br> -->
		<div class="description2"><textarea class="descript" name="descript" id="descript" style="resize:none;height:100px;" placeholder="有趣的动态描述，会增加被小编捕捉为热门动态的机会哟 (=ﾟωﾟ)ﾉ" maxlength="233"></textarea></div></div>
			<input type="submit" class="btn"value="上传" id="btn" onclick="check();return false;">
		</form></div></div>
		<div class="body-right"> <img src="../img//timg (2).jpg" width=100% height=100% class="rightImg"> </div></div>

</div>
</body>
</html>
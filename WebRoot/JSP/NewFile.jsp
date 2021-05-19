<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <title>input框的focus美化效果</title>
   
   <style type="text/css">
        #progressBar{width: 300px;height: 20px;border: 1px #EEE solid;}
        #progress{width: 0%;height: 20px;background-color: lime;}
    </style>
    <script src="../js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
        function upload(){
            $("#f1").submit();
            var pro=null;
            pro=setInterval(function(){
                $.get("${pageContext.request.contextPath }/Upload.do","",function(data){
                    if(data=='100%'){
                        clearInterval(pro);
                        $("#proInfo").text("上传进度：100%");
                         //更新进度条
                        $("#progress").width("100%");
                    }else{//正在上传
                        //更新进度信息
                        $("#proInfo").text("上传进度："+data);
                        //更新进度条
                        $("#progress").width(data);
                    }
                });
            },200);
        }
        
    </script>
  </head>
  
  <body>
      <iframe name="aa" style="display: none;"></iframe>
    <h2>带进度条的文件上传效果</h2>
    <form target="aa" id="f1" action="${pageContext.request.contextPath }/Upload.do" method="post" enctype="multipart/form-data">
        文件：<input name="file" type="file">
        <input type="button" value="上传" onclick="upload();">
        <div id="progressBar">
            <div id="progress"></div>
        </div>
        <span id="proInfo">上传进度：0%</span>
    </form>
  </body>
</html>
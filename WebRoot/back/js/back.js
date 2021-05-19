function navButton(btnnum){
		//取消之前的active
		var btns=document.getElementsByClassName("navbtn");
		for(i=0;i<btns.length;i++){
			btns[i].classList.remove("active");
		}
		//当前变为active
		btns[btnnum].classList.add("active");
		//main页面跳转
		var main=document.getElementById("main");
		
		
		if(btnnum==0){
			$("#main").load(
				projectLog+"/back/welcome.jsp",
				{
				}, function() {
				});
		} 
		if(btnnum==1){
			$("#main").load(
				projectLog+"/back/userSearch.jsp",
				{
				}, function() {
				});
		} 
		if(btnnum==2){
			reloadVerify();
		} 
		if(btnnum==3){
			$("#main").load(
				projectLog+"/back/videoManage.jsp",
				{
				}, function() {
				});
		} 
		if(btnnum==4){
			reloadCategory();
		}
		if(btnnum==5){
			$("#main").load(
				projectLog+"/back/pieChart.jsp",
				{
				}, function() {
				});
		}
		if(btnnum==6){
			$("#main").load(
				projectLog+"/Video/GetBarChart.do",
				{
				}, function() {
				});
		}
		if(btnnum==7){
			$("#main").load(
					projectLog+"/Comment/GetallComment.do?pageNum=1",
					{
					}, function() {
					});
			}
		
	}

window.onload= function(){
	$("#main").load(
		projectLog+"/back/welcome.jsp",
		{
		}, function() {
		});
}


var logUserName;
function toLayout(logName){
	var logUser=document.getElementById("logUser");
	logUserName=logName;
	logUser.innerHTML="注销";
}
function LayoutOff(){
	var logUser=document.getElementById("logUser");
	logUser.innerHTML=logUserName;
}

function searchUser(){
	var input_userName=document.getElementById("userName");
	var value=input_userName.value;
	$("#searchResult").load(
			projectLog+"/User/SearchUser.do",
			{
				"userName":value
			}, function() {
			});
}

function frozeUser(userId,type){
	$.post(
			projectLog+"/User/FrozeUser.do",
			{
				"userId":userId,
				"type":type
			}, function(resText) {
				if(resText=="success"){
					alert("操作成功");
					searchUser();
				} else {
					alert("操作失败");
				}
			});
}

function changeRoleId(userId,type){
	$.post(
			projectLog+"/User/ChangeRole.do",
			{
				"userId":userId,
				"type":type
			}, function(resText) {
				if(resText=="success"){
					alert("操作成功");
					searchUser();
				} else {
					alert("操作失败");
				}
			});
}

function reloadVerify(){
	$("#main").load(
		projectLog+"/Video/GetVideoByState.do?state=202",
		{
		}, function() {
		});
}

function acceptVideo(videoId){
	$.post(
		projectLog+"/Video/ChangeState.do",
		{
			"videoId":videoId,
			"state":200
		}, function(resText) {
			if(resText=="success"){
				alert("操作成功");
				reloadVerify();
			} else {
				alert("操作失败");
			}
		});
}

function denyVideo(videoId){
	$.post(
		projectLog+"/Video/ChangeState.do",
		{
			"videoId":videoId,
			"state":203
		}, function(resText) {
			if(resText=="success"){
				alert("操作成功");
				reloadVerify();
			} else {
				alert("操作失败");
			}
		});
}

function searchVideo(){
	var input_videoName=document.getElementById("videoName");
	var value=input_videoName.value;
	$("#searchResult").load(
		projectLog+"/Video/SearchVideo.do",
		{
			"videoName":value
		}, function() {
		});
}

function deleteVideo(videoId){
	$.post(
		projectLog+"/Video/ChangeState.do",
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

function recoverVideo(videoId){
	$.post(
		projectLog+"/Video/ChangeState.do",
		{
			"videoId":videoId,
			"state":200
		}, function(resText) {
			if(resText=="success"){
				alert("操作成功");
				searchVideo();
			} else {
				alert("操作失败");
			}
		});
}

function reloadCategory(){
	$("#main").load(
		projectLog+"/Category/ManageCategory.do",
		{
		}, function() {
		});
}

function newCategory(parentId){
	var input_text=document.getElementById("categoryName");
	if(input_text.value==""){
		alert("分类名不能为空");
	} else {
		$.post(
		projectLog+"/Category/NewCategory.do",
		{
			"categoryName":input_text.value,
			"parentId":parentId
		}, function(resText) {
			if(resText=="success"){
				alert("操作成功");
				reloadCategory();
			} else {
				alert("操作失败");
			}
		});
	}
}

function deleteCategory(categoryId){
	$.post(
		projectLog+"/Category/DeleteCategory.do",
		{
			"categoryId":categoryId
		}, function(resText) {
			if(resText=="notempty"){
				alert("分类非空");
			} else if(resText=="failure") {
				alert("删除失败");
			} else if(resText=="success") {
				alert("删除成功");
				reloadCategory();
			}
		});
}
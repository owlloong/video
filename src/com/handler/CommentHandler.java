package com.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.Category;
import com.po.Comment;
import com.po.User;
import com.po.Video;
import com.service.CategoryService;
import com.service.CommentService;
import com.service.VideoService;

@Controller
@RequestMapping("/Comment")
public class CommentHandler {

	@Autowired
	private VideoService videoService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;
	
	//@Autowired 
	//private TuijianService tuijianService;
	
	
	@RequestMapping("/deleteCommCount")
	@ResponseBody
	public String deleteCommCount(String commentId,
			HttpSession session,Model model) throws Exception {
		int result=commentService.deleteSubCommCount(commentId);
		if(result>0) {
			return "success";
		} 
			 else {
				return "failure";
			}
		
	}
	
	@RequestMapping("/GetComment")
	public String GetComment(String videoId,String pageNum,
			HttpSession session,Model model) throws Exception {
		List<Comment> list=commentService.getVideoComment(videoId, Integer.parseInt(pageNum));
		//获取评论总页数
		int totalComments=commentService.countVideoComment(videoId);
		int totalPage=totalComments%6==0?totalComments/6:totalComments/6+1;
		session.setAttribute("commList", list);
		session.setAttribute("totalPage", totalPage);
		
		return "/comment";
	}
	@RequestMapping("/GetallComment")
	public String GetallComment(String pageNum,
			HttpSession session,Model model) throws Exception {
		if(Integer.parseInt(pageNum)<1){
			pageNum="1";
		}
		List<Comment> alllist=commentService.getAllComm();
		//获取评论总页数
		int totalComments=alllist.size();
		int totalPage=totalComments%6==0?totalComments/6:totalComments/6+1;
		if(Integer.parseInt(pageNum)>totalPage){
			pageNum=String.valueOf(totalPage);
		}
		List<Comment> list=commentService.getAllComm(Integer.parseInt(pageNum));
		
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("commList", list);
		session.setAttribute("totalPage", totalPage);
		
		return "/back/comment";
	}
	@RequestMapping("/GetSubComment")
	public String GetSubComment(String parentId,String pageNum,
			HttpSession session,Model model) throws Exception {
		List<Comment> list=commentService.getVideoComment(parentId, Integer.parseInt(pageNum));
		int totalComments=commentService.countVideoComment(parentId);
		int totalPage=totalComments%6==0?totalComments/6:totalComments/6+1;
		session.setAttribute("parentId", parentId);
		session.setAttribute("commList", list);
		session.setAttribute("totalPage", totalPage);
		return "/SecComment";
	}
	
	@RequestMapping("/PostComment")
	public String PostComment(String videoId,String parentId,String comment,
			HttpSession session,Model model) throws Exception {
		
		
		User user=(User) session.getAttribute("user");
		String userId=(user.getUserId()).toString();
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
		String datetime=sdf.format(dt);
		commentService.sendComment(userId, parentId, comment, datetime);
		
		//向推荐表添加信息
		//tuijianService.addTuijian(userId, videoId, parentId, 1);
		
		return "forward:GetComment.do?videoId="+videoId+"&pageNum=1";
	}
	
}

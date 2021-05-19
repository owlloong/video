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
@RequestMapping("/Video")
public class VideoHandler {

	@Autowired
	private VideoService videoService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	
	/*@RequestMapping("/GetComment")
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
	*/
	
	@RequestMapping("/GetVideoByState")
	public String GetVideoByState(String state,
			HttpSession session,Model model) throws Exception {
		int states=Integer.parseInt(state);
		List list=videoService.GetVideoByState(states);
		model.addAttribute("VideoList", list);
		return "/back/videoVerify";
	}
	@RequestMapping("/SearchVideo")
	public String SearchVideo(String videoName,
			HttpSession session,Model model) throws Exception {
		
		List list=videoService.getVideosByName(videoName);
		model.addAttribute("VideoList", list);
		return "/back/videoResult";
	}
	@RequestMapping("/JumpSearchPage")
	public String JumpSearchPage(String keyword,
			HttpSession session,Model model) throws Exception {
		
		int totalCount=videoService.countSearchResult(keyword);
		int totalpage=totalCount%6==0?totalCount/6:totalCount/6+1;
		model.addAttribute("totalPage", totalpage);
		model.addAttribute("keyword", keyword);
		return "/search";
	}
	@RequestMapping("/HeadSearchVideo")
	public String HeadSearchVideo(String keyword,
			HttpSession session,Model model) throws Exception {
		
		String pageNum="1";
		List<Video> searchlist=videoService.searchVideo(keyword, Integer.parseInt(pageNum));

		model.addAttribute("VideoList", searchlist);
		return "/search";
	}
	@RequestMapping("/GetBarChart")
	public String GetBarChart(String keyword,
			HttpSession session,Model model) throws Exception {
		
		List hotVideoList=null;
		hotVideoList=videoService.GetHotVideos();
		model.addAttribute("HotVideoCount", hotVideoList);
		return "/back/barChart";
	}
	
	
	@RequestMapping("/VideoPage")
	public String VideoPage(String videoId,
			HttpSession session,Model model) throws Exception {
		
		Video video=videoService.GetVideoById(videoId);
		//增加videocount
		videoService.countPlus(videoId);
		//System.out.println("id"+video.getVideoId()+",name"+video.getVideoName());
		//获得总页数
		int totalComments=commentService.countVideoComment(videoId);
		int totalPage=totalComments%6==0?totalComments/6:totalComments/6+1;
		model.addAttribute("video", video);
		model.addAttribute("totalPage", totalPage);
		
		List hot2VideoList=null;
		User user = (User) session.getAttribute("user");
		hot2VideoList=videoService.GetTuiJianVideos(user);
		model.addAttribute("hot2VideoList", hot2VideoList);
		
		List<Video> hotVideoList=new ArrayList<>();
		hotVideoList=videoService.GetHotVideos();
		model.addAttribute("hotVideoList", hotVideoList);
		if(user!=null){
			//判断用户是否发表过评论
			if(commentService.userIsComment(user.getUserId())){
				model.addAttribute("flag", 1);//发表过
			}else{
				model.addAttribute("flag", 0);//没有
			}
		}
		
		
		return "/play";
	}
	
	
	@RequestMapping("/ChangeState")
	@ResponseBody
	public String ChangeState(String videoId,String state,
			HttpSession session,Model model) throws Exception {
		int states=Integer.parseInt(state);
		int result=videoService.changeState(videoId, states);
		//返回结果
		if(result==1) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	
}

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
import com.po.Danmu;
import com.po.User;
import com.po.Video;
import com.service.CategoryService;
import com.service.CommentService;
import com.service.DanmuService;
import com.service.VideoService;

@Controller
@RequestMapping("/Danmu")
public class DanmuHandler {

/*	@Autowired
	private VideoService videoService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CategoryService categoryService;*/
	
	@Autowired
	private DanmuService danmuService;
	
	
	
	@RequestMapping("/GetDanmu")
	@ResponseBody
	public String GetDanmu(String videoId,
			HttpSession session,Model model) throws Exception {
		
		if (videoId == null) {
			return null;
		} else {
			// 进行弹幕获取
			List<Danmu> list = danmuService.getDanmu(videoId);
			// 编辑返回字符串
			String callback = "[";
			for (Danmu d : list) {
				callback += "'" + d.getDanmu() + "',";
			}
			callback += "]";
			return callback;
		}
	}
	
	@RequestMapping("/PostDanmu")
	@ResponseBody
	public String PostDanmu(String danmu,String videoId,
			HttpSession session,Model model) throws Exception {
		
		User user = (User) session.getAttribute("user");
		String userId = user.getUserId() + "";
		// 视频编号
		if (videoId == null) {
			// 无视频
		} else {
			// 进行弹幕发送
			danmuService.postDanmu(userId, videoId, danmu);
		}
		return null;
	}
	
	
}

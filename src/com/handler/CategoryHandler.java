package com.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.Category;
import com.po.User;
import com.po.Video;
import com.service.CategoryService;
import com.service.VideoService;

@Controller
@RequestMapping("/Category")
public class CategoryHandler {

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/CateVideoList")
	public String CateVideoList(String categoryId,String categoryLV,String pageNum,
			HttpSession session,Model model) throws Exception {
		
		List<Video> list = new ArrayList<Video>();
		int totalCount=0;
		if (categoryLV.equals("1")) {
			// 一级分类
			list = videoService.GetFirCateVideos(categoryId,pageNum);
			totalCount=videoService.countFirCateVideos(categoryId);
		} else if (categoryLV.equals("2")) {
			// 二级分类
			list = videoService.GetSecCateVideos(categoryId,pageNum);
			totalCount=videoService.countSecCateVideos(categoryId);
		}
		int totalpage=totalCount%6==0?totalCount/6:totalCount/6+1;
		model.addAttribute("totalPage", totalpage);
		model.addAttribute("VideoList", list);
		return "/all_content";
	}
	@RequestMapping("/DeleteCategory")
	@ResponseBody
	public String DeleteCategory(String categoryId,
			HttpSession session,Model model) throws Exception {
		int result=videoService.checkCateVideo(categoryId);
		if(result>0) {
			return "notempty";
		} else {
			result=categoryService.delCategory(categoryId);
			if(result>0) {
				return "success";
			} else {
				return "failure";
			}
		}
	}
	
	@RequestMapping("/ManageCategory")
	public String ManageCategory(
			HttpSession session,Model model) throws Exception {
		List list = categoryService.GetCategories();
		model.addAttribute("CateList", list);
		return "/back/categoryManage";
	}
	@RequestMapping("/PieChart")
	public String PieChart(
			HttpSession session,Model model) throws Exception {
		
		return "/back/pieChart";
	}
	
	
	@RequestMapping("/CategoryList")
	public String CategoryList(String categoryId,
			HttpSession session,Model model) throws Exception {
		Category category=categoryService.getCategoryById(Integer.parseInt(categoryId));
		int totalCount=videoService.countFirCateVideos(categoryId);
		int totalpage=totalCount%6==0?totalCount/6:totalCount/6+1;
		model.addAttribute("totalPage", totalpage);
		model.addAttribute("category", category);
		return "/all";
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/Index")
	public String Index(
			HttpSession session,Model model) throws Exception {
		List<Category> CategoryList=categoryService.GetCategories();
		List<Video> cateVideoList=new ArrayList<>();
		for(Category c:CategoryList) {
			c.setVideo(videoService.GetFirCateVideos(c.getCategoryId().toString(),"1"));
		}
		//获取热门视频(通过播放量)
		List<Video> hotVideoList=new ArrayList<>();
		hotVideoList=videoService.GetHotVideos();
		session.setAttribute("CategoryList", CategoryList);
		model.addAttribute("cateVideoList", cateVideoList);
		model.addAttribute("hotVideoList", hotVideoList);
		return "/index";
	}
	
	@RequestMapping("/NewCategory")
	@ResponseBody
	public String NewCategory(String categoryName,String parentId,
			HttpSession session,Model model) throws Exception {
		int result=categoryService.addCategory(categoryName, parentId);
		if(result==1) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	
}

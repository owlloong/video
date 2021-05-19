package com.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.hadoop.mahout.ItemCFByLocalData;
import com.test.hadoop.mahout.UserCFByLocalData;


@Controller
@RequestMapping("/Tuijian")
public class TuijianHandler {
	
	
	@RequestMapping("/TuijianPage")
	public String TuijianPage(String videoId,
			HttpSession session,Model model) throws Exception {
		ItemCFByLocalData itemCFByLocalData=new ItemCFByLocalData();
		UserCFByLocalData userCFByLocalData=new UserCFByLocalData();
		
		return "/play";
	}
}

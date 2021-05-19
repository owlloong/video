package com.handler;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mapper.Video_categoryMapper;
import com.po.Category;
import com.po.Comment;
import com.po.Danmu;
import com.po.User;
import com.po.Video;
import com.po.Video_category;
import com.service.CategoryService;
import com.service.CommentService;
import com.service.DanmuService;
import com.service.VideoService;
import com.util.DBUtils;
import com.util.MyProgressListener;
import com.util.Upload;

@Controller
@RequestMapping("/Up")
public class UploadHandler {

	@Autowired
	private VideoService videoService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private Video_categoryMapper video_categoryMapper;

	@RequestMapping("/upload")
	public String upload(String title, Integer vcategory, String descript,
			MultipartFile uploadFile, HttpSession session, Model model,
			HttpServletRequest request) throws Exception {
		String message = "";

		Video video = new Video();
		video.setVideoName(title);
		video.setCategoryId(vcategory);
		video.setVideoBrief(descript);
		boolean flag = false;

		String basePath = "D:\\apache-tomcat-8.0.23\\webapps\\cili_back";
		String fileUrl = uploadFile.getOriginalFilename();
		String fileType = fileUrl.substring(fileUrl.lastIndexOf("."));
		String serialName = String.valueOf(System.currentTimeMillis());
		video.setVideoId(serialName);

		Upload.creatpicture(uploadFile, "temp", serialName);
		String codcFilePath = basePath + "/" + serialName + ".flv";
		String videoPicPath = basePath + "\\images" + File.separator
				+ serialName + ".jpg";
		String ffmpegPath = request.getServletContext().getRealPath(
				"/tools/ffmpeg.exe");
		video.setVideoURL("D:/apache-tomcat-8.0.23/webapps/cili_back/temp/" + serialName + fileType);
		video.setVideoSRC("D:/apache-tomcat-8.0.23/webapps/cili_back/images/" + serialName + ".jpg");

		video.setVideoTime(new Date());
		
		File uploadFiles = new File(basePath + "/temp/" + serialName + fileType);
		flag = executeCodecs(ffmpegPath, uploadFiles.getAbsolutePath(),
				codcFilePath, videoPicPath);

		if (flag) {
			User user = (User) session.getAttribute("user");
			String userId = user.getUserId();

			video.setVideoURL(video.getVideoURL().substring(
					video.getVideoURL().lastIndexOf("/")));
			video.setVideoSRC(video.getVideoSRC().substring(
					video.getVideoSRC().lastIndexOf("/")));
			video.setUserId(userId);
			video.setStatus(202);
			video.setCount(0l);
			videoService.insert(video);

			Integer pidString = categoryService.getCategoryById(
					video.getCategoryId()).getParentId();
			Video_category video_category = new Video_category();
			video_category
					.setCategoryId(String.valueOf((video.getCategoryId())));
			video_category.setVideoId(video.getVideoId());
			video_category.setParentId(pidString.toString());
			video_categoryMapper.insert(video_category);

			List<Video> list = videoService.GetVideoByuid(userId);

			session.setAttribute("list", list);

			message = "视频上传成功!";

		}
		model.addAttribute("message", message);
		return "forward:/Category/Index.do";

	}
	
	
	

	public boolean executeCodecs(String ffmpegPath, String upFilePath,
			String codcFilePath, String videoPicPath) throws Exception {
		// TODO Auto-generated method stub
		List<String> cutpic = new ArrayList<String>();
		cutpic.add(ffmpegPath);
		cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
		cutpic.add("3"); // 添加起始时间为第2秒
		cutpic.add("-i");
		cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
		cutpic.add("-y");
		cutpic.add("-f");
		cutpic.add("image2");
		cutpic.add("-vframes");
		cutpic.add("1");
		/*
		 * cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间 cutpic.add("1"); //
		 * 添加起始时间为第2秒
		 *//*
			 * cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间 cutpic.add("0.001"); //
			 * 添加持续时间为1毫秒
			 *//*
				 * cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
				 * cutpic.add("800*280"); // 添加截取的图片大小为350*240
				 */cutpic.add(videoPicPath); // 添加截取的图片的保存路径
		boolean mark = true;
		ProcessBuilder builder = new ProcessBuilder();
		try {
			/*
			 * builder.command(convert); builder.redirectErrorStream(true);
			 * builder.start();
			 */
			builder.command(cutpic);
			builder.redirectErrorStream(true);
			builder.start();
		} catch (Exception e) {
			mark = false;
			System.out.println(e);
			e.printStackTrace();
		}
		return mark;
	}

}

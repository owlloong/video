package com.util;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

public class Upload {
	public static String creatpicture(MultipartFile picturefile, String name,String filename)
			throws Exception {

		// 原始上传的文件名称
		String originalFileName = picturefile.getOriginalFilename();
		// 非空判断
		if (picturefile != null && originalFileName != null
				&& originalFileName.length() > 0) {
			// 图片存储的物理路径
			/*
			 * String pic_path = "F:\\java\\photo\\SSM\\" + name + "\\";
			 */
			/* String pic_path = "H:\\officesoft\\server\\photo\\SSM\\user\\"; */
			//String pic_path = "E:\\videos\\" + name + "\\";
			String pic_path = "D:\\apache-tomcat-8.0.23\\webapps\\cili_back\\" + name + "\\";
			
			// 新的图片名称
			String newFileName = filename
					+ originalFileName.substring(originalFileName
							.lastIndexOf("."));

			// 新产生的临时图片及位置
			File newFile = new File(pic_path + newFileName);

			// 将内存的数据写入临时文件中
			picturefile.transferTo(newFile);

			return newFileName;
		}
		return null;
	}
	
	public static String creatpicture(MultipartFile picturefile, String name)
			throws Exception {

		// 原始上传的文件名称
		String originalFileName = picturefile.getOriginalFilename();
		// 非空判断
		if (picturefile != null && originalFileName != null
				&& originalFileName.length() > 0) {
			// 图片存储的物理路径
			/*
			 * String pic_path = "F:\\java\\photo\\SSM\\" + name + "\\";
			 */
			/* String pic_path = "H:\\officesoft\\server\\photo\\SSM\\user\\"; */
			/*String pic_path = "E:\\videos\\" + name
					+ "\\";
*/
			 WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
				ServletContext servletContext = webApplicationContext.getServletContext();
		
			String pic_path = servletContext.getRealPath(
					"/cili_back/images/");
			// 新的图片名称
			String newFileName = new Date().getTime()+
					 originalFileName.substring(originalFileName
							.lastIndexOf("."));

			// 新产生的临时图片及位置
			File newFile = new File(pic_path+"/" + newFileName);

			// 将内存的数据写入临时文件中
			picturefile.transferTo(newFile);

			return  newFileName;
		}
		return null;
	}
}

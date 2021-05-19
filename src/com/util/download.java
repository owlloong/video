package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class download
 */
public class download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String videoName=request.getParameter("videoURL");
		System.out.println(videoName);
		File file = new File(videoName);
		if(!file.exists()){
			System.out.println("文件不存在");
		}
		String s=videoName.substring(videoName.indexOf("/"));
		String si=s.substring(s.indexOf("/")+1);
		String st=si.substring(si.indexOf("/")+1);
		String realName=st.substring(st.indexOf("/")+1);
		System.out.println("realname"+realName);
		response.setContentType("application/octet-stream"); 
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realName, "UTF-8"));
		FileInputStream in = new FileInputStream(videoName);
		OutputStream out = response.getOutputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		       
	    while((len=in.read(buffer))>0){
	            
		out.write(buffer, 0, len);
		        }
	       
	    in.close();
		        
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

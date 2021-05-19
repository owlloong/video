package com.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Video;


/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String videoId=request.getParameter("videoId");
		String videoURL=request.getParameter("videoURL");
		String videoSRC=request.getParameter("videoSRC");
		String basePath = "D:\\apache-tomcat-8.0.23\\webapps\\cili_back";
		String s=videoURL.substring(videoURL.indexOf("/"));
		String si=s.substring(s.indexOf("/")+1);
		String st=si.substring(si.indexOf("/")+1);
		String s1=st.substring(st.indexOf("/")+1,st.indexOf("."));
		String videoFilePath = basePath+"/"+s1+".flv";
		System.out.println(videoFilePath);
		File fv = new File(videoURL);
		File fs = new File(videoFilePath);
		File fp = new File(videoSRC);
		int tryCount = 0;
		int tryCount1 = 0;
		int tryCount2 = 0;
		
        while(tryCount++ <10)    
        {         
        System.gc();    
         fv.delete();    
        }   
        while(tryCount1++ <10)    
        {         
        System.gc();    
         fs.delete();
        } 
        while(tryCount2++ <10)    
        {         
        System.gc();    
         fp.delete();    
        } 
		/*if(fv.exists()){
			fv.delete();
		}
		else{
			System.out.println("閸掔姳绗夐崝銊ユ櫓1");
		}
		if(fs.exists()){
			fs.delete();
		}
		else{
			System.out.println("閸掔姳绗夐崝銊ユ櫓2");
		}
		if(fp.exists()){
			fp.delete();
		}
		else{
			System.out.println("閸掔姳绗夐崝銊ユ櫓3");
		}*/
		System.out.println("视频路径:"+videoURL);
		System.out.println("封面路径:"+videoSRC);
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from video where videoId='"+videoId+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			String sql2="delete from video_category where videoId='"+videoId+"'";
			ps = conn.prepareStatement(sql2);
			ps.executeUpdate();
			int i = 1;
			Connection conn1 = null;
			try{
				conn1 = DBUtils.getConnection();
				String sql1 = "select * from video where userId='"+i+"'";
				PreparedStatement ps1 = conn1.prepareStatement(sql1);
				ResultSet rs = ps1.executeQuery();
				List<Video> list = new ArrayList<Video>();
				while(rs.next()){
					Video video1 = new Video();
					video1.setVideoId(rs.getString(1));
					video1.setVideoName(rs.getString(2));
					video1.setVideoBrief(rs.getString(3));
					video1.setUserId(rs.getString(4));
					video1.setCategoryId(Integer.parseInt(rs.getString(5)));
					video1.setVideoURL(rs.getString(6));
					video1.setVideoSRC(rs.getString(7));
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					video1.setVideoTime(simpleDateFormat.parse(rs.getString(8)));
					video1.setStatus(Integer.parseInt(rs.getString(9)));
					list.add(video1);
				}
			
				request.getSession().setAttribute("list", list);
				
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
			String message = "";
			message="删除成功";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/JSP/video_upload.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

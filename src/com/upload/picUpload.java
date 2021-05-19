package com.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.DaoFactory;
import com.dao.VideoDao;
import com.po.Video;
import com.util.DBUtils;




/**
 * Servlet implementation class picUpload
 */
public class picUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		VideoDao videoDao = DaoFactory.getVideoDao();
		String message = "";
		String uri=request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("11");
		System.out.println(	);
		/*if("/uploadFile".equals(path)){*/
			System.out.println("22");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			try{
				Video video = new Video();
				Video video1=new Video();
			    List<FileItem> items = sfu.parseRequest(request);
				boolean flag = false;
				String bVideoSRC="";
				for(int i =0;i<items.size();i++){
					FileItem item = items.get(i);
					if(item.isFormField()){
						String paramName = item.getFieldName();
						if(paramName.equals("title")){
							video.setVideoName(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
							System.out.println(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
						
						if(paramName.equals("videoSRC")){
							bVideoSRC=new String(item.getString().getBytes("ISO8859-1"),"UTF-8");
							
							File fv = new File(bVideoSRC);
							int tryCount = 0;
							while(tryCount++ <10)    
					        {         
					        System.gc();    
					         fv.delete();    
					        } 
							//video.setVideoName(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
							//System.out.println("图"+bVideoSRC);
							video1.setVideoSRC(bVideoSRC);
						}
						if(paramName.equals("vcategory")){
							video.setCategoryId(Integer.parseInt(new String(item.getString().getBytes("ISO8859-1"),"UTF-8")));
							System.out.println(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
						if(paramName.equals("descript")){
							video.setVideoBrief(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
							System.out.println(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
						}
						
						
					}else{
						ServletContext sctx = this.getServletContext();
						String basePath = "D:\\apache-tomcat-8.0.23\\webapps\\cili_back";
						String fileUrl = item.getName();
						String fileType = fileUrl.substring(fileUrl.lastIndexOf("."));
						String serialName = String.valueOf(System.currentTimeMillis());
						/*video.setVideoId(serialName);*/
						File uploadFile = new File(basePath+"/images/"+serialName+fileType);
						item.write(uploadFile);
						video.setVideoSRC("D:/apache-tomcat-8.0.23/webapps/cili_back/images/"+serialName+fileType);
						if(item.getSize()>10*1024*1024){
							message = "<li>大小超出范围</li>";
						}
				

						
	}}
					Connection conn = null;
					try{
						System.out.println("视频封面"+video.getVideoSRC());
						video.setVideoSRC(video.getVideoSRC().substring(video.getVideoSRC().lastIndexOf("/")));
						String sql="UPDATE video set videoSRC='"+video.getVideoSRC()+"',videoName='"+video.getVideoId()+"',videoBrief='"+video.getVideoBrief()+"' where videoSRC='"+bVideoSRC+"'";
						conn = DBUtils.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.executeUpdate(sql);
						//通过categoryId查询parentId
						String querysql="SELECT parentId FROM category WHERE categoryId='"+video.getCategoryId()+"'";
						ResultSet rs=ps.executeQuery(querysql);
						String parentId="0";
						if(rs.next()) {
							parentId=rs.getString(1);
						}
						System.out.println("parentId="+parentId);
						System.out.println("categoryId="+video.getCategoryId());
						
						String sql2="UPDATE video_category SET categoryId='"+video.getCategoryId()+"',parentId='"+parentId+"' WHERE videoId='"+video.getVideoId()+"'";
						ps = conn.prepareStatement(sql2);
						ps.executeUpdate(sql2);
						conn.close();
					}catch(Exception e){
						e.printStackTrace();
						
					}
					Connection conn1 = null;
					try{
						int i=1;
						conn1 = DBUtils.getConnection();
						String sql = "select * from video where userId='"+i+"'";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						conn1.close();
						List<Video> list = new ArrayList<Video>();
						while(rs.next()){
							Video video11 = new Video();
							video11.setVideoId(rs.getString(1));
							video11.setVideoName(rs.getString(2));
							video11.setVideoBrief(rs.getString(3));
							video11.setUserId(rs.getString(4));
							video11.setCategoryId(Integer.parseInt(rs.getString(5)));
							video11.setVideoURL(rs.getString(6));
							video11.setVideoSRC(rs.getString(7));
							SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							video11.setVideoTime(simpleDateFormat.parse(rs.getString(8)));
							video11.setStatus(Integer.parseInt(rs.getString(9)));
							list.add(video11);
						}
					
						request.getSession().setAttribute("list", list);
						
						
					}catch(Exception e){
						e.printStackTrace();
						
					}
					
					message="更新成功 !";
					
					request.getRequestDispatcher("/JSP/video_upload.jsp").forward(request, response);
			}catch(Exception e){
		e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

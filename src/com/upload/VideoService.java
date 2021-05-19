package com.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.DaoFactory;
import com.dao.VideoDao;
import com.po.User;
import com.po.Video;
import com.util.DBUtils;
import com.util.MyProgressListener;





/**
 * Servlet implementation class VideoService
 */
public class VideoService extends HttpServlet {
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
		
			DiskFileItemFactory factory = new DiskFileItemFactory();
		
			ServletFileUpload sfu = new ServletFileUpload(factory);
			sfu.setProgressListener(new MyProgressListener(request));
		
			try{
				Video video = new Video();
			    List<FileItem> items = sfu.parseRequest(request);
		
				boolean flag = false;
				for(int i =0;i<items.size();i++){
					FileItem item = items.get(i);
					if(item.isFormField()){
						String paramName = item.getFieldName();
						if(paramName.equals("title")){
							video.setVideoName(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
							System.out.println(new String(item.getString().getBytes("ISO8859-1"),"UTF-8"));
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
						video.setVideoId(serialName);
						File uploadFile = new File(basePath+"/temp/"+serialName+fileType);
						
						item.write(uploadFile);
						if(item.getSize()>1024*1024*1024){
							message = "<li>文件过大</li>";
						}
						String codcFilePath = basePath +"/" + serialName + ".flv";
						String videoFilePath = basePath+"/temp/"+serialName+fileType ;
						System.out.println("鍓�:"+videoFilePath);
/*						request.getSession().setAttribute("videoFilePath", videoFilePath);*/
						String videoPicPath = basePath +"\\images" +File.separator+ serialName+".jpg";
						String ffmpegPath = getServletContext().getRealPath("/tools/ffmpeg.exe");
						System.out.println(videoFilePath);
						video.setVideoURL("D:/apache-tomcat-8.0.23/webapps/cili_back/temp/"+serialName+fileType);
						video.setVideoSRC("D:/apache-tomcat-8.0.23/webapps/cili_back/images/"+serialName+".jpg");
						
						Calendar cal=Calendar.getInstance();  
						int y=cal.get(Calendar.YEAR);      
						int m=cal.get(Calendar.MONTH)+1;      
						int d=cal.get(Calendar.DATE);      
						int h=cal.get(Calendar.HOUR_OF_DAY);      
						int mi=cal.get(Calendar.MINUTE);      
						int s=cal.get(Calendar.SECOND); 
						String time =""+h+":"+mi+":"+s;
						String date =""+y+"-"+m+"-"+d;
						System.out.println(time);
						System.out.println(date);
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						video.setVideoTime(simpleDateFormat.parse(date+" "+time));
						//杞爜
						 flag = videoDao.executeCodecs(ffmpegPath, uploadFile.getAbsolutePath(), codcFilePath, videoPicPath);
					}
					
				}
				if(flag){
					HttpSession session=request.getSession();
					User user=(User) session.getAttribute("user");
					String userId=user.getUserId();
					videoDao.saveVideo(video,userId);
					/*videoDao.queryVideoById(1, request);*/
					int i = 1;
					Connection conn = null;
					try{
						conn = DBUtils.getConnection();
						String sql = "select * from video where userId='"+i+"'";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						conn.close();
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
					message="视频上传成功!";
					
				}
				request.setAttribute("message", message);
				System.out.println(message);
				request.getRequestDispatcher("/Category/Index.do").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
				throw new ServletException(e);
			}
		/*}*/
		/*if("/queryAll".equals(path)){
			List<Video>videoList;
			try{
				videoList = videoDao.
			}
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
		
	}

}

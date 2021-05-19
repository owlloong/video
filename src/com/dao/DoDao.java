package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.VideoMapper;
import com.po.Video;
import com.util.DBUtils;





public class DoDao implements VideoDao{
	
	

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
        /*cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add("1"); // 添加起始时间为第2秒
*/      /*cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("0.001"); // 添加持续时间为1毫秒
*/        /*cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
        cutpic.add("800*280"); // 添加截取的图片大小为350*240
*/        cutpic.add(videoPicPath); // 添加截取的图片的保存路径
        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try{
        /*	builder.command(convert);
        	builder.redirectErrorStream(true);
        	builder.start();*/
        	builder.command(cutpic);
        	builder.redirectErrorStream(true);
        	builder.start();
        }catch(Exception e){
        	mark = false;
        	System.out.println(e);
        	e.printStackTrace();
        }
		return mark;
	}

	public boolean saveVideo(Video video,String userId) throws Exception {
		// TODO Auto-generated method stub
		boolean mark = true;
		/*String videoId = video.getVideoId();
		String videoName = video.getVideoName();*/
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			video.setVideoURL(video.getVideoURL().substring(video.getVideoURL().lastIndexOf("/")));
			video.setVideoSRC(video.getVideoSRC().substring(video.getVideoSRC().lastIndexOf("/")));
			video.setUserId(userId);
			video.setStatus(202);
			video.setCount(0l);
			PreparedStatement ps=null;
				String sql = "insert into video values("+"'"+video.getVideoId()+"',"+"'"+video.getVideoName()+"',"+"'"+video.getVideoBrief()+"',"+"'"+userId+"',"+"'"+video.getVideoURL()+"',"+"'"+video.getVideoSRC()+"',"+"'"+video.getVideoTime()+"',"+"'202',"+"'0')";
				ps= conn.prepareStatement(sql);
				ps.execute(sql);
			
			//通过categoryId查询parentId
			String querysql="SELECT parentId FROM category WHERE categoryId='"+video.getCategoryId()+"'";
			ResultSet rs=ps.executeQuery(querysql);
			String parentId="0";
			if(rs.next()) {
				parentId=rs.getString(1);
			}
			System.out.println("parentId="+parentId);
			System.out.println("categoryId="+video.getCategoryId());
			String sql2="INSERT INTO video_category VALUES('"+video.getVideoId()+"','"+video.getCategoryId()+"','"+parentId+"')";
			ps = conn.prepareStatement(sql2);
			ps.executeUpdate(sql2);
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			mark = false;
		}
		return mark;
	}

	public boolean queryVideoById(int id,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		int i = id;
		boolean mark = true;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			String sql = "select * from video where userId='"+i+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
			//System.out.println(list);
			request.getSession().setAttribute("list", list);
			list.clear();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			mark = false;
		}
		return mark;
	}

}

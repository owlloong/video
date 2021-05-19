package com.dao;

import javax.servlet.http.HttpServletRequest;

import com.po.Video;



public interface VideoDao {
	
	public boolean executeCodecs(String ffmpegPath,String upFilePath,String codcFilePath,String videoPicPath)throws Exception;
	
	public boolean saveVideo(Video video,String userId)throws Exception;
	public boolean queryVideoById(int id,HttpServletRequest request)throws Exception;
	
}

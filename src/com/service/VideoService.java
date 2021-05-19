package com.service;

import java.util.List;

import com.po.User;
import com.po.Video;



public interface VideoService {
	
	
	/*
	 * 获取一级分类的视频
	 * @param categoryId
	 * 
	 * 
	 */
	public List GetFirCateVideos(String categoryId,String pageNum) throws Exception;
	/*
	 * 获取二级分类的视频
	 * @param categoryId
	 */
	public List GetSecCateVideos(String categoryId,String pageNum) throws Exception;
	/*
	 * 通过编号获取视频
	 * @param videoId
	 */
	public Video GetVideoById(String videoId) throws Exception;
	/*
	 * 通过state获取视频
	 * @param state
	 */
	public List GetVideoByState(int state) throws Exception;
	/*
	 * 根据id 改state
	 * @param videoId
	 * @param state
	 */
	public int changeState(String videoId,int state) throws Exception;
	/*
	 * 根据name获得
	 * @param videoName
	 */
	public List getVideosByName(String videoName) throws Exception;
	//根据name获得有限制
	//count search结果
	/*
	 * 热门视频
	 */
	/*
	 * 大分类视频数量
	 */
	public int countFirCateVideos(String categoryId) throws Exception;
	/*
	 * 小分类视频数量
	 */
	public int countSecCateVideos(String categoryId) throws Exception;
	/*
	 * 增加count
	 */
	public int countPlus(String videoId) throws Exception;
	/*
	 * 检查分类是否还有视频
	 */
	public int checkCateVideo(String categoryId) throws Exception;
	/*
	 * userId获取视频
	 */
	
	public List GetTuiJianVideos(User user) throws Exception;
	public List GetHotVideos() throws Exception;
	public int countSearchResult(String keyword);
	public List<Video> searchVideo(String keyword, int parseInt);
	public List<Video> GetVideoByuid(String userid);
	
	public int insert(Video video) ;
}

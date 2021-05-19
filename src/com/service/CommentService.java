package com.service;

import java.util.List;

public interface CommentService {
	/*
	 * 发送评论
	 * @param userId 用户编号
	 * @param parentId 父级编号
	 * @param comment 评论内容
	 * @param datetime 时间
	 */
	public void sendComment(String userId,String parentId,String comment,String datetime) throws Exception;
	/*
	 * 获取视频评论
	 * @param videoId 视频编号
	 * @param pageNum 页码
	 */
	public List getVideoComment(String videoId,int pageNum) throws Exception;
	/*
	 * 获取视频评论总数
	 * @param videoId 视频编号
	 */
	public int countVideoComment(String videoId) throws Exception;
	/*
	 * 获取子评论数量
	 * @param commentId 评论编号
	 */
	public int getSubCommCount(String commentId) throws Exception;
	
	public int deleteSubCommCount(String commentId) throws Exception;
	public List getAllComm() throws Exception;
	public List getAllComm(int pageNum) throws Exception;
	
	public boolean userIsComment(String userId) throws Exception;
	
	
}

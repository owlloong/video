package com.service;

import java.util.List;

public interface DanmuService {
	/*
	 * 获取弹幕
	 * @param videoId
	 */
	public List getDanmu(String videoId) throws Exception;
	
	/*
	 * 发送弹幕
	 * @param userId
	 * @param videoId
	 * @param 
	 */
	public void postDanmu(String userId,String videoId,String danmu) throws Exception;
}

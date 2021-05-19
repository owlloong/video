package com.po;

import java.io.Serializable;

/**
 * 描述:tuijian表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Tuijian implements Serializable {
	
	private String userId;
	//private String videoId;
	private String parentId;
	private Integer num;
	
	/**
     * 
     * @return userId 
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * 
     * @param userId 
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
	
	 /**
     * 
     * @return videoId 
     */
    /*public String getVideoId() {
        return videoId;
    }*/
    
    /**
     * 
     * @param videoId 
     */
   /* public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }*/
    
    /**
     * 
     * @return parentId 
     */
    public String getParentId() {
        return parentId;
    }
    
    /**
     * 
     * @param parentId 
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    /**
     * 
     * @return num 
     */
    public Integer num() {
        return num;
    }

    /**
     * 
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

	
    
}

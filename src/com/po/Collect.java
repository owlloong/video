package com.po;

import java.util.Date;

/**
 * 描述:collect表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Collect {
    /**
     * 
     */
    private String collectId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String videoId;

    /**
     * 
     */
    private Date collectTime;

    /**
     * 
     * @return collectId 
     */
    public String getCollectId() {
        return collectId;
    }

    /**
     * 
     * @param collectId 
     */
    public void setCollectId(String collectId) {
        this.collectId = collectId == null ? null : collectId.trim();
    }

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
    public String getVideoId() {
        return videoId;
    }

    /**
     * 
     * @param videoId 
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * 
     * @return collectTime 
     */
    public Date getCollectTime() {
        return collectTime;
    }

    /**
     * 
     * @param collectTime 
     */
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
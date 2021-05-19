package com.po;

import java.io.Serializable;

/**
 * 描述:video_category表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Video_category implements Serializable {
    /**
     * 
     */
    private String videoId;

    /**
     * 
     */
    private String categoryId;

    /**
     * 
     */
    private String parentId;

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
     * @return categoryId 
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId 
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

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
        this.parentId = parentId == null ? null : parentId.trim();
    }
}
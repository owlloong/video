package com.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:video表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Video implements Serializable {
	
	private Category category;
	private User user;
	private int categoryId;
	
    /**
     * 
     * 
     * 
     */
    private String videoId;

    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
     * 
     */
    private String videoName;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String videoURL;

    /**
     * 
     */
    private String videoSRC;

    /**
     * 
     */
    private Date videoTime;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Long count;

    /**
     * 
     */
    private String videoBrief;

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
     * @return videoName 
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 
     * @param videoName 
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
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
     * @return videoURL 
     */
    public String getVideoURL() {
        return videoURL;
    }

    /**
     * 
     * @param videoURL 
     */
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL == null ? null : videoURL.trim();
    }

    /**
     * 
     * @return videoSRC 
     */
    public String getVideoSRC() {
        return videoSRC;
    }

    /**
     * 
     * @param videoSRC 
     */
    public void setVideoSRC(String videoSRC) {
        this.videoSRC = videoSRC == null ? null : videoSRC.trim();
    }

    /**
     * 
     * @return videoTime 
     */
    public Date getVideoTime() {
        return videoTime;
    }

    /**
     * 
     * @param videoTime 
     */
    public void setVideoTime(Date videoTime) {
        this.videoTime = videoTime;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return count 
     */
    public Long getCount() {
        return count;
    }

    /**
     * 
     * @param count 
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 
     * @return videoBrief 
     */
    public String getVideoBrief() {
        return videoBrief;
    }

    /**
     * 
     * @param videoBrief 
     */
    public void setVideoBrief(String videoBrief) {
        this.videoBrief = videoBrief == null ? null : videoBrief.trim();
    }
}
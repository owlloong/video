package com.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:comment表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Comment implements Serializable {
   
	private User user;
	private int subCommCount;
	/**
     * 
     */
    private String commentId;

    /**
     * 
     */
    private String parentId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private Date commentTime;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSubCommCount() {
		return subCommCount;
	}

	public void setSubCommCount(int subCommCount) {
		this.subCommCount = subCommCount;
	}

	/**
     * 
     */
    private String commContext;

    /**
     * 
     * @return commentId 
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 
     * @param commentId 
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
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
     * @return commentTime 
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 
     * @param commentTime 
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 
     * @return commContext 
     */
    public String getCommContext() {
        return commContext;
    }

    /**
     * 
     * @param commContext 
     */
    public void setCommContext(String commContext) {
        this.commContext = commContext == null ? null : commContext.trim();
    }
}
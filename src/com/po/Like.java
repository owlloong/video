package com.po;

import java.util.Date;

/**
 * 描述:like表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Like {
    /**
     * 
     */
    private String likeId;

    /**
     * 
     */
    private String sendId;

    /**
     * 
     */
    private String receiveId;

    /**
     * 
     */
    private Integer likeType;

    /**
     * 
     */
    private Date likeTime;

    /**
     * 
     * @return likeId 
     */
    public String getLikeId() {
        return likeId;
    }

    /**
     * 
     * @param likeId 
     */
    public void setLikeId(String likeId) {
        this.likeId = likeId == null ? null : likeId.trim();
    }

    /**
     * 
     * @return sendId 
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * 
     * @param sendId 
     */
    public void setSendId(String sendId) {
        this.sendId = sendId == null ? null : sendId.trim();
    }

    /**
     * 
     * @return receiveId 
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * 
     * @param receiveId 
     */
    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    /**
     * 
     * @return likeType 
     */
    public Integer getLikeType() {
        return likeType;
    }

    /**
     * 
     * @param likeType 
     */
    public void setLikeType(Integer likeType) {
        this.likeType = likeType;
    }

    /**
     * 
     * @return likeTime 
     */
    public Date getLikeTime() {
        return likeTime;
    }

    /**
     * 
     * @param likeTime 
     */
    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }
}
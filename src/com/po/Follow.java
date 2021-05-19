package com.po;

import java.util.Date;

/**
 * 描述:follow表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Follow {
    /**
     * 
     */
    private String followId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String upId;

    /**
     * 
     */
    private Date followTime;

    /**
     * 
     * @return followId 
     */
    public String getFollowId() {
        return followId;
    }

    /**
     * 
     * @param followId 
     */
    public void setFollowId(String followId) {
        this.followId = followId == null ? null : followId.trim();
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
     * @return upId 
     */
    public String getUpId() {
        return upId;
    }

    /**
     * 
     * @param upId 
     */
    public void setUpId(String upId) {
        this.upId = upId == null ? null : upId.trim();
    }

    /**
     * 
     * @return followTime 
     */
    public Date getFollowTime() {
        return followTime;
    }

    /**
     * 
     * @param followTime 
     */
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}
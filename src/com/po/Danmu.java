package com.po;

/**
 * 描述:danmu表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Danmu {
    /**
     * 
     */
    private String danmuId;

    /**
     * 
     */
    private String videoId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String danmu;

    /**
     * 
     * @return danmuId 
     */
    public String getDanmuId() {
        return danmuId;
    }

    /**
     * 
     * @param danmuId 
     */
    public void setDanmuId(String danmuId) {
        this.danmuId = danmuId == null ? null : danmuId.trim();
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
     * @return danmu 
     */
    public String getDanmu() {
        return danmu;
    }

    /**
     * 
     * @param danmu 
     */
    public void setDanmu(String danmu) {
        this.danmu = danmu == null ? null : danmu.trim();
    }
}
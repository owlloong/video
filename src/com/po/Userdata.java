package com.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:userdata表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Userdata  implements Serializable{
    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String portraitSRC;

    /**
     * 
     */
    private Date birthday;

    /**
     * 
     */
    private String qq;

    /**
     * 
     */
    private Integer gender;

    /**
     * 
     */
    private String brief;

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
     * @return portraitSRC 
     */
    public String getPortraitSRC() {
        return portraitSRC;
    }

    /**
     * 
     * @param portraitSRC 
     */
    public void setPortraitSRC(String portraitSRC) {
        this.portraitSRC = portraitSRC == null ? null : portraitSRC.trim();
    }

    /**
     * 
     * @return birthday 
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 
     * @param birthday 
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 
     * @return qq 
     */
    public String getQq() {
        return qq;
    }

    /**
     * 
     * @param qq 
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 
     * @return gender 
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 
     * @param gender 
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return brief 
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 
     * @param brief 
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}
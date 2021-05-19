package com.po;

import java.io.Serializable;

/**
 * 描述:user表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class User   implements Serializable{
    /**
     * 
     */
	private Role role;
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private String userId;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String roleId;

    /**
     * 
     */
    private Integer state;

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
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * @return userName 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return roleId 
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 
     * @param roleId 
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * 
     * @return state 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state 
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
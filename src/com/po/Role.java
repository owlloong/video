package com.po;

/**
 * 描述:role表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Role {
    /**
     * 
     */
    private String roleId;

    /**
     * 
     */
    private String roleName;

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
     * @return roleName 
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 
     * @param roleName 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
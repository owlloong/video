package com.service;

import com.po.Role;

public interface RoleService {
	/*
	 * 通过userId查询role
	 * @param userId
	 */
	public Role GetUserRole(String roleId) throws Exception;
}

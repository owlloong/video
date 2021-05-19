package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RoleMapper;
import com.po.Role;
import com.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Role GetUserRole(String roleId) throws Exception {
		return roleMapper.selectByPrimaryKey(roleId);
	}
	
	
	
}

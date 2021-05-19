package com.service;

import com.po.Userdata;

public interface UserdataService {
	//新增个人信息
	public int NewUserData(String userId) throws Exception;
	//查询个人信息
	public Userdata GetUserData(String userId) throws Exception;
	//更新个人信息
	public int UpdateUserData(String portraitSRC,String brief,String gender,String qq,String birthday,String userId) throws Exception;
	public int AlterUserData(String portraitSRC,String brief, String gender, String qq,
			String birthday, String userId);
}

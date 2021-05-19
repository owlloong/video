package com.service;

import java.util.List;

import com.po.User;



public interface UserService {
	
	
	public int frozeUser(String userId,int type)  throws Exception;
	public int changeRole(String userId,int type)  throws Exception;
	/*
	 * 通过name获取用户
	 * @param userName
	 */
	public List getUserByName(String userName) throws Exception;
	public int CheckNameUnique(String userName) throws Exception;
	/*
	 * 通过id改变状态
	 * @param userId
	 * @param state
	 */
	public int changeUserState(String userId,int state) throws Exception;
	/*
	 * 更改roleId
	 * @param userId
	 * @param roleId
	 */
	public int changeRoleId(String userId,int roleId) throws Exception;
	/*
	 * 通过userId拿User
	 * @param userId用户编号
	 */
	public User getUserByuid(String userId) throws Exception;
	/*
	 * 登录
	 * @param email
	 * @param password
	 */
	public User login(String email,String password) throws Exception;
	/*
	 * 注册
	 * @param email
	 * @param userName
	 * @param password
	 */
	public int register(String email,String userName,String password) throws Exception;
	/*
	 * 检查用户名重复
	 * @param userName
	 */
	public int checkUserNameUnique(String userName) throws Exception;
	/*
	 * 检查邮箱重复
	 * @param email
	 */
	public int checkEmailUnique(String email) throws Exception;
	/*
	 * 通过userName拿到user
	 *@param userName
	 */
	public User getUIdByName(String userName) throws Exception;
	/*
	 * 修改password
	 */
	public int updatePassword(String password,String userId) throws Exception;
	/*
	 * 修改userName
	 */
	public int updateName(String userId,String userName) throws Exception;
	public int AlterPassword(String password, String userId);
	public int AlterName(String userId, String userName);
}

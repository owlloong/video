package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.RoleMapper;
import com.mapper.UserMapper;
import com.po.Role;
import com.po.User;
import com.po.UserExample;
import com.service.UserService;
import com.util.CommonsUtils;
import com.util.ManagerThreadLocal;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Override
	public List getUserByName(String userName) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameLike("%" + userName + "%");
		List<User> list=userMapper.selectByExample(example);
		for (User user : list) {
			Role role=roleMapper.selectByPrimaryKey(user.getRoleId());
			user.setRole(role);
		}
				
		return list;
	}

	@Override
	public int changeUserState(String userId, int state) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setState(state);
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int changeRoleId(String userId, int roleId) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setRoleId(String.valueOf(roleId));
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User getUserByuid(String userId) throws Exception {
		Role role=roleMapper.selectByPrimaryKey(userMapper.selectByPrimaryKey(userId).getRoleId());
		User user=userMapper.selectByPrimaryKey(userId);
		user.setRole(role);
		return user;
	}

	@Override
	public User login(String email, String password) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			Role role=roleMapper.selectByPrimaryKey(user.getRoleId());
			user.setRole(role);
		}
		if (list.size() > 0) {
			return (User) list.get(0);
		} else
			return null;
	}

	@Override
	public int register(String email, String userName, String password) throws Exception {

		User user = new User();
		user.setUserId(CommonsUtils.getUUID());
		user.setEmail(email);
		user.setUserName(userName);
		user.setPassword(password);
		user.setRoleId("2");
		user.setState(101);
		return userMapper.insert(user);
	}

	@Override
	public int checkUserNameUnique(String userName) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<User> list = userMapper.selectByExample(example);
		
		if(list==null || list.size()<1) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int checkEmailUnique(String email) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andEmailEqualTo(email);
		List<User> list = userMapper.selectByExample(example);
		
		if(list==null || list.size()<1) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public User getUIdByName(String userName) throws Exception {
		
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			Role role=roleMapper.selectByPrimaryKey(user.getRoleId());
			user.setRole(role);
		}
		if(list==null || list.size()<1) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public int updatePassword(String password, String userId) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setPassword(password);
		return  userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public int updateName(String userId, String userName) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setUserName(userName);
		return  userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int frozeUser(String userId, int type) throws Exception {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			//操作
			if(type==0) {
				//冻结
				result=changeUserState(userId, 103);
			} else if(type==1) {
				//解冻或激活
				result=changeUserState(userId, 100);
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int changeRole(String userId, int type) throws Exception {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			//操作
			if(type==0) {
				//降级
				result=changeRoleId(userId, 2);
			} else if(type==1) {
				//升级
				result=changeRoleId(userId, 1);
			}
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int CheckNameUnique(String userName) throws Exception {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=checkUserNameUnique(userName);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int AlterPassword(String password, String userId) {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=updatePassword(password, userId);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result>0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int AlterName(String userId, String userName) {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=updateName(userId, userName);
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				ManagerThreadLocal.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(result>0) {
			return 1;
		} else {
			return 0;
		}
	}

}

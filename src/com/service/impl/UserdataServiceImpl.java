package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserdataMapper;
import com.po.Userdata;
import com.service.UserdataService;
import com.util.ManagerThreadLocal;

@Service("userdataService")
public class UserdataServiceImpl implements UserdataService {
	
	@Autowired
	private UserdataMapper UserdataMapper;
	
	private SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Override
	public int NewUserData(String userId) throws Exception {
		Userdata userdata=new Userdata();
		userdata.setUserId(userId);
		userdata.setBirthday(null);
		userdata.setBrief("这个用户很懒，还没有个性签名。");
		userdata.setGender(1);
		userdata.setPortraitSRC("/img/default.jpg");
		userdata.setQq(null);
		return UserdataMapper.insert(userdata);
	}

	@Override
	public Userdata GetUserData(String userId) throws Exception {
		return UserdataMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int UpdateUserData(String portraitSRC,String brief, String gender, String qq, String birthday, String userId) throws Exception {
		Userdata userdata=UserdataMapper.selectByPrimaryKey(userId);
		if(userdata==null){
			userdata=new Userdata();
			if(!birthday.equals("")&&birthday.length()>1){
				userdata.setBirthday(sFormat.parse(birthday));
			}
			userdata.setBrief(brief);
			userdata.setGender(Integer.parseInt(gender));
			if(portraitSRC!=null&&portraitSRC.length()>0){
				userdata.setPortraitSRC(portraitSRC);
			}else{
				userdata.setPortraitSRC("/img/default.jpg");
			}
			userdata.setUserId(userId);
			userdata.setQq(qq);
			return UserdataMapper.insert(userdata);
		}else{
			if(!birthday.equals("")&&birthday.length()>1){
				userdata.setBirthday(sFormat.parse(birthday));
			}
		userdata.setBrief(brief);
		userdata.setGender(Integer.parseInt(gender));
		if(portraitSRC!=null&&portraitSRC.length()>0){
			userdata.setPortraitSRC(portraitSRC);
		}else{
			userdata.setPortraitSRC("/img/default.jpg");
		}
		
		userdata.setQq(qq);
		return UserdataMapper.updateByPrimaryKey(userdata);}
	}

	@Override
	public int AlterUserData(String portraitSRC,String brief, String gender, String qq,
			String birthday, String userId) {
		int result=0;
		try {
			ManagerThreadLocal.startTransacation();
			result=UpdateUserData(portraitSRC,brief, gender, qq, birthday, userId);
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

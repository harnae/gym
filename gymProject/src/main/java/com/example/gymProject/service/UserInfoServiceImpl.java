package com.example.gymProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gymProject.dao.UserInfoDao;
import com.example.gymProject.form.UserInfoForm;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDao uid;
	@Autowired
	PasswordEncoder pwden;

	@Override
	public UserInfoForm getUserInfo(Integer cardNo) {
		UserInfoForm userInfo = uid.getUserInfo(cardNo);
		return userInfo;
	}



	@Override
	public boolean changeUserInfo(String name, String addr, String phone, Integer cardNo) {
		try {
			uid.changeInfo(name, addr, phone, cardNo);
			//System.out.println("updateservice = ");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean changeUserPwd(String pwd, Integer cardNo) {
		try {
			String newPwd = pwden.encode(pwd);
			uid.changePassword(newPwd, cardNo);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;


	}

}

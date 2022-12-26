package com.example.gymProject.service;

import java.util.Collection;

import com.example.gymProject.form.UserInfoForm;

public interface UserInfoService {
	public Collection<UserInfoForm> getUserInfo(Integer cardNo);
	public boolean changeUserInfo(String name, String addr, String phone, Integer cardNo);
	public boolean changeUserPwd(String pwd, Integer cardNo);
}

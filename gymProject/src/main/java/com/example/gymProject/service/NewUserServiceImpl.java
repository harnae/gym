package com.example.gymProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymProject.dao.NewUserDao;
import com.example.gymProject.form.NewUser;

@Service
public class NewUserServiceImpl implements NewUserService {
	@Autowired
	NewUserDao newUserSignup;


	@Override
	public void signUp(NewUser newUser) {
		System.out.println("serv"+newUser.getName());
		newUserSignup.newUser(newUser);
	}

}

package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymProject.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService uis;


	@PostMapping("/userinfo")
	public String userInfo(Integer cardNo, Model model) {

		model.addAttribute("userInfo", uis.getUserInfo(cardNo));
		return "userinfo/userinfo";
	}
}

package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gymProject.form.UserInfoForm;
import com.example.gymProject.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService uis;


	@GetMapping("/userinfo")
	public String getUserInfo(@RequestParam Integer cardNo, Model model) {
		UserInfoForm userinfo = uis.getUserInfo(cardNo);
		if (userinfo.getRole() == 3) {
			model.addAttribute("role", "admin");
		}
		else {
			model.addAttribute("role", "user");
		}
		model.addAttribute("userinfo", userinfo);
		return "userinfo/userinfo";
	}
}

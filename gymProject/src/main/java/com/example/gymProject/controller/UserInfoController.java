package com.example.gymProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gymProject.form.UserInfoForm;
import com.example.gymProject.service.UserInfoService;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService uis;
	@Autowired
	PasswordEncoder pe;

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

	@ResponseBody
	@PostMapping("/update")
	public void updateUserInfo(@RequestBody Map<String, Object> updateInfo) throws Exception {
		Integer cardNo = (Integer)updateInfo.get("cardNo");
		String name = (String)updateInfo.get("name");
		String phone = (String)updateInfo.get("phone");
		String addr = (String)updateInfo.get("addr");
		uis.changeUserInfo(name, addr, phone, cardNo);
		//System.out.println("updateinfo = " + updateInfo);
	}

	@ResponseBody
	@PostMapping("/updatePwd")
	public void updateUserPwd(@RequestBody Map<String, Object> pwdData) throws Exception {
		Integer cardNo = (Integer)pwdData.get("cardNo");
		String pwd = (String)pwdData.get("pwd");
		uis.changeUserPwd(pwd, cardNo);
	}

}

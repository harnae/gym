package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymProject.dto.NewUserDto;
import com.example.gymProject.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public String signup(NewUserDto infoDto) {
		userService.save(infoDto);
		return "redirect:/login";
	}
	
	
	@GetMapping("/info")
	public String userInfo(Authentication authentication) {
		if(authentication.getAuthorities().toString().equals("[ROLE_USER]")) {
			return "redirect:/main";
		}else if(authentication.getAuthorities().toString().equals("[ROLE_ADMIN]")){
			return "redirect:/admin/userlist";
		}else {
			return "redirect:/error";
		}
	}
}

package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
//	@RequestMapping("/list")
//	public String user() {
//		return "list";
//	}
	
//	@GetMapping("/login")
//    public String login(){
//        return "login";
//    }
	
	@PostMapping("/loginProc")
    public String loginForm() {
		System.out.print("login");	
        return "/loginProc";
    }
	
	@PostMapping("/signup")
	public String signup(NewUserDto infoDto) {
		System.out.println("save");
		System.out.print(infoDto);
		userService.save(infoDto);
		return "redirect:/login";
	}
	
//	@PostMapping("/login")
//	public String login(LoginUser user) {
//		System.out.print(user);
//		System.out.print("login");
//		userService.loadUserByUsername(user.getUsername());
//		return "redirect:/userinfo";
//	}
	
	@GetMapping("/userinfo")
	public String userInfo() {
		return "redirect:/userinfo";
	}
}

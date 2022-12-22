package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymProject.service.ListService;

@Controller
public class ListController {
//
//	@PostMapping("list")
//	ModelAndView userList(HttpSession session) {
//
//	}

	@Autowired
	ListService ls;


	@GetMapping("/")
	public String index() {
		System.out.println(ls.getUserList());

		return "/login/login";
	}

	@PostMapping("login/action")
	public String loginAct() {
		return null;
	}
}

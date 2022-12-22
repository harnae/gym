package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gymProject.service.ListService;

import jakarta.servlet.http.HttpSession;

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
	public String listPage(HttpSession session, Model model) {
		if (session == null) {
			return "/login/login";
		}
		model.addAttribute("userList",ls.getUserList());
		return "/list/list";
	}

}

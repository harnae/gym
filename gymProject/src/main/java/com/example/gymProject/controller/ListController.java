package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gymProject.common.Paging;
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

	@GetMapping({"/", "/list/list"})
	public String listPage(Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {
		Paging paging = ls.getListCount(page, range);

		//System.out.println("paging = " + paging);

//		model.addAttribute("startList", paging.getStartPage());
//		model.addAttribute("endPage",paging.getEndPage());
		model.addAttribute("listed", true);
		model.addAttribute("pag",paging);
		model.addAttribute("userList",ls.getUserList(paging));
		return "/list/list";
	}

	@GetMapping("/list/search")
	public String searchList(Model model,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(defaultValue = "") String search) {
		if(search=="") {
			return "/";
		}
		Paging paging = ls.getSearchListCount(page, range, search);
		//System.out.println("paging = " + paging);
		model.addAttribute("searchWord", search);
		model.addAttribute("searched", true);
		model.addAttribute("pag",paging);
		model.addAttribute("userList",ls.getSearchedList(search, paging));
		return "list/list";
	}

}

package com.example.gymProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gymProject.form.NewUser;
import com.example.gymProject.service.NewUserService;

@Controller
public class SignUpController {
	@Autowired
	NewUserService nus;

	@GetMapping("/newUser")
	public String newUserPage(Model model) {
		model.addAttribute("newUserSignIn", new NewUser());
		return "newUser/newUser";
	}


	@PostMapping("/signup")
	public String signUpUser(@ModelAttribute NewUser newUser, Model model) {
		System.out.println("contr"+newUser.getName());
		BCryptPasswordEncoder pwdencoder = new BCryptPasswordEncoder();
		newUser.setPassword(pwdencoder.encode(newUser.getPassword()));
		newUser.setRole(2);
		nus.signUp(newUser);
		return "login/login";
	}
}

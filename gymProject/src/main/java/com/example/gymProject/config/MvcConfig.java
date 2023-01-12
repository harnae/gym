package com.example.gymProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("login/login");
	    registry.addViewController("/userinfo").setViewName("userInfo/userInfo"); 
	    registry.addViewController("/userlist").setViewName("list/list"); 
	    registry.addViewController("/login").setViewName("login/login");
	    registry.addViewController("/newuser").setViewName("newUser/newUser");
	    registry.addViewController("/error").setViewName("error/error");
	}

	
}

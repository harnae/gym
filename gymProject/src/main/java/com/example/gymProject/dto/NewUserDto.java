package com.example.gymProject.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NewUserDto {
	private String username;
	private String password;
	private String gender;
	private String name;
	private String phone;
	private String area;
	private String role;
	
	@Builder
	public NewUserDto(String username, String password, String gender, String name, String phone, String area, String role) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.phone = phone;
		this.area = area;
		this.role = role;
	}
	
	
}

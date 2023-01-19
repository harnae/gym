package com.example.gymProject.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NewUserDto {
	private String username;
	private String password;
	private String gender;
	private String nameKanji;
	private String nameKana;
	private String phone;
	private String postCode;
	private String areaDetail;
	private String area;
	private String role;
	
	@Builder
	public NewUserDto(String username, String password, String gender, String nameKanji, String nameKana, String phone,
			String postCode, String areaDetail, String area, String role) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.nameKanji = nameKanji;
		this.nameKana = nameKana;
		this.phone = phone;
		this.postCode = postCode;
		this.areaDetail = areaDetail;
		this.area = area;
		this.role = role;
	}
	
	
	
	
	
	
	
	
	
	
	
}

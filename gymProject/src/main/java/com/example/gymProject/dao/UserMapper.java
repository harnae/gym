package com.example.gymProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.gymProject.dto.LoginUser;
import com.example.gymProject.dto.NewUserDto;


@Mapper
public interface UserMapper {
	
	@Select("select username, password, role from user_info where username = #{username}")
	public LoginUser login(String username);
	
	
	@Insert("Insert into user_info(username, password, nameKanji, nameKana, gender, phone, postCode, area, role)"
			+ " values(#{username}, #{password}, #{nameKanji}, #{nameKana}, #{gender}, #{phone}, #{postCode}, #{area}, #{role})")
	public void save(NewUserDto user);
}

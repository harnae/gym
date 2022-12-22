package com.example.gymProject.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.gymProject.form.NewUser;

@Mapper
public interface NewUserDao {
	@Insert("INSERT INTO test2 (id, password, name, phone, addr, role) VALUES (#{username}, #{password}, #{name}, #{phone}, #{addr}, #{role})")
	void newUser(NewUser newUser);
}

package com.example.gymProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.gymProject.form.ListForm;


@Mapper
public interface ListDao {
	@Select("SELECT * FROM test1")
	List<ListForm> allListSelect();
}
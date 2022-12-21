package com.example.gymProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gymProject.form.ListForm;


@Mapper
public interface ListDao {
	List<ListForm> allListSelect();
}

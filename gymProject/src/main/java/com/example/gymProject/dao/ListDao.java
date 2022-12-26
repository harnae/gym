package com.example.gymProject.dao;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.gymProject.form.ListForm;


@Mapper
public interface ListDao {
	@Select("SELECT * FROM test1")
	Collection<ListForm> allListSelect();

	@Select("SELECT count(*) FROM test1")
	Integer listCount();

	@Select("SELECT * FROM test1 LIMIT #{startList}, #{listSize}")
	Collection<ListForm> allListSelect2(
			@Param("startList") Integer startList, @Param("listSize") Integer listSize);

	@Select("SELECT * FROM test1 WHERE name LIKE #{searchWord} LIMIT #{startList}, #{listSize}")
	Collection<ListForm> searchedList(
			@Param("searchWord") String searchWord,
			@Param("startList") Integer startList, @Param("listSize") Integer listSize);

	@Select("SELECT count(*) FROM test1 WHERE name LIKE #{searchWord}")
	Integer searchListCount(@Param("searchWord") String searchWord);

}

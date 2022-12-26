package com.example.gymProject.dao;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import com.example.gymProject.form.UserInfoForm;

@Mapper
public interface UserInfoDao {
	@Select("SELECT cardNo, id, name, phone, addr, gender, startTime, endTime FROM test1 WHERE cardNo = #{cardNo}")
	Collection<UserInfoForm> getUserInfo(@Param("cardNo") Integer cardNo);


	@Transactional
	@Update("UPDATE test1 SET name = #{name}, addr = #{addr}, phone = #{phone} WHERE cardNo = #{cardNo}")
	void changeInfo(@Param("name") String name, @Param("addr") String addr, @Param("phone") String phone,
			@Param("cardNo") Integer cardNo);


	@Transactional
	@Update("UPDATE test1 SET password = #{password} WHERE cardNo = #{cardNo}")
	void changePassword(@Param("password") String password, @Param("cardNo") Integer cardNo);
}

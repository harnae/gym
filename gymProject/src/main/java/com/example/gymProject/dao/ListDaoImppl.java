package com.example.gymProject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.gymProject.form.ListForm;

public class ListDaoImppl implements ListDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ListForm> allListSelect() {
		List<ListForm> list = sqlSession.selectList("listMapper.allListSelect");
		return list;
	}

}

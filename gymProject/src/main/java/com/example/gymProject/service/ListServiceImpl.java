package com.example.gymProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymProject.dao.ListDao;
import com.example.gymProject.form.ListForm;

@Service
public class ListServiceImpl implements ListService {
	@Autowired
	ListDao listDao;
	@Override
	public List<ListForm> getUserList() {
		List<ListForm> aa = listDao.allListSelect();
		return aa;
	}

	@Override
	public Integer getListCount() {
		Integer count = listDao.listCount();
		return count;
	}


}

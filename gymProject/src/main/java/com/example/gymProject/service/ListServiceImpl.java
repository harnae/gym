package com.example.gymProject.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymProject.common.Paging;
import com.example.gymProject.dao.ListDao;
import com.example.gymProject.form.ListForm;

@Service
public class ListServiceImpl implements ListService {
	@Autowired
	ListDao listDao;
	@Override
	public Collection<ListForm> getUserList(Paging paging) {

		//Collection<ListForm> userList = listDao.allListSelect();
		Collection<ListForm> userList2 = listDao.allListSelect2(paging.getStartList(),paging.getListSize());
		//System.out.println("userlist2 = " + userList2);

		return userList2;
	}

	@Override
	public Paging getListCount(int page, int range) {
		Integer count = listDao.listCount();
		Paging paging = new Paging();
		if (count < 1) {
			//System.out.println("listService =");
			paging.pageInfo(1,1,1);
			return paging;
		}
		paging.pageInfo(page, range, count);
		return paging;
	}

	@Override
	public Collection<ListForm> getSearchedList(String searchWord, Paging paging) {
		String r = "%" + searchWord + "%";
		Collection<ListForm> searchedList = listDao.searchedList(
				r, paging.getStartList(),paging.getListSize());
		//System.out.println("search = "+searchedList);
		return searchedList;
	}

	@Override
	public Paging getSearchListCount(int page, int range, String word) {
		Integer count = listDao.searchListCount(word);
		Paging paging = new Paging();
		if (count < 1) {
			//System.out.println("listService =");
			paging.pageInfo(1,1,1);
			return paging;
		}
		paging.pageInfo(page, range, count);
		return paging;
	}


}

package com.example.gymProject.service;

import java.util.Collection;

import com.example.gymProject.common.Paging;
import com.example.gymProject.form.ListForm;

public interface ListService {
	public Collection<ListForm> getUserList(Paging paging);
	public Paging getListCount(int page, int range);
	public Collection<ListForm> getSearchedList(String word, Paging paging);
	public Paging getSearchListCount(int page, int range, String word);
}

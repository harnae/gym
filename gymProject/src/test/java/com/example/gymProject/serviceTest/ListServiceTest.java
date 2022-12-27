package com.example.gymProject.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gymProject.common.Paging;
import com.example.gymProject.dao.ListDao;
import com.example.gymProject.form.ListForm;
import com.example.gymProject.service.ListServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class ListServiceTest {
	@InjectMocks
	ListServiceImpl listService;

	@Mock
	ListDao listDao;



	@Test
	void getUserListTest() {
		Paging page = new Paging();
		page.pageInfo(1, 1, 1);
		Collection<ListForm> list = listDao.allListSelect2(page.getStartList(), page.getListSize());
		assertNotNull(list);
	}
}

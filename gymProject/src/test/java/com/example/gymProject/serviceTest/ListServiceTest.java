package com.example.gymProject.serviceTest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
	Paging page;

	@Mock
	ListDao listDao;

	static List<ListForm> list2 = new ArrayList<ListForm>();

	@BeforeAll
	static void makeList() {
		ListForm list = new ListForm();
		list.setCardNo("1");
		list.setGender("man");
		list.setName("abcd");
		list.setPhone("000-0000-0000");
		ListForm list3 = new ListForm();
		list3.setCardNo("2");
		list3.setGender("man");
		list3.setName("greger");
		list3.setPhone("010-0000-0000");

		list2.add(list);
		list2.add(list3);

	}


	@Test
	void getUserListTest() {
//		Paging page = new Paging();
//		page.pageInfo(1, 1, 1);
//		Collection<ListForm> list = listDao.allListSelect2(page.getStartList(), page.getListSize());
//		assertNotNull(list);
//		verify(listDao.allListSelect2(page.getStartList(), page.getListSize()), atLeast(1));

		page.pageInfo(anyInt(), anyInt(), anyInt());

		when(listService.getUserList(page)).thenReturn(list2);

		Collection<ListForm> testList = listService.getUserList(page);
		ListForm list = new ListForm();
		list.setCardNo("1");
		list.setGender("man");
		list.setName("abcd");
		list.setPhone("000-0000-0000");
		Assertions.assertThat(list).isEqualTo(testList.toArray()[1]);



	}
}

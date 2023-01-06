package com.example.gymProject.controllerTest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.gymProject.common.Paging;
import com.example.gymProject.controller.ListController;
import com.example.gymProject.form.ListForm;
import com.example.gymProject.service.ListService;

@WebMvcTest(ListController.class)
@AutoConfigureMockMvc
public class ListControllerTest {
	@MockBean
	ListService listService;

	@Autowired
	MockMvc mvc;


	@Test
	void testListPage() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/"))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().contentType("html"));
//		mvc.perform(MockMvcRequestBuilders.get("/list/list"))
//			.andExpect(MockMvcResultMatchers.view().name("/list/list"));
		Paging page = new Paging();
		page.pageInfo(1, 1, 1);
		ListForm list = new ListForm();
		list.setCardNo("1");
		list.setGender("man");
		list.setName("abcd");
		list.setPhone("000-0000-0000");
		List<ListForm> list2 = new ArrayList<ListForm>();
		list2.add(list);
		given(listService.getUserList(page)).willReturn(list2);

//		when(listService.getUserList(page))
//			.thenReturn(list2);

		mvc.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(contains("1")));
	}
}

package com.mjk.thymeleafTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mjk.thymeleafTest.dao.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	UserDAO userDAO;
	
	public void testUserAll() throws Exception {
		mockMvc.perform(get("/userAll")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testUserSelect() throws Exception {
		String id = "kim123";
		userDAO.searchText(id);
		mockMvc.perform(get("/userSelect")).andExpect(status().isOk()).andDo(print());
	}

}

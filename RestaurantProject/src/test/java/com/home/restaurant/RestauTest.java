package com.home.restaurant;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.home.controller.RestauController;

@RunWith(SpringRunner.class)
@WebMvcTest(RestauController.class)
//@SpringBootTest
class RestauTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void list() throws Exception {
		mvc.perform(get("/restau"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Bob zip")));
	}
}

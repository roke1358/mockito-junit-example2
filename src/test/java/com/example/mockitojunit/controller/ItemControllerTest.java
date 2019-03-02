package com.example.mockitojunit.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mockitojunit.model.Item;
import com.example.mockitojunit.service.ItemBusinessService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Autowired
	private MockMvc mockMvc;


	@Test
	public void findOne_basic() throws Exception {
		
		Item item = new Item(2,"Item 2", 5, 20);
		when(businessService.findOne(anyInt())).thenReturn(Optional.of(item));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"name\":\"Item 2\",\"price\":5,\"quantity\":20}"))
				.andReturn();			
	}

	
	
	@Test
	public void getAllItem_basic() throws Exception {
		
		when(businessService.findAllItems()).thenReturn(Arrays.asList(new Item(2,"Item 2", 5,20)));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/All")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"name\":\"Item 2\",\"price\":5,\"quantity\":20}]"))
				.andReturn();			
	}
}

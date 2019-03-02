package com.example.mockitojunit.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.mockitojunit.model.Item;
import com.example.mockitojunit.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	ItemBusinessService itemBusinessService;
	
	@Mock
	ItemRepository itemRepository;

	//Testing findAllItems()
	//Testing business logic
	@Test
	public void findAllItems_basic() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(
				new Item(1,"Item 1",10,10), 
				new Item(2,"Item 2",25,5)));
		
		List<Item> items = itemBusinessService.findAllItems();
		
		//Test business logic output
		assertEquals(100,items.get(0).getValue());
		assertEquals(125,items.get(1).getValue());
	}

}

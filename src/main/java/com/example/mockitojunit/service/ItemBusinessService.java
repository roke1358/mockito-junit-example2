package com.example.mockitojunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mockitojunit.model.Item;
import com.example.mockitojunit.repository.ItemRepository;

@Component
public class ItemBusinessService {
	
	
	@Autowired
	private ItemRepository itemRepository;

	public Item getHardcodedItem() {
		return new Item(1, "ball", 10, 100);		
	}
	
	public List<Item> findAllItems() {
		
		return itemRepository.findAll();
	}
	
	public Item findOne(int id) {
		
		return itemRepository.getOne(id);
	}
}

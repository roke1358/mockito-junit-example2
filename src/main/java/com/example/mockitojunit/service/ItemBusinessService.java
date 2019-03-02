package com.example.mockitojunit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mockitojunit.model.Item;
import com.example.mockitojunit.repository.ItemRepository;

@Component
public class ItemBusinessService {
	
	
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> findAllItems() {
		
		List<Item> items = itemRepository.findAll();
		
		//Business logic
		for(Item item:items) {
			item.setValue(item.getQuantity() * item.getPrice());
		}
		
		return items;
	}
	
	public Optional<Item> findOne(int id) {
		
		Optional<Item> item = itemRepository.findById(id); 
		return item;
		
	}
}

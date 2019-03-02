package com.example.mockitojunit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mockitojunit.model.Item;
import com.example.mockitojunit.service.ItemBusinessService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService itemBusinessService;
	
	@GetMapping("/All")
	public List<Item> getAllItems() {
		
		List<Item> items = itemBusinessService.findAllItems();
		
		//Business logic
		for(Item item:items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		return items;
	}
	
	@GetMapping("/item/{id}")
	public Optional<Item> findOne(@PathVariable String id) {
		
		Optional<Item> item = itemBusinessService.findOne(Integer.parseInt(id));
		
		return item;
		
	}
}

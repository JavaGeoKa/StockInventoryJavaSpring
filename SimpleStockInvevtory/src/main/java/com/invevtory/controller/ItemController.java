package com.invevtory.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.invevtory.dto.ItemDto;
import com.invevtory.dto.ItemsCountDto;
import com.invevtory.service.ItemService;



@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
		
	@PostMapping
	public boolean addPerson(@RequestBody ItemDto itemDto) {
		return itemService.addItem(itemDto);
	}
	
	@GetMapping("/{id}")
	public ItemDto findPersonById(@PathVariable Integer id) {
		return itemService.findItemById(id);
	}
	
	@GetMapping("/count/{name}")
	public ItemsCountDto getPost(@PathVariable String name) {
		return itemService.getCount(name);
	}
}

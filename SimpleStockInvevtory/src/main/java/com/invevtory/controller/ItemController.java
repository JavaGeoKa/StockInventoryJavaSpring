package com.invevtory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.invevtory.dto.ItemDto;
import com.invevtory.service.ItemService;



@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
		
	@PostMapping
	public boolean addItem(@RequestBody ItemDto itemDto) {
		return itemService.addItem(itemDto);
	}
	
	@GetMapping("/find/{code}")
	public ItemDto findItem(@PathVariable String code) {
		return itemService.findItem(code);
	}
	
	@DeleteMapping("/delete/{code}")
	public ItemDto deleteItem(@PathVariable String code) {
		return itemService.deleteItem(code);
	}
	
	
	
	
	
	@GetMapping("/quantity/{name}")
	public int countByName(@PathVariable String name) {
		return itemService.quantityByName(name);
	}
	
	
	@GetMapping("/getall")
	public Iterable<ItemDto> getAllItems () {
		return itemService.getAllItems();
	}

	@GetMapping("/totalamount")
	public long getTotalAmount () {
		return itemService.getTotalAmount();
	}
	
	@GetMapping("/totalamountbyname/{name}")
	public long getTotalAmountByName (@PathVariable String name) {
		return itemService.getTotalAmountByName(name);
	}
	
	
}

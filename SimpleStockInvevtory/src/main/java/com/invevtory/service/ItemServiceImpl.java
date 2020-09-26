package com.invevtory.service;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invevtory.dao.ItemRepository;
import com.invevtory.dto.ItemDto;
import com.invevtory.model.Item;




@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	//Add item 
	@Transactional
	@Override
	public boolean addItem(ItemDto itemDto) {	
		Item item = modelMapper.map(itemDto, Item.class);
		if (itemRepository.existsById(item.getCode() )) { return false;
		} else { 
		itemRepository.save(item);
		return true;}
	}

	//Find item by inventory code
	@Transactional(readOnly = true)
	@Override
	public ItemDto findItem(String code) {
		if (!itemRepository.existsById(code)) { return null;
		} else { 
		Item item = itemRepository.findById(code).orElse(null);
		return modelMapper.map(item, ItemDto.class);}
	}
	
	//Delete item by invevtory code
	@Transactional
	@Override
	public ItemDto deleteItem(String code) {
		if (!itemRepository.existsById(code)) { return null;
		} else { 
		Item item = itemRepository.findById(code).orElse(null);
		itemRepository.delete(item);
		return modelMapper.map(item, ItemDto.class);}
	}

	//Get quantity items by type (name)
	@Transactional
	@Override
	public int quantityByName(String name) {
		return  itemRepository.findAllByName(name)
				.collect(Collectors.toList())
				.size();
		}

	//Get all items 
	@Transactional
	@Override
	public Iterable<ItemDto> getAllItems() {
		return itemRepository.findAll().stream()
				.map(i -> modelMapper.map(i, ItemDto.class))
				.collect(Collectors.toList());
	}

	
	//Get total amount of items in stock 
	@Transactional
	@Override
	public long getTotalAmount() {
		return itemRepository.findAll().stream()
				.mapToInt(i -> i.getAmount())
				.sum();
	}
	
	
	//Get total amount of items in stock by name
		@Transactional
		@Override
		public long getTotalAmountByName(String name) {
			return itemRepository.findAllByName(name)			
					.mapToInt(i -> i.getAmount())
					.sum();
		}
	


}
	
	
	
	
	
	
	
	
	

	


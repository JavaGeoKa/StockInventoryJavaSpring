package com.invevtory.service;

import com.invevtory.dto.ItemDto;

public interface ItemService {

	boolean addItem(ItemDto itemDto);

	ItemDto deleteItem(String code);
	
	ItemDto findItem(String code);

	int quantityByName(String name);

	Iterable<ItemDto> getAllItems();

	long getTotalAmount();

	long getTotalAmountByName(String name);

	
	
}

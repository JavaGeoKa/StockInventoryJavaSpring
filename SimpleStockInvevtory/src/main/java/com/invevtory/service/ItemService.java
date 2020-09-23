package com.invevtory.service;

import com.invevtory.dto.ItemDto;
import com.invevtory.dto.ItemsCountDto;

public interface ItemService {

	boolean addItem(ItemDto itemDto);
	
	ItemDto findItemById(Integer id);

	ItemsCountDto getCount(String name);
	
	
}

package com.invevtory.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invevtory.dao.ItemRepository;
import com.invevtory.dto.ItemDto;
import com.invevtory.dto.ItemsCountDto;
import com.invevtory.model.Item;






@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public boolean addItem(ItemDto itemDto) {
		Item item = modelMapper.map(itemDto, Item.class);
		itemRepository.save(item);
		return true;
	}
	
	
	@Override
	public ItemDto findItemById(Integer id) {
		Item item = itemRepository.findById(id).orElse(null);
		return modelMapper.map(item, ItemDto.class);
	}

//========================================
	@Override
	public ItemsCountDto getCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
//TODO
//	@Override
//	public ItemsCountDto getCount(String name) {
//		Item item = itemRepository.findByName(name);  //.orElseThrow(()-> new PostNotFoundException(id));
//		return ItemsCountDto.builder()
//				.name(item.getName())
//				.count(item.getCount())
//				.build();
//		
//	}

//	@Override
//	public PostDto getPost(String id) {
//		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
//		return convertToPostDto(post);
	
	
}

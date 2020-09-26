package com.invevtory.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invevtory.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {


	Stream<Item> findAllByName(String name);


}

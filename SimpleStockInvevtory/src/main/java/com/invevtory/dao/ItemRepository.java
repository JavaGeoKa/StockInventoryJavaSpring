package com.invevtory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invevtory.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}

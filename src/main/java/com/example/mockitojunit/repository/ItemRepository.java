package com.example.mockitojunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockitojunit.model.Item;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}

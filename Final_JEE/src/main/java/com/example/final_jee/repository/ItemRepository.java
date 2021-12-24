package com.example.final_jee.repository;

import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();
    Item findById(Long id);
    Item findByPrice(double price);
    Item findbyName(String name);
    Item createItem(String name, Double price);
    Item deleteItemById(int id);
}

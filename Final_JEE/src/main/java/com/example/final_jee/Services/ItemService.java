package com.example.final_jee.Services;

import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;
import com.example.final_jee.repository.ItemRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class ItemService {
    @Inject
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item getItemByPrice(double price) {
        return itemRepository.findByPrice(price);
    }

    public Item getItemByName(String name) {
        return itemRepository.findbyName(name);
    }

    public Item deleteItemById(int id) {
        return itemRepository.deleteItemById(id);
    }

    public Item createItem(String name, Double price ) {
        return itemRepository.createItem(name, price);
    }

}

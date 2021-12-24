package com.example.final_jee.repository;

import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;
import com.example.final_jee.models.User;

import java.util.List;

public interface GoodRepository {
    List<Good> findAll();
    Good findById(Long id);
    Good findByPrice(double price);
    Good updatePrice(int id, Double price);
    Good findbyName(String name);
    Good createGood(String name, Double price);
    Good deleteGoodById(int id);
}

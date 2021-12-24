package com.example.final_jee.repository;

import com.example.final_jee.models.Cost;

import java.util.List;

public interface CostRepository {
    List<Cost> findAll();
    Cost findById(int id);
    Cost deleteCostById(int id);
    Cost createCost(int id, Double price, String disc);
    Cost updateCost(int id, Double price);
}

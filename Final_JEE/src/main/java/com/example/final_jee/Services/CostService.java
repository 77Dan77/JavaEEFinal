package com.example.final_jee.Services;

import com.example.final_jee.models.Cost;
import com.example.final_jee.repository.CostRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class CostService {
    @Inject
    CostRepository costRepository;

    public List<Cost> getAllCosts() {
        return costRepository.findAll();
    }

    public Cost getCostById(int id) {
        return costRepository.findById(id);
    }

    public Cost createCost(int id, Double price, String disc) {
        return costRepository.createCost(id, price, disc);
    }

    public Cost deleteCostById(int id) {
        return costRepository.deleteCostById(id);
    }

    public Cost updateCost(int id, Double price) {
        return costRepository.updateCost(id, price);
    }
}

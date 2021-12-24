package com.example.final_jee.Services;

import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;
import com.example.final_jee.models.User;
import com.example.final_jee.repository.GoodRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class GoodService {
    @Inject
    GoodRepository goodRepository;


    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    public Good getGoodById(Long id) {
       return goodRepository.findById(id);
    }

    public Good getGoodByPrice(double price) {
        return goodRepository.findByPrice(price);
    }

    public Good getGoodByName(String name) {
        return goodRepository.findbyName(name);
    }

    public Good createGood(String name, Double price) {
        return goodRepository.createGood(name, price);
    }

    public Good deleteGoodById(int id) {
        return goodRepository.deleteGoodById(id);
    }

    public Good updatePrice(int id, Double price) {
        return goodRepository.updatePrice(id, price);
    }


}

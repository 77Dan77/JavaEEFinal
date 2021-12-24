package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.*;
import com.example.final_jee.repository.ItemRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Item> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT i FROM Item i");
        List<Item> result = query.getResultList();
        return result;
    }

    @Override
    public Item findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT i FROM Item i WHERE i.id = %d", id);
        Query query = entityManager.createQuery(sql);
        Item result = (Item) query.getSingleResult();
        return result;
    }

    @Override
    public Item findByPrice(double price) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT i FROM Item i WHERE i.price = %d", price); ///////////////////////
        Query query = entityManager.createQuery(sql);
        Item result = (Item) query.getSingleResult();
        return result;
    }

    @Override
    public Item findbyName(String name) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT i FROM Item i WHERE name = ", name);
        Query query = entityManager.createQuery(sql);
        Item result = (Item) query.getSingleResult();
        return result;
    }

    @Override
    public Item createItem(String name, Double price) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Item item = new Item();
            item.setName(name);
            item.setPrice(price);
            List<Good> goods = (List<Good>) entityManager.find(Good.class, 1);
            item.setGoods(goods);
            entityManager.persist(item);
            return item;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Item deleteItemById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Item item = entityManager.find(Item.class, id);
            entityManager.remove(item);
            return item;
        } catch (NoResultException e){
            return null;
        }
    }
}

package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Cost;
import com.example.final_jee.models.Good;
import com.example.final_jee.models.Item;
import com.example.final_jee.models.User;
import com.example.final_jee.repository.GoodRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class GoodRepositoryImpl implements GoodRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Good> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT g FROM Good g");
        List<Good> result = query.getResultList();
        return result;
    }

    @Override
    public Good findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT g FROM Good g WHERE g.id = %d", id);
        Query query = entityManager.createQuery(sql);
        Good result = (Good) query.getSingleResult();
        return result;
    }

    @Override
    public Good findByPrice(double price) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT g FROM Good g WHERE g.price = %d", price); ///////////////////////
        Query query = entityManager.createQuery(sql);
        Good result = (Good) query.getSingleResult();
        return result;
    }

    @Override
    public Good findbyName(String name) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT g FROM Good g WHERE name = ", name);
        Query query = entityManager.createQuery(sql);
        Good result = (Good) query.getSingleResult();
        return result;
    }

    @Override
    public Good createGood(String name, Double price){
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Good good = new Good();
            good.setName(name);
            good.setPrice(price);
            List<Item> goods = (List<Item>) entityManager.find(Item.class, 1);
            good.setItems(goods);
            User user = entityManager.find(User.class, 1);
            good.setUser(user);
            entityManager.persist(good);
            return good;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Good deleteGoodById(int id){
            javax.persistence.EntityManager entityManager = em.manager();
            try {
                Good good = entityManager.find(Good.class, id);
                entityManager.remove(good);
                return good;
            } catch (NoResultException e){
                return null;
            }
        }

    @Override
    public Good updatePrice(int id, Double price) {
        javax.persistence.EntityManager entityManager = em.manager();
        Good good = entityManager.find(Good.class, id);
        good.setPrice(price);
        entityManager.persist(good);
        return good;
    }

}

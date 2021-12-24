package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.*;
import com.example.final_jee.repository.CostRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CostRepositoryImpl implements CostRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Cost> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT c FROM Cost c");
        List<Cost> result = query.getResultList();
        return result;
    }

    @Override
    public Cost findById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT c FROM Cost c WHERE c.id = %d", id);
        Query query = entityManager.createQuery(sql);
        Cost result = (Cost) query.getSingleResult();
        return result;
    }

    @Override
    public Cost createCost(int id, Double price, String disc){
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Cost cost = new Cost(id, price, disc);
            entityManager.persist(cost);
            return cost;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Cost deleteCostById(int id){
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Cost cost = entityManager.find(Cost.class, id);
            entityManager.remove(cost);
            return cost;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Cost updateCost(int id, Double price) {
        javax.persistence.EntityManager entityManager = em.manager();
        Cost cost = entityManager.find(Cost.class, id);
        cost.setCost(price);
        entityManager.persist(cost);
        return cost;
    }
}

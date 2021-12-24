package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Role;
import com.example.final_jee.repository.RoleRepository;

import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Role> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT r FROM Role r");
        List<Role> result = query.getResultList();
        return result;
    }

    @Override
    public Role findByName(String name) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT r FROM Role r WHERE name = ", name);
        Query query = entityManager.createQuery(sql);
        Role result = (Role) query.getSingleResult();
        return result;
    }
}

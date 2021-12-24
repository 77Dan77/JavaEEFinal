package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Userdetail;
import com.example.final_jee.repository.UserdetailRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserdetailRepositoryImpl implements UserdetailRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Userdetail> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT u FROM Userdetail u");
        List<Userdetail> result = query.getResultList();
        return result;
    }

    @Override
    public Userdetail findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT u FROM Userdetail u WHERE u.id = %d", id);
        Query query = entityManager.createQuery(sql);
        Userdetail result = (Userdetail) query.getSingleResult();
        return result;
    }

    @Override
    public Userdetail findByFname(String fname){
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT u FROM Userdetail u WHERE u.fname = ", fname);
        Query query = entityManager.createQuery(sql);
        Userdetail result = (Userdetail) query.getSingleResult();
        return result;
    }

    @Override
    public Userdetail deleteById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Userdetail userdetail = entityManager.find(Userdetail.class, id);
            entityManager.remove(userdetail);
            return userdetail;
        } catch (NoResultException e){
            return null;
        }
    }

}

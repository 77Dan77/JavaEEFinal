package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Role;
import com.example.final_jee.models.User;
import com.example.final_jee.repository.UserRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Inject
    EntityManager em;

    @Override
    public List<User> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT u FROM User u");
        System.out.println(query.getResultList());
        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public User findById(Long id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT u FROM User u WHERE u.id = %d", id);
        Query query = entityManager.createQuery(sql);
        User result = (User) query.getSingleResult();
        return result;
    }

    @Override
    public User deleteById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            return user;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User createUser(String login, String password) {
        javax.persistence.EntityManager entityManager = em.manager();
        try{
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            Role role = entityManager.find(Role.class, 1);
            user.setRole(role);
            entityManager.persist(user);
            return user;
        } catch(NoResultException e) {
            return null;
        }
    }


}

package com.example.final_jee.Utils;

import com.example.final_jee.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateless
public class EntityManager {

    public javax.persistence.EntityManager manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dan");

        javax.persistence.EntityManager em = emf.createEntityManager();
        return em;
    }


}

package com.example.final_jee.RepositoryImpl;

import com.example.final_jee.Utils.EntityManager;
import com.example.final_jee.models.Comment;
import com.example.final_jee.models.Cost;
import com.example.final_jee.models.Role;
import com.example.final_jee.models.User;
import com.example.final_jee.repository.CommentRepository;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    @Inject
    EntityManager em;

    @Override
    public List<Comment> findAll() {
        javax.persistence.EntityManager entityManager = em.manager();
        Query query = entityManager.createQuery("SELECT c FROM Comment c");
        List<Comment> result = query.getResultList();
        return result;
    }

    @Override
    public Comment findById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        String sql = String.format("SELECT c FROM Comment c WHERE c.id = %d", id);
        Query query = entityManager.createQuery(sql);
        Comment result = (Comment) query.getSingleResult();
        return result;
    }

    @Override
    public Comment createComment(String comm) {
        javax.persistence.EntityManager entityManager = em.manager();
        try{
            Comment comment = new Comment();
            comment.setComment(comm);
            User user = entityManager.find(User.class, 1);
            comment.setUser(user);
            entityManager.persist(comment);
            return comment; /////////////////////////////////////////////
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public Comment deleteCommentById(int id) {
        javax.persistence.EntityManager entityManager = em.manager();
        try {
            Comment comment = entityManager.find(Comment.class, id);
            entityManager.remove(comment);
            return comment;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Comment updateComment(int id, String comment) {
            javax.persistence.EntityManager entityManager = em.manager();
            Comment comment1 = entityManager.find(Comment.class, id);
            comment1.setComment(comment);
            entityManager.persist(comment1);
            return comment1;

    }
}

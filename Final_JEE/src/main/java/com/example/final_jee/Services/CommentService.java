package com.example.final_jee.Services;

import com.example.final_jee.models.Comment;
import com.example.final_jee.repository.CommentRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class CommentService {
    @Inject
    CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(String comment) {
        return commentRepository.createComment(comment);
    }

    public Comment deleteCommentById(int id) {
        return commentRepository.deleteCommentById(id);
    }

    public Comment updateComment(int id, String comment){
        return commentRepository.updateComment(id, comment);
    }

}

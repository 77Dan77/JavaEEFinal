package com.example.final_jee.repository;

import com.example.final_jee.models.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> findAll();
    Comment findById(int id);
    Comment deleteCommentById(int id);
    Comment createComment(String comment);
    Comment updateComment(int id, String comment);
}

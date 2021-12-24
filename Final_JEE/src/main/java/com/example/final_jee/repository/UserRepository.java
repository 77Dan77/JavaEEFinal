package com.example.final_jee.repository;

import com.example.final_jee.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User deleteById(int id);
    User createUser(String login, String password);

}

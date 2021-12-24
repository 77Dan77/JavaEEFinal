package com.example.final_jee.repository;

import com.example.final_jee.models.Role;

import java.util.List;

public interface RoleRepository {
    List<Role> findAll();
    Role findByName(String name);
}

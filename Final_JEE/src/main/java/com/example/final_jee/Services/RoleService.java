package com.example.final_jee.Services;

import com.example.final_jee.models.Role;
import com.example.final_jee.repository.RoleRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class RoleService {
    @Inject
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}

package com.example.final_jee.Services;
import com.example.final_jee.models.User;
import com.example.final_jee.repository.UserRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(String login, String pass){
        return userRepository.createUser(login,pass);
    }

    public User deleteUser(int id){
        return userRepository.deleteById(id);
    }
}

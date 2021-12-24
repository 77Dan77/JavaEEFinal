package com.example.final_jee.Services;

import com.example.final_jee.models.Userdetail;
import com.example.final_jee.repository.UserdetailRepository;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.List;

@Stateful
public class UserdetailService {
    @Inject
    UserdetailRepository userdetailRepository;

    public List<Userdetail> getAllUserdetails() {
        return userdetailRepository.findAll();
    }

    public Userdetail getUserdetailById(Long id) {
        return userdetailRepository.findById(id);
    }

    public Userdetail getUserdetailByName(String name) {
        return userdetailRepository.findByFname(name);
    }

    public Userdetail deleteByid(int id) {
        return userdetailRepository.deleteById(id);
    }
}

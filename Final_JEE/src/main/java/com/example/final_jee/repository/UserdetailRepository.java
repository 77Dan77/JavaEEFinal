package com.example.final_jee.repository;

import com.example.final_jee.models.Userdetail;

import java.util.List;

public interface UserdetailRepository {
    List<Userdetail> findAll();
    Userdetail findById(Long id);
    Userdetail findByFname(String fname);
    Userdetail deleteById(int id);
}

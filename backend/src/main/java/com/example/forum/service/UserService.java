package com.example.forum.service;

import java.util.List;
import com.example.forum.dto.User;

public interface UserService {
    List<User>findAll();      //this find all is different from find all of mongodb but we are making new find all method

    User findOne(int id);    //By Id

    void save(User user); 
}

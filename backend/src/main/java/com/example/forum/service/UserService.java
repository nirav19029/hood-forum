package com.example.forum.service;

import java.util.List;
import com.example.forum.dto.User;

public interface UserService {
    List<User>findAll();

    User findOne(int id);

    User findByUserName(String username);

    User save(User user); 
    
}

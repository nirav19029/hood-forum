package com.example.forum.service.user;

import java.util.ArrayList;
import java.util.List;
import com.example.forum.dto.User;

public interface UserService {
    ArrayList<User>findAll();      //this find all is different from find all of mongodb but we are making new find all method

    User findByUserId(String id) throws Exception;    //By Id

    void save(User user); 
    User findByUserEmail(String email) throws Exception;
}

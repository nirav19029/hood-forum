package com.example.forum.service.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.dto.User;
import com.example.forum.repositoryservices.user.UserRepositoryService;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public ArrayList<User>findAll(){
        return userRepositoryService.findAll();
    }

    @Override
    public User findByUserId(String id) throws Exception {
        User user =  userRepositoryService.findByUserId(id);
        return user ;
    }

    @Override
    public User findByUserEmail(String email) throws Exception {

        return userRepositoryService.findByUserEmail(email);
    }

    @Override
    public void save(User user) {
        userRepositoryService.save(user);
    }
    
}

package com.example.forum.repositoryservices.user;

import java.util.ArrayList;

import com.example.forum.dto.User;

public interface UserRepositoryService {
    public User findByUserId(String id) throws Exception;

    public ArrayList<User> findAll();

    public void save(User user);

    public User findByUserEmail(String email);

}

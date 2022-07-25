package com.example.forum.repositoryservices;

import java.util.List;

import com.example.forum.dto.User;

public interface UserRepositoryService {
    public User findOne(int id);

    public List<User> findAll();

    public void save(User user);

}

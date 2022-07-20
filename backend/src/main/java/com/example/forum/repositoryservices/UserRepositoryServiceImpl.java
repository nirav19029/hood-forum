package com.example.forum.repositoryservices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.forum.dto.User;
import com.example.forum.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import javax.inject.Provider;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Override
    public User findOne(int id) {
        
        return null;
    }

    @Override
    public User findByUserName(String username) {
        
        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

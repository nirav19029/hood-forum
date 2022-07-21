package com.example.forum.repositoryservices;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.forum.dto.User;
import com.example.forum.models.UserEntity;
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
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> user=new ArrayList<>();
        for(UserEntity tempEntity:userEntities){
            User user1=modelMapperProvider.get().map(tempEntity, User.class);
            user.add(user1);
        }
        return user;
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
    }
    
}

package com.example.forum.repositoryservices.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.forum.dto.User;
import com.example.forum.models.UserEntity;
import com.example.forum.repository.UserRepository;

import org.modelmapper.ModelMapper;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

    private ModelMapper modelMapper ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    UserRepositoryServiceImpl(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public User findByUserId(String id) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()){
            return modelMapper.map(userEntity, User.class);
        }else{
            throw new Exception("User Not found");
        }
        
    }

    @Override
    public ArrayList<User> findAll() {
        List<UserEntity> userEntity = userRepository.findAll();
        ArrayList<User> user=new ArrayList<>();
        for(UserEntity tempEntity:userEntity){
            User user1=modelMapper.map(tempEntity, User.class);
            user.add(user1);
        }
        return user;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userRepository.save(userEntity);

    }
    
}

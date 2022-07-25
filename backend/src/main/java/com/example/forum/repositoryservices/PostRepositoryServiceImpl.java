package com.example.forum.repositoryservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;
import com.example.forum.repository.PostRepository;


@Service
public class PostRepositoryServiceImpl implements PostRepositoryService{

    private ModelMapper modelMapper ;


    @Autowired
    PostRepository postRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    // @Autowired
    // private Provider<ModelMapper> modelMapperProvider;
    PostRepositoryServiceImpl(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<Post> getAllPost() {
        List<PostEntity> postEntity = postRepository.findAll();
        List<Post> post = new ArrayList<>();
        for(PostEntity tempEntity:postEntity){
            Post post1 = modelMapper.map(tempEntity, Post.class);
            post.add(post1);
        }
        return post;
    }

    @Override
    public Post createPost(Post post) {
        PostEntity postEntity = modelMapper.map(post, PostEntity.class);
        
        postRepository.save(postEntity);

        return post ;
        
    }

    @Override
    public Post findById(String id) throws Exception{
        Optional<PostEntity> postEntity = postRepository.findById(id);

        if(postEntity.isPresent()){
            return modelMapper.map(postEntity.get(), Post.class);
        }else{
            throw new Exception("Id not present");
        }
    }

    @Override
    public String delete(String id) throws Exception {
        Optional<PostEntity> postEntity = postRepository.findById(id);
        if(postEntity.isPresent()){
            postRepository.deleteById(id);
            return "Post Deleted";
        }else{
            throw new Exception("Id not present");
        }
    }
    
}

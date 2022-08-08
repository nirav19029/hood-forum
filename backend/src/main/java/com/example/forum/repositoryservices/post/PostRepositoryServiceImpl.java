package com.example.forum.repositoryservices.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

// import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;
import com.example.forum.repository.PostRepository;
import com.mongodb.client.result.DeleteResult;


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
        
        PostEntity createdEntity =  postRepository.save(postEntity);

        Post createdPost =  modelMapper.map(createdEntity, Post.class) ;


        return createdPost ;
        
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
            Query query = new Query();            //For the query parameter
            query.addCriteria(Criteria.where("_id").is(id));  //key- postId, value- Input vaue in postId parameter
            DeleteResult postEntity1 = mongoTemplate.remove(query,PostEntity.class);
            if(postEntity1.wasAcknowledged()){
                return "Post Deleted";
            }
        }
        throw new Exception("PostId not present");
    }



    @Override
    public Post updatePost(Map<String, Object> updates,String id) throws IllegalArgumentException {
        Optional<PostEntity> postEntity = postRepository.findById(id);
        if(postEntity.isPresent()){

            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            Update updatequery = new Update();
            FindAndModifyOptions option =  new FindAndModifyOptions().returnNew(true).upsert(false);
            for (Map.Entry<String, Object> entry  : updates.entrySet()) {
                updatequery.set(entry.getKey(),entry.getValue());
            }
            mongoTemplate.findAndModify(query, updatequery,option,PostEntity.class);
            return null;
        }
        else
        throw new IllegalArgumentException("postId not present");
       
       
    }
    
}

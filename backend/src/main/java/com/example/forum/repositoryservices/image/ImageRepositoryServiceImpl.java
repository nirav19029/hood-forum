package com.example.forum.repositoryservices.image;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.forum.dto.Image;
import com.example.forum.models.ImageEntity;
import com.example.forum.repository.ImageRepository;

@Service
public class ImageRepositoryServiceImpl implements ImageRepositoryService {
    private ModelMapper modelMapper;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // @Autowired
    // private Provider<ModelMapper> modelMapperProvider;
    ImageRepositoryServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Image getImage(String postId) {
        ImageEntity imageEntity = imageRepository.findByPostid(postId);
        Image image = modelMapper.map(imageEntity, Image.class);
        return image;
    }

    @Override
    public Image addImage(Image image) {
        ImageEntity imageEntity = modelMapper.map(image, ImageEntity.class);

        imageRepository.save(imageEntity);

        return image;

    }

    @Override
    public String delete(String postId) throws Exception {
        // Optional<ImageEntity> postEntity = imageRepository.findByPostId(postId);
        // if (postEntity.isPresent()) {
        // postRepository.deleteById(id);
        // return "Post Deleted";
        // } else {
        // throw new Exception("Id not present");
        // }
        return "not functional";
    }
}

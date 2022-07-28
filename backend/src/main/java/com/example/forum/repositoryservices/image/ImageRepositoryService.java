package com.example.forum.repositoryservices.image;

import java.util.List;

import com.example.forum.dto.Image;

public interface ImageRepositoryService {
    public Image getImage(String postId);

    public Image addImage(Image image);

    public String delete(String postId) throws Exception;
}

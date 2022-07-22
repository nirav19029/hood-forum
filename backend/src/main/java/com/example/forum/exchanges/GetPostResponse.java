package com.example.forum.exchanges;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.forum.dto.Post;
import com.example.forum.models.PostEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPostResponse {
    List<Post>post;
}

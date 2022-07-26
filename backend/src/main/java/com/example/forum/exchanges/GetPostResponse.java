package com.example.forum.exchanges;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import com.example.forum.dto.Post;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPostResponse {
    List<Post>post;
}

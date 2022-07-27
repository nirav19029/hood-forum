package com.example.forum.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

class Like {
    private String userId;
}

@Data
@Document(collection="comment")
@NoArgsConstructor
public class CommentEntity {

    @Field("_id")
    private String commentId;

    private String userId;
    private String postId;
    private String createdOn;
    private String description;
    private Like[] likes ;
}

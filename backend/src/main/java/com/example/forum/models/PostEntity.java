package com.example.forum.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection="post")
@NoArgsConstructor
public class PostEntity {
    @Id
    private int userId;         //primary-Key
    private int id;
    private String createdOn;
    private String description;
    private String title;
    private String reply;
}

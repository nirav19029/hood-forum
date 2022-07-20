package com.example.forum.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection="post")
@NoArgsConstructor
public class postEntity {
    @Id
    private String userId;         //primary-Key
    private String createdOn;
    private String description;
    private String title;
    private String reply;
}

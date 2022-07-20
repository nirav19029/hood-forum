package com.example.forum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="user")
public class userEntity {
    @NonNull
    private String userId;
    private String userName;
    private String password;
    private String refreshToken;
    private String NumberOfPosts;
    private String number;
}

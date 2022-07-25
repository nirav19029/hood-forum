package com.example.forum.dto;

import lombok.Data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String email;
    private String username;
    private String password;
    private boolean active;
    private boolean removed;
    private Date createdAt;

}

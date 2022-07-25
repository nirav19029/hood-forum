package com.example.forum.utils;

import java.util.Set;

import com.example.forum.dto.Post;
import com.example.forum.dto.User;

public class UserProfile {
    private User user;
    
    /*Importing the posts make by user and Topic */
    private Set<Post> posts;
    
    
    public UserProfile() {}
    
    public UserProfile(User user,
                       Set<Post> posts) {
        super();
        this.user = user;
        this.posts = posts;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Set<Post> getPosts() {
        return posts;
    }
    
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}

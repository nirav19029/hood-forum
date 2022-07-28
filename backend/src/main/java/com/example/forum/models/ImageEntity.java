package com.example.forum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.NonNull;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "image")
public class ImageEntity {
    @NonNull
    private String postid;
    @Field("_id")
    private String imageid;
    private String name;
    private String path;
}

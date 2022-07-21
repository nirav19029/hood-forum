package com.example.forum.models;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

// import org.springframework.data.annotation.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


class Like {
    private String useId;
}


class Reply{

    private String userId;
    private String postId;

    private String description;


    private Like[] likes  ;


}



@Data
@Document(collection="post")
@NoArgsConstructor
public class PostEntity{
    private String title;
    // @Id
    // @JsonIgnore

    @Field("_id")
    private String postId;

    private String userId;
    private String createdOn;
    private String description;

    private ArrayList<Reply> replies ;
}

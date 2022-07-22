package com.example.forum.models;

import java.time.Instant;
import java.util.ArrayList;
// import java.util.Date;

import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;
// import org.springframework.data.mongodb.core.aggregation.DateOperators.DateAdd;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

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

class Upload {
    private String fileId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    //Constructor 
    public Upload(String fileName,String fileType, byte[] data){
        this.fileName=fileName;
        this.fileType=fileType;
        this.data = data;
    }
    
}



@Data
@Document(collection="post")
@NoArgsConstructor
public class PostEntity{
    private String title;

    @Field("_id")
    private String postId;

    private String userId;

    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    // @CreatedDate
    private String createdOn;
    private String description;

    private ArrayList<Reply> replies ;

    private ArrayList<Upload> upload;
}

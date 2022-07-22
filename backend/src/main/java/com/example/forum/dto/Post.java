//Data transfere object 
//Main Logic
package com.example.forum.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



class Like {
    private String useId;
}


class Reply{

    private String userId;
    private String postId;

    private String description;


    private Like[] likes  ;

}

/**
 * ifile */
class upload {
    private String fileId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    //Constructor 
    public upload(String fileName,String fileType, byte[] data){
        this.fileName=fileName;
        this.fileType=fileType;
        this.data = data;
    }
    
}



@Data
@NoArgsConstructor
public class Post{
    private String title;
    @Id
    @JsonIgnore    
    @JsonProperty("_id")
    private String postId;
    private String userId;

    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    // @CreatedDate
    private String createdOn;
    private String description;

    private ArrayList<Reply> replies ;

    // figure out how media is encrypted or stored in request object.

    private ArrayList<upload> upload;


}
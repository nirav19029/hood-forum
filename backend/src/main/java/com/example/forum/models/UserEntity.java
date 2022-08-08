/*
 * For Connecting User Entity Model to the database
 */
package com.example.forum.models;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Document(collection="user")
@Data
public class UserEntity {
 
    @NotNull
    @NotBlank
    private String name ;
    @NotNull
    @NotBlank
    private String email ;
    @NotNull
    @NotBlank
    private String image_url ;

   @Id
    private String userId ;

}

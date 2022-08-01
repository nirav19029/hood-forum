/*
 * For Connecting User Entity Model to the database
 */
package com.example.forum.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
// import javax.persistence.OneToOne;
// import javax.persistence.PrimaryKeyJoinColumn;
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

/*
 * For Connecting User Entity Model to the database
 */
package com.example.forum.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// import javax.persistence.OneToOne;
// import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Data
@Document(collection="user")
@NoArgsConstructor
public class UserEntity {
    @Id                                                      //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //To automaticall generate the primary key value     //GenerationType.IDENTITY is used to auto-increment the id 
    private int userId;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(length = 30, nullable = false, unique = true)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean active;

    private boolean removed;

    private Date createdAt;

    // private Date lastLoginTime;

    // @OneToOne
    // @PrimaryKeyJoinColumn
    // private UserAdditionalInfo info;
}

package com.example.forum.exchanges;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data

public class PostRequestBody{
    
    @NotEmpty(message = "title must not be empty")
    @NotNull(message = "title must not be null")
    private String title;

    @NotEmpty(message = "useId must not be empty")
    @NotNull(message = "useId must not be null")
    private String userId;

    @NotEmpty(message = "description must not be empty")
    @NotNull(message = "description must not be null")
    private String description;


    

}
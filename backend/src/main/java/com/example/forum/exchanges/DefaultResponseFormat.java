package com.example.forum.exchanges;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class DefaultResponseFormat{

    
    
    private int statusCode  = 500  ;
    private String message  = "Default error Message |  server phat gya hai ";
    private List<String> errors ;

    
    

}

package com.example.forum.exchanges;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

import com.example.forum.dto.post;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class getPostResponse {
    List<post>post;
}

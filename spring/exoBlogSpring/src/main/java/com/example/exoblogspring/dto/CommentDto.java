package com.example.exoblogspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private int id;
    private String name;
    private String email;
    private String content;
    private int postId;


}

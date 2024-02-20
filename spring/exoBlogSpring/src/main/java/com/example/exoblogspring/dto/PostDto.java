package com.example.exoblogspring.dto;

import com.example.exoblogspring.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private int id;
    private String title;
    private String description;
    private String content;
    private List<CommentDto> comments;



}


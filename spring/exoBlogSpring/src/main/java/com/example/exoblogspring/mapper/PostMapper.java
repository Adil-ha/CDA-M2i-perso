package com.example.exoblogspring.mapper;

import com.example.exoblogspring.dto.CommentDto;
import com.example.exoblogspring.dto.PostDto;
import com.example.exoblogspring.entity.Comment;
import com.example.exoblogspring.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public PostDto toDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        // Convertir la liste d'entités Comment en liste de DTO CommentDto si nécessaire
        // dto.setComments(post.getComments().stream().map(CommentMapper::toDto).collect(Collectors.toList()));

        return dto;
    }

    public  Post toEntity(PostDto dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());

        // Convertir la liste de DTO CommentDto en liste d'entités Comment si nécessaire
        // post.setComments(dto.getComments().stream().map(CommentMapper::toEntity).collect(Collectors.toList()));

        return post;
    }
}



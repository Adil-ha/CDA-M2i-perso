package com.example.exoblogspring.mapper;

import com.example.exoblogspring.dto.CommentDto;
import com.example.exoblogspring.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {


    public CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setContent(comment.getContent());
        // Convertir l'entité Post en DTO PostDto si nécessaire
        // dto.setPostDto(PostMapper.toDto(comment.getPost()));
        return dto;
    }

    public Comment toEntity(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setName(dto.getName());
        comment.setEmail(dto.getEmail());
        comment.setContent(dto.getContent());
        // Convertir le DTO PostDto en entité Post si nécessaire
//         comment.setPost(PostMapper.toEntity(dto.getPostDto()));
        return comment;
    }
}


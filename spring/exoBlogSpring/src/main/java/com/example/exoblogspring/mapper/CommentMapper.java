package com.example.exoblogspring.mapper;

import com.example.exoblogspring.dto.CommentDto;
import com.example.exoblogspring.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "post.id", target = "postId")
    CommentDto commentToCommentDto(Comment comment);

    @Mapping(source = "postId", target = "post.id")
    Comment commentDtoToComment(CommentDto commentDto);

    List<CommentDto> commentsToCommentDtos(List<Comment> comments);

    List<Comment> commentDtosToComments(List<CommentDto> commentDtos);
}


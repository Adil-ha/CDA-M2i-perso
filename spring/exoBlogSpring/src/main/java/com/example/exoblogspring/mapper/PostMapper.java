package com.example.exoblogspring.mapper;

import com.example.exoblogspring.dto.PostDto;
import com.example.exoblogspring.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "commentaires", target = "comments")
    PostDto postToPostDto(Post post);

    @Mapping(source = "comments", target = "commentaires")
    Post postDtoToPost(PostDto postDto);

    List<PostDto> postsToPostDtos(List<Post> posts);

    List<Post> postDtosToPosts(List<PostDto> postDtos);
}

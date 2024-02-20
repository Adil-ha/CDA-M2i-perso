package com.example.exoblogspring.service;

import com.example.exoblogspring.dto.PostDto;
import com.example.exoblogspring.entity.Post;
import com.example.exoblogspring.mapper.PostMapper;
import com.example.exoblogspring.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private final IPostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(IPostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.map(postMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    @Override
    public PostDto save(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public PostDto update(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        if (post.getId() <= 0) {
            throw new IllegalArgumentException("Invalid Post ID");
        }
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public void delete(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        postRepository.delete(post);
    }
}



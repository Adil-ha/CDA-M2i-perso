package com.example.exoblogspring.service;

import com.example.exoblogspring.dto.PostDto;

import java.util.List;

public interface IPostService {
    List<PostDto> findAll();

    PostDto findById(int id);

    PostDto save(PostDto postDto);

    PostDto update(PostDto postDto);

    void delete(PostDto postDto);
}


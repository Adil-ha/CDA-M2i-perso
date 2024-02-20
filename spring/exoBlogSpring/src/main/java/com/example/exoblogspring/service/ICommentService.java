package com.example.exoblogspring.service;

import com.example.exoblogspring.dto.CommentDto;

import java.util.List;

public interface ICommentService {
    List<CommentDto> findAll();

    CommentDto findById(int id);

    CommentDto save(CommentDto commentDto);

    CommentDto update(CommentDto commentDto);

    void delete(int id);
}



package com.example.exoblogspring.service;

import com.example.exoblogspring.dto.CommentDto;
import com.example.exoblogspring.entity.Comment;
import com.example.exoblogspring.mapper.CommentMapper;
import com.example.exoblogspring.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {

    private final ICommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(ICommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(int id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.map(commentMapper::toDto).orElse(null);
    }

    @Override
    public CommentDto save(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto update(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public void delete(int id) {
        commentRepository.deleteById(id);
    }
}



package com.example.exoblogspring.controller.rest;

import com.example.exoblogspring.dto.CommentDto;
import com.example.exoblogspring.dto.PostDto;
import com.example.exoblogspring.service.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {

    private final ICommentService commentService;

    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/comments/{id}")
    public CommentDto getCommentById(@PathVariable int id) {
        return commentService.findById(id);
    }

    @PostMapping("/posts/{id}/comments/")
    public CommentDto createComment(@PathVariable("id") int postId, @RequestBody CommentDto commentDto) {
        PostDto postDto = new PostDto();
        postDto.setId(postId);
        commentDto.setPostDto(postDto);

        return commentService.save(commentDto);
    }

    @PutMapping("/comments/{id}")
    public CommentDto updateComment(@PathVariable int id, @RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        return commentService.update(commentDto);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.delete(id);
    }
}



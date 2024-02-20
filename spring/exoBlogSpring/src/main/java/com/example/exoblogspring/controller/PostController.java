package com.example.exoblogspring.controller;

import com.example.exoblogspring.dto.PostDto;
import com.example.exoblogspring.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class PostController {

    private final IPostService postService;

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.findById(id);
    }

    @PostMapping("/posts")
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @PutMapping("/posts/{id}")
    public PostDto updatePost(@PathVariable int id, @RequestBody PostDto postDto) {
        postDto.setId(id);
        return postService.update(postDto);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable int id) {
        PostDto postDto = postService.findById(id);
        if (postDto != null) {
            postService.delete(postDto);
        }
    }
}

package com.example.exoblogspring.repository;

import com.example.exoblogspring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Integer> {
}

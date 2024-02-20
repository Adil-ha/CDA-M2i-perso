package com.example.exoblogspring.repository;

import com.example.exoblogspring.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}

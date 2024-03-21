package com.example.todospringsecurity.repository;

import com.example.todospringsecurity.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

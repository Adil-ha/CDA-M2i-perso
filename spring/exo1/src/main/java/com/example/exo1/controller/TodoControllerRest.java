package com.example.exo1.controller;

import com.example.exo1.entity.Todo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class TodoControllerRest {




    @GetMapping(value = "todos")
    public List<Todo> getAllTodos(){
        Todo todo1 = new Todo(1,"sport", "Faire du sport", false);
        Todo todo2 = new Todo(2,"travail", "Aller au sport", false);

        return List.of(todo1, todo2);
    }

    @GetMapping(value= "todo")
    public Todo getTodo(){
        return new Todo(8,"test1", "description", true);
    }



}

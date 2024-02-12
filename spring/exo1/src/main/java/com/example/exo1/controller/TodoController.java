package com.example.exo1.controller;

import com.example.exo1.entity.Todo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.ArrayList;

@Controller
public class TodoController {

    @GetMapping
    public String home(){
        return "home";
    }



    @RequestMapping("/home/todo")
    public String getAllTodos(Model model) {
        Todo todo1 = new Todo(1, "sport", "Faire du sport", false);
        Todo todo2 = new Todo(2, "travail", "Aller au travail", false);
        Todo todo3 = new Todo(3, "travail", "Aller au travail", false);

        List<Todo> todos = List.of(todo1, todo2, todo3);

        model.addAttribute("todos", todos);

        return "todo/todos";
    }

    @GetMapping(value = "/home/details")
    public String getOneTodo(Model model) {
        Todo todo = new Todo(5,"test5", "description5",true);
        model.addAttribute(todo.getTitle());
        model.addAttribute(todo.getDescription());
        if(todo.isDone()){
            model.addAttribute("status","finis");
        }else {
            model.addAttribute("status", "en cours");
        }

        return "todo/details";
    }



}

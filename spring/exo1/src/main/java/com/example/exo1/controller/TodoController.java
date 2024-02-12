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

    private List<Todo> todos = new ArrayList<>();

    @RequestMapping("/home/todo")
    public String getAllTodos(Model model) {
        Todo todo1 = new Todo(1,"sport", "Faire du sport", false);
        Todo todo2 = new Todo(2,"travail", "Aller au travail", false);
        Todo todo3 = new Todo(3,"travail", "Aller au travail", false);

        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);

        model.addAttribute("todos", todos);

        return "todo/todos";
    }

    @GetMapping(value = "/todos/{id}")
    public String getTodoById(@PathVariable("id") Long id, Model model) {
        Todo foundTodo = null;
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                foundTodo = todo;
                break;
            }
        }
        if (foundTodo != null) {
            model.addAttribute("todo", foundTodo);
            return "todo/details";
        } else {
            return "error/not_found";
        }
    }



}

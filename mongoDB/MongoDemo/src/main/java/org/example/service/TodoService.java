package org.example.service;

import org.example.dao.impl.TodoDao;
import org.example.model.TodoItem;

import java.util.List;

public class TodoService {

    private TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void addTodo(TodoItem todoItem){
        todoDao.addTodo(todoItem);
    }

    public List<TodoItem> getAllTodos(){
        return todoDao.getAllTodos();
    }
}

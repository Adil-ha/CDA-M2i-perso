package org.example.dao.impl;

import org.example.model.TodoItem;

import java.util.List;

public interface TodoDao {

    void addTodo(TodoItem todoitem);

    List<TodoItem> getAllTodos();
}

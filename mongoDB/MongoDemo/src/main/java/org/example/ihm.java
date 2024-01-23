package org.example;

import org.example.service.TodoService;

import java.util.Scanner;

public class ihm {

    private TodoService todoService;

    private Scanner scanner;

    public ihm(TodoService todoService, Scanner scanner) {
        this.todoService = todoService;
        this.scanner = scanner;
    }


}

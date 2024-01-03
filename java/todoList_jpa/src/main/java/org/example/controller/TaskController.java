package org.example.controller;

import org.example.model.Task;
import org.example.dao.TaskDAO;

import java.util.List;

public class TaskController {
    private TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void addTask(Task task) {
        taskDAO.addTask(task);
    }

    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    public void markTaskAsCompleted(Long taskId) {
        taskDAO.markTaskAsCompleted(taskId);
    }

    public void removeTask(Long taskId) {
        taskDAO.removeTask(taskId);
    }
}


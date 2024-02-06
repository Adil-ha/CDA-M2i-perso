package com.example.todolist.service;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.util.HibernateSession;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TodoService {

    private final TodoRepository todoRepository;

    @Inject
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoDto.toEntity();
        Session session = HibernateSession.getSessionFactory().openSession();
        todoRepository.setSession(session);
        session.beginTransaction();
        try {
            todoRepository.create(todo);
            session.getTransaction().commit();
            return todo.toDto();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }finally {
            session.close();
        }
    }

    public TodoDto findById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            return todo.toDto();
        }
    }

    public List<TodoDto> findAll() {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            todoRepository.setSession(session);
            return todoRepository.findAll().stream()
                    .map(todo ->todo.toDto())
                    .collect(Collectors.toList());
        }
    }

    public TodoDto changeStatus(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            todo.setStatus(!todo.isStatus());
            todoRepository.update(todo);
            session.getTransaction().commit();
            return todo.toDto();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    public boolean delete(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            todoRepository.setSession(session);
            Todo todo = todoRepository.findById(id);
            todoRepository.delete(todo);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

}

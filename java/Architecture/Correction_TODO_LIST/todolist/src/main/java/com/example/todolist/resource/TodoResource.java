package com.example.todolist.resource;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("todos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    public List<TodoDto> get() {
        return todoService.findAll();
    }

    @GET
    @Path("{id}")
    public TodoDto get(@PathParam("id") Long id) {
        return todoService.findById(id);
    }

    @POST
    public TodoDto post(TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PATCH
    @Path("{id}")
    public TodoDto patchStatus(@PathParam("id") Long id) {
        return todoService.changeStatus(id);
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
        return todoService.delete(id);
    }
}

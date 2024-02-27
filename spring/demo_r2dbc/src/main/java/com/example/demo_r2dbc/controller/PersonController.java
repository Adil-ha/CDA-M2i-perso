package com.example.demo_r2dbc.controller;


import com.example.demo_r2dbc.dao.PersonDAO;
import com.example.demo_r2dbc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @PostMapping
    public Mono post(@RequestBody Person person) {
        return personDAO.add(person.getFirstname(), person.getLastname());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get() {
        return personDAO.getAll();
    }

    @DeleteMapping("{id}")
    public Mono delete(@PathVariable("id") int id) {
        return personDAO.delete(id);
    }

    @PutMapping("{id}")
    public Mono update(@PathVariable("id") int id, @RequestBody Person updatedPerson) {
        return personDAO.update(id, updatedPerson.getFirstname(), updatedPerson.getLastname());
    }
}

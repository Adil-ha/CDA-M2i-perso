package com.example.base_spring.service;

import com.example.base_spring.model.Rabbit;

import java.util.List;
import java.util.UUID;

public interface IRabbitService {
    List<Rabbit> getRabbits();
    Rabbit getRabbitById(UUID id);
    Rabbit addRabbit(Rabbit rabbit);
    Rabbit getRabbitByName(String name);
}

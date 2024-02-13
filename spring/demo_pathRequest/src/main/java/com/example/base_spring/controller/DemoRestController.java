package com.example.base_spring.controller;


import com.example.base_spring.model.Rabbit;
import com.example.base_spring.service.IRabbitService;
import com.example.base_spring.service.RabbitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {

    private final IRabbitService rabbitService;


    @GetMapping
    public List<Rabbit> getAllRabbit(){
        return rabbitService.getRabbits();
    }

    @PostMapping("/rabbits")
    public Rabbit addRabbit(@RequestBody Rabbit rabbit){
        return rabbitService.addRabbit(rabbit);
    }

    @GetMapping("/look")
    public ResponseEntity<Rabbit> showRabbit(@RequestParam(value = "name", required = false) String name) {
        Rabbit rabbit = rabbitService.getRabbitByName(name);
        if (rabbit != null) {
            return ResponseEntity.ok(rabbit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}

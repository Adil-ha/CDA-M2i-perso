package com.example.base_spring.controller;


import com.example.base_spring.model.Rabbit;
import com.example.base_spring.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final RabbitService rabbitService;

    @GetMapping
    public String homePage(){
        return "pagea";
    }

    @GetMapping("/pageb")
    public String pageb(Model model){
        List<Rabbit> rabbits = rabbitService.getRabbits();
        model.addAttribute("rabbits", rabbits);
        return "pageb";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model){
        Rabbit rabbit = rabbitService.getRabbitById(id);
        model.addAttribute("monlapin",rabbit);
        return "pagec";
    }


}

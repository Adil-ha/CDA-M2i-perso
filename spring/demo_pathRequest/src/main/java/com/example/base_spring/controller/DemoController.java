package com.example.base_spring.controller;


import com.example.base_spring.model.Rabbit;
import com.example.base_spring.service.IRabbitService;
import com.example.base_spring.service.RabbitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final IRabbitService rabbitService;

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

    @GetMapping("/add")
    public String addRabbit(Model model){
        model.addAttribute("rabbit",new Rabbit());
        return "form/form";
    }

    @PostMapping("/add")
    public String submitRabbit(@ModelAttribute("rabbit") Rabbit rabbit){
        rabbitService.addRabbit(rabbit);
        return "redirect:/pageb";
    }



    @GetMapping("/look")
    public String showRabbit(@RequestParam("name") String name, Model model) {
        Rabbit rabbit = rabbitService.getRabbitByName(name);
        model.addAttribute("monlapin", rabbit);
        return "pagec";
    }

}

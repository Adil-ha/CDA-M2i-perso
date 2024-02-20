package com.example.exosession.controller;

import com.example.exosession.entity.User;
import com.example.exosession.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class LoginController {

    private LoginService service;

    @GetMapping("/login")
    public String getLogin(){
        return "form-login";
    }



    @PostMapping("/verif")
    public String login(@RequestParam String login, @RequestParam String password) {
        if (service.login(login,password)){
            return "success";
        }
        return "login";

    }

    @GetMapping("/protected")
        public String prtectedPage(){
            if(service.isLogged()){
                return "success";
            }
            return "redirect:/login";
        }
}

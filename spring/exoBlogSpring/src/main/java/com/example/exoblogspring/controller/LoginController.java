package com.example.exoblogspring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/http-session")
public class LoginController {
    @Autowired
    private HttpSession _httpSession;

    @GetMapping("/login")
    public String getFormLogin(){
        return "form-login";
    }
}

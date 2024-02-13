package com.example.exostudentspring.controller;

import com.example.exostudentspring.model.Student;
import com.example.exostudentspring.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/listing")
    public String getAllStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "listing";
    }

    @GetMapping("/detail/{studentId}")
    public String detailStudent(@PathVariable("studentId") UUID id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("MyStudent",student);
        return "detail";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "form/form";
    }

    @PostMapping("/add")
    public String submitStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/listing";
    }

    @GetMapping("/look")
    public String showStudent(@RequestParam(value = "name", required = false) String name, Model model) {
        List<Student> students = studentService.searchStudentByName(name);
        model.addAttribute("MyStudent", students);
        return "detail";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }



}

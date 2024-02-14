package com.example.exostudentspring.controller;

import com.example.exostudentspring.model.Student;
import com.example.exostudentspring.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentControllerRest {
    private final IStudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable("studentId") UUID id){
        return studentService.getStudentById(id);

    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/look")
    public ResponseEntity<Student> showStudent(@RequestParam(value = "name", required = false) String name) {
        Student student = studentService.searchStudentByName(name);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UUID> deletePost(@PathVariable UUID id) {

        boolean isRemoved = studentService.deleteStudentById(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

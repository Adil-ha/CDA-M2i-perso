package com.example.exostudentspring.service;

import com.example.exostudentspring.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentService {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(UUID id);
    Student updateStudent(UUID id, Student student);
    boolean deleteStudentById(UUID id);
    List<Student> searchStudentByName(String name);

}

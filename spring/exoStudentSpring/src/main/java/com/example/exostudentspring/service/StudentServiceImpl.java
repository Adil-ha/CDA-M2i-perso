package com.example.exostudentspring.service;

import com.example.exostudentspring.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {
    private final Map<UUID, Student> students;

    public StudentServiceImpl() {
        students = new HashMap<>();
        initializeStudents();
    }

    private void initializeStudents() {
        Student student1 = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Doe")
                .firstname("John")
                .age(20)
                .email("john.doe@example.com")
                .build();
        students.put(student1.getId(), student1);

        Student student2 = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Smith")
                .firstname("Alice")
                .age(22)
                .email("alice.smith@example.com")
                .build();
        students.put(student2.getId(), student2);

        Student student3 = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Johnson")
                .firstname("Bob")
                .age(21)
                .email("bob.johnson@example.com")
                .build();
        students.put(student3.getId(), student3);

        Student student4 = Student.builder()
                .id(UUID.randomUUID())
                .lastname("Brown")
                .firstname("Emily")
                .age(23)
                .email("emily.brown@example.com")
                .build();
        students.put(student4.getId(), student4);
    }

    @Override
    public Student createStudent(Student student) {
        UUID id = UUID.randomUUID();
        student.setId(id);
        students.put(id, student);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Student getStudentById(UUID id) {
        return students.get(UUID.fromString(id.toString()));
    }

    @Override
    public Student updateStudent(UUID id, Student student) {
        if (students.containsKey(UUID.fromString(id.toString()))) {
            student.setId(UUID.fromString(id.toString()));
            students.put(UUID.fromString(id.toString()), student);
            return student;
        }
        return null;
    }

    @Override
    public boolean deleteStudentById(UUID id) {
        return students.remove(UUID.fromString(id.toString())) != null;
    }

//    @Override
//    public List<Student> searchStudentByName(String name) {
//        return students.values().stream()
//                .filter(student -> student.getLastname().equalsIgnoreCase(name) || student.getFirstname().equalsIgnoreCase(name))
//                .collect(Collectors.toList());
//    }
@Override
public List<Student> searchStudentByName(String name) {
    List<Student> foundStudents = new ArrayList<>();
    for (Student student : students.values()) {
        if (student.getFirstname().equals(name) || student.getLastname().equals(name)) {
            foundStudents.add(student);
        }
    }
    return foundStudents;
}
}


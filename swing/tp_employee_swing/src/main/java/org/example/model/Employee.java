package org.example.model;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private Role role;


    public Employee(int id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role= role;
    }
    public Employee(String name, Role role) {
        this.name = name;
        this.role= role;
    }
}

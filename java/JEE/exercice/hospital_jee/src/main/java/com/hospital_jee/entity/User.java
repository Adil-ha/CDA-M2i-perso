package com.hospital_jee.entity;

import javax.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name="T_User")
public class User {
    private Long id;

    private String email;

    private String name;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}

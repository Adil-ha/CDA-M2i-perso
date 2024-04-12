package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private Gender gender;
    private int age;
    private BloodGroup bloodGroup;
    private String phoneNumber;
    private Qualification qualification;
    private Date startDate;
    private String address;
    private String photoUrl;
}

package com.hospital_jee.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="T_Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }
}


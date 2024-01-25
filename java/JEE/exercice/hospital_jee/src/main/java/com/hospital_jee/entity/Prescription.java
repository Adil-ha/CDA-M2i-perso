package com.hospital_jee.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="T_Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicationType;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}


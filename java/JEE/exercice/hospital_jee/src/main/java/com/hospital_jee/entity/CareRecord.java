package com.hospital_jee.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="T_CareRecord")
public class CareRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String careType;
    private int duration;


    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}


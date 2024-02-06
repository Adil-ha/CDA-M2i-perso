package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient> {
    public PatientRepository() {

    }

    @Override
    Patient findById(int id) {
        return session.get(Patient.class, id);
    }

    @Override
    List<Patient> findAll() {
        return session.createQuery("from Patient ").list();
    }
}

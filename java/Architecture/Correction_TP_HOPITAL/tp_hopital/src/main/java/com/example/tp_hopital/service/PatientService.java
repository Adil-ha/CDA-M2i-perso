package com.example.tp_hopital.service;

import com.example.tp_hopital.entity.Patient;
import com.example.tp_hopital.exception.RepositoryException;
import com.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PatientService {
    Repository<Patient> patientRepository;
    SessionFactory sessionFactory;
    public PatientService(SessionFactory sessionFactory, Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
        this.sessionFactory = sessionFactory;
    }

    public boolean createPatient(String name, String phone) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        Patient patient = Patient.builder()
                .name(name)
                .phone(phone)
                .build();
        session.beginTransaction();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }

        return result;
    }
}

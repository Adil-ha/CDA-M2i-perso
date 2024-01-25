package com.hospital_jee.service;

import com.hospital_jee.entity.Consultation;
import com.hospital_jee.entity.Patient;
import com.hospital_jee.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {
    @Override
    public boolean create(Patient patient) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Patient patient) {

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public boolean delete(Patient patient) {

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(patient);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public Patient findById(int id) {
        Patient patient = null;
        session = sessionFactory.openSession();
        patient = (Patient) session.get(Patient.class, id);
        session.close();
        return patient;
    }


    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        patientList = patientQuery.list();
        session.close();
        return patientList;

    }

    public List<Patient> searchByName(String name) {
        try {
            session = sessionFactory.openSession();
            Query<Patient> query = session.createQuery("FROM Patient WHERE firstName LIKE :name OR lastName LIKE :name", Patient.class);
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Consultation> getMedicalRecordForPatient(int patientId) {
        try  {
            session = sessionFactory.openSession();
            Query<Consultation> query = session.createQuery(
                    "SELECT c FROM Consultation c WHERE c.patient.id = :patientId", Consultation.class);
            query.setParameter("patientId", patientId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }



}

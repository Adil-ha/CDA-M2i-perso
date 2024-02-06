package com.example.tp_hopital.controller;

import com.example.tp_hopital.repository.PatientRepository;
import com.example.tp_hopital.service.PatientService;
import com.example.tp_hopital.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.hibernate.Session;


@WebServlet(name = "patient", value = "/patient/consultation")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;


    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory(), new PatientRepository());
    }

}

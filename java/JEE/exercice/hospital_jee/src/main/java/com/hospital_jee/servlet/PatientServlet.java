package com.hospital_jee.servlet;

import com.hospital_jee.entity.Patient;
import com.hospital_jee.service.PatientService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {
    private PatientService service;

    @Override
    public void init() throws ServletException {
        service = new PatientService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged") : false;

        if (logged) {

            String action = req.getServletPath();
            try {
                switch (action) {
                    case "/new":
                        showNewForm(req, resp);
                        break;
                    case "/insert":
                        insertPatient(req, resp);
                        break;
                    case "/delete":
                        deletePatient(req, resp);
                        break;
                    case "/details":
                        showPatient(req, resp);
                        break;
                    case "/list":
                        listPatient(req, resp);
                        break;
                    default:
                        listPatient(req, resp);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }

    private void listPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("patients", service.findAll());
        request.getRequestDispatcher("patients.jsp").forward(request,response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("patient-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        Part imagePart = request.getPart("image");

        String fileType = imagePart.getContentType();

        if(fileType.equalsIgnoreCase("image/png")){

            byte[] imageBytes = null;
            if (imagePart != null) {
                InputStream inputStream = imagePart.getInputStream();
                imageBytes = inputStream.readAllBytes();
            }
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("firstName");

            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dob"));

            Patient produit = new Patient(firstName, lastName, dateOfBirth, imageBytes);

            Integer id = request.getParameter("id") !=null ? Integer.valueOf(request.getParameter("id")) : null;

            if(id != null){
                produit.setId(id);
            }

            if(service.create(produit)) {
                response.sendRedirect("list");
            }else{
                response.sendRedirect("form-produit.jsp");
            }
        }else{
            response.sendRedirect("form-produit.jsp");
        }
    }
    private void deletePatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient patient = service.findById(id);
        if(patient != null){
            service.delete(patient);
        }
        response.sendRedirect("list");
    }

    private void showPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Patient patient = service.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("patients", service.findAll());
            request.getRequestDispatcher("patients.jsp").forward(request,response);
        }
    }

}

package org.example.dao;

import org.example.model.Employee;
import org.example.util.ConnexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Gender;

public class EmployeeDao {
    private Connection connection;

    public EmployeeDao() {
        try {
            connection = ConnexionDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un employé
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (id, name, gender, age, bloodGroup, phoneNumber, qualification, startDate, address, photoUrl) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getGender().toString());
            statement.setInt(4, employee.getAge());
            statement.setString(5, employee.getBloodGroup());
            statement.setString(6, employee.getPhoneNumber());
            statement.setString(7, employee.getQualification());
            statement.setDate(8, new java.sql.Date(employee.getStartDate().getTime()));
            statement.setString(9, employee.getAddress());
            statement.setString(10, employee.getPhotoUrl());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les employés
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        Gender.valueOf(resultSet.getString("gender")),
                        resultSet.getInt("age"),
                        resultSet.getString("bloodGroup"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("qualification"),
                        resultSet.getDate("startDate"),
                        resultSet.getString("address"),
                        resultSet.getString("photoUrl")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Méthode pour récupérer un employé par son ID
    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            Gender.valueOf(resultSet.getString("gender")),
                            resultSet.getInt("age"),
                            resultSet.getString("bloodGroup"),
                            resultSet.getString("phoneNumber"),
                            resultSet.getString("qualification"),
                            resultSet.getDate("startDate"),
                            resultSet.getString("address"),
                            resultSet.getString("photoUrl")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Méthode pour supprimer un employé par son ID
    public void deleteEmployeeById(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour les détails d'un employé
    public void updateEmployee(Employee updatedEmployee) {
        String query = "UPDATE employees SET name = ?, gender = ?, age = ?, bloodGroup = ?, phoneNumber = ?, qualification = ?, startDate = ?, address = ?, photoUrl = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedEmployee.getName());
            statement.setString(2, updatedEmployee.getGender().toString());
            statement.setInt(3, updatedEmployee.getAge());
            statement.setString(4, updatedEmployee.getBloodGroup());
            statement.setString(5, updatedEmployee.getPhoneNumber());
            statement.setString(6, updatedEmployee.getQualification());
            statement.setDate(7, new java.sql.Date(updatedEmployee.getStartDate().getTime()));
            statement.setString(8, updatedEmployee.getAddress());
            statement.setString(9, updatedEmployee.getPhotoUrl());
            statement.setInt(10, updatedEmployee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


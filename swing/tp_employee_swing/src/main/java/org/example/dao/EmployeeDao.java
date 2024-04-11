package org.example.dao;

import org.example.model.Employee;
import org.example.model.Role;
import org.example.util.ConnexionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = ConnexionDb.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employee")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                employees.add(new Employee(id, name, Role.valueOf(role)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                employee = new Employee(id, name, Role.valueOf(role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void addEmployee(Employee employee) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (name, role) VALUES (?, ?)")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getRole().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET name = ?, role = ? WHERE id = ?")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getRole().toString());
            preparedStatement.setInt(3, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


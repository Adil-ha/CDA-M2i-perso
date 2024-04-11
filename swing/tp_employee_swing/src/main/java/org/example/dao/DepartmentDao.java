package org.example.dao;

import org.example.model.Department;
import org.example.util.ConnexionDb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = ConnexionDb.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM department")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                departments.add(new Department(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public Department getDepartmentById(int id) {
        Department department = null;
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM department WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                department = new Department(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public void addDepartment(Department department) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO department (name) VALUES (?)")) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartment(Department department) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE department SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(int id) {
        try (Connection connection = ConnexionDb.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM department WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


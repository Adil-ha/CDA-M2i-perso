package org.example.dao;

import org.example.ConnectionUtils.ConnectionUtils;
import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection connection;

    public StudentDao() {
        try {
            this.connection = ConnectionUtils.getInstance().getMySQLConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'obtention de la connexion.", e);
        }
    }

    public void addStudent(Student student) {
        try {
            String request = "INSERT INTO T_student (last_name, first_name, number_class, date_diplome) VALUES (?, ?, ?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setString(1, student.getLastName());
                statement.setString(2, student.getFirstName());
                statement.setInt(3, student.getNumberClass());
                statement.setDate(4, new java.sql.Date(student.getDateDiplome().getTime()));

                int rows = statement.executeUpdate();
                System.out.println(rows + " ligne(s) insérée(s) avec succès.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            String request = "SELECT * FROM T_student;";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(request)) {

                while (resultSet.next()) {
                    Student student = createStudentFromResultSet(resultSet);
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> getStudentsByClass(int numberClass) {
        List<Student> students = new ArrayList<>();
        try {
            String request = "SELECT * FROM T_student WHERE number_class = ?;";
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setInt(1, numberClass);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Student student = createStudentFromResultSet(resultSet);
                        students.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public void deleteStudent(int studentId) {
        try {
            String request = "DELETE FROM T_student WHERE id = ?;";
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setInt(1, studentId);

                int rows = statement.executeUpdate();
                System.out.println(rows + " ligne(s) supprimée(s) avec succès.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Student createStudentFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String lastName = resultSet.getString("last_name");
        String firstName = resultSet.getString("first_name");
        int numberClass = resultSet.getInt("number_class");
        Date dateDiplome = resultSet.getDate("date_diplome");

        return new Student(id,firstName, lastName, numberClass, dateDiplome);
    }
}
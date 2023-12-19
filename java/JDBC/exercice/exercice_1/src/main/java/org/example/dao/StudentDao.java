package org.example.dao;

import org.example.utils.DataBaseManager;
import org.example.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection connection;

    public StudentDao() throws SQLException {


        this.connection = DataBaseManager.getInstance().getMySQLConnection();

    }

    public boolean addStudent(Student student) throws SQLException {

        String request = "INSERT INTO T_student (last_name, first_name, number_class, date_diplome) VALUES (?, ?, ?, ?);";
        int rows;
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setString(1, student.getLastName());
            statement.setString(2, student.getFirstName());
            statement.setInt(3, student.getNumberClass());
            statement.setDate(4, new java.sql.Date(student.getDateDiplome().getTime()));

            rows = statement.executeUpdate();
            System.out.println(rows + " ligne(s) insérée(s) avec succès.");
        }
        return rows == 1;
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();

            String request = "SELECT * FROM T_student;";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(request)) {

                while (resultSet.next()) {
                    Student student = createStudentFromResultSet(resultSet);
                    students.add(student);
                }
            }

        return students;
    }

    public List<Student> getStudentsByClass(int numberClass) throws SQLException {
        List<Student> students = new ArrayList<>();

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

        return students;
    }


    public List<Student> getStudentsByLastName(String lastName) throws SQLException {
        List<Student> students = new ArrayList<>();
        String request = "SELECT * FROM T_student WHERE last_name = ?;";
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setString(1, lastName);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = createStudentFromResultSet(resultSet);
                    students.add(student);
                }
            }

            if (students.isEmpty()) {
                System.out.println("Aucun étudiant trouvé avec le nom : " + lastName);
            }
        }
        return students;
    }


    public boolean deleteStudent(int studentId) throws SQLException {
        String request = "DELETE FROM T_student WHERE id = ?;";
        int rowsAffected;
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setInt(1, studentId);

            rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " ligne(s) supprimée(s) avec succès.");
            } else {
                System.out.println("Aucun étudiant trouvé avec l'ID : " + studentId);
            }
        }
        return rowsAffected == 1;
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

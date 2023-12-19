package org.example.ihm;

import org.example.dao.StudentDao;
import org.example.models.Student;
import org.example.utils.DataBaseManager;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentIhm {
    private final StudentDao studentDao;
    private final Scanner scanner;

    public StudentIhm()  {

        try {
            this.studentDao = new StudentDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.scanner = new Scanner(System.in);
    }

    public void start() {
        try {
            int choice;
            do {
                displayMenu();
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        displayStudentsByClass();
                        break;
                    case 4:
                        searchStudentByLastName();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 0:
                        System.out.println("Exiting the application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } catch (ParseException | SQLException e) {
            System.out.println("Error parsing date or SQL exception: " + e.getMessage());
        } finally {
            DataBaseManager.getInstance().closeConnection();
            scanner.close();
        }
    }

    private void displayMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Display Students by Class");
        System.out.println("4. Search Student by Last Name");
        System.out.println("5. Delete Student");
        System.out.println("0. Exit");
        System.out.println("================");
    }

    private void addStudent() throws ParseException, SQLException {
        System.out.println("Merci de saisir le nom");
        String lastName = scanner.nextLine();

        System.out.println("Merci de saisir le prénom");
        String firstName = scanner.nextLine();

        System.out.println("Merci de saisir le numéro de classe ");
        int numberClass = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Merci de saisir la date de diplôme (au format dd/MM/yyyy)");
        String dateDiplomeString = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDiplome = dateFormat.parse(dateDiplomeString);

        Student newStudent = new Student();
        newStudent.setLastName(lastName);
        newStudent.setFirstName(firstName);
        newStudent.setNumberClass(numberClass);
        newStudent.setDateDiplome(dateDiplome);

        studentDao.addStudent(newStudent);
    }

    private void displayAllStudents() throws SQLException {
        List<Student> allStudents;
        try {
            allStudents = studentDao.getAllStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Liste de tous les étudiants :");
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    private void displayStudentsByClass() throws SQLException {
        System.out.println("Merci de saisir le numéro de classe pour afficher les étudiants :");
        int classToDisplay = scanner.nextInt();
        List<Student> studentsByClass = studentDao.getStudentsByClass(classToDisplay);
        System.out.println("Liste des étudiants de la classe " + classToDisplay + " :");
        for (Student student : studentsByClass) {
            System.out.println(student);
        }
    }

    private void searchStudentByLastName() throws SQLException {
        System.out.println("Merci de saisir le nom de l'étudiant à rechercher :");
        String studentLastnameToSearch = scanner.nextLine();
        List<Student> searchStudentByLastname = studentDao.getStudentsByLastName(studentLastnameToSearch);
        System.out.println("Recherche étudiants par le nom " + studentLastnameToSearch);
        for (Student student : searchStudentByLastname) {
            System.out.println(student);
        }
    }

    private void deleteStudent() throws SQLException {
        System.out.println("Merci de saisir l'ID de l'étudiant à supprimer :");
        int studentIdToDelete = scanner.nextInt();
        studentDao.deleteStudent(studentIdToDelete);
    }
}

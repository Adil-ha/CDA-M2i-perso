package org.example;

import org.example.ConnectionUtils.ConnectionUtils;
import org.example.dao.StudentDao;
import org.example.models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao ;
        studentDao = new StudentDao();

        try {

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


            List<Student> allStudents = studentDao.getAllStudents();
            System.out.println("Liste de tous les étudiants :");
            for (Student student : allStudents) {
                System.out.println(student);
            }


            System.out.println("Merci de saisir le numéro de classe pour afficher les étudiants :");
            int classToDisplay = scanner.nextInt();
            List<Student> studentsByClass = studentDao.getStudentsByClass(classToDisplay);
            System.out.println("Liste des étudiants de la classe " + classToDisplay + " :");
            for (Student student : studentsByClass) {
                System.out.println(student);
            }

            System.out.println("Merci de saisir l'ID de l'étudiant à supprimer :");
            int studentIdToDelete = scanner.nextInt();
            studentDao.deleteStudent(studentIdToDelete);

        } catch (ParseException e) {
            System.out.println("Erreur lors de la conversion de la date : " + e.getMessage());
        }finally{
            ConnectionUtils.getInstance().closeConnection();
        }
    }
}


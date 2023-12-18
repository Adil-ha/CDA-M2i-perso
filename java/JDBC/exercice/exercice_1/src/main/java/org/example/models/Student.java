package org.example.models;

import java.util.Date;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int numberClass;
    private Date dateDiplome;


    public Student() {

    }

    public Student(int id ,String firstName, String lastName, int numberClass, Date dateDiplome) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberClass = numberClass;
        this.dateDiplome = dateDiplome;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }

    public void setDateDiplome(Date dateDiplome) {
        this.dateDiplome = dateDiplome;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberClass=" + numberClass +
                ", dateDiplome=" + dateDiplome +
                '}';
    }
}


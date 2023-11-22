package org.example;

public class Student extends Person {

    public Student(int age) {
        super(age);
    }

    public void goToClass() {
        System.out.println("I'm going to class");
    }

    public void displayAge(){
        System.out.printf("My age is: %d years old",this.getAge());
    }
}

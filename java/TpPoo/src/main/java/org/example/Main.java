package org.example;


import org.example.bank.PayantCompte;
import org.example.house.Apartment;
import org.example.house.Door;
import org.example.house.House;
import org.example.house.Person;

public class Main {
    public static void main(String[] args) {
//        exo1
//            Chaise chaise = new Chaise(4,"Bleu", "Bois");
//            chaise.display();

//        exo2 a
//            Person person = new Person();
//            person.sayHello();
//
//            Student student = new Student( 15);
//            student.sayHello();
//            student.goToClass();
//            System.out.println(student.getAge());
//
//            Teacher teacher  = new Teacher(40);
//            teacher.sayHello();
//            teacher.explain();

//        exo2 b
        Door door = new Door("bleu");
        Apartment apartment = new Apartment(door);
        Person person = new Person("Thomas",apartment);
        person.display();

//        exo3

//            SimpleCompte simpleCompte = new SimpleCompte(5000f,200);
//            simpleCompte.debit(5300);
//            System.out.println(simpleCompte.getSolde());
//            simpleCompte.credit(5000);
//            System.out.println(simpleCompte.getSolde());

//            EpargneCompte epargneCompte = new EpargneCompte(1000f, 5f);
//            epargneCompte.debit(500);
//            System.out.println(epargneCompte.getSolde());
//            System.out.println(epargneCompte.calculInteret());
//            System.out.println(epargneCompte.getSolde());

//            PayantCompte payantCompte = new PayantCompte(8000f);
//            payantCompte.credit(2000);
//            System.out.println(payantCompte.getSolde());

        }

}
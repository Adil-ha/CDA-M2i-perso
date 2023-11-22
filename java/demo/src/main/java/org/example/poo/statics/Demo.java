package org.example.poo.statics;

public class Demo {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user);
        User user1 = new User("Jean");
        System.out.println(user1);
        User employe = new Employee();
        System.out.println(employe);
    }
}

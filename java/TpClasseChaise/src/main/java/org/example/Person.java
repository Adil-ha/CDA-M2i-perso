package org.example;

public class Person {
    protected int age;
    public Person(){

    }
    public Person(int age) {
        this.age = age;
    }

    public void sayHello(){
        System.out.println("hello");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int n) {
        this.age = n;
    }
}

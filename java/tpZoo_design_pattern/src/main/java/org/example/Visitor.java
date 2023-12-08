package org.example;

public class Visitor implements Observer<String>{

    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " received notification: " + event);
    }
}

package org.example;

import org.example.builder.AnimalBuilder;
import org.example.builder.LionBuilder;
import org.example.entity.Animal;
import org.example.factory.AnimalFactory;
import org.example.factory.LionFactory;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = Zoo.getInstance();

        Visitor visitor = new Visitor("Michel");

        zoo.registerObserver(visitor);

        AnimalFactory lionFactory = new LionFactory();
        AnimalBuilder lionBuilder = new LionBuilder().name("Symba").size(5);
        Animal lion = lionFactory.createAnimal(lionBuilder);

        zoo.simulateEvent("New lion arrived");
        zoo.simulateEvent("Lion makes a sound: " + lion.getSound());


    }
}
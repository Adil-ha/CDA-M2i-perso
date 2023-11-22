package org.example.house;

public class Person {

    private String name;
    private House house;

    public Person(String name,House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Je m'appelle " + getName() +
                "\nJe suis " + (house instanceof Apartment ? "un appartement" : " une maison") +
                ", ma surface est de " + house.getSurface() + "m2" +
                "\nLa porte de ma maison est de couleur " + house.getDoor().getColor());
    }
}

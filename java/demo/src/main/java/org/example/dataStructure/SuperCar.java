package org.example.dataStructure;

public class SuperCar implements Vehicule{
    @Override
    public void drive() {
        System.out.println("Je suis un supercar qui roule");
    }

    @Override
    public void starEngine() {
        System.out.println("Je suis un supercar qui demarre");
    }
}

package org.example.dataStructure;

public class PetroleCar extends Engine implements Vehicule{

    public PetroleCar() {
        id = Engine.count;
    }

    @Override
    public void test() {

    }

    @Override
    public void drive() {
        System.out.println("Je suis un petrolecar qui roule");
    }

    @Override
    public void starEngine() {
        System.out.println("Je suis un petrolecar qui demarre");
    }
}

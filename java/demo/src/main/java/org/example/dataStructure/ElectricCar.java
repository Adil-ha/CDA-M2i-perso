package org.example.dataStructure;

public class ElectricCar extends Engine implements Vehicule{

    public ElectricCar() {
        id = Engine.count;
    }

    @Override
    public void test() {

    }

    @Override
    public void drive() {
        System.out.println("Je suis un ElectricCar qui roule");
    }

    @Override
    public void starEngine() {
        System.out.println("Je suis un ElectricCar qui demarre");    }
}

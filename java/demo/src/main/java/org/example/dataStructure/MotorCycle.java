package org.example.dataStructure;

public class MotorCycle extends Engine implements Vehicule{

    public MotorCycle() {
        id = Engine.count;
    }

    @Override
    public void test() {

    }

    @Override
    public void drive() {
        System.out.println("Je suis un motorcycle qui roule");
    }

    @Override
    public void starEngine() {
        System.out.println("Je suis un motorcycle qui demarre");
    }
}

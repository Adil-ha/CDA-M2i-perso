package org.example.dataStructure;

public class Demo {

    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setCouleur("bleu");
        electricCar.setNbreRoue(5);

        MotorCycle motorCycle = new MotorCycle();
        motorCycle.setCouleur("rouge");
        motorCycle.setNbreRoue(2);

        PetroleCar petroleCar = new PetroleCar();
        petroleCar.setCouleur("gris");
        petroleCar.setNbreRoue(4);

        SuperCar superCar = new SuperCar();

        Engine[] engines = {electricCar,motorCycle,petroleCar};
        for (Engine engine: engines) {
            moveVehicule(engine);
        }

        Vehicule[] vehicules = {superCar,electricCar,motorCycle,petroleCar};
    }

    public static void moveVehicule(Engine engine){

        if(engine instanceof ElectricCar){
            System.out.println("electrique");
            ((ElectricCar)engine).drive();
        } else if (engine instanceof MotorCycle) {
            System.out.println("motorCycle");
            ((MotorCycle)engine).drive();
        } else if (engine instanceof PetroleCar){
            System.out.println("petroleCar");
            ((PetroleCar)engine).drive();
        }
    }
}

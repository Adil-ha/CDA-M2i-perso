package org.example;

import org.example.exoPizza.Cheese;
import org.example.exoPizza.Pizza;
import org.example.exoPizza.Topping;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Topping toppingPepperroni = new Topping("Pepperroni");
        Topping toppingChampignons = new Topping("champignons");
        List<Topping> toppings = new ArrayList<>();
        toppings.add(toppingPepperroni);
        toppings.add(toppingChampignons);

        Pizza pizza = new Pizza.Builder()
                .size("moyenne")
                .typeDough("pâte fine")
                .cheese(Cheese.MOZZARELLA)
                .toppings(toppings)
                .sauce("tomate").build();

        System.out.println(pizza.toString());


    }
}
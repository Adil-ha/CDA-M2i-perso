package org.example;

import org.example.exoAbstractFactoring.ItalianCuisineFactory;
import org.example.exoAbstractFactoring.JapaneseCuisineFactory;
import org.example.exoAbstractFactoring.MexicanCuisineFactory;
import org.example.exoAbstractFactoring.Restaurant;
import org.example.exoBuilder.Cheese;
import org.example.exoBuilder.Pizza;
import org.example.exoBuilder.Topping;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //         exoBuilder
//        Topping toppingPepperroni = new Topping("Pepperroni");
//        Topping toppingChampignons = new Topping("champignons");
//        List<Topping> toppings = new ArrayList<>();
//        toppings.add(toppingPepperroni);
//        toppings.add(toppingChampignons);
//
//        Pizza pizza = new Pizza.Builder()
//                .size("moyenne")
//                .typeDough("pâte fine")
//                .cheese(Cheese.MOZZARELLA)
//                .toppings(toppings)
//                .sauce("tomate")
//                .build();
//
//        System.out.println(pizza.toString());

//    exoAbstractFactory

    Restaurant restaurant = new Restaurant(new ItalianCuisineFactory());
        restaurant.runPlate();
        restaurant.setCuisineFactory(new JapaneseCuisineFactory());
        restaurant.runPlate();


    }
}
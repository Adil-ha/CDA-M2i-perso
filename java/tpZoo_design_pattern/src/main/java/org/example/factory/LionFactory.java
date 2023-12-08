package org.example.factory;

import org.example.builder.AnimalBuilder;
import org.example.entity.Animal;

public class LionFactory extends AnimalFactory{
    @Override
    public Animal createAnimal(AnimalBuilder builder) {
        return builder.build();
    }
}

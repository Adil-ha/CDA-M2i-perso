package org.example.factory;

import org.example.builder.AnimalBuilder;
import org.example.entity.Animal;

public abstract class AnimalFactory {
    public abstract Animal createAnimal(AnimalBuilder builder);
}

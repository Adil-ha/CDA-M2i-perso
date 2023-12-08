package org.example.builder;

import org.example.entity.Animal;
import org.example.entity.Elephant;

public class ElephantBuilder extends AnimalBuilder{


    @Override
    public AnimalBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AnimalBuilder size(int size) {
        this.size = size;
        return this;
    }

    @Override
    public Animal build() {
        return new Elephant(this);
    }
}

package org.example.entity;

import org.example.builder.ElephantBuilder;

public class Elephant extends Animal{


    public Elephant(ElephantBuilder builder) {
        this.name = builder.getName();
        this.size = builder.getSize();
    }


    @Override
    public String getSound() {
        return "barrissement ";
    }
}

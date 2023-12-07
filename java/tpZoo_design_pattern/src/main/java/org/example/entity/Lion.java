package org.example.entity;

import org.example.builder.LionBuilder;

public class Lion extends Animal{
    public Lion(LionBuilder builder) {
        this.name = builder.getName();
        this.size = builder.getSize();
    }

    @Override
    public String getSound() {
        return null;
    }
}

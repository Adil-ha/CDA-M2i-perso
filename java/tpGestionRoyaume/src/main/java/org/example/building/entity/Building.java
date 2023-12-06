package org.example.building.entity;

public abstract class Building {
    protected String name;
    protected float size;
    protected int capacity;


    public Building name(String name) {
        this.name = name;
        return this;
    }

    public Building size(float size) {
        this.size = size;
        return this;
    }

    public Building capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public abstract Building build();


    public String getName() {
        return this.name;
    }
}

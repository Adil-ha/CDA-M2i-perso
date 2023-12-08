package org.example.builder;

import org.example.entity.Animal;

public abstract class AnimalBuilder {

    protected String name;
    protected int size;
    public abstract AnimalBuilder name(String name);
    public abstract AnimalBuilder size(int size);
    public abstract Animal build();

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }


}

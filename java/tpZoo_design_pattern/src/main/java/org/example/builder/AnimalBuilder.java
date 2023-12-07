package org.example.builder;

import lombok.Data;

public abstract class AnimalBuilder {
    public abstract AnimalBuilder name(String name);
    public abstract AnimalBuilder size(int size);
    public abstract AnimalBuilder build();


}

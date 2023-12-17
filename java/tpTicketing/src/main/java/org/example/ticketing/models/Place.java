package org.example.ticketing.models;

import lombok.Data;


@Data
public class Place {

    private static int count;

    private int id;

    private String name;

    private String adress;

    private int capacity;

    public Place(String name, String adress, int capacity) {
        this.id = ++count;
        this.name = name;
        this.adress = adress;
        this.capacity = capacity;
    }
}

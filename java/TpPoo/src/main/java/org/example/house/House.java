package org.example.house;

import org.example.house.Door;

public class House {
    protected int surface;
    protected Door door;

    public House(int surface) {
        this.surface = surface;
        this.door = new Door();
    }

    public Door getDoor() {
        return door;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void display(){
        System.out.println("Je suis une maison, ma surface est de " + this.getSurface() + "m2");
    }
}

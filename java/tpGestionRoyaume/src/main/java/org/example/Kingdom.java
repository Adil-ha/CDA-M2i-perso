package org.example;

import org.example.building.entity.Building;
import org.example.character.entity.Character;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
    private final String name;
    private List<Character> characters;
    private List<Building> buildings;

    public Kingdom(String name) {
        this.name = name;
        this.characters = new ArrayList<>();
        this.buildings = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void displayInfo() {
        System.out.println("Kingdom: " + name);

        System.out.println("Characters:");
        for (Character character : characters) {
            System.out.println("- " + character.getName());
        }

        System.out.println("Buildings:");
        for (Building building : buildings) {
            System.out.println("- " + building.getName());
        }
    }
}
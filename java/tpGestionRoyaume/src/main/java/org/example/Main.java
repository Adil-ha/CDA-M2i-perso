package org.example;


import org.example.building.entity.Barracks;
import org.example.building.entity.Castle;
import org.example.building.entity.Forge;
import org.example.building.entity.MedievalForge;
import org.example.building.factory.BuildingFactory;
import org.example.building.factory.FuturisticBuildingFactory;
import org.example.building.factory.MedievalBuildingFactory;
import org.example.character.entity.Character;
import org.example.character.factory.ArcherFactory;
import org.example.character.factory.CharacterFactory;
import org.example.character.factory.MageFactory;
import org.example.character.factory.WarriorFactory;

public class Main {
    public static void main(String[] args) {
        Kingdom kingdom1 = new Kingdom("Kingdom A");

        kingdom1.displayInfo();

        Game gameInstance = Game.getInstance("MyGame");

        gameInstance.play();

        System.out.println("Game Name: " + gameInstance.getGameName());

        // Utilisation de l'usine FuturisticBuildingFactory
        BuildingFactory futuristicFactory = new FuturisticBuildingFactory();

        // Création d'un château futuriste
        Castle futuristicCastle = futuristicFactory.createCastle();
        futuristicCastle.buildCastle();

        // Création d'une caserne futuriste
        Barracks futuristicBarracks = futuristicFactory.createBarracks();
        futuristicBarracks.recruitUnits();

        // Création d'une forge futuriste
        Forge futuristicForge = futuristicFactory.createForge();
        futuristicForge.createWeapons();

        // Utilisation de l'usine MedievalBuildingFactory
        BuildingFactory medievalFactory = new MedievalBuildingFactory();

        // Création d'un château médiéval
        Castle medievalCastle = medievalFactory.createCastle();
        medievalCastle.buildCastle();

        // Création d'une caserne médiévale
        Barracks medievalBarracks = medievalFactory.createBarracks();
        medievalBarracks.recruitUnits();

        // Création d'une forge médiévale
        Forge medievalForge = medievalFactory.createForge();
        medievalForge.createWeapons();

        // Utilisation des personnages
        CharacterFactory mageFactory = new MageFactory();
        Character mage = mageFactory.createCharacter("Merlin");
        mage.display();

        CharacterFactory warriorFactory = new WarriorFactory();
        Character warrior = warriorFactory.createCharacter("Arthur");
        warrior.display();

        CharacterFactory archerFactory = new ArcherFactory();
        Character archer = archerFactory.createCharacter("Robin Hood");
        archer.display();

        kingdom1.addCharacter(mage);
        kingdom1.addCharacter(warrior);
        kingdom1.addCharacter(archer);

        kingdom1.addBuilding(futuristicCastle);
        kingdom1.addBuilding(futuristicBarracks);
        kingdom1.addBuilding(futuristicForge);
        kingdom1.addBuilding(medievalCastle);
        kingdom1.addBuilding(medievalBarracks);
        kingdom1.addBuilding(medievalForge);

        kingdom1.displayInfo();

    }
}
package org.example;

public class Zoo {
    private static Zoo instance;

    // Empêchez l'instanciation directe depuis l'extérieur de la classe
    private Zoo() {}

    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    // Ajoutez d'autres méthodes ou attributs nécessaires pour le zoo
}

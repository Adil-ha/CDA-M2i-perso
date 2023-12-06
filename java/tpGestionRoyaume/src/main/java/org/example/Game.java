package org.example;

public class Game {
    private static Game instance;
    private String gameName;

    private Game(String gameName) {
        this.gameName = gameName;
    }

    public static Game getInstance(String gameName) {
        if (instance == null) {
            instance = new Game(gameName);
        }
        return instance;
    }

    public void play() {
        System.out.println("The game is in progress...");
    }

    public String getGameName() {
        return gameName;
    }
}

package org.example;

public class Chaise {
    private int npPied;

    private String couleur;

    private String materiau;

    public Chaise() {

    }

    public Chaise(int npPied, String couleur, String materiau) {
        this.npPied = npPied;
        this.couleur = couleur;
        this.materiau = materiau;
    }

    public void display(){
        String phrase = "Je suis une %s, avec %d pieds, en %s et de couleur %s";
        System.out.printf(phrase, getClass().getName(),this.npPied, this.materiau, this.couleur);
    }
}


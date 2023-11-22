package org.example.poo;

public class Phone extends Product {
    int prix;

    public Phone(int id, String name, int prix) {
        super(id, name);
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}

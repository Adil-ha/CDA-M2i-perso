package org.example.poo;

public class Product {
    protected int id;

    protected String name;

    public Product() {
    }
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void getBonjour(){
        System.out.println("Bonjour");
    }

    public static void quiSuisJe(){
        System.out.println("Je suis un produit");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

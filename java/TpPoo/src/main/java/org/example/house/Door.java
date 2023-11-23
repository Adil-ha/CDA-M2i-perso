package org.example.house;

public class Door  {
    private String color;


    public Door(){
        this.color = "bleu";
    }
    public Door(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display(){
        System.out.println("Je suis une porte, ma couleur est "+ this.color );
    }
}

package org.example.stationery;

public class Pen extends ArticleUnitary {
    private String color;


    public Pen(String name, Double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", reference=" + reference +
                '}';
    }
}

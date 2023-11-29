package org.example.stationery;

public class Ream extends ArticleUnitary{

    private float weight;

    public Ream(String name, Double price, float weight) {
        super(name, price);
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Ream{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", reference=" + reference +
                '}';
    }
}

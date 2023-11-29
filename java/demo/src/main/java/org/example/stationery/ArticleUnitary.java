package org.example.stationery;

public class ArticleUnitary extends Article {
    protected String name;
    protected Double price;

    public ArticleUnitary(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ArticleUnitary{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", reference=" + reference +
                '}';
    }
}

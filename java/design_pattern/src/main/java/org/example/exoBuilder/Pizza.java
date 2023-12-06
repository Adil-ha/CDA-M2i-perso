package org.example.exoBuilder;

import java.util.List;

public class Pizza {
    private String size;
    private String typeDough;
    private Cheese cheese;
    private List<Topping> toppings;
    private String sauce;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.typeDough = builder.typeDough;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.sauce = builder.sauce;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", typeDough='" + typeDough + '\'' +
                ", cheese=" + cheese +
                ", toppings=" + toppings +
                ", sauce='" + sauce + '\'' +
                '}';
    }

    public static class Builder {
        private String size;
        private String typeDough;
        private List<Topping> toppings;
        private String sauce;
        private Cheese cheese;

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder typeDough(String typeDough) {
            this.typeDough = typeDough;
            return this;
        }

        public Builder cheese(Cheese cheese) {
            if(this.cheese != null)
                throw new RuntimeException("Un fromage a deja été choisi");
            this.cheese = cheese;
            return this;
        }

        public Builder toppings(List<Topping> toppings) {
            this.toppings = toppings;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

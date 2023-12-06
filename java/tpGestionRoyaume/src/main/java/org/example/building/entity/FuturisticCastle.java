package org.example.building.entity;

public class FuturisticCastle extends Castle{

    private FuturisticCastle(FuturisticCastleBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;
    }
    @Override
    public void buildCastle() {
        System.out.println("Futuristic Castle built.");
    }

    @Override
    public Building build() {
        return null;
    }

    public static class FuturisticCastleBuilder extends Building {

        @Override
        public FuturisticCastle build() {
            return new FuturisticCastle(this);
        }
    }
}

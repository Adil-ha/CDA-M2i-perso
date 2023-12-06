package org.example.building.entity;

public class MedievalCastle extends Castle {
    private MedievalCastle(MedievalCastleBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;
    }

    @Override
    public void buildCastle() {
        System.out.println("Medieval Castle built.");
    }

    @Override
    public Building build() {
        return null;
    }

    public static class MedievalCastleBuilder extends Building {

        @Override
        public MedievalCastle build() {
            return new MedievalCastle(this);
        }
    }
}
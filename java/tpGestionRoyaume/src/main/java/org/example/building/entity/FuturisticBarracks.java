package org.example.building.entity;

public class FuturisticBarracks extends Barracks {
    private FuturisticBarracks(FuturisticBarracksBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;
    }

    @Override
    public void recruitUnits() {
        System.out.println("Futuristic Barracks recruiting units.");
    }

    @Override
    public Building build() {
        return null;
    }

    public static class FuturisticBarracksBuilder extends Building {

        @Override
        public FuturisticBarracks build() {
            return new FuturisticBarracks(this);
        }
    }
}

package org.example.building.entity;

public class FuturisticForge extends Forge {
    private FuturisticForge(FuturisticForgeBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;
    }

    @Override
    public void createWeapons() {
        System.out.println("Futuristic Forge creating weapons.");
    }

    @Override
    public Building build() {
        return null;
    }

    public static class FuturisticForgeBuilder extends Building {

        @Override
        public FuturisticForge build() {
            return new FuturisticForge(this);
        }
    }
}

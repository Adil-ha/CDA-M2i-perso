package org.example.building.entity;

public class MedievalForge extends Forge {
    private MedievalForge(MedievalForgeBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;
    }

    @Override
    public void createWeapons() {
        System.out.println("Medieval Forge creating weapons.");
    }

    @Override
    public Building build() {
        return null;
    }

    public static class MedievalForgeBuilder extends Building {

        @Override
        public MedievalForge build() {
            return new MedievalForge(this);
        }
    }
}

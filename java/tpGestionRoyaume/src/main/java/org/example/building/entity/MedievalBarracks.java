package org.example.building.entity;

public class MedievalBarracks extends Barracks {

    private MedievalBarracks(MedievalBarracksBuilder builder) {
        this.name = builder.name;
        this.size = builder.size;
        this.capacity = builder.capacity;

    }

    @Override
    public void recruitUnits() {
        System.out.println("Medieval Barracks recruiting units.");

    }

    @Override
    public Building build() {
        return null;
    }


    public static class MedievalBarracksBuilder extends Building {

        @Override
        public Building build() {
            return new MedievalBarracks(this);
        }
    }
}

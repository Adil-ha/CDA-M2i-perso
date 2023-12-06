package org.example.building.factory;

import org.example.building.entity.*;

public class MedievalBuildingFactory extends BuildingFactory {
    @Override
    public Castle createCastle() {
        return (Castle) new MedievalCastle.MedievalCastleBuilder()
                .name("Medieval Castle")
                .size(150.0f)
                .capacity(400)
                .build();
    }

    @Override
    public Barracks createBarracks() {
        return (Barracks) new MedievalBarracks.MedievalBarracksBuilder()
                .name("Medieval Barracks")
                .size(120.0f)
                .capacity(250)
                .build();
    }

    @Override
    public Forge createForge() {
        return (Forge) new MedievalForge.MedievalForgeBuilder()
                .name("Medieval Forge")
                .size(90.0f)
                .capacity(180)
                .build();
    }
}

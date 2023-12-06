package org.example.building.factory;

import org.example.building.entity.*;

public class FuturisticBuildingFactory extends BuildingFactory {
    @Override
    public Castle createCastle() {
        return (Castle) new FuturisticCastle.FuturisticCastleBuilder()
                .name("Futuristic Castle")
                .size(100.0f)
                .capacity(200)
                .build();
    }

    @Override
    public Barracks createBarracks() {
        return (Barracks) new FuturisticBarracks.FuturisticBarracksBuilder()
                .name("Futuristic Barracks")
                .size(130.0f)
                .capacity(300)
                .build();
    }

    @Override
    public Forge createForge() {
        return (Forge) new FuturisticForge.FuturisticForgeBuilder()
                .name("Futuristic Forge")
                .size(80.0f)
                .capacity(150)
                .build();
    }
}

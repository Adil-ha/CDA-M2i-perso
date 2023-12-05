package org.example.factory;

import org.example.entity.*;

public class MedievalBuildingFactory extends BuildingFactory {
    @Override
    public Castle createCastle() {
        return new MedievalCastle();
    }

    @Override
    public Barracks createBarracks() {
        return new MedievalBarracks();
    }

    @Override
    public Forge createForge() {
        return new MedievalForge();
    }
}

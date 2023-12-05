package org.example.factory;

import org.example.entity.*;

public class FuturisticBuildingFactory extends BuildingFactory{
    @Override
    public Castle createCastle() {
        return new FuturisticCastle();
    }

    @Override
    public Barracks createBarracks() {
        return new FuturisticBarracks();
    }

    @Override
    public Forge createForge() {
        return new FuturisticForge();
    }
}

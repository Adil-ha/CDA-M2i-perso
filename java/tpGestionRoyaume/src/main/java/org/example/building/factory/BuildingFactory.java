package org.example.building.factory;

import org.example.building.entity.Barracks;
import org.example.building.entity.Castle;
import org.example.building.entity.Forge;


public abstract class BuildingFactory {
    public abstract Castle createCastle();
    public abstract Barracks createBarracks();
    public abstract Forge createForge();
}

package org.example.factory;

import org.example.entity.Barracks;
import org.example.entity.Castle;
import org.example.entity.Forge;

public abstract class BuildingFactory {
    public abstract Castle createCastle();
    public abstract Barracks createBarracks();
    public abstract Forge createForge();
}

package org.example.character.factory;

import org.example.character.entity.Character;
import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Weapon;

public abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
    public abstract Weapon createWeapon();
    public abstract MagicalSkill createMagicalSkill();
    public abstract PhysicalAttribute createPhysicalAttribute();


}

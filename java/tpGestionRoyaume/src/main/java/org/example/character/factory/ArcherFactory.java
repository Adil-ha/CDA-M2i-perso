package org.example.character.factory;

import org.example.character.entity.*;
import org.example.character.entity.magicalSkill.Invisibility;
import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.Agility;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Bow;
import org.example.character.entity.weapon.Weapon;

public class ArcherFactory extends CharacterFactory {

    @Override
    public Archer createCharacter(String name) {
        return new Archer.ArcherBuilder()
                .name(name)
                .weapon(createWeapon())
                .magicalSkill(createMagicalSkill())
                .physicalAttribute(createPhysicalAttribute())
                .build();

    }

    @Override
    public Weapon createWeapon() {
        return new Bow();
    }

    @Override
    public MagicalSkill createMagicalSkill() {
        return new Invisibility();
    }

    @Override
    public PhysicalAttribute createPhysicalAttribute() {
        return new Agility();
    }
}

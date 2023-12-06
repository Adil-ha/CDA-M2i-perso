package org.example.character.factory;

import org.example.character.entity.*;
import org.example.character.entity.magicalSkill.Lighthing;
import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.Intelligence;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Staff;
import org.example.character.entity.weapon.Weapon;

public class MageFactory extends CharacterFactory {


    @Override
    public Mage createCharacter(String name) {
         return new Mage.MageBuilder()
                .name(name)
                .weapon(createWeapon())
                .magicalSkill(createMagicalSkill())
                .physicalAttribute(createPhysicalAttribute())
                .build();

    }

    @Override
    public Weapon createWeapon() {
        return new Staff();
    }

    @Override
    public MagicalSkill createMagicalSkill() {
        return new Lighthing();
    }

    @Override
    public PhysicalAttribute createPhysicalAttribute() {
        return new Intelligence();
    }
}

package org.example.character.factory;

import org.example.character.entity.*;
import org.example.character.entity.magicalSkill.FireBall;
import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.physicalAttribute.Strength;
import org.example.character.entity.weapon.Sword;
import org.example.character.entity.weapon.Weapon;

public class WarriorFactory extends CharacterFactory {

    @Override
    public Warrior createCharacter(String name) {
        return new Warrior.WarriorBuilder()
                .name(name)
                .weapon(createWeapon())
                .magicalSkill(createMagicalSkill())
                .physicalAttribute(createPhysicalAttribute())
                .build();

    }

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public MagicalSkill createMagicalSkill() {
        return new FireBall();
    }

    @Override
    public PhysicalAttribute createPhysicalAttribute() {
        return new Strength();
    }
}

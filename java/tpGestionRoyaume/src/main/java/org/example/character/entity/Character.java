package org.example.character.entity;

import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Weapon;

public abstract class Character {
    protected String name;
    protected Weapon weapon;
    protected MagicalSkill magicalSkill;
    protected PhysicalAttribute physicalAttribute;

    public abstract void display();

    public String getName() {
        return name;
    }
}

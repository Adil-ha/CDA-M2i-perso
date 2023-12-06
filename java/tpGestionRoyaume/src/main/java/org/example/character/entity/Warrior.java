package org.example.character.entity;

import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Weapon;

public class Warrior extends Character {
    private Warrior(WarriorBuilder builder) {
        this.name = builder.name;
        this.weapon = builder.weapon;
        this.magicalSkill = builder.magicalSkill;
        this.physicalAttribute = builder.physicalAttribute;
    }

    @Override
    public void display() {
        System.out.println("Warrior: " + name);
        weapon.display();
        magicalSkill.display();
        physicalAttribute.display();
        System.out.println();
    }

    public static class WarriorBuilder {
        private String name;
        private Weapon weapon;
        private MagicalSkill magicalSkill;
        private PhysicalAttribute physicalAttribute;

        public WarriorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public WarriorBuilder weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public WarriorBuilder magicalSkill(MagicalSkill magicalSkill) {
            this.magicalSkill = magicalSkill;
            return this;
        }

        public WarriorBuilder physicalAttribute(PhysicalAttribute physicalAttribute) {
            this.physicalAttribute = physicalAttribute;
            return this;
        }

        public Warrior build() {
            return new Warrior(this);
        }
    }
}

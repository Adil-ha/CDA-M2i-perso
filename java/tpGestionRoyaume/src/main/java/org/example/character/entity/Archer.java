package org.example.character.entity;

import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Weapon;

public class Archer extends Character {
    private Archer(ArcherBuilder builder) {
        this.name = builder.name;
        this.weapon = builder.weapon;
        this.magicalSkill = builder.magicalSkill;
        this.physicalAttribute = builder.physicalAttribute;
    }

    @Override
    public void display() {
        System.out.println("Archer: " + name);
        weapon.display();
        magicalSkill.display();
        physicalAttribute.display();
        System.out.println();
    }

    public static class ArcherBuilder {
        private String name;
        private Weapon weapon;
        private MagicalSkill magicalSkill;
        private PhysicalAttribute physicalAttribute;

        public ArcherBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ArcherBuilder weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public ArcherBuilder magicalSkill(MagicalSkill magicalSkill) {
            this.magicalSkill = magicalSkill;
            return this;
        }

        public ArcherBuilder physicalAttribute(PhysicalAttribute physicalAttribute) {
            this.physicalAttribute = physicalAttribute;
            return this;
        }

        public Archer build() {
            return new Archer(this);
        }
    }
}




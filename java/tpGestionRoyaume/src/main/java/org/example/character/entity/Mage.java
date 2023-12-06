package org.example.character.entity;


import org.example.character.entity.magicalSkill.MagicalSkill;
import org.example.character.entity.physicalAttribute.PhysicalAttribute;
import org.example.character.entity.weapon.Weapon;

public class Mage extends Character{
    private Mage(MageBuilder builder){
        this.name = builder.name;
        this.magicalSkill = builder.magicalSkill;
        this.weapon = builder.weapon;
        this.physicalAttribute = builder.physicalAttribute;
    }
    @Override
    public void display() {
        System.out.println("Mage: " + name);
        weapon.display();
        magicalSkill.display();
        physicalAttribute.display();
        System.out.println();
    }

    public static class MageBuilder {
        private String name;
        private Weapon weapon;
        private MagicalSkill magicalSkill;
        private PhysicalAttribute physicalAttribute;

        public MageBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MageBuilder weapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public MageBuilder magicalSkill(MagicalSkill magicalSkill) {
            this.magicalSkill = magicalSkill;
            return this;
        }

        public MageBuilder physicalAttribute(PhysicalAttribute physicalAttribute) {
            this.physicalAttribute = physicalAttribute;
            return this;
        }

        public Mage build() {
            return new Mage(this);

        }
    }
}

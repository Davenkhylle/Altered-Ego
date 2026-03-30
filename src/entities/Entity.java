package entities;

import utils.Util;

public class Entity {
    protected final String name;
    protected final int baseHP = 500;
    protected final int baseMana = 200;
    protected int currentHP;
    protected int currentMana;

    protected Skill skill1;
    protected Skill skill2;
    protected Skill skill3;

    public Entity(String name, String skill1Name, String skill2Name, String skill3Name) {
        this.name = name;
        this.currentHP = baseHP;
        this.currentMana = baseMana;
        skill1 = new Skill(skill1Name, 50, 60, 25, 2);
        skill2 = new Skill(skill2Name, 60, 70, 50, 3);
        skill3 = new Skill(skill3Name, 100, 150, 100, 5);
    }

    public void basicAttack(Entity target) {
        int damage = Util.randomInt(40, 50);
        target.takeDamage(damage);
    }

    public void useSkill(int skillIndex, Entity target) {
        Skill selectedSkill = switch(skillIndex) {
            case 1 -> skill1;
            case 2 -> skill2;
            case 3 -> skill3;
            default -> null;
        };

        if(selectedSkill != null) {
            int damage = selectedSkill.useSkill();
            target.takeDamage(damage);
            currentMana -= selectedSkill.getManaCost();
        }
    }

    public void takeDamage(int damage) {
        if(isAlive()) {
            currentHP -= damage;
            if(currentHP < 0) {
                currentHP = 0;
            }
        }
    }

    public void resetCharacter() {
        currentHP = baseHP;
        currentMana = baseMana;
        skill1.resetCooldown();
        skill2.resetCooldown();
        skill3.resetCooldown();
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMana() {
        return currentMana;
    }
}

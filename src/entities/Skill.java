package entities;

import utils.Util;

public class Skill {
    private final String name;
    private final int minDamage;
    private final int maxDamage;
    private final int manaCost;
    private final int baseCooldown;
    private int currentCooldown;

    public Skill(String name, int minDamage, int maxDamage, int manaCost, int baseCooldown) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.manaCost = manaCost;
        this.baseCooldown = baseCooldown;
        this.currentCooldown = 0;
    }

    public int useSkill() {
        currentCooldown = baseCooldown;
        return Util.randomInt(minDamage, maxDamage);
    }

    public void reduceCooldown() {
        if(isCooldown()) {
            currentCooldown--;
        }
    }

    public void resetCooldown() {
        currentCooldown = 0;
    }

    public boolean isCooldown() {
        return currentCooldown > 0;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }
}

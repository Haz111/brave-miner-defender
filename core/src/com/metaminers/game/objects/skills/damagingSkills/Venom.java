package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Venom extends AbstractDamagingSkill {
    public Venom(){
        this.cooldown = 5000;
        this.damage = 100;
        this.areaOfEffect = 3;
        this.energyCost = 20;
        this.name = "Venom";
    }
}
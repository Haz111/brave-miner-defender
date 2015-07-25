package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class WindBlade extends AbstractDamagingSkill {
    public WindBlade(){
        this.cooldown = 3000;
        this.damage = 100;
        this.areaOfEffect = 2;
        this.energyCost = 20;
        this.name = "Wind Blade";
    }
}
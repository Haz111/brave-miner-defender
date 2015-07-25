package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Shuriken extends AbstractDamagingSkill {   //basic attack dla ninjy
    public Shuriken(){
        this.cooldown = 500;
        this.damage = 30;
        this.areaOfEffect = 1;
        this.energyCost = 0;
        this.name = "Shuriken";
    }
}
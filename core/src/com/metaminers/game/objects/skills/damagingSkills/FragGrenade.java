package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class FragGrenade extends AbstractDamagingSkill{
    public FragGrenade(){
        this.name = "Frag Grenade";
        this.areaOfEffect = 3;
        this.damage = 100;
        this.cooldown = 8000;
        this.energyCost = 20;
    }
}

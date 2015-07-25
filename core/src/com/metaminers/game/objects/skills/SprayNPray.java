package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class SprayNPray extends AbstractDamagingSkill{
    public SprayNPray(){
        this.name = "Spray n' Pray";
        this.areaOfEffect = 3;
        this.damage = 80;
        this.cooldown = 8000;
        this.energyCost = 15;
    }
}
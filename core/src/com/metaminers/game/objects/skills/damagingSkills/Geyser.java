package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Geyser extends AbstractDamagingSkill {
    public Geyser(){
        this.cooldown = 5000;
        this.damage = 80;
        this.areaOfEffect = 3;
        this.energyCost = 30;
        this.name = "Geyser";
    }
}

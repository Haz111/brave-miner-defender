package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
*/
public class SchorchingSun extends AbstractDamagingSkill {
    public SchorchingSun(){
        this.cooldown = 10000;
        this.damage = 120;
        this.areaOfEffect = 3;
        this.energyCost = 50;
        this.name = "Schorching Sun";
    }
}
package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ScorpionTail extends AbstractDamagingSkill {
    public ScorpionTail(){
        this.cooldown = 8000;
        this.damage = 140;
        this.areaOfEffect = 2;
        this.energyCost = 5;
        this.name = "Scorpion Tail";
    }
}
package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ScorpionSupport extends AbstractRepairSkill {
    public ScorpionSupport(){
        this.name = "Scorpion Support";
        this.cooldown = 50000;
        this.energyCost = 50;
        this.HPRestored = 200;
        this.AreaofEffect = 40;
    }
}
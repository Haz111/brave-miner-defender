package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class SummonBob extends AbstractRepairSkill {
    public SummonBob(){
        this.name = "Summon Bob the Builder";
        this.cooldown = 50000;
        this.energyCost = 50;
        this.HPRestored = 200;
        this.AreaofEffect = 40;
    }
}
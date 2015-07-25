package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Revitalization extends AbstractRepairSkill {
    public Revitalization(){
        this.name = "Revitalization";
        this.cooldown = 20000;
        this.energyCost = 10;
        this.HPRestored = 100;
        this.AreaofEffect = 2;
    }
}

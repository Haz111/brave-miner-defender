package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ScorpionHelp extends AbstractRepairSkill {
    public ScorpionHelp(){
        this.name = "Scorpion Help";
        this.cooldown = 20000;
        this.energyCost = 10;
        this.HPRestored = 100;
        this.AreaofEffect = 2;
    }
}

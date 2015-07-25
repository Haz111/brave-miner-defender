package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class MagicRepair extends AbstractRepairSkill {
    public MagicRepair(){
        this.name = "Magic Repair";
        this.cooldown = 10000;
        this.energyCost = 20;
        this.HPRestored = 100;
        this.AreaofEffect = 1;
    }
}

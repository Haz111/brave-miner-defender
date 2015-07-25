package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class CanWeFixIt extends AbstractRepairSkill {
    public CanWeFixIt(){
        this.name = "Can We Fix It?";
        this.cooldown = 50000;
        this.energyCost = 50;
        this.HPRestored = 200;
        this.AreaofEffect = 40;
    }
}
package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class MineField extends AbstractWallSkill{
    public MineField() {
        this.name = "Minefield";
        this.energyCost = 60;
        this.cooldown = 40000;
        this.wallHP = 1;
        this.blocksAmount = 3;
        this.retaliationDamage = 100;
    }
}
package com.metaminers.game.objects.skills.wallSkills;

/**
* Created by Kuba on 2015-07-25.
        */
public class WallOfFire extends AbstractWallSkill {
    public WallOfFire(){
        this.name = "Wall of Fire";
        this.energyCost = 50;
        this.cooldown = 350000;
        this.wallHP = 1;
        this.blocksAmount = 5;
        this.retaliationDamage = 80;
    }
}


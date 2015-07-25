package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class PoolOfAcid extends AbstractWallSkill {
    public PoolOfAcid(){
        this.name = "Pool of Acid";
        this.energyCost = 50;
        this.cooldown = 40000;
        this.wallHP = 10;
        this.blocksAmount = 5;
        this.retaliationDamage = 40;
    }
}


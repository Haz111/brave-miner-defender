package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class BarbedWire extends AbstractWallSkill{
    public BarbedWire() {
        this.name = "BarbedWire";
        this.energyCost = 50;
        this.cooldown = 50000;
        this.wallHP = 10;
        this.blocksAmount = 3;
        this.retaliationDamage = 10;
    }
}


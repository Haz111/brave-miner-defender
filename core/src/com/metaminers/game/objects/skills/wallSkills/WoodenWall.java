package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class WoodenWall extends AbstractWallSkill{
    public WoodenWall() {
        this.name = "Wooden Wall";
        this.energyCost = 30;
        this.cooldown = 20000;
        this.wallHP = 10;
        this.blocksAmount = 5;
        this.retaliationDamage = 0;
    }
}

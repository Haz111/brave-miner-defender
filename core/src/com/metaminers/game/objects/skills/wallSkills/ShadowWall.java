package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ShadowWall extends AbstractWallSkill{
    public ShadowWall(){
        this.name = "Shadow Wall";
        this.energyCost = 30;
        this.cooldown = 20000;
        this.wallHP = 20;
        this.blocksAmount = 5;
        this.retaliationDamage = 0;
    }

}
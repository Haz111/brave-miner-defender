package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Quicksand extends AbstractWallSkill{
    public Quicksand(){
        this.name = "Quicksand";
        this.energyCost = 10;
        this.cooldown = 40000;
        this.wallHP = 15;
        this.blocksAmount = 5;
        this.retaliationDamage = 0;
    }

}
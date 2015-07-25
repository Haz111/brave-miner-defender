package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ScorpionSwarm extends AbstractWallSkill{
    public ScorpionSwarm(){
        this.name = "Scropion Swarm";
        this.energyCost = 50;
        this.cooldown = 10000;
        this.wallHP = 5;
        this.blocksAmount = 5;
        this.retaliationDamage = 40;
    }
}

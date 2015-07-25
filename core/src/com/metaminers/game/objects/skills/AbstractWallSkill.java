package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractWallSkill extends AbstractSkillClass {
    protected int wallHP = 0;
    protected int retaliationDamage = 0; //dla min albo drutu kolczastego
    protected int blocksAmount = 0;
    public int getWallHP(){ return this.wallHP;}
    public int getRetaliationDamage() {return this.retaliationDamage;}
    public int getBlocksAmount(){return this.blocksAmount;}
}

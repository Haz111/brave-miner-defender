package com.metaminers.game.objects.skills.wallSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractWallSkill{
    protected int wallHP = 0;
    protected int retaliationDamage = 0; //dla min albo drutu kolczastego
    protected int blocksAmount = 0;
    public int getWallHP(){ return this.wallHP;}
    public int getRetaliationDamage() {return this.retaliationDamage;}
    public int getBlocksAmount(){return this.blocksAmount;}
    String name = "";
    protected int energyCost = 0;
    protected int cooldown = 0; //milisekundy?
    public String getName(){return this.name;}
    public int getEnergyCostCost(){return  this.energyCost;}
    public int getCooldown(){return this.cooldown;}
}

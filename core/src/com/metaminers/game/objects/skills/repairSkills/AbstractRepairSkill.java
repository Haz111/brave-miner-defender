package com.metaminers.game.objects.skills.repairSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractRepairSkill{
    protected int HPRestored = 0;
    protected int AreaofEffect = 0;
    public int getHPRestored(){return this.HPRestored;}
    public int getAreaofEffect(){return  this.AreaofEffect;}
    String name = "";
    protected int energyCost = 0;
    protected int cooldown = 0; //milisekundy?
    public String getName(){return this.name;}
    public int getEnergyCostCost(){return  this.energyCost;}
    public int getCooldown(){return this.cooldown;}
}

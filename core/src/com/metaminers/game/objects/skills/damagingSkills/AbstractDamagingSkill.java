package com.metaminers.game.objects.skills.damagingSkills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractDamagingSkill{
    protected int damage = 0;
    protected int areaOfEffect = 0; //widz� to mo�e jako d�ugo�� boku kwadratu na kt�ry zdolno�� ma wp�yw
    public int getDamage(){return  this.damage;}
    public int getAreaOfEffect(){return  this.areaOfEffect;}
    String name = "";
    protected int energyCost = 0;
    protected int cooldown = 0; //milisekundy?
    public String getName(){return this.name;}
    public int getEnergyCostCost(){return  this.energyCost;}
    public int getCooldown(){return this.cooldown;}
}

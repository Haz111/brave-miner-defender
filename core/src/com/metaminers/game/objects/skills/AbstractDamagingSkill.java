package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractDamagingSkill extends AbstractSkillClass {
    protected int damage = 0;
    protected int areaOfEffect = 0; //widz� to mo�e jako d�ugo�� boku kwadratu na kt�ry zdolno�� ma wp�yw
    public int getDamage(){return  this.damage;}
    public int getAreaOfEffect(){return  this.areaOfEffect;}
}

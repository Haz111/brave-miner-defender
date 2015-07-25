package com.metaminers.game.objects.skills;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractRepairSkill extends AbstractSkillClass {
    protected int HPRestored = 0;
    protected int AreaofEffect = 0;
    public int getHPRestored(){return this.HPRestored;}
    public int getAreaofEffect(){return  this.AreaofEffect;}
}

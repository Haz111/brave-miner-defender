package com.metaminers.game.objects.hero_classes;

import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.objects.skills.AbstractDamagingSkill;
import com.metaminers.game.objects.skills.AbstractRepairSkill;
import com.metaminers.game.objects.skills.AbstractWallSkill;

/**
 * Created by Tymoteusz but picked up by Jacques on 2015-07-25.
 */
public abstract class AbstractHeroClass {

    protected AbstractDamagingSkill damagingSkill;

    public AbstractDamagingSkill getDamagingSkill(){
        return this.damagingSkill;
    }

    protected AbstractRepairSkill repairSkill;

    public AbstractRepairSkill getRepairSkill() {
        return repairSkill;
    }
    protected AbstractWallSkill wallSkill;

    public AbstractWallSkill getWallSkill() {
        return wallSkill;
    }

    protected int energy = 0;

    public int getEnergy() {
        return energy;
    }
}

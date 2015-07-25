package com.metaminers.game.objects.hero_classes;

import com.metaminers.game.objects.skills.damagingSkills.AbstractDamagingSkill;
import com.metaminers.game.objects.skills.repairSkills.AbstractRepairSkill;
import com.metaminers.game.objects.skills.wallSkills.AbstractWallSkill;

import java.util.LinkedList;

/**
 * Created by Tymoteusz but picked up by Jacques on 2015-07-25.
 */
public abstract class AbstractHeroClass {
    protected AbstractDamagingSkill basicSkill;

    public AbstractDamagingSkill getBasicSkill() {
        return basicSkill;
    }

    protected LinkedList <AbstractDamagingSkill> damagingSkillList;

    public LinkedList getDamagingSkill(){
        return this.damagingSkillList;
    }

    protected LinkedList <AbstractRepairSkill> repairSkillList;

    public LinkedList getRepairSkill() {
        return repairSkillList;
    }
    protected LinkedList <AbstractWallSkill> wallSkillList;

    public LinkedList getWallSkill() {
        return wallSkillList;
    }

    protected int energy = 0;

    public int getEnergy() {
        return energy;
    }
}

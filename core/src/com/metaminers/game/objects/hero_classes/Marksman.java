package com.metaminers.game.objects.hero_classes;

import com.metaminers.game.objects.skills.EngineerIntervention;
import com.metaminers.game.objects.skills.Headshot;
import com.metaminers.game.objects.skills.WoodenWall;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Marksman extends AbstractHeroClass {
    public Marksman(){
        this.energy = 100;
        this.damagingSkill = new Headshot();
        this.repairSkill = new EngineerIntervention();
        this.wallSkill = new WoodenWall();
    }
}


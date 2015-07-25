package com.metaminers.game.objects.hero_classes;

import com.metaminers.game.objects.skills.damagingSkills.*;
import com.metaminers.game.objects.skills.repairSkills.MagicRepair;
import com.metaminers.game.objects.skills.repairSkills.Revitalization;
import com.metaminers.game.objects.skills.repairSkills.SummonBob;
import com.metaminers.game.objects.skills.wallSkills.BarbedWire;
import com.metaminers.game.objects.skills.repairSkills.CanWeFixIt;
import com.metaminers.game.objects.skills.wallSkills.PoolOfAcid;
import com.metaminers.game.objects.skills.wallSkills.WallOfFire;
import com.metaminers.game.objects.skills.wallSkills.WallOfWind;

/**
 * Created by Kuba on 2015-07-25.
 */
public class MageOfTheWaste extends AbstractHeroClass {
    public MageOfTheWaste(){
        this.energy = 100;
        this.basicSkill = new AcidSpray();
        this.damagingSkillList.add(new Geyser());
        this.damagingSkillList.add(new SchorchingSun());
        this.damagingSkillList.add(new WindBlade());
        this.repairSkillList.add( new MagicRepair());
        this.repairSkillList.add( new Revitalization());
        this.repairSkillList.add( new SummonBob());
        this.wallSkillList.add( new PoolOfAcid());
        this.wallSkillList.add( new WallOfFire());
        this.wallSkillList.add( new WallOfWind());
    }
}

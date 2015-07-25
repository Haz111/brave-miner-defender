package com.metaminers.game.objects.hero_classes;

import com.metaminers.game.objects.skills.damagingSkills.ScorpionStrike;
import com.metaminers.game.objects.skills.damagingSkills.ScorpionTail;
import com.metaminers.game.objects.skills.damagingSkills.Shuriken;
import com.metaminers.game.objects.skills.damagingSkills.Venom;
import com.metaminers.game.objects.skills.repairSkills.ScorpionAssistance;
import com.metaminers.game.objects.skills.repairSkills.ScorpionHelp;
import com.metaminers.game.objects.skills.repairSkills.ScorpionSupport;
import com.metaminers.game.objects.skills.wallSkills.Quicksand;
import com.metaminers.game.objects.skills.wallSkills.ScorpionSwarm;
import com.metaminers.game.objects.skills.wallSkills.ShadowWall;

/**
 * Created by Kuba on 2015-07-25.
 */
public class ScorpionNinja extends AbstractHeroClass {
    public ScorpionNinja(){
        this.energy = 100;
        this.basicSkill = new Shuriken();
        this.damagingSkillList.add(new Venom());
        this.damagingSkillList.add(new ScorpionStrike());
        this.damagingSkillList.add(new ScorpionTail());
        this.repairSkillList.add( new ScorpionHelp());
        this.repairSkillList.add( new ScorpionAssistance());
        this.repairSkillList.add( new ScorpionSupport());
        this.wallSkillList.add( new ShadowWall());
        this.wallSkillList.add( new Quicksand());
        this.wallSkillList.add( new ScorpionSwarm());
    }
}
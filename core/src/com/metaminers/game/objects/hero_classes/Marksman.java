package com.metaminers.game.objects.hero_classes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.metaminers.game.objects.skills.damagingSkills.FragGrenade;
import com.metaminers.game.objects.skills.damagingSkills.Headshot;
import com.metaminers.game.objects.skills.damagingSkills.MolotovCocktail;
import com.metaminers.game.objects.skills.damagingSkills.SprayNPray;
import com.metaminers.game.objects.skills.repairSkills.CanWeFixIt;
import com.metaminers.game.objects.skills.repairSkills.EngineerIntervention;
import com.metaminers.game.objects.skills.repairSkills.HardlyWorkin;
import com.metaminers.game.objects.skills.wallSkills.BarbedWire;
import com.metaminers.game.objects.skills.wallSkills.MineField;
import com.metaminers.game.objects.skills.wallSkills.WoodenWall;

/**
 * Created by Kuba on 2015-07-25.
 */
public class Marksman extends AbstractHeroClass {
    public Marksman(){
        this.energy = 100;
        this.basicSkill = new Headshot();
        this.damagingSkillList.add(new FragGrenade());
        this.damagingSkillList.add(new MolotovCocktail());
        this.damagingSkillList.add(new SprayNPray());
        this.repairSkillList.add( new EngineerIntervention());
        this.repairSkillList.add( new HardlyWorkin());
        this.repairSkillList.add( new CanWeFixIt());
        this.wallSkillList.add( new WoodenWall());
        this.wallSkillList.add( new BarbedWire());
        this.wallSkillList.add( new MineField());
        this.texture = new Texture(Gdx.files.internal("characters/gornik1.png"));
    }
}

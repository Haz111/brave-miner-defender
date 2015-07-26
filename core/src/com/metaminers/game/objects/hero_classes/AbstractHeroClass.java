package com.metaminers.game.objects.hero_classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.metaminers.game.GameConstants;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.skills.damagingSkills.AbstractDamagingSkill;
import com.metaminers.game.objects.skills.repairSkills.AbstractRepairSkill;
import com.metaminers.game.objects.skills.wallSkills.AbstractWallSkill;

import java.util.LinkedList;

/**
 * Created by Tymoteusz but picked up by Jacques on 2015-07-25.
 */
public abstract class AbstractHeroClass extends GameObject {
    protected AbstractDamagingSkill basicSkill;

    public AbstractDamagingSkill getBasicSkill() {
        return basicSkill;
    }

    protected LinkedList <AbstractDamagingSkill> damagingSkillList = new LinkedList<>();

    public LinkedList getDamagingSkill(){
        return this.damagingSkillList;
    }

    protected LinkedList <AbstractRepairSkill> repairSkillList = new LinkedList<>();

    public LinkedList getRepairSkill() {
        return repairSkillList;
    }
    protected LinkedList <AbstractWallSkill> wallSkillList = new LinkedList<>();

    public LinkedList getWallSkill() {
        return wallSkillList;
    }

    protected int energy = 0;

    public int getEnergy() {
        return energy;
    }

    protected Texture texture;
    public void draw(SpriteBatch batch) {
//        batch.draw(new TextureRegion(this.texture, 0, 0, 32, 32), getWidth() / 2, getHeight() / 2, 32, 32);
        setSprite(new TextureRegion(this.texture, 0, 0, 24, 24));
        sprite.setBounds(GameConstants.WIDTH/2-15 , GameConstants.HEIGHT/2, getWidth()*2, getHeight()*2);
        sprite.draw(batch);
    }
}

package com.metaminers.game.objects.skills;

import com.badlogic.gdx.Game;
import com.metaminers.game.objects.GameObject;

/**
 * Created by Kuba on 2015-07-25.
 */
public abstract class AbstractSkillClass extends GameObject {
    String name = "";
    protected int energyCost = 0;
    protected int cooldown = 0; //milisekundy?
    public String getName(){return this.name;}
    public int getEnergyCostCost(){return  this.energyCost;}
    public int getCooldown(){return this.cooldown;}

    }




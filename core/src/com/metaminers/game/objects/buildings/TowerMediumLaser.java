package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerMediumLaser extends AbstractBuilding {
    private static final int price = 60;
    private static final int damage = 60;
    public TowerMediumLaser(float posX, float posY) {
        this.hp = 80;
        this.texture = new Texture(Gdx.files.internal("buildings/tower6.png"));
        this.posX = posX;
        this.posY = posY;
    }
}
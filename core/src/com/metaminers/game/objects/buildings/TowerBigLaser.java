package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerBigLaser extends AbstractBuilding {
    private static final int price = 80;
    private static final int damage = 80;
    public TowerBigLaser(float posX, float posY) {
        this.hp = 120;
        this.texture = new Texture(Gdx.files.internal("buildings/tower8.png"));
        this.posX = posX;
        this.posY = posY;
    }
}

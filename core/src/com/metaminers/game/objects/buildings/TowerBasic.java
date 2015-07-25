package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerBasic extends AbstractBuilding {
    private static final int price = 10;
    private static final int damage = 10;
    public TowerBasic(float posX, float posY) {
        this.hp = 50;
        this.texture = new Texture(Gdx.files.internal("buildings/tower2.png"));
        this.posX = posX;
        this.posY = posY;
    }
    
}

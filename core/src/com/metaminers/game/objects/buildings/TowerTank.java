package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerTank extends AbstractBuilding {
    private static final int price = 20;
    private static final int damage = 20;
    public TowerTank(float posX, float posY) {
        this.hp = 100;
        this.texture = new Texture(Gdx.files.internal("buildings/tower1.png"));
        this.posX = posX;
        this.posY = posY;
    }
    
}

package com.metaminers.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerOne extends AbstractBuilding {
    private static final int price = 20;
    public TowerOne(float posX, float posY) {
        this.hp = 100;
        this.texture = new Texture(Gdx.files.internal("buildings/tower1.png"));
        this.posX = posX;
        this.posY = posY;
    }
    public int getPrice() {
        return price;
    }
}

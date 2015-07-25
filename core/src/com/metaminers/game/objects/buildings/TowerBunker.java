package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerBunker extends AbstractBuilding {
    private static final int price = 30;
    private static final int damage = 10;
    public TowerBunker(float posX, float posY) {
        this.hp = 250;
        this.texture = new Texture(Gdx.files.internal("buildings/tower3.png"));
        this.posX = posX;
        this.posY = posY;
    }
}
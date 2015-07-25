package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerDouble extends AbstractBuilding {
    private static final int price = 40;
    private static final int damage = 40;
    public TowerDouble(int posX, int posY) {
        this.hp = this.initialHp = 100;
        this.texture = new Texture(Gdx.files.internal("buildings/tower4.png"));
        this.posX = posX;
        this.posY = posY;
    }

}
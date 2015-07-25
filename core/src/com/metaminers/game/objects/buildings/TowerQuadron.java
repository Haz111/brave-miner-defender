package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerQuadron extends AbstractBuilding {
    private static final int price = 70;
    private static final int damage = 60;
    public TowerQuadron(int posX, int posY) {
        this.hp = this.initialHp = 100;
        this.texture = new Texture(Gdx.files.internal("buildings/tower7.png"));
        this.posX = posX;
        this.posY = posY;
    }

}
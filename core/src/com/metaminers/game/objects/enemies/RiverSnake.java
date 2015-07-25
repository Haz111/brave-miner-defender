package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class RiverSnake extends AbstractEnemy {
    public RiverSnake(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.texture = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        this.hp = 300;
        this.damage = 50;
    }
}

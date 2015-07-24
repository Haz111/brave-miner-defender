package com.metaminers.game.objects;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractBuilding extends GameObject {
    Texture texture;
    int hp = 0;
    float posX, posY;
    void takeHp(int hp) { this.hp -= hp; }
    int getHp() { return hp; }
}

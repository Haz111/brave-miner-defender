package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.enemies.AbstractEnemy;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractBuilding extends GameObject {
    Texture texture;
    int hp = 0;
    int damage = 0;
    int price = 0;
    float posX, posY;
    public float getPosX() { return posX; }
    public float getPosY() { return posY; }
    public int getPrice() {
        return price;
    }
    public void takeHp(int hp) { this.hp -= hp; }
    public int getHp() { return hp; }
    public void attack(AbstractEnemy enemy) {
        enemy.takeHp(damage);
    }
}

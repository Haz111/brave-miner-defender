package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.enemies.AbstractEnemy;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractBuilding extends GameObject {

    int hp = 0;
    int damage = 0;
    int price = 0;

    public int getPrice() {
        return price;
    }
    public void takeHp(int hp) { this.hp -= hp; }
    public int getHp() { return hp; }
    public void attack(AbstractEnemy enemy) {
        enemy.takeHp(damage);
    }
    public void drawInGui(float posX, float posY, float scale) {
        batch.begin();
        batch.draw(this.extractIcon(), posX, posY, this.extractIcon().getRegionWidth()*scale,
                this.extractIcon().getRegionHeight()*scale);
        batch.end();
        this.setSprite(this.extractIcon());
        this.sprite.setBounds(posX, posY, this.extractIcon().getRegionWidth()*scale,
                    this.extractIcon().getRegionHeight()*scale);
    }
    public TextureRegion extractIcon() { return null; }
}

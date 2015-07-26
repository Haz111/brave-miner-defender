package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerSmallLaser extends AbstractBuilding {
    private static final int damage = 50;
    public TowerSmallLaser(int posX, int posY) {
        this.hp = this.initialHp = 70;
        this.price = 50;
        this.texture = new Texture(Gdx.files.internal("buildings/tower5.png"));
        this.setSprite(this.extractIcon());
        this.posX = posX;
        this.posY = posY;
    }
    public TextureRegion extractIcon() {
        return new TextureRegion(this.texture, 0, 32, 32, 32);
    }
}
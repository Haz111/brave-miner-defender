package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class TowerQuadron extends AbstractBuilding {
    private static final int damage = 60;
    public TowerQuadron(int posX, int posY) {
        this.price = 70;
        this.hp = this.initialHp = 100;
        this.texture = new Texture(Gdx.files.internal("buildings/tower7.png"));
        this.setSprite(this.extractIcon());
        this.posX = posX;
        this.posY = posY;
    }
    public TextureRegion extractIcon() {
        return new TextureRegion(this.texture, 0, 64, 64, 64);
    }
}
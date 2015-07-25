package com.metaminers.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tymoteusz on 2015-07-24.
 */

public abstract class GameObject {
    protected Texture texture; //TODO: PRZEROBIC NA SIATKE
    protected float posX, posY; //TODO: TUTAJ NIE JEST TO POTRZEBNE, SZCZEGOLNIE DLA ENEMY
    protected SpriteBatch batch = new SpriteBatch(); //TODO: Jest to dobrze?
    protected Sprite sprite;

    public void draw() {
        batch.begin();
        batch.draw(texture, posX, posY);
        batch.end();
    }

    public void draw(float x, float y) {
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }

    public float getPosX() { return posX; }
    public float getPosY() { return posY; }
    public void setPosX(float posX) { this.posX = posX; }
    public void setPosY(float posY) { this.posY = posY; }
    public float getWidth() {return texture.getWidth();}
    public float getHeight() { return texture.getHeight();}
    public Texture getTexture() { return texture;}
    public Sprite getSprite() { return sprite;}
    public void setSprite(Texture t) {
        sprite = new Sprite(t);
    }
    public void setSprite(TextureRegion t) {
        sprite = new Sprite(t);
    }
    public void setSprite(Sprite t) {
        sprite = new Sprite(t);
    }
}


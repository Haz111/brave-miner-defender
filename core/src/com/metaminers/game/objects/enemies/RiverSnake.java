package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class RiverSnake extends AbstractEnemy {
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float elapsedTime = 0;

    //    konstruktor dla standardowego enemy
    public RiverSnake() {
        this.posX = this.width;
        this.posY = this.height;
        this.texture = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        this.hp = 300;
        this.damage = 50;

        this.batch = new SpriteBatch();
        this.textureAtlas = new TextureAtlas(Gdx.files.internal("enemies/wanzrzeczny.png"));
        this.animation = new Animation(1/15f, textureAtlas.getRegions());
    }

//    konstruktor dla enemy ktory wychodzi w jakims innym miejscu
    public RiverSnake(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
        this.texture = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        this.hp = 300;
        this.damage = 50;

        this.batch = new SpriteBatch();
        this.textureAtlas = new TextureAtlas(Gdx.files.internal("enemies/wanzrzeczny.png"));
    }

    public void dispose() {
        this.batch.dispose();
        this.textureAtlas.dispose();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        //sprite.draw(batch);
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
        batch.end();
    }
}

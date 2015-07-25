package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Action;

import java.util.Iterator;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class RiverSnake extends AbstractEnemy {
    private Animation animation;
    private Texture animTex;
    private TextureRegion[] frames;
    private static final int framesNum = 9;
    private TextureRegion currFrame;
    private float elapsedTime = 0f;
    private Sprite sprite;
    private SpriteBatch batch;


    //    konstruktor dla standardowego enemy
    public RiverSnake() {
        this.posX = this.width;
        this.posY = this.height;
        this.hp = 300;
        this.damage = 50;

        this.batch = new SpriteBatch();

        animTex = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        frames = new TextureRegion[framesNum];
        TextureRegion[][] tmp = TextureRegion.split(animTex, animTex.getWidth() / framesNum, animTex.getHeight());

        animation = new Animation(1 / 15f, frames);
        currFrame = animation.getKeyFrame(0f);
        sprite = new Sprite(currFrame);
        setBounds(posX, posY, currFrame.getRegionWidth(), currFrame.getRegionHeight());

    }

//    konstruktor dla enemy ktory wychodzi w jakims innym miejscu
    public RiverSnake(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
        this.hp = 300;
        this.damage = 50;

        this.batch = new SpriteBatch();

        animTex = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        frames = new TextureRegion[framesNum];
        TextureRegion[][] tmp = TextureRegion.split(animTex, animTex.getWidth() / framesNum, animTex.getHeight());

        animation = new Animation(1 / 15f, frames);
        currFrame = animation.getKeyFrame(0f);
        sprite = new Sprite(currFrame);
        setBounds(posX, posY, currFrame.getRegionWidth(), currFrame.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float delta) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
            iter.next().act(delta);
        }
    }

    public void render(float delta) {
        batch.begin();
        draw(batch, delta);
        batch.end();
    }
}

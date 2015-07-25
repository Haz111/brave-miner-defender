package com.metaminers.game.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.metaminers.game.GameConstants;

/**
 * Created by Konrad on 2015-07-25.
 */
public class Village implements Disposable{
    private Texture house, background;
    private float x, y; //Position of house
    SpriteBatch batch;

    public Village(String houseFileName, String backgroundFileName) {
        //TODO: Tekstury house i background!
        house = new Texture(Gdx.files.internal(houseFileName));
        background = new Texture(Gdx.files.internal(backgroundFileName));
        //TODO: Pomyslec co ze spriteBatch
        batch = new SpriteBatch();
    }

    public void drawHouse(float x, float y, float scale) {
        batch.begin();
//        Sprite houseSprite = new Sprite(house);
//        houseSprite.scale(scale);
//        houseSprite.draw(batch);
        batch.end();
    }

    public void drawAll() {
        batch.begin();
//        batch.draw(house, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch.draw(background, 0, 0, GameConstants.WIDTH, GameConstants.HEIGHT);
        batch.end();
    }
    @Override
    public void dispose() {
        house.dispose();
        background.dispose();
    }
}

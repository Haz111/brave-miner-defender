package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;

import java.util.Iterator;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public class RiverSnake extends AbstractEnemy {

    //konstruktor dla standardowego enemy
    public RiverSnake() {
        this.hp = 300;
        this.damage = 50;

        int[] startingPlace = super.randomStartingPlace();
        this.posX = (float)startingPlace[0];
        this.posY = (float)startingPlace[1];

        //TODO: Da sie to zrobic lepiej?
        this.destX = (Gdx.graphics.getWidth() / 2) - 18;
        this.destY = (Gdx.graphics.getHeight() / 2) - 20;
        this.batch = new SpriteBatch();
        this.imgDir = "enemies/wonzrzeczny.png";
        directionVec = new Vector2();
        setUpAnim(imgDir);
        setUpDirection();

    }

//  konstruktor dla enemy ktory wychodzi w jakims innym miejscu
    public RiverSnake(int posX,  int posY) {
        this.hp = 300;
        this.damage = 50;

        this.posX = posX;
        this.posY = posY;
        //TODO: Da sie to zrobic lepiej?
        this.destX = (Gdx.graphics.getWidth() / 2)-100;
        this.destY = (Gdx.graphics.getHeight() / 2);
        this.batch = new SpriteBatch();
        directionVec = new Vector2();
        setUpAnim(imgDir);
        setUpDirection();
    }
}

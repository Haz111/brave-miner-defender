package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Hubert on 2015-07-25.
 */
public class Scavenger extends AbstractEnemy {
    //konstruktor dla standardowego enemy
    public Scavenger() {
        this.hp = 300;
        this.damage = 50;

        int[] startingPlace = super.randomStartingPlace();
        this.posX = (float)startingPlace[0];
        this.posY = (float)startingPlace[1];

        //TODO: Da sie to zrobic lepiej?
        this.destX = (Gdx.graphics.getWidth() / 2) - 18;
        this.destY = (Gdx.graphics.getHeight() / 2) - 20;
        this.batch = new SpriteBatch();
        this.imgDir = "enemies/jadaczscierwa.png";
        directionVec = new Vector2();
        this.animLenHorizontal = 4;
        this.animLenVertical = 8;
        this.framesNum = 9;
        setUpAnim(imgDir);
        setUpDirection();
    }

    //  konstruktor dla enemy ktory wychodzi w jakims innym miejscu
    public Scavenger(int posX,  int posY) {
        this.hp = 300;
        this.damage = 50;

        this.posX = posX;
        this.posY = posY;
        //TODO: Da sie to zrobic lepiej?
        this.destX = (Gdx.graphics.getWidth() / 2)-100;
        this.destY = (Gdx.graphics.getHeight() / 2);
        this.batch = new SpriteBatch();
        directionVec = new Vector2();
        this.animLenHorizontal = 4;
        this.animLenVertical = 8;
        this.framesNum = 9;
        setUpAnim(imgDir);
        setUpDirection();
    }
}

package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
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
    private static final int animLen = 2;
    private static final int animLen2 = 8;
    private TextureRegion currFrame;
    private Animation currAnim;
    private float elapsedTime = 0f;
    private Sprite sprite;
    private SpriteBatch batch;
    private static final int DIRECTIONS = 8;
    private Animation[] anims;
    private static final float ANIM_FACTOR = 1/15f;
    private int destX, destY;
    //TODO: Moze orzebuesc ten Vector wyzej?
    private Vector2 directionVec;

    //    konstruktor dla standardowego enemy
    public RiverSnake() {
        //this(this.width, this.height);
        this(0, 0);
    }

//    konstruktor dla enemy ktory wychodzi w jakims innym miejscu
    public RiverSnake(int posX,  int posY) {
        this.posX = posX;
        this.posY = posY;
        this.hp = 300;
        this.damage = 50;
        //TODO: Da sie to zrobic lepiej?
        this.destX = Gdx.graphics.getWidth() / 2;
        this.destY = Gdx.graphics.getHeight() / 2;
        this.batch = new SpriteBatch();
        directionVec = new Vector2();
        setUpAnim();
        setUpDirection();
    }

    private void setUpDirection() {
        directionVec.x = destX - this.posX;
        directionVec.y = destX - this.posY;
        directionVec.nor(); //Normalizacja

//        int [][] directions = new int[][]{{8, 1, 2},
//                                            {7, 0, 3},
//                                            {6, 5, 4}};

        int [][] directions = new int[][]{{7, 0, 6},
                                          {3, 0, 2},
                                          {5, 1, 4}};

        int px, py;
        if(directionVec.x < -0.5)
            px = -1;
        else if(directionVec.x >= -0.5 && directionVec.x <= 0.5)
            px = 0;
        else
            px = 1;

        if(directionVec.y < -0.5)
            py = -1;
        else if(directionVec.y >= -0.5 && directionVec.y <= 0.5)
            py = 0;
        else
            py = 1;

        direction = directions[py + 1][px + 1];
        currAnim = anims[direction];
        currFrame = currAnim.getKeyFrame(0f);
    }

    private void setUpAnim() {
        animTex = new Texture(Gdx.files.internal("enemies/wonzrzeczny.png"));
        frames = new TextureRegion[framesNum];
        TextureRegion[][] tmp = TextureRegion.split(animTex, animTex.getWidth() / animLen, animTex.getHeight() / animLen2);
        anims = new Animation[DIRECTIONS];
        for(int i = 0; i < DIRECTIONS; i++)
            anims[i] = new Animation(ANIM_FACTOR, tmp[i]);

        //animation = new Animation(1 / 15f, frames);
        currAnim = anims[0];
        currFrame = currAnim.getKeyFrame(0f);
        sprite = new Sprite(currFrame);
        sprite.setPosition(this.posX, this.posY);
        setBounds(posX, posY, currFrame.getRegionWidth(), currFrame.getRegionHeight());

    }
    @Override
    public void draw(Batch batch, float delta) {
        elapsedTime += delta;
        currFrame = currAnim.getKeyFrame(elapsedTime, true);
        sprite.setRegion(currFrame);
        sprite.setPosition(sprite.getX() + directionVec.x, sprite.getY() + directionVec.y);
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

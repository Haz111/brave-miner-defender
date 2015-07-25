package com.metaminers.game.objects.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.metaminers.game.GameConstants;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.buildings.AbstractBuilding;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractEnemy extends GameObject {

    int initialHp = 0;
    int hp = 0;
    int damage = 0;

    public void attack(AbstractBuilding building) { building.takeHp(damage); }

    public void takeHp(int hp) { this.hp -= hp; }
    int[] widthHeightAndDir = randomStartingPlace();
//    int width = widthHeightAndDir[0];
//    int height = widthHeightAndDir[1];
    int direction = widthHeightAndDir[2];

    protected String imgDir;
    protected Animation currAnim;
    protected Animation[] anims;
    protected TextureRegion currFrame;
    protected int animLenHorizontal;
    protected int animLenVertical;
    protected Texture animTex;
    protected TextureRegion[] frames;
    protected int framesNum;
    protected static final int DIRECTIONS = 8;
    protected static final float ANIM_FACTOR = 1/15f;
    protected Sprite sprite;
    protected float elapsedTime = 0f;

    protected float posX;
    protected float posY;
    protected int destX, destY;
    //TODO: Moze orzebuesc ten Vector wyzej?
    protected Vector2 directionVec;

    //    it returns array - first element: width, second: heigh, third: direction
    protected int[] randomStartingPlace(){
        Random rand = new Random();
        int width;
        int height;
        int direction;
//        losuje sciane - 0 - polnoc, dalej zgodnie ze wskazowkami zegara
        switch(rand.nextInt(4)){
        case (0):
            width = (rand.nextInt(GameConstants.WIDTH - 2*GameConstants.INTERFACE_PANEL_WIDTH)) + GameConstants.INTERFACE_PANEL_WIDTH;
            height = GameConstants.HEIGHT - GameConstants.INTERFACE_PANEL_WIDTH;
            if (width < (GameConstants.WIDTH/3)){
                direction = 7;
            } else if (width < (2*GameConstants.WIDTH/3)){
                direction = 0;
            } else {
                direction = 1;
            }
            break;
        case (1):
            width = GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH;
            height = rand.nextInt(GameConstants.HEIGHT);
            if (height > (2*GameConstants.HEIGHT/3)){
                direction = 1;
            } else if (height> (GameConstants.HEIGHT/3)){
                direction = 2;
            } else {
                direction = 3;
            }
            break;
        case (2):
            width = (rand.nextInt(GameConstants.WIDTH - 2*GameConstants.INTERFACE_PANEL_WIDTH)) + GameConstants.INTERFACE_PANEL_WIDTH;
            height = 0;
            if (width < (GameConstants.WIDTH/3)){
                direction = 5;
            } else if (width < (2*GameConstants.WIDTH/3)){
                direction = 4;
            } else {
                direction = 3;
            }
            break;
        case (3):
            width = GameConstants.INTERFACE_PANEL_WIDTH;
            height = rand.nextInt(GameConstants.HEIGHT);;
            if (height > (2*GameConstants.HEIGHT/3)){
                direction = 7;
            } else if (height > (GameConstants.HEIGHT/3)){
                direction = 6;
            } else {
                direction = 5;
            }
            break;
        default:
            width = 0;
            height = 0;
            direction = 5;
        }

        int[] toReturn = new int[3];
        toReturn[0] = width;
        toReturn[1] = height;
        toReturn[2] = direction;
        return (toReturn);
    }

    protected void setUpDirection() {
        directionVec.x = this.destX - this.posX;
        directionVec.y = this.destY - this.posY;
        System.out.println("destX = " + this.destX + " posX " + this.posX + " destY = " + this.destY + " posY " + this.posY);
        directionVec.nor(); //Normalizacja
        System.out.println("x = " + directionVec.x + " y = " + directionVec.y);

        int [][] directions = new int[][]{{5, 1, 4},
                                          {3, 0, 2},
                                          {7, 0, 6}};

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

    protected void setUpAnim(String imgDir) {
        animTex = new Texture(Gdx.files.internal(imgDir));
        frames = new TextureRegion[framesNum];
        TextureRegion[][] tmp = TextureRegion.split(animTex, animTex.getWidth() / animLenHorizontal, animTex.getHeight() / animLenVertical);
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
        posX += directionVec.x;
        posY += directionVec.y;
        setUpDirection();
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

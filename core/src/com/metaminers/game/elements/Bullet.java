package com.metaminers.game.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.phases.PlayingInformation;

import java.util.List;

/**
 * Created by Konrad on 2015-07-26.
 */
public class Bullet {

    private int x, y;
    private boolean isEnded = false;
    private Vector2 vector;
    private Texture bulletTexture;
    private Sprite bulletSprite;
    private int damage;
    public Bullet(int startX, int startY, int enemyX, int enemyY, int enemyWidth, int enemyHeight, int _damage) {
        //TODO: Czynnik losowy w strzale
        vector = new Vector2( enemyX - startX, enemyY - startY);
        vector.nor();
        x = startX;
        y = startY;
        damage = _damage;
        bulletTexture = new Texture(Gdx.files.internal("assets.png"));
        bulletSprite = new Sprite(bulletTexture);
        bulletSprite.setBounds(x, y, bulletTexture.getWidth(), bulletTexture.getHeight());
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void update(SpriteBatch batch, PlayingInformation info) {
        x += vector.x;
        y += vector.y;
        //TODO: Gridy i te sprawy!
        bulletSprite.setPosition(x, y);
        checkCollision(info);
        if(!isEnded) {
            batch.begin();
            bulletSprite.draw(batch);
            batch.end();
        }
    }

    private void checkCollision(PlayingInformation info) {
        Rectangle r = bulletSprite.getBoundingRectangle();
        List<AbstractEnemy> enemies = info.getEnemiesObjects();

        for(AbstractEnemy e : enemies ) {
            if(e.getSprite().getBoundingRectangle().overlaps(r)) {
                e.takeHp(damage);
                if(e.getHp() <= 0)
                    info.getEnemiesObjects().remove(e);

                isEnded = true;
                break;
            }
        }
    }
}

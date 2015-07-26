package com.metaminers.game.objects.buildings;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.metaminers.game.GameConstants;
import com.metaminers.game.Grid;
import com.metaminers.game.elements.Bullet;
import com.metaminers.game.objects.GameObject;
import com.metaminers.game.objects.enemies.AbstractEnemy;
import com.metaminers.game.phases.PlayingInformation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tymoteusz on 2015-07-25.
 */
public abstract class AbstractBuilding extends GameObject {

    List<Bullet> bullets = new LinkedList<>();
    int initialHp = 0;
    int hp = 0;
    int damage = 0;
    int price = 0;
    private int range = 0;
    public int getPrice() {
        return price;
    }
    public void takeHp(int hp) { this.hp -= hp; }
    public int getHp() { return hp; }
    public void attack(AbstractEnemy enemy) {
        enemy.takeHp(damage);
    }

    public void attack(PlayingInformation info) {
        Grid grid = info.getGrid();

        int gX = getPosX() / GameConstants.CELL_WIDTH;
        int gY = getPosY() / GameConstants.CELL_HEIGHT;
        int enemyX, enemyY, enemyWidth, enemyHeight;
        List<AbstractEnemy> enemies = info.getEnemiesObjects();
        Rectangle rangeRect = new Rectangle(gX - range, gY - range, 2 * range, 2 * range);
        for(AbstractEnemy e : enemies) {
            enemyX = e.getPosX() / GameConstants.CELL_WIDTH;
            enemyY = e.getPosY() / GameConstants.CELL_HEIGHT;
            enemyWidth = (int)(e.getWidth() / GameConstants.CELL_WIDTH);
            enemyHeight = (int)(e.getHeight() / GameConstants.CELL_HEIGHT);

            Rectangle enemyRect = new Rectangle(enemyX, enemyY, enemyWidth, enemyHeight);
            if(enemyRect.overlaps(rangeRect)) {
                bullets.add(new Bullet(gX, gY, enemyX, enemyY, enemyWidth, enemyHeight, this.damage));
            }
        }

    }

    public void drawInGui(float posX, float posY, float scale) {
        batch.begin();
        batch.draw(this.extractIcon(), posX, posY, this.extractIcon().getRegionWidth()*scale,
                this.extractIcon().getRegionHeight()*scale);
        batch.end();
        this.setSprite(this.extractIcon());
        this.sprite.setBounds(posX, posY, this.extractIcon().getRegionWidth()*scale,
                    this.extractIcon().getRegionHeight()*scale);
    }
    public TextureRegion extractIcon() { return null; }

    public void drawSprite() {
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public void update(PlayingInformation info) {
        for(Bullet e : bullets)
            e.update(batch, info);

        for(Bullet e : bullets) {
            if(e.isEnded())
                bullets.remove(e);
        }
    }

    public void drawSprite(int x, int y) {
        sprite.setPosition(x, y);
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public void setRange(int r) {
        this.range = r;
    }

    public int getRange() {
        return this.range;
    }

//    !!! SKILLE !!!
    public void repairBuilding (int repairedHp){
        if (hp+repairedHp > initialHp) {
            hp = initialHp;
        } else {
            hp += repairedHp;
        }
    }
}

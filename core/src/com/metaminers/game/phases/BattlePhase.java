package com.metaminers.game.phases;

import com.metaminers.game.EnemyFactory;
import com.metaminers.game.GameConstants;
import com.metaminers.game.elements.Village;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.enemies.AbstractEnemy;

import static java.lang.Math.abs;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BattlePhase extends Phase {

    //TODO: Wrogowie!
    //TODO: Wyjscie z gry przez escape
    private Village village;

    private String escString = "Press ESC to exit from this game.";
    @Override
    public void start(PlayingInformation info) {
        super.start(info);
        info.setEnemiesObjects(EnemyFactory.generateEnemies(info.getLvl()));
        this.village = info.getVillage();
        System.out.println("Battle phase starts");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //super.render(delta);
        village.drawAll();
        batch.begin();
        drawHero();
        drawEnemies(delta);
        drawGUI();
        drawBuildings();
        batch.end();
        handleInput();
        if(info.getEnemiesObjects().isEmpty()) {
            BattlePhase.this.markEnded(true);
            System.out.println("Battle Phase Ends");
        }
    }

    private void drawHero() {
        info.getHero().draw(batch);
    }

    private void drawEnemies(float delta) {

        for(AbstractEnemy enemy : info.getEnemiesObjects()) {
           if(enemy.canGo(info))
               enemy.draw(batch, delta);
            else {
               for(AbstractBuilding b : info.getBuildings()) {
                   if(abs(b.getPosX() - enemy.getPosX()) < 2 && abs(b.getPosY() - enemy.getPosY()) < 2) {
                       enemy.attack(b);
                   }
               }
           }
        }
    }

//    protected void drawBuildings() {
//        for(AbstractBuilding e: info.getBuildings()) {
//            e.draw();
//        }
//    }

    @Override
    protected void handleMovementMap(float x, float y) {

    }

    @Override
    protected void handleMovementInventory(float x, float y) {
        //Przeciazylismy tutaj metode musimy sprawdzic w co kliknelismy - jak w lewy panel to ok, jak nie to wychodzimy z niej
        if(x > GameConstants.INTERFACE_PANEL_WIDTH)
            return;

        //TODO: Skille
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

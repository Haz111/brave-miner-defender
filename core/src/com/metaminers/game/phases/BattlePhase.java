package com.metaminers.game.phases;

import com.metaminers.game.EnemyFactory;
import com.metaminers.game.GameConstants;
import com.metaminers.game.objects.buildings.AbstractBuilding;
import com.metaminers.game.objects.enemies.AbstractEnemy;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BattlePhase extends Phase {

    //TODO: Wrogowie!
    //TODO: Wyjscie z gry przez escape


    private String escString = "Press ESC to exit from this game.";
    @Override
    public void start(PlayingInformation info) {
        super.start(info);
        this.info.setEnemiesObjects(EnemyFactory.generateEnemies(this.info.getLvl()));
        System.out.println("Battle phase starts");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        drawGUI();
        drawBuildings();
        drawEnemies(delta);
        batch.end();
        handleInput();
    }

    private void drawEnemies(float delta) {
        for(AbstractEnemy enemy : info.getEnemiesObjects()) {
            enemy.draw(batch, delta);
        }
    }

    protected void drawBuildings() {
        for(AbstractBuilding e: info.getBuildings()) {
            e.draw();
        }
    }

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

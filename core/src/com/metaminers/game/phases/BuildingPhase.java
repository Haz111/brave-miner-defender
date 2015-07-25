package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.metaminers.game.elements.GameConstants;
import com.metaminers.game.objects.AbstractHeroClass;

import java.util.HashMap;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BuildingPhase extends Phase {

    //TODO: ZROBIC JAKIEGOS RENDERERA KTORY BY NP. RYSOWAL GUI, OBECNA WERSJA JEST MANROTRAWSTWEM PAMIECI!
    private HashMap<AbstractHeroClass, Integer> buildingsToBuild;
    private final String warnString = "You cannot place building here";
    private Texture pane, background;
    private SpriteBatch batch;

    @Override
    public void start(PlayingInformation info) {
        markEnded(false);
        pane = new Texture(Gdx.files.internal("gui/pane.png"));
        background = new Texture(Gdx.files.internal("gui/background.png"));
        batch = new SpriteBatch();
        //renderGUI();
    }

    @Override
    public void show() {
        /*
        1. Draw interface
        2. Draw buildings, its status and others
        3. Allow player to build sth
        4. Just save and mark ended
         */
        //TODO: Jakis renderer do GUI, cobysmy nie kopiowali kodu
    }


    @Override
    public void render(float delta) {
        batch.begin();
        drawGUI();
        drawEnemies();
        setUpBuildings();
        batch.end();
    }

    private void drawGUI() {
        batch.draw(pane, 0, 0);
        batch.draw(pane, GameConstants.WIDTH - GameConstants.INTERFACE_PANEL_WIDTH, 0);
        batch.draw(background, GameConstants.INTERFACE_PANEL_WIDTH, 0);
    }

    private void drawEnemies() {

    }

    private void setUpBuildings() {

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
        pane.dispose();
        background.dispose();
    }
}

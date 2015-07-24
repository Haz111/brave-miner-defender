package com.metaminers.game.phases;

import com.metaminers.game.objects.AbstractHeroClass;

import java.util.HashMap;

/**
 * Created by Konrad on 2015-07-24.
 */
public class BuildingPhase extends Phase {

    private HashMap<AbstractHeroClass, Integer> buildingsToBuild;
    private final String warnString = "You cannot place building here";

    @Override
    public void start(PlayingInformation info) {
        markEnded(false);
        renderGUI();
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

    public void renderGUI() {

    }

    @Override
    public void render(float delta) {

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

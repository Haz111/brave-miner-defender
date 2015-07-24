package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.metaminers.game.phases.*;

/**
 * Created by Hubert on 2015-07-24.
 */
public class LevelScreen implements Screen {

    //TODO: Change it!
    private final static int PHASES_COUNT = 3;

    private Phase currentPhase;
    int counter = 0; //array counter for phases
    Phase [] phases;
    PlayingInformation info;
    private Game game;

    public LevelScreen(Game game) {
        phases = new Phase[PHASES_COUNT];
        phases[0] = new BuildingPhase();
        phases[1] = new UpgradePhase();
        phases[2] = new BattlePhase();
        currentPhase = phases[0];
        this.game = game;
        info = new PlayingInformation();

        currentPhase.start(info);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(currentPhase.isEnded()) {
            info = currentPhase.getResults();
            counter = (counter + 1) % PHASES_COUNT;
            currentPhase = phases[counter];
        }
        //currentPhase.render / draw
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

package com.metaminers.game.phases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Konrad on 2015-07-24.
 */
public class UpgradePhase extends Phase {

    private TextButton buy, fight;
    private Stage stage;


    @Override
    public void start(PlayingInformation info) {
        this.info = info;
        buy = makeTextButton("Buy!", 500, 500, 100, 100);
        fight = makeTextButton("Just do it!", 500, 100, 100, 100);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        stage.addActor(buy);
        stage.addActor(fight);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    protected void handleMovementMap(float x, float y) {

    }

    @Override
    protected void handleMovementInventory(float x, float y) {

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

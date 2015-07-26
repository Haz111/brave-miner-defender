package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Jacques on 2015-07-24.
 */
public class OptionsScreen implements Screen {
    TextButton exitButton;
    TextButton fullScreenButton;
    TextButton windowedButton;
    Stage stage;
    Game game;
    Preferences prefs;
    Texture buttonTexture;
    TextureRegion buttonTextureRegion;
    TextButtonStyle style;
    Skin skin;
    BitmapFont font;
    Music music;
    float volume;


    public OptionsScreen(Game game) {
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();
        buttonTexture = new Texture(Gdx.files.internal("buttons/exampleButton.png"));
        buttonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

        buttonTextureRegion = new TextureRegion(buttonTexture);


        prefs = Gdx.app.getPreferences("com.meataminers.brave-miner-defender.settings");


        style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;
        exitButton = new TextButton("Back", style);
        exitButton.setBounds(Gdx.graphics.getWidth()/2 - 50, 50, 100, 40);
        fullScreenButton = new TextButton("Volume -", style);
        fullScreenButton.setBounds(Gdx.graphics.getWidth()/2 - 100,  Gdx.graphics.getHeight()/2, 100, 40);
        windowedButton = new TextButton("Volume +", style);
        windowedButton.setBounds(Gdx.graphics.getWidth()/2 + 10,  Gdx.graphics.getHeight()/2, 100, 40);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(exitButton);
        stage.addActor(windowedButton);
        stage.addActor(fullScreenButton);


    }

    @Override
    public void show() {
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                OptionsScreen.this.game.setScreen(new MenuScreen(game));
            }
        });
        fullScreenButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (volume < 1) volume += 0.1f;
                OptionsScreen.this.prefs.flush();
            }
        });
        windowedButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (volume > 0) volume -= 0.1f;
                OptionsScreen.this.prefs.flush();
            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
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
        stage.dispose();
        skin.dispose();
    }
}

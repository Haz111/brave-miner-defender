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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    Texture buttonTextureRight;
    TextureRegion buttonTextureRegionRight;
    TextButtonStyle styleRight;
    Texture buttonTextureBack;
    TextureRegion buttonTextureRegionBack;
    TextButtonStyle styleBack;
    Skin skin;
    BitmapFont font;
    Music music;
    Float volume;
    Boolean update;

    SpriteBatch batch;
    Sprite sprite;
    Texture background;
    AudioManager audiomanager;
    public OptionsScreen(Game game, AudioManager audiomanager) {
        this.audiomanager = audiomanager;
        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("homescreen/bg3.png"));
        background.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        sprite = new Sprite(background);
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();
        buttonTexture = new Texture(Gdx.files.internal("buttons/volumedown.png"));
        buttonTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        buttonTextureRight = new Texture(Gdx.files.internal("buttons/volumeup.png"));
        buttonTextureRight.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        buttonTextureBack = new Texture(Gdx.files.internal("buttons/back.png"));
        buttonTextureBack.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        buttonTextureRegion = new TextureRegion(buttonTexture);
        buttonTextureRegionRight = new TextureRegion(buttonTextureRight);
        buttonTextureRegionBack= new TextureRegion(buttonTextureBack);
        prefs = Gdx.app.getPreferences("com.meataminers.brave-miner-defender.settings");
        volume = prefs.getFloat("volume", 0.5f);
        update = false;
        style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;
        styleRight = new TextButtonStyle();
        styleRight.up = new TextureRegionDrawable(buttonTextureRegionRight);
        styleRight.down = new TextureRegionDrawable(buttonTextureRegionRight);
        styleRight.font = font;
        styleBack = new TextButtonStyle();
        styleBack.up = new TextureRegionDrawable(buttonTextureRegionBack);
        styleBack.down = new TextureRegionDrawable(buttonTextureRegionBack);
        styleBack.font = font;
        exitButton = new TextButton("", styleBack);
        exitButton.setBounds(Gdx.graphics.getWidth()/2 - 50, 50, 144, 96);
        fullScreenButton = new TextButton("", style);
        fullScreenButton.setBounds(Gdx.graphics.getWidth()/2 - 180,  Gdx.graphics.getHeight()/2 - 150, 180, 90);
        windowedButton = new TextButton("", styleRight);
        windowedButton.setBounds(Gdx.graphics.getWidth()/2 + 50,  Gdx.graphics.getHeight()/2 - 150, 180, 90);

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
        fullScreenButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (OptionsScreen.this.volume >= 0.1f) {

                    OptionsScreen.this.volume -= 0.1f;

                    OptionsScreen.this.update = true;
                    audiomanager.updateMusic(volume);
                }



            }
        });
        windowedButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (OptionsScreen.this.volume <= 0.9f){

                    OptionsScreen.this.volume += 0.1f;

                    OptionsScreen.this.update = true;
                    audiomanager.updateMusic(volume);
                }

            }
        });
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        stage.act();
        stage.draw();;
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

package com.metaminers.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.metaminers.game.phases.PlayingInformation;

/**
 * Created by Hubert on 2015-07-26.
 */
public class PlotScreen implements Screen {
    TextButton playButton;
    Stage stage;
    Game game;

    Texture buttonTexture;
    TextureRegion buttonTextureRegion;
    TextButton.TextButtonStyle style;
    Skin skin;
    BitmapFont font;
    SpriteBatch batch;
    Texture background;
    Sprite sprite;
    TextureRegion backgroundRegion;

    AudioManager audioManager;
    PlayingInformation info;

    public PlotScreen(Game game, PlayingInformation info, AudioManager audioManager) {
        this.game = game;
        font = new BitmapFont();
        skin = new Skin();

        this.audioManager = audioManager;
        this.info = info;

        batch = new SpriteBatch();
        background = new Texture(Gdx.files.internal("homescreen/hsscreen.png"));
        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite = new Sprite(background);
        backgroundRegion = new TextureRegion(background);

        buttonTexture = new Texture(Gdx.files.internal("buttons/play.png"));
        buttonTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        buttonTextureRegion = new TextureRegion(buttonTexture);

        style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(buttonTextureRegion);
        style.down = new TextureRegionDrawable(buttonTextureRegion);
        style.font = font;
        playButton = new TextButton("", style);
        playButton.setBounds(750, 45, 144, 96);


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        stage.addActor(playButton);
    }

    @Override
    public void show() {
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                PlotScreen.this.game.setScreen(new LevelScreen(game,info, audioManager));
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        batch.end();
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